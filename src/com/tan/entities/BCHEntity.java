package com.tan.entities;

import java.sql.Date;

public class BCHEntity {
   private String mssv;
   private String name;
   private String lop;
   private Date dob;
   private String email;
   private String phone;
   private String maBan;
   
   public String getMssv() {
		return mssv;
	}
   public void setMssv(String mssv) {
		this.mssv = mssv;
	}
   
   public String getName() {
		return name;
 	}
   public void setName(String name) {
		this.name = name;
	}
   
   public String getLop() {
		return lop;
	}
   public void setLop(String lop) {
		this.lop = lop;
	}
   
   public Date getDob() {
		return dob;
	}
   public void setDob(Date dob) {
		this.dob = dob;
	}
   
   public String getEmail() {
		return email;
	}
   public void setEmail(String email) {
		this.email = email;
	}
	
   public String getPhone() {
		return phone;
	}
   public void setPhone(String phone) {
		this.phone = phone;
	}
   
   public String getMaBan() {
		return maBan;
	}
   public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
public BCHEntity(String mssv, String name, String lop, Date dob, String email, String phone, String maBan) {
	super();
	this.mssv = mssv;
	this.name = name;
	this.lop = lop;
	this.dob = dob;
	this.email = email;
	this.phone = phone;
	this.maBan = maBan;
}
public BCHEntity() {
	super();
}
 
   
   
}
