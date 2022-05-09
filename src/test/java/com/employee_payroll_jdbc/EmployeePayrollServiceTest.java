package com.employee_payroll_jdbc;

import static org.junit.Assert.*;
import org.junit.Test;


import org.junit.Test;

public class EmployeePayrollServiceTest {

	

		
			@Test
			public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() {
				EmployeePayrollService employeePayrollService = new EmployeePayrollService();
				employeePayrollService.checkDatabaseConnection();
			}
	}

	


