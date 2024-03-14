CREATE DATABASE IF NOT EXISTS student_manager;

use student_manager;

CREATE TABLE IF NOT EXISTS `class` (
	id INT PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL,
	start_date DATETIME NOT NULL,
	`status` BIT
);

ALTER TABLE `class` CHANGE COLUMN `id` `id` INT(11) AUTO_INCREMENT;

CREATE TABLE IF NOT EXISTS student (
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	address varchar(50),
	phone varchar(20),
	`status` bit,
	class_id int NOT NULL,
	FOREIGN KEY (class_id) REFERENCES class (id)
);

CREATE TABLE IF NOT EXISTS `subject` (
	id int PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	credit tinyint NOT NULL DEFAULT 1,
	`status` bit DEFAULT 1,
	CHECK (Credit >= 1)
);

CREATE TABLE IF NOT EXISTS mark (
	id int PRIMARY KEY AUTO_INCREMENT,
	sub_id int NOT NULL,
	student_id int NOT NULL,
	mark float DEFAULT 0,
	exam_times tinyint DEFAULT 1,
	UNIQUE (sub_id, student_id),
CHECK (mark BETWEEN 0 AND 100),
FOREIGN KEY (sub_id) REFERENCES `subject` (id),
FOREIGN KEY (student_id) REFERENCES student (id)
);

-------------

INSERT INTO class (`name`, start_date, `status`) value ('C0420G1', '2020-12-15', 1);
INSERT INTO class value (2, 'C0420G1', '2020-12-15', 1);

insert into student (`name`, address, phone, `status`, class_id) VALUE('quoc', '19 le do', '0708', 1, 1);
insert into student (`name`, address, phone, `status`, class_id) VALUE('dung', '19 le do', '0708', 1, 2);
insert into student (`name`, address, phone, `status`, class_id) VALUE('toan', '19 le do', '0708', 1, 2);
insert into student (`name`, address, phone, `status`, class_id) VALUE('my', '19 le do', '0708', 1, 2);

insert into `subject` (name, credit, `status`) VALUE('java', 10, 1);
insert into `subject` (name, credit, `status`) VALUE('csharp', 15, 1);

insert into mark(sub_id, student_id, mark, exam_times) VALUE(1, 1, 12, 2);
insert into mark(sub_id, student_id, mark, exam_times) VALUE(2, 2, 10, 2);
insert into mark(sub_id, student_id, mark, exam_times) VALUE(2, 1, 8, 2);
insert into mark(sub_id, student_id, mark, exam_times) VALUE(1, 3, 5, 2);
insert into mark(sub_id, student_id, mark, exam_times) VALUE(2, 3, 4, 2);
insert into mark(sub_id, student_id, mark, exam_times) VALUE(2, 4, 5, 2);





