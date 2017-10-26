package com.hsy.springboot.demo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.util.Date;
@Entity(name="t_user_info")
public class TUserInfo {
	@Id
    @GeneratedValue
    private String id;
	@Column
	private String username;
    @Column
	private String password;
    @Column(name="is_del")
	private Integer isDel;
    @Column
	private String realname;
    @Column
	private String qq;
    @Column
	private String email;
    @Column
	private String telephone;
    @Column(name="encrtption_type")
	private String encryptionType;
    @Column
	private String updator;
    @Column(name="update_time")
	private Date updateTime;
    @Column
	private String inserter;
    @Column(name="insert_time")
	private Date insertTime;
    @Column
    @Min(value = 18,message = "未成年禁止注册")
    private Integer age ;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

