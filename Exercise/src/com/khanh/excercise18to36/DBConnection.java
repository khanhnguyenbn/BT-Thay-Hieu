package com.khanh.excercise18to36;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DBConnection {

	// define constant for default database_name
	public static final String DATABASE_NAME = "school";
	
	// define default user_name
	public static final String USER_NAME = "root";
	
	// define default password
	public static final String PASSWORD = "123456";

	// define base url
	static final String BASE_URL = "jdbc:mysql://localhost:3306/";

	// get Connection and display all table after connect successfully
	public static Connection getConnection(String databaseName, String user, String password) {

		try {
			
			// Driver for MySQL
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			// show error when can't find
			System.out.println("Don't find mysql-connector please add jar to project");
		}

		// init connection
		Connection connection = null;
		try {
			
			// init connection with url, user, password
			connection = DriverManager.getConnection(BASE_URL + databaseName, user, password);
		} catch (SQLException e) {
			
			// show error when database name, user or password is incorrect
			System.out.println("Can't connect to database because: Database name, user or password is incorrect");
		}
		
		// connect success
		if (connection != null) {
			
			//show result connect to DB
			System.out.println("connect to: " + databaseName + " successfully");

			// display all tables when connect to DB successfully
			System.out.println("List tables in database");
			
			// call function to display all table name in DB
			displayAllTable(connection);
			
			// return connection
			return connection;
		} else {
			return null;
		}

	}

	// display all table
	static void displayAllTable(Connection connection) {
		
		// query to get tables DB
		String sql = "show tables";
		
		// init preparedStatement
		PreparedStatement preparedStatement = null;
		
		// init resultSet.DB return resulset
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			//execute query and return resultSet
			resultSet = preparedStatement.executeQuery();
			
			// get rows in resultSet
			while (resultSet.next()) {
				
				//display table name
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// close resultSet and preparedStatement when exception or not exception
			try {
				
				// close resulSet
				if (resultSet != null) {
					resultSet.close();
				}

				// close preparedStatement
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

		// init preparedStatement
		PreparedStatement preparedStatement = null;
		
		// init resultSet
		ResultSet resultSet = null;
		try {
			
			// assign value for preparedStatement using sql above
			preparedStatement = connection.prepareStatement(sql);
			
			// executeQuery, return a ResultSet
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
			
			// get total of column number
			int columnsNumber = rsmd.getColumnCount();
			
			// get rows in resultSet
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
			
			// close all when have exception or don't have exception. allways run
			try {

				// close resultSet
				if (resultSet != null) {
					resultSet.close();
				}

				// close preparedStatement
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				// close connection
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// display error when can't close
				e.printStackTrace();
			}

		}
	}

	// with statement edit data
	static void editData(Connection connection, String sql) {

		// init preparedStatement
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			//excecute query
			preparedStatement.executeUpdate();
			
			// show successfully
			System.out.println("execute successfully");
			
		} catch (SQLException e) {
			
			// show error
			System.out.println("query is not correct");
			e.printStackTrace();
		}

	}

	// add propery of People in DB: int sex, text hobby
	static void addCollumnPeople(Connection connection) {
		
		// define query
		String sql = "ALTER TABLE tbl_people ADD COLUMN sex INT, ADD COLUMN hobby TEXT;";
		
		// call function to excecute this query
		editData(connection, sql);
	}

	public static void main(String[] args) {

		// input information to connect to DB
		Scanner scanner = new Scanner(System.in);
		
		// show for user to input database name
		System.out.println("input database name: ");
		// input databaseName
		String databaseName = scanner.nextLine();
		
		// show for user to input user name
		System.out.println("input your user name");
		// input userName
		String userName = scanner.nextLine();
		
		// show for user to input user name
		System.out.println("input your password");
		//input password
		String password = scanner.nextLine();

		Connection connection = getConnection(databaseName, userName, password);

		// show for people to input query
		System.out.println("Input query to select data");
		// input sql query
		String sql = scanner.nextLine();
		//call function to execute query
		selectData(connection, sql);

		// input query to edit data: UPDATE INSERT OR DELETE ...
		System.out.println("Input query to edit data");
		// input sql to edit data
		String sqlEdit = scanner.nextLine();
		// call function to execute
		editData(connection, sqlEdit);

		// function to addCollumPeople require in excercise 36
		addCollumnPeople(connection);
	}

}
