package com.khanh.excercise18to36;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DBConnection {

	public static final String DATABASE_NAME = "school";
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "123456";

	static final String BASE_URL = "jdbc:mysql://localhost:3306/";

	// get Connection and display all table after connect successfully
	public static Connection getConnection(String databaseName, String user, String password) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Don't find mysql-connector please add jar to project");
		}

		Connection connection = null;
		try {
			// init connection with url, user, password
			connection = DriverManager.getConnection(BASE_URL + databaseName, user, password);
		} catch (SQLException e) {
			System.out.println("Can't connect to database because: Database name, user or password is incorrect");
		}
		if (connection != null) {
			System.out.println("connect to: " + databaseName + " successfully");

			// display all tables when connect to DB successfully
			System.out.println("List tables in database");
			displayAllTable(connection);
			return connection;
		} else {
			return null;
		}

	}

	// display all table
	static void displayAllTable(Connection connection) {
		// query to get tables DB
		String sql = "show tables";
		PreparedStatement preparedStatement = null;
		// DB return resulset
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// close all
			try {

				if (resultSet != null) {
					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// with statement select data
	static void selectData(Connection connection, String sql) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = resultSet.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				if (resultSet != null) {
					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// with statement edit data
	static void editData(Connection connection, String sql) {

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			System.out.println("execute successfully");
		} catch (SQLException e) {
			System.out.println("query is not correct");
			e.printStackTrace();
		}

	}

	// add propery of People in DB: int sex, text hobby
	static void addCollumnPeople(Connection connection) {
		String sql = "ALTER TABLE tbl_people ADD COLUMN sex INT, ADD COLUMN hobby TEXT;";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			System.out.println("Add column successfully");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("excecute statement false");
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {

		// input information to connect to DB
		Scanner scanner = new Scanner(System.in);
		System.out.println("input database name: ");
		String databaseName = scanner.nextLine();
		System.out.println("input your user name");
		String userName = scanner.nextLine();
		System.out.println("input your password");
		String password = scanner.nextLine();

		Connection connection = getConnection(databaseName, userName, password);

		// input query to select data
		System.out.println("Input query to select data");
		String sql = scanner.nextLine();
		selectData(connection, sql);

		// input query to edit data: UPDATE INSERT OR DELETE ...
		System.out.println("Input query to edit data");
		String sqlEdit = scanner.nextLine();
		editData(connection, sqlEdit);

		addCollumnPeople(connection);
	}

}
