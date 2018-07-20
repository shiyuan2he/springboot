drop table if exists t_table_lock;
create table t_table_lock(
  id bigint(32) primary key auto_increment comment '主键',
  lock_value varchar(10) default '' comment '锁住的值',
  description varchar(20) default '' comment '锁描述',
  lock_time datetime not null default current_timestamp on update current_timestamp comment '上锁时间',
  UNIQUE key idx_lock_value(lock_value) using BTREE
) engine=InnoDB default character set=utf8 comment '分布式锁表';

create table t_stock(
  id bigint(32) primary key auto_increment comment '主键',
  name varchar(20) not null default '' comment '商品名称',
  count int not null default 0 comment '库存量',
  create_time datetime not null default current_timestamp comment '创建时间',
  update_time datetime not null default current_timestamp on update current_timestamp comment '更新时间'
) engine = InnoDB character set=utf8 comment '库存表';

INSERT INTO exercise.t_stock (id, name, count, create_time, update_time) VALUES (1, '小米7高配版', 1, '2018-07-20 16:32:10', '2018-07-20 16:43:03');