CREATE DATABASE IF NOT EXISTS Bank;

USE Bank;

CREATE TABLE Accounts(
accNo VARCHAR(12) primary KEY,
balance DOUBLE
);

CREATE TABLE DebitOrCredit(
transactionID int auto_increment primary KEY,
senderAcNo VARCHAR(12),
receiverAcNo VARCHAR(12),
amount double);

INSERT INTO Accounts VALUES("1234",50000), ("1245",40000);

SET AUTOCOMMIT=0;
UPDATE Accounts SET balance=balance-10000 WHERE accNo="1234";
INSERT INTO DebitOrCredit(senderAcNo, receiverAcNo,amount) VALUES( "1234","1245",10000);
TRUNCATE DebitOrCredit;
UPDATE Accounts SET balance=balance+10000 WHERE accNo="1245";
COMMIT;

SELECT * FROM Accounts;
SELECT * FROM DebitOrCredit;