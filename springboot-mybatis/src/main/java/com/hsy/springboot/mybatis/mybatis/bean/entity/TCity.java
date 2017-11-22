package com.hsy.springboot.mybatis.mybatis.bean.entity;



public class TCity {
	private Long id;
	private String name;
	private String code;
	private Integer sortId;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setCode(String code){
		this.code=code;
	}
	public String getCode(){
		return code;
	}
	public void setSortId(Integer sortId){
		this.sortId=sortId;
	}
	public Integer getSortId(){
		return sortId;
	}
}

