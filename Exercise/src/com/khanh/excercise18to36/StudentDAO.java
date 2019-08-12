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

		// get connection
		Connection connection = DBConnection.getConnection("school", "root", "123456");
		// declare query
		String sql = "INSERT INTO tbl_people (first_name, last_name, date_of_birth, kind) VALUES (?, ?, ?, ?)";
		// declare preparedStatement
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			// set value in the first "?"
			preparedStatement.setString(1, student.getFirstName());
			// set value in the second "?"
			preparedStatement.setString(2, student.getLastName());
			// set value in the third "?"
			preparedStatement.setDate(3, new Date(student.getDateOfBirth().getTime()));
			// set value in the fourth "?"
			preparedStatement.setInt(4, 0);
			//execute
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// close all
			try {
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
				// display error
				e.printStackTrace();
			}

		}

	}

	// get student by id with full information include base information and registration learning information
	public Student getStudentById(int id) {
		// init student
		Student student = new Student();
		// get Connection
		Connection connection = DBConnection.getConnection(DBConnection.DATABASE_NAME, DBConnection.USER_NAME, DBConnection.PASSWORD);
		// declare query to get base information of student
		String sql = "SELECT * FROM tbl_people WHERE id = ? AND kind = 0";
		// declare query to get information about subject and score of student
		String sql1 = "SELECT subject_name, start_date, end_date, score FROM tbl_people INNER JOIN tbl_learning ON tbl_people.id = tbl_learning.student_id INNER JOIN tbl_teaching ON tbl_learning.teaching_id = tbl_teaching.id INNER JOIN tbl_subject ON tbl_teaching.subject_id = tbl_subject.id WHERE tbl_people.id = ?;";
		// declare resultSet
		ResultSet resultSet = null;
		// declare preparedStatement
		PreparedStatement preparedStatement = null;
		// declare preparedStatementSubject
		PreparedStatement preparedStatementSubject = null;
		try {
			// get connection
			preparedStatement = connection.prepareStatement(sql);
			//set value for first "?" in sql
			preparedStatement.setInt(1, id);
			// execute and return resultSet
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				//set studentId get from resultSet
				student.setId(resultSet.getInt(id));
				//set firstName get from resultSet
				student.setFirstName(resultSet.getString("first_name"));
				//set LastName get from resultSet
				student.setLastName(resultSet.getString("last_name"));
				//set dateOfBirth get from resultSet
				student.setDateOfBirth(new java.util.Date(resultSet.getDate("date_of_birth").getTime()));
				//set placeToLive get from resultSet
				student.setPlaceToLive(resultSet.getString("place_to_live"));
			}
			
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// close all
			try {
				// close resultSet
				if (resultSet != null) {
					resultSet.close();
				}
				
				// close preparedStatement
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// display error when close
				e.printStackTrace();
			}

		}
		
		// declare Map to save subject and score of subject
		Map<Subject, Integer> subjectScore = new HashMap<Subject, Integer>();
		try {
			
			preparedStatementSubject = connection.prepareStatement(sql1);
			// set value in "?"
			preparedStatementSubject.setInt(1, id);
			// execute and return resultSetSubject
			ResultSet resultSetSubject = preparedStatementSubject.executeQuery();
			
			// get information of subject
			while (resultSetSubject.next()) {
				Subject subject = new Subject();
				subject.setSubjectName(resultSetSubject.getString("subject_name"));
				subject.setStartDate(new java.util.Date(resultSetSubject.getDate("start_date").getTime()));
				subject.setEndDate(new java.util.Date(resultSetSubject.getDate("end_date").getTime()));
				// get score
				int score = resultSetSubject.getInt("score");
				// put to map
				subjectScore.put(subject, score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set map subjectScore for student
		student.setSubjectScore(subjectScore);
		
		
		//return that student
		return student;
	}

}
