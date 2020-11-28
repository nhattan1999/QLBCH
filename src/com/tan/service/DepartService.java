package com.tan.service;

import java.util.List;

import com.tan.entities.DepartmentEntity;
import com.tan.repositories.DepartRepositories;

public class DepartService {
	private DepartRepositories deprepo;
	public DepartService() {
		deprepo = new DepartRepositories();

	}
	public List<DepartmentEntity> getAll(){
		return deprepo.getDepart();
	}
	public void delDEP(String maBan) {
		deprepo.deleteDepart(maBan);
	}
	public void addDEP(DepartmentEntity dep) {
		deprepo.addDEP(dep);
	}
	
}
