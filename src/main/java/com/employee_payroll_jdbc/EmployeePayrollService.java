package com.employee_payroll_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;


public class EmployeePayrollService {
	private static final String url = "jdbc:mysql://localhost:3306/payroll_service";
	private static final String userName = "root";
	private static final String password = "user@456";

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = null;
		connection = DriverManager.getConnection(url, userName, password);
		System.out.println("connected to database" + connection);
		return connection;

	}

	
	public void checkDatabaseConnection() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		listDrivers();

	}

	
	private void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}

	
	public void selectData() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
					+ resultSet.getDouble(4) + " " + resultSet.getDate(5));
		}

	}

	
	public boolean updateSalary() throws EmployeePayrollExcepation {
		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("update employee_payroll set salary=300000 where name='Tersia'");
			if (result > 0) {
				System.out.println("updated");
				success = true;
			}
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollExcepation("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollExcepation("sql exception");
		}

		return success;

	}

	public boolean updateSalaryPrepared() throws EmployeePayrollExcepation {

		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update employee_payroll set salary=? where name=?");
			preparedStatement.setDouble(1, 300000);
			preparedStatement.setString(2, "Tersia");
			success = true;
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollExcepation("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollExcepation("sql exception");
		}

		return success;

	}

	
	public boolean retrievePrepared(String name) throws EmployeePayrollExcepation {
		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from employee_payroll where name=?");
			preparedStatement.setString(1, name);
			success = true;
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollExcepation("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollExcepation("sql exception");
		}

		return success;

	}

	
	public void retrieveDate() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select * from employee_payroll where start BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW())");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
					+ resultSet.getDouble(4) + " " + resultSet.getDate(5));
		}
	}

	
	public void retrieveSum() throws EmployeePayrollExcepation {
		Connection connection;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select sum(salary) from employee_payroll where gender='F' group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " ");

			}
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollExcepation("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollExcepation("sql exception");
		}

	}

	
	public void retrieveAverage() throws EmployeePayrollExcepation {
		Connection connection;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select avg(salary) from employee_payroll where gender='F' group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " ");

			}
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollExcepation("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollExcepation("sql exception");
		}

	}

	
	public void retrieveMinimum() throws EmployeePayrollExcepation {
		Connection connection;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select min(salary) from employee_payroll where gender='F' group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " ");

			}
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollExcepation("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollExcepation("sql exception");
		}

	}

	
	public void retrieveMaximum() throws EmployeePayrollExcepation {
		Connection connection;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select max(salary) from employee_payroll where gender='F' group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " ");

			}
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollExcepation("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollExcepation("sql exception");
		}

	}

	
	public void retrieveCount() throws EmployeePayrollExcepation {
		Connection connection;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(salary) from employee_payroll group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " ");

			}
		} catch (ClassNotFoundException e) {
			throw new EmployeePayrollExcepation("class not found");
		} catch (SQLException e) {
			throw new EmployeePayrollExcepation("sql exception");
		}

	}

}