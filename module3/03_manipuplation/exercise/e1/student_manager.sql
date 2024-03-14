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

-- 1 Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student where `name` like 'h%';

-- 2 Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
select * from class where month(start_date) = 12;

-- 3 Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5
select * from subject where credit between 3 and 5;

-- 4 Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2
update student set class_id = 2 where name = 'Hung';

-- 5 Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần
select s.name, su.name, m.mark from student s
join mark m on s.id = m.student_id
join subject su on m.sub_id = su.id
order by m.mark desc, s.name;





