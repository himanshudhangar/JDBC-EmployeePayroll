package com.employee_payroll_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeePayrollService {
	private static final String url = "jdbc:mysql://localhost:3306/payroll_service";
	private static final String userName = "root";
	private static final String password = "user@456";

	public void checkDatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection con;
			try {
				con = DriverManager.getConnection(url, userName, password);
				System.out.println("connected to database" + con);
				listDrivers();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass = (Driver)driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
		}
	}

}