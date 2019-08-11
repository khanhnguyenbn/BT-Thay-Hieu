package com.khanh.excercise18to36;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeachingAndLearningRegistration {

	// register subject for teacher to teach
	static void registerSubjectTeaching(int teacherId, int subjectId) {
		Connection connection = DBConnection.getConnection("school", "root", "123456");
		String sql = "INSERT INTO tbl_teaching (teacher_id, subject_id) VALUES (?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, teacherId);
			preparedStatement.setInt(2, subjectId);
			preparedStatement.executeUpdate();
			System.out.println("Register successfully");
		} catch (SQLException e) {
			System.out.println("teacherId or subjectId is not exit");
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
	
	// register subject and teacher for student to learn
	static void registerSubjectLearning(int studentId, int teachingId) {
		Connection connection = DBConnection.getConnection("school", "root", "123456");
		String sql = "INSERT INTO tbl_learning (student_id, teaching_id) VALUES (?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, teachingId);
			preparedStatement.executeUpdate();
			System.out.println("Register successfully");
		} catch (SQLException e) {
			System.out.println("studentId or teachingId is not exit");
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
