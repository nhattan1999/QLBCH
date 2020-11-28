<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Form thông tin thành viên</title>
	<style>
		input[type=text], select {
		  width: 100%;
		  padding: 12px 20px;
		  margin: 8px 0;
		  display: inline-block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
		}
		
		input[type=submit] {
		  width: 30%;
		  background-color: #000080;
		  color: white;
		  padding: 14px 20px;
		  margin-left: 35%;

		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}
		input [type=date] {
		  width: 100%;
		}
		
		input[type=submit]:hover {
		  background-color: #191970;
		  
		}
		
		div {
		  border-radius: 5px;
		  background-color: #D3D3D3;
		  margin: 20%;
		  padding: 20px;
		}
	</style>	
	</head>
	<body>
	   <div>
	   <form id="regform" method="post" action ="/QLBCH/submitDEP">	
	   <c:if test="${isEdit }" > 
	       <p>Mã ban: <input type="text" name = "maBan" value="${dep.maBan}" readonly="readonly"> </p>
	   </c:if>
	   	   <c:if test="${!isEdit }" > 
	       <p>Mã ban: <input type="text" name = "maBan" value="${dep.maBan}"> </p>
	   </c:if>
	  
       <p>Tên ban: <input type="text" name = "tenBan" value="${dep.tenBan}"> </p>
       <p>Mô tả công việc: <input type="text" name = "description" value="${dep.description}"> </p>
       <p><input class="center"type="submit"> </p>
       </form>   
       </div>
	</body>
</html>