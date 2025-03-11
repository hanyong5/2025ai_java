use shop;

-- //Create Department table
CREATE TABLE department (
department_code INT PRIMARY KEY AUTO_INCREMENT,
department_name VARCHAR(50)
);

-- //Create Student table
CREATE TABLE student (
student_id INT PRIMARY KEY AUTO_INCREMENT,
student_name VARCHAR(50),
student_height DECIMAL(5,2),
department_code INT
);


-- // Create Professor table
CREATE TABLE professor (
professor_code INT PRIMARY KEY AUTO_INCREMENT,
professor_name VARCHAR(50),
department_code INT
);

-- // Create Course table
CREATE TABLE course (
course_code INT PRIMARY KEY AUTO_INCREMENT,
course_name VARCHAR(50),
professor_code INT,
start_date DATE,
end_date DATE
);

-- // Create Student_Course table
CREATE TABLE student_course (
id INT not null unique,
student_id INT,
course_code INT,
primary key(student_id , course_code)
);

-- // Add foreign key constraints using ALTER TABLE
ALTER TABLE student ADD CONSTRAINT FK_Student_Department FOREIGN KEY (department_code) REFERENCES department(department_code);
ALTER TABLE professor ADD CONSTRAINT FK_Professor_Department FOREIGN KEY (department_code) REFERENCES department(department_code);
ALTER TABLE course ADD CONSTRAINT FK_Course_Professor FOREIGN KEY (professor_code) REFERENCES professor(professor_code);
ALTER TABLE student_course ADD CONSTRAINT FK_Student_Course_Student FOREIGN KEY (student_id) REFERENCES student(student_id);
ALTER TABLE student_course ADD CONSTRAINT FK_Student_Course_Course FOREIGN KEY (course_code) REFERENCES course(course_code);



-- 학과
INSERT INTO department (department_name) VALUES
("수학통계학"),
("국어문과"),
("전자정보통신과"),
("모바일AI공학");

-- 학생
INSERT INTO student (student_name, student_height,
department_code) VALUES
("가학생", 170.5, 1),
("나학생", 165.2, 1),
("다학생", 180.2, 1),
("라학생", 175.8, 2),
("마학생", 160.7, 2),
("바학생", 168.3, 3),
("사학생", 172.1, 4),
("아학생", 175.3, 4);

-- 교수
INSERT INTO professor (professor_name, department_code) VALUES
("가교수", 1),
("나교수", 2),
("다교수", 3),
("빌게이츠", 4),
("스티브잡스", 3);


-- 개설과목
INSERT INTO course (course_name, professor_code, start_date,
end_date) VALUES
("교양 영어", 1, "2023-07-01", "2023-08-15"),
("데이터베이스 입문", 3, "2023-07-01", "2023-08-31"),
("회로이론", 2, "2023-07-15", "2023-09-15"),
("공학수학", 4, "2023-07-15", "2023-09-30"),
("객체지향 프로그래밍", 3, "2023-07-01", "2023-08-31");

-- 수강
INSERT INTO student_course (id, student_id, course_code) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 3),
(5, 5, 4),
(6, 6, 5),
(7, 7, 5);


select * from shop.student;
select * from shop.department;
select * from shop.course;
select * from shop.professor;
select * from shop.student_course;


-- 학생번호, 학생이름, 키, 학과번호, 학과명 정보를 출력
select 
	s.student_id,
	s.student_name,
	s.student_height,
	d.department_code,
	d.department_name
from shop.student s 
inner join shop.department d 
on s.department_code = d.department_code;



select * from shop.department;
select * from shop.professor;
-- 교수의 학과정보를 출력
select
	p.professor_name,
	d.department_name
from shop.professor p 
join shop.department d 
on p.department_code = d.department_code;

-- 학과별 교수의 수를 출력
select d.department_name,count(p.professor_name) as count
from shop.professor p 
join shop.department d 
on p.department_code = d.department_code
group by d.department_name;

select * from shop.student s ;
select * from shop.department d; 

-- 수학통계학과 학생정보
select *
from shop.student s 
where s.department_code = 1;

select 
	s.student_id,
	s.student_name,
	s.student_height,
	d.department_name
from shop.student s 
join shop.department d 
on s.department_code = d.department_code
where d.department_name = '수학통계학';


select * from shop.student s ;
select * from shop.department d; 

-- 학생 중 성이 '바%'인 학생이 속한 학과이름과 학생이름을 출력
select 
	s.student_id,
	s.student_name,
	d.department_name
from shop.student s 
join shop.department d 
on s.department_code = d.department_code
where s.student_name like '바%';

-- 학생의 키가 175~180사이에 속하는 학생 수를 출력
select count(s.student_id) as cnt
from shop.student s
where s.student_height between 175 and 180;



-- 학과별 키의 최고값과 평균값을 출력




