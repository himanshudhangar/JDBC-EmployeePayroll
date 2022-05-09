package com.employee_payroll_jdbc;

import static org.junit.Assert.*;

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

	
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnEmployeeDetailsUsingBasedOndate()
			throws EmployeePayrollExcepation, ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.retrieveDate();

	}
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnSumofEmployeeSalary()
			throws EmployeePayrollExcepation, ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.retrieveSum();

	}
	
		@Test
	public void givenEmployeePayrollDatabase_ShouldReturnAverageofEmployeeSalary()
			throws EmployeePayrollExcepation, ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.retrieveAverage();

	}
	
	
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnMinofEmployeeSalary()
			throws EmployeePayrollExcepation, ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.retrieveMinimum();

	}
	
	
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnMaxofEmployeeSalary()
			throws EmployeePayrollExcepation, ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.retrieveMaximum();

	}
	
	
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnCountofEmployeeSalary()
			throws EmployeePayrollExcepation, ClassNotFoundException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.retrieveCount();

	}
	@Test
	public void givenEmployeePayrollDatabase_ShouldAddEmployeeToDatabase() throws EmployeePayrollExcepation {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		boolean result = employeePayrollService.insertData();
		System.out.println(result);
		Assert.assertTrue(result);
	}
	
}