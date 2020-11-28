package com.tan.entities;

public class DepartmentEntity {
	private String maBan;
	private String tenBan;
	private String description;
	
	public String getMaBan() {
		return maBan;
	}
    public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
   
    public DepartmentEntity() {
		super();
	}
	public DepartmentEntity(String maBan, String tenBan, String description) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.description = description;
	}
	public String getTenBan() {
		return tenBan;
	}
    public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}
    
    public String getDescription() {
		return description;
	}
    public void setDescription(String description) {
		this.description = description;
	}

}
