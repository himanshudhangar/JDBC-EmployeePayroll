package com.employee_payroll_jdbc;

public class EmployeePayrollExcepation extends Exception {
	private String message;

	public EmployeePayrollExcepation(String message) {
		this.message = message;
	}
	
}