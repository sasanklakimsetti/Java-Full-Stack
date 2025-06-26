use jdbc;

-- Create a table Customer
CREATE TABLE Customer(
custid INT,
name VARCHAR(100),
phone VARCHAR(13),
address VARCHAR(250)
);

--  Make custid primary key
ALTER TABLE Customer ADD PRIMARY KEY (custid);
-- Make name not null
ALTER TABLE Customer MODIFY COLUMN name VARCHAR(100) NOT NULL;
-- Insert 10 rows
INSERT INTO Customer VALUES (1002,"Sai","9133931410","Tanuku");
INSERT INTO Customer VALUES (1003,"Sasank","9133931411","Tanuku");
INSERT INTO Customer VALUES (1004,"Yuvaraj","8978987389","Penugonda");
INSERT INTO Customer VALUES (1005,"Sahithi","9948507775","Tanuku");
INSERT INTO Customer VALUES (1006,"Prasad","9948062853","Tanuku");
INSERT INTO Customer VALUES (1007,"Madhavi","9912499757","Tanuku");
INSERT INTO Customer VALUES (1008,"Harshith","8919578631","Tanuku");
INSERT INTO Customer VALUES (1009,"Rishith","8317579171","Velpur");
INSERT INTO Customer VALUES (1010,"Ram","7780553421","Peravali");
INSERT INTO Customer VALUES (1011,"Kalyan","6542587456","Rajahmundry");

-- Make phone unique
ALTER TABLE Customer MODIFY COLUMN phone VARCHAR(13) UNIQUE;
-- add column email
ALTER TABLE Customer ADD COLUMN email VARCHAR(50);
-- Add constraint such that both email and phone can't be null. Either of them can be null
ALTER TABLE Customer ADD CONSTRAINT chk_email_phone CHECK(email IS NOT NULL OR phone IS NOT NULL);
-- add column age with default value 25
ALTER TABLE Customer ADD COLUMN age INT DEFAULT 25;
desc Customer;
-- Insert min rows with age>40
INSERT INTO Customer (custid, name, phone, address, age) VALUES (1012,"Vikram","6549872310","Rajahmundry",45);
INSERT INTO Customer (custid, name, phone, address, age) VALUES (1013,"Vikranth","6549871231","Rajahmundry",55);
INSERT INTO Customer (custid, name, phone, address, age) VALUES (1014,"Parakram","7872372310","Vijayawada",45);

-- Create table OldCustomer from Customer with same rows but only with age>=40
CREATE TABLE OldCustomer AS 
SELECT * FROM Customer WHERE age>=40;

-- Make phone to VARCHAR(15)
ALTER TABLE Customer MODIFY COLUMN phone VARCHAR(15);
-- Rename name to custname
ALTER TABLE Customer RENAME COLUMN name to custname;
-- Make primary key auto increment
ALTER TABLE Customer MODIFY COLUMN custid INT AUTO_INCREMENT;

SELECT * FROM Customer;
SELECT * FROM OldCustomer;

-- Print customer name whose name starts with V
SELECT * FROM Customer WHERE custname LIKE 'V%';
-- contains SH
SELECT * FROM Customer WHERE custname LIKE '%sh%';
-- ends with i
SELECT * FROM Customer WHERE custname LIKE '%i';
-- starts with S and ends with i
SELECT * FROM Customer WHERE custname LIKE 's%i';  -- like is case-insensitive  i.e. it will treat S and s as same