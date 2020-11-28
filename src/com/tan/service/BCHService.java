package com.tan.service;

import java.util.List;

import com.tan.entities.BCHEntity;
import com.tan.repositories.BCHRepositories;

public class BCHService {
	private BCHRepositories bchrepo;
	public BCHService() {
		bchrepo = new BCHRepositories();
	}
	public List<BCHEntity> getAll() {
		return bchrepo.getBCH();
	}
	public void delBCH(String mssv) {
		bchrepo.deleteBCH(mssv);
	}
	public void addBCH(BCHEntity bch) {
		bchrepo.addBCH(bch);
	}
	public List<BCHEntity> findById(String maBan) {
		return bchrepo.findById(maBan);
	}
}
