package com.khanh.excercise18to36;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDAO {
	
	// insert subject to DB
	public void insert(Subject subject) {

		Connection connection = DBConnection.getConnection("school", "root", "123456");
		String sql = "INSERT INTO tbl_Subject (subject_name, start_date, end_date) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, subject.getSubjectName());
			preparedStatement.setDate(2, new Date(subject.getStartDate().getTime()));
			preparedStatement.setDate(3, new Date(subject.getEndDate().getTime()));
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