package com.tan.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tan.entities.BCHEntity;
import com.tan.entities.DepartmentEntity;
import com.tan.util.ConnectionUtil;

public class BCHRepositories {
  public List<BCHEntity> getBCH (){
	  List<BCHEntity> bchs = new ArrayList<BCHEntity>();
	  String getsql = "select * from bch";
	  try(Connection conn = ConnectionUtil.openConnection();
			PreparedStatement p = conn.prepareStatement(getsql);  ){
		  ResultSet rs = p.executeQuery();
		  while(rs.next())
		  {  
			  BCHEntity bch = new BCHEntity();
			  bch.setMssv(rs.getString("mssv"));
			  bch.setName(rs.getString("name"));
			  bch.setLop(rs.getString("lop"));
			  bch.setDob(rs.getDate("dob"));
			  bch.setEmail(rs.getString("email"));
			  bch.setPhone(rs.getString("phone"));
			  bch.setMaBan(rs.getString("maBan"));
              bchs.add(bch);			 
		  }
		  rs.close();
		  p.close();
		  conn.close();
		
	} catch (Exception e) {
		System.out.println("Can't get data.");
	}	  
	  return bchs;
  }
  public void deleteBCH (String mssv) {
	  String delsql = "delete from bch where mssv = ?";
	  try (Connection conn = ConnectionUtil.openConnection();
				PreparedStatement p = conn.prepareStatement(delsql);){
		  p.setString(1, mssv);
		  p.execute();
		  p.close();
		  conn.close();
	} catch (Exception e) {
		System.out.println("Can't delete data.");
	}
  }
  public void addBCH (BCHEntity be)
  {   
	  List<BCHEntity> bchs = getBCH();
	  String query = "insert into bch values (?, ?, ?, ?, ?, ?, ?)";
	  int d = 0;
	  for (BCHEntity bchEntity : bchs) {
		if(be.getMssv().equals(bchEntity.getMssv()))
		{	query = "update bch set name = ?, lop = ?, dob = ?, email = ?, phone = ?, maBan = ? where mssv = ?";
		    d = 1;
		    break;
		}
	  }
	  try (Connection conn = ConnectionUtil.openConnection();
		   PreparedStatement p = conn.prepareStatement(query); 
			  ){
		  if(d==0) {
			  p.setString(1, be.getMssv());
			  p.setString(2, be.getName());
			  p.setString(3, be.getLop());
			  p.setDate(4, be.getDob());
			  p.setString(5, be.getEmail());
			  p.setString(6, be.getPhone());
			  p.setString(7, be.getMaBan());
		  }
		  else
		  {
			  p.setString(1, be.getName());
			  p.setString(2, be.getLop());
			  p.setDate(3, be.getDob());
			  p.setString(4, be.getEmail());
			  p.setString(5, be.getPhone());
			  p.setString(6, be.getMaBan());
			  p.setString(7, be.getMssv());
		  }
		  p.execute();
		  p.close();
		  conn.close();
	} catch (Exception e) {
		System.out.println("Can't add or update data.");
	}
  }
  public List<BCHEntity> findById(String maBan){
	   List<BCHEntity> bchs= new ArrayList<BCHEntity>();
	   String getsql = "select * from bch where maBan = ?";
	   try(Connection conn = ConnectionUtil.openConnection();
		  PreparedStatement p = conn.prepareStatement(getsql);  ){
			  p.setString(1, maBan);
		      ResultSet rs = p.executeQuery();
			  while(rs.next())
			  {  
				  BCHEntity bch = new BCHEntity();
				  bch.setMssv(rs.getString("mssv"));
				  bch.setName(rs.getString("name"));
				  bch.setLop(rs.getString("lop"));
				  bch.setDob(rs.getDate("dob"));
				  bch.setEmail(rs.getString("email"));
				  bch.setPhone(rs.getString("phone"));
				  bch.setMaBan(rs.getString("maBan"));
	              bchs.add(bch);	 
			  }
			  rs.close();
			  p.close();
			  conn.close();
			
		} catch (Exception e) {
			System.out.println("Can't get data.");
		}	  
	   return bchs;
  }
  
}
