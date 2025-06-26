CREATE DATABASE jdbc;

USE jdbc;
SHOW TABLES;

CREATE TABLE Student(
rollNo INT PRIMARY KEY,
name VARCHAR(100),
branch VARCHAR(50),
mobileNo VARCHAR(12)
);

INSERT INTO Student VALUES(101,'Amit','ECE','9876541230');
INSERT INTO Student VALUES(102,'SAmit','CSE','9876541210');
SELECT * FROM Student;
desc Student;
INSERT INTO Student VALUES (107,"Shiv",null,null);
INSERT INTO Student(rollNo, name) VALUES (108,"Sai");

SELECT * FROM Student WHERE branch IS NULL;
SELECT * FROM Student WHERE branch IS NOT NULL;
SELECT * FROM Student WHERE rollNo in (101,102,103);
SELECT * FROM Student WHERE rollNo not in (101,102,103);
SELECT * FROM Student WHERE rollNo BETWEEN 101 AND 105;

UPDATE Student SET branch="CSE" WHERE rollNo IN (101,103,107);

-- Change VARCHAR(100) to VARCHAR(150) for name column
ALTER TABLE Student MODIFY COLUMN name VARCHAR(150) NOT NULL;
-- Rename name to sname
ALTER TABLE Student RENAME COLUMN name TO sname;
-- Add new column DOB
ALTER TABLE Student ADD COLUMN dob DATE;
-- add new column marks which is integer, can not be null, will be >=40 and <=100
ALTER TABLE Student ADD COLUMN marks INT NOT NULL DEFAULT 40 CHECK (marks<=100);
ALTER TABLE Student ADD CONSTRAINT marksconstraint CHECK(marks>=40 AND marks<=100);
-- Drop Column marks
ALTER TABLE Student DROP COLUMN marks;
-- Add Column gender(male or female)
ALTER TABLE Student ADD COLUMN gender ENUM("male","female");
UPDATE Student SET gender=1 WHERE rollNo=105;  -- given 1 as gender since 1 is mapped to male in enum
UPDATE Student SET marks=70 WHERE rollNo=103;

-- 5 aggregate methods : min, max, sum, count, avg
SELECT min(marks) FROM Student;
SELECT max(marks) FROM Student;
SELECT avg(marks) FROM Student;
SELECT sum(marks) FROM Student;
SELECT count(marks) FROM Student;
-- count no.of rows in the table
SELECT COUNT(*) FROM Student;
SELECT COUNT(dob) FROM Student;  -- return 0 since dob in every row is currently null


-- find the name of student who got maximum marks
SELECT sname, marks FROM Student WHERE marks=(SELECT max(marks) FROM Student);
SELECT sname, marks FROM Student WHERE marks=(SELECT min(marks) FROM Student);
SELECT sname, marks FROM Student ORDER BY marks DESC LIMIT 3;  -- get top 3 students
