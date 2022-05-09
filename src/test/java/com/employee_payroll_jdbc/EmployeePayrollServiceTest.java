package com.employee_payroll_jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;


import org.junit.Test;

public class EmployeePayrollServiceTest {

	

		
			@Test
			public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() {
				EmployeePayrollService employeePayrollService = new EmployeePayrollService();
				try {
					employeePayrollService.checkDatabaseConnection();
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
	}

	


