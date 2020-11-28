package com.tan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tan.entities.BCHEntity;
import com.tan.entities.DepartmentEntity;
import com.tan.service.BCHService;
import com.tan.service.DepartService;

@WebServlet("/")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BCHService bchser;
	private DepartService depser;
	
    public MyController() {
        super();
        bchser = new BCHService();
        depser = new DepartService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		switch(path) {
		  case "/QLBCH/":
		      show(request, response);
		      break;
		  case "/QLBCH/bch":
			  getBCH(request, response);
			  break;
		  case "/QLBCH/deleteBCH":
			  deleteBCH(request, response);
			  break;
		  case "/QLBCH/aouBCH":
			  addBCH(request, response);
			  break;
		  case "/QLBCH/submitBCH":
			  submitBCH(request, response);
			  break;
		  case "/QLBCH/dep":
			  getDEP(request, response);
			  break;	  
		  case "/QLBCH/deleteDEP":
			  deleteDEP(request, response);
			  break;		  
		  case "/QLBCH/aouDEP":
			  addDEP(request, response);
			  break;
		  case "/QLBCH/submitDEP":
			  submitDEP(request, response);
			  break;
		  case "/QLBCH/listBCH":
			  showBCH(request, response);
			  break;
		  default: break;	  
		}
		
		
	}

	

	private void showBCH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BCHEntity> bchs= bchser.findById(request.getParameter("maBan"));
		request.setAttribute("bchs", bchs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void getBCH(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BCHEntity> bchs = bchser.getAll();
		request.setAttribute("bchs", bchs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	private void deleteBCH(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mssv = request.getParameter("mssv");
		bchser.delBCH(mssv);
		getBCH(request, response);
		
	}
	private void addBCH(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("formEditBCH.jsp");
		String mssv = request.getParameter("mssv");
		BCHEntity bch = new BCHEntity();
		List<BCHEntity> bchs = bchser.getAll();
		int d = 0;
		for (BCHEntity bchEntity : bchs) {
			if(bchEntity.getMssv().equals(mssv))
			{
				bch.setMssv(bchEntity.getMssv()); 
				bch.setName(bchEntity.getName());
				bch.setLop(bchEntity.getLop());
				bch.setDob(bchEntity.getDob());
				bch.setEmail(bchEntity.getEmail());
				bch.setPhone(bchEntity.getPhone());
				bch.setMaBan(bchEntity.getMaBan());
				d = 1;
				break;
			}
		}
		if (d==1)
		{
		  request.setAttribute("bch", bch);
		  request.setAttribute("isEdit", true);
		}
		dispatcher.forward(request, response);
		
	}
	private void submitBCH(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BCHEntity bch = new BCHEntity();
		bch.setMssv(request.getParameter("mssv"));
		bch.setName(request.getParameter("name"));
		bch.setLop(request.getParameter("lop"));
		bch.setDob(Date.valueOf(request.getParameter("dob")));
		bch.setEmail(request.getParameter("email"));
		bch.setPhone(request.getParameter("phone"));
		bch.setMaBan(request.getParameter("maBan"));
		bchser.addBCH(bch);
		getBCH(request, response);
	}
	private void getDEP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DepartmentEntity> deps = depser.getAll();
		request.setAttribute("deps", deps);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index_depart.jsp");
		dispatcher.forward(request, response);
		
	}
	private void deleteDEP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maBan = request.getParameter("maBan");
		depser.delDEP(maBan);
		getDEP(request, response);
		
	}
	private void addDEP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("formEditDepartment.jsp");
		String maBan = request.getParameter("maBan");
		DepartmentEntity dep = new DepartmentEntity();
		List<DepartmentEntity> deps = depser.getAll();
		int d = 0;
		for (DepartmentEntity depEntity : deps) {
			if(depEntity.getMaBan().equals(maBan))
			{  
				dep.setMaBan(depEntity.getMaBan());
				dep.setTenBan(depEntity.getMaBan());
				dep.setDescription(depEntity.getDescription());
				d = 1;
				break;
			}
		}
		if (d==1)
		{
		  request.setAttribute("dep", dep);
		  request.setAttribute("isEdit", true);
		}
		dispatcher.forward(request, response);
		
	}


	private void submitDEP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentEntity dep = new DepartmentEntity();
		dep.setMaBan(request.getParameter("maBan"));
		dep.setTenBan(request.getParameter("tenBan"));
		dep.setDescription(request.getParameter("description"));
		depser.addDEP(dep);
		
		getDEP(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
