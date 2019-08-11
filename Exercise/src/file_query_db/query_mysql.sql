use school;

CREATE TABLE tbl_people (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name NVARCHAR(255) NOT NULL,
    last_name NVARCHAR(255) NOT NULL,
    date_of_birth DATE,
    place_to_live NVARCHAR(255),
    kind int
);

CREATE TABLE tbl_subject (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subject_name NVARCHAR(255) NOT NULL,
    start_date DATE,
    end_date DATE
);

CREATE TABLE tbl_teaching (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    teacher_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY fk_teacher(teacher_id) REFERENCES tbl_people(id),
    FOREIGN KEY fk_subject(subject_id) REFERENCES tbl_subject(id)
);

CREATE TABLE tbl_learning (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    teaching_id INT NOT NULL,
    score INT,
    FOREIGN KEY fk_student(student_id) REFERENCES tbl_people(id),
    FOREIGN KEY fk_teaching(teaching_id) REFERENCES tbl_teaching(id)
);