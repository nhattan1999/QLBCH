package com.tan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection openConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();// nap driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbch?" + "user=root&password=12345678");
		return con;
	}
}
