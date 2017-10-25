package com.hsy.springboot.demo.springboot.mybatis.bean.entity;

import java.util.Date;


public class TUserInfo {
	private String id;
	private String username;
	private String password;
	private Integer isDel;
	private String realname;
	private String qq;
	private String email;
	private String telephone;
	private String encryptionType;
	private String updator;
	private Date updateTime;
	private String inserter;
	private Date insertTime;
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setIsDel(Integer isDel){
		this.isDel=isDel;
	}
	public Integer getIsDel(){
		return isDel;
	}
	public void setRealname(String realname){
		this.realname=realname;
	}
	public String getRealname(){
		return realname;
	}
	public void setQq(String qq){
		this.qq=qq;
	}
	public String getQq(){
		return qq;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setTelephone(String telephone){
		this.telephone=telephone;
	}
	public String getTelephone(){
		return telephone;
	}
	public void setEncryptionType(String encryptionType){
		this.encryptionType=encryptionType;
	}
	public String getEncryptionType(){
		return encryptionType;
	}
	public void setUpdator(String updator){
		this.updator=updator;
	}
	public String getUpdator(){
		return updator;
	}
	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return updateTime;
	}
	public void setInserter(String inserter){
		this.inserter=inserter;
	}
	public String getInserter(){
		return inserter;
	}
	public void setInsertTime(Date insertTime){
		this.insertTime=insertTime;
	}
	public Date getInsertTime(){
		return insertTime;
	}
}

