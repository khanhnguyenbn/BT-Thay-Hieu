package com.khanh.excercise18to36;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class StudentDAO {

	// insert student with base information to DB
	public void insert(Student student) {

		Connection connection = DBConnection.getConnection("school", "root", "123456");
		String sql = "INSERT INTO tbl_people (first_name, last_name, date_of_birth, kind) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setDate(3, new Date(student.getDateOfBirth().getTime()));
			preparedStatement.setInt(4, 0);
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

	// get student by id with full information include base information and registration learning information
	public Student getStudentById(int id) {
		Student student = new Student();
		Connection connection = DBConnection.getConnection("school", "root", "123456");
		String sql = "SELECT * FROM tbl_people WHERE id = ? AND kind = 0";
		String sql1 = "SELECT subject_name, start_date, end_date, score FROM tbl_people INNER JOIN tbl_learning ON tbl_people.id = tbl_learning.student_id INNER JOIN tbl_teaching ON tbl_learning.teaching_id = tbl_teaching.id INNER JOIN tbl_subject ON tbl_teaching.subject_id = tbl_subject.id WHERE tbl_people.id = ?;";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementSubject = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				student.setId(resultSet.getInt(id));
				student.setFirstName(resultSet.getString("first_name"));
				student.setLastName(resultSet.getString("last_name"));
				student.setDateOfBirth(new java.util.Date(resultSet.getDate("date_of_birth").getTime()));
				student.setPlaceToLive(resultSet.getString("place_to_live"));
			}
			
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		Map<Subject, Integer> subjectScore = new HashMap<Subject, Integer>();
		try {
			preparedStatementSubject = connection.prepareStatement(sql1);
			preparedStatementSubject.setInt(1, id);
			ResultSet resultSetSubject = preparedStatementSubject.executeQuery();
			while (resultSetSubject.next()) {
				Subject subject = new Subject();
				subject.setSubjectName(resultSetSubject.getString("subject_name"));
				subject.setStartDate(new java.util.Date(resultSetSubject.getDate("start_date").getTime()));
				subject.setEndDate(new java.util.Date(resultSetSubject.getDate("end_date").getTime()));
				int score = resultSetSubject.getInt("score");
				subjectScore.put(subject, score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		student.setSubjectScore(subjectScore);
		
		

		return student;
	}

}
