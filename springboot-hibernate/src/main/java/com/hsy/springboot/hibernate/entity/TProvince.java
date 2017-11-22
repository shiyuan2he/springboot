package com.hsy.springboot.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="t_province")
public class TProvince {
	@Id
    private Long id;
	@Column
	private String code;
	@Column
	private String name;
	@Column(name = "sort_id")
	private Integer sortId;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setCode(String code){
		this.code=code;
	}
	public String getCode(){
		return code;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setSortId(Integer sortId){
		this.sortId=sortId;
	}
	public Integer getSortId(){
		return sortId;
	}
}

