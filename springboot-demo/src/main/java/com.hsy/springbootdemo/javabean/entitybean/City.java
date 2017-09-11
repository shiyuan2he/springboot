package com.hsy.springbootdemo.javabean.entitybean;
/**
 * @author liuzh_3nofxnp
 * @since 2016-01-22 22:16
 */
public class City extends BaseEntity {
    private String name;
    private String code;
    private Integer sortId ;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Integer getSortId() {
        return sortId;
    }
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
