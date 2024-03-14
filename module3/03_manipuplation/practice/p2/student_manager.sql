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

-- 1 Hiển thị danh sách tất cả các học viên
select * from student;

-- 2 Hiển thị danh sách các học viên đang theo học
select * from student where `status` <> 0;

-- 3 Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ
select * from subject where credit < 10;

-- 4 Hiển thị danh sách học viên lớp A1
select * from student s join `class` c on s.class_id = c.id where c.name = 'A1';

-- 5 Hiển thị điểm môn CF của các học viên
select * from student s 
join mark m on s.id = m.student_id 
join subject s on m.sub_id = s.id
where s.name = 'CF'
group by s.id 
-- group by isn't necessary because of UNIQUE (sub_id, student_id)





