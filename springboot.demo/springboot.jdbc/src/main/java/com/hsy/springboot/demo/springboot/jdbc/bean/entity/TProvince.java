package com.hsy.springboot.demo.springboot.jdbc.bean.entity;



public class TProvince {
	private Integer id;
	private String code;
	private String name;
	private Integer sortId;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
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

