package com.khanh.excercise18to36;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDAO {

	// insert teacher with base information to DB
	public void insert(Teacher teacher) {

		Connection connection = DBConnection.getConnection(DBConnection.DATABASE_NAME, DBConnection.USER_NAME, DBConnection.PASSWORD);
		String sql = "INSERT INTO tbl_people (first_name, last_name, date_of_birth, kind) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getFirstName());
			preparedStatement.setString(2, teacher.getLastName());
			preparedStatement.setDate(3, new Date(teacher.getDateOfBirth().getTime()));
			preparedStatement.setInt(4, 1);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
}
