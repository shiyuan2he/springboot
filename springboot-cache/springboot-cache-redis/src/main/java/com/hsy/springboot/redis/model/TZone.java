package com.hsy.springboot.redis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity(name = "t_zone")
public class TZone implements Serializable{
    @Id
    @GeneratedValue
    @Column()
    private Long id;
    @Column(unique = true,nullable = false)
    @Min(value = 100000,message = "邮编最小值100000")
    private Integer code;
    @Column()
    private String name;
    @Column(name = "parent_id",nullable = false)
    @Min(value = 100000,message = "父级邮编最小值100000")
    private Long parentId;
    @Column(name = "sort_id")
    @Min(value = 0,message = "sortId不能为负数")
    private Integer sortId = 0;
    @Column()
    private String remark = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public TZone(Integer code, String name, Long parentId) {
        this.code = code;
        this.name = name;
        this.parentId = parentId;
    }
}
