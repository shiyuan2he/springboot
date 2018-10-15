package com.hsy.springboot.canal.runner;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.hsy.springboot.canal.util.RedisUtil;
import java.net.InetSocketAddress;
import java.util.List;

@SuppressWarnings("Duplicates")
public class CanalClient {
    public static void main(String[] args){
        runCanalClient();
    }
    public static void runCanalClient() {
//        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(AddressUtils.getHostIp(),
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("192.168.1.100",
                11111), "example", "", "");
        int batchSize = 1000;
        try {
            connector.connect();
            connector.subscribe(".*\\..*");
            connector.rollback();
            while (true) {
                Message message = connector.getWithoutAck(batchSize); // 获取指定数量的数据
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    printEntry(message.getEntries());
                }
                connector.ack(batchId); // 提交确认
                // connector.rollback(batchId); // 处理失败, 回滚数据
            }
        } finally {
//            connector.disconnect();
        }
    }

    private static void printEntry( List<CanalEntry.Entry> entrys) {
        for (CanalEntry.Entry entry : entrys) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }
            CanalEntry.RowChange rowChage = null;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                        e);
            }
            CanalEntry.EventType eventType = rowChage.getEventType();
            String changeInfo = "" ;
            if(null==rowChage || rowChage.getRowDatasList().isEmpty()){
                changeInfo = "没有变更的字段" ;
            }else{
                changeInfo = "有变更的字段" ;
            }
            StringBuffer redisKey = new StringBuffer();
            System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s, ==>%s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType, changeInfo));
            for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                redisKey.append(entry.getHeader().getSchemaName()).append(":")
                        .append(entry.getHeader().getTableName()).append(":");
                if (eventType == CanalEntry.EventType.DELETE) {
                    printColumn(rowData.getBeforeColumnsList());
                    redisDelete(redisKey.toString(), rowData.getBeforeColumnsList());
                } else if (eventType == CanalEntry.EventType.INSERT) {
                    printColumn(rowData.getBeforeColumnsList());
                    redisInsert(redisKey.toString(), rowData.getAfterColumnsList());
                } else {
                    System.out.println("-------> before");
                    printColumn(rowData.getBeforeColumnsList());
                    System.out.println("-------> after");
                    printColumn(rowData.getAfterColumnsList());
                    redisUpdate(redisKey.toString(), rowData.getAfterColumnsList());
                }
            }
        }
    }

    private static void printColumn(List<CanalEntry.Column> columns) {
        for (CanalEntry.Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }

    private static void redisInsert(String key, List<CanalEntry.Column> columns){
        System.out.println("insert 操作");
        JSONObject json=new JSONObject();
        for (CanalEntry.Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if(columns.size()>0){
            RedisUtil.stringSet(key + columns.get(0).getValue(),json.toJSONString());
        }
    }

    private static  void redisUpdate(String key, List<CanalEntry.Column> columns){
        System.out.println("update 操作");
        JSONObject json=new JSONObject();
        for (CanalEntry.Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if(columns.size()>0){
            RedisUtil.stringSet(key + columns.get(0).getValue(),json.toJSONString());
        }
    }

    private static void redisDelete(String key, List<CanalEntry.Column> columns){
        System.out.println("delete 操作");
        JSONObject json=new JSONObject();
        for (CanalEntry.Column column : columns) {
            json.put(column.getName(), column.getValue());
        }
        if(columns.size()>0){
            RedisUtil.delKey(key + columns.get(0).getValue());
        }
    }
}
