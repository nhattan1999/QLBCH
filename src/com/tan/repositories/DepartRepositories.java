package com.tan.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tan.entities.DepartmentEntity;
import com.tan.util.ConnectionUtil;
public class DepartRepositories {
   public List<DepartmentEntity> getDepart(){
	   List<DepartmentEntity> des= new ArrayList<DepartmentEntity>();
	   String getsql = "select * from department";
	   try(Connection conn = ConnectionUtil.openConnection();
		  PreparedStatement p = conn.prepareStatement(getsql);  ){
			  ResultSet rs = p.executeQuery();
			  while(rs.next())
			  {  
				  DepartmentEntity de = new DepartmentEntity();
				  de.setMaBan(rs.getString("maBan"));
				  de.setTenBan(rs.getString("tenBan"));
				  de.setDescription(rs.getString("description"));
	              des.add(de);			 
			  }
			  rs.close();
			  p.close();
			  conn.close();
			
		} catch (Exception e) {
			System.out.println("Can't get data.");
		}	  
	   return des;
   }
   public void deleteDepart (String maBan) {
		  String delsql = "delete from department where maBan = ?";
		  
		  String query = "delete from bch where maBan= ?";
		  
		  try (Connection conn = ConnectionUtil.openConnection();	  
			   PreparedStatement p = conn.prepareStatement(delsql);
			   PreparedStatement p1 = conn.prepareStatement(query);
         	  ){

              p1.setString(1, maBan);
              p1.execute();
              p1.close();
			  p.setString(1, maBan);
			  p.execute();
			  p.close();
			  conn.close();
		} catch (Exception e) {
			System.out.println("Can't delete data.");
		}
	} 
   
   public void addDEP (DepartmentEntity de)
   {   

 	  List<DepartmentEntity> deps = getDepart();
 	  String query="insert into department values (?, ?, ?)";
 	  int d = 0;
 	  for (DepartmentEntity depEntity : deps) {
 		if(de.getMaBan().equals(depEntity.getMaBan()))
 		{	query = "update department set tenBan = ?, description = ? where maBan = ?";
 		    d = 1;
 		    break;
 		}
 	  }
 	  try (Connection conn = ConnectionUtil.openConnection();
 		   PreparedStatement p = conn.prepareStatement(query); 
 			  ){
 		  if(d==0) {
 			  p.setString(1,de.getMaBan());
 			  p.setString(2,de.getTenBan());
 			  p.setString(3,de.getDescription());
 		  }
 		  else
 		  {			 
			  p.setString(1,de.getTenBan());
			  p.setString(2,de.getDescription());
			  p.setString(3,de.getMaBan());
 		  }
 		  p.execute();
 		  p.close();
 		  conn.close();
 	} catch (Exception e) {
 		System.out.println("Can't add or update data.");
 	}
   }
  
}
