create schema student_management;
use student_management;

create table student(
	id int primary key,
    name varchar(50),
    age tinyint null,
    country varchar(50) null
);

create table class(
	id int primary key,
    name varchar(50)
);

create table teacher(
	id int primary key,
    name varchar(50),
    age tinyint null,
    country varchar(50) null
);