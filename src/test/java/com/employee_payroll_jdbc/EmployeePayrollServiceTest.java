package com.employee_payroll_jdbc;

import java.sql.SQLException;

import org.junit.Test;

import junit.framework.Assert;

public class EmployeePayrollServiceTest {
	
	@Test
	public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() throws ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.checkDatabaseConnection();
	}

	
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveData() throws ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.selectData();
	}

	
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateSalary() throws EmployeePayrollExcepation {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		boolean result = employeePayrollService.updateSalary();
		Assert.assertTrue(result);

	}

	
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateSalaryUsingPreparedStatement()
			throws EmployeePayrollExcepation {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		boolean result = employeePayrollService.updateSalaryPrepared();
		Assert.assertTrue(result);

	}

	
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnEmployeeDetailsUsingPreparedStatement()
			throws EmployeePayrollExcepation {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		boolean result = employeePayrollService.retrievePrepared("Tersia");
		Assert.assertTrue(result);

	}
}