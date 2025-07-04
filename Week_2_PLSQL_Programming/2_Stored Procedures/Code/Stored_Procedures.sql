-- Database Schema Definition

CREATE TABLE CUSTOMERS (
    CUSTOMERID   NUMBER PRIMARY KEY,
    NAME         VARCHAR2(100),
    DOB          DATE,
    BALANCE      NUMBER,
    LASTMODIFIED DATE
);

CREATE TABLE ACCOUNTS (
    ACCOUNTID    NUMBER PRIMARY KEY,
    CUSTOMERID   NUMBER,
    ACCOUNTTYPE  VARCHAR2(20),
    BALANCE      NUMBER,
    LASTMODIFIED DATE,
    FOREIGN KEY ( CUSTOMERID )
        REFERENCES CUSTOMERS ( CUSTOMERID )
);

CREATE TABLE TRANSACTIONS (
    TRANSACTIONID   NUMBER PRIMARY KEY,
    ACCOUNTID       NUMBER,
    TRANSACTIONDATE DATE,
    AMOUNT          NUMBER,
    TRANSACTIONTYPE VARCHAR2(10),
    FOREIGN KEY ( ACCOUNTID )
        REFERENCES ACCOUNTS ( ACCOUNTID )
);

CREATE TABLE LOANS (
    LOANID       NUMBER PRIMARY KEY,
    CUSTOMERID   NUMBER,
    LOANAMOUNT   NUMBER,
    INTERESTRATE NUMBER,
    STARTDATE    DATE,
    ENDDATE      DATE,
    FOREIGN KEY ( CUSTOMERID )
        REFERENCES CUSTOMERS ( CUSTOMERID )
);

CREATE TABLE EMPLOYEES (
    EMPLOYEEID NUMBER PRIMARY KEY,
    NAME       VARCHAR2(100),
    POSITION   VARCHAR2(50),
    SALARY     NUMBER,
    DEPARTMENT VARCHAR2(50),
    HIREDATE   DATE
);

-- Sample Data Population

-- Adding records to CUSTOMERS
INSERT INTO CUSTOMERS (CUSTOMERID, NAME, DOB, BALANCE, LASTMODIFIED)
VALUES (1, 'Michael Green', TO_DATE('1982-04-10', 'YYYY-MM-DD'), 1200, SYSDATE);
INSERT INTO CUSTOMERS (CUSTOMERID, NAME, DOB, BALANCE, LASTMODIFIED)
VALUES (2, 'Emily White', TO_DATE('1991-09-25', 'YYYY-MM-DD'), 1800, SYSDATE);

-- Adding records to ACCOUNTS
INSERT INTO ACCOUNTS (ACCOUNTID, CUSTOMERID, ACCOUNTTYPE, BALANCE, LASTMODIFIED)
VALUES (1, 1, 'Savings', 1200, SYSDATE);
INSERT INTO ACCOUNTS (ACCOUNTID, CUSTOMERID, ACCOUNTTYPE, BALANCE, LASTMODIFIED)
VALUES (2, 2, 'Checking', 1800, SYSDATE);

-- Adding records to TRANSACTIONS
INSERT INTO TRANSACTIONS (TRANSACTIONID, ACCOUNTID, TRANSACTIONDATE, AMOUNT, TRANSACTIONTYPE)
VALUES (1, 1, SYSDATE, 250, 'Deposit');
INSERT INTO TRANSACTIONS (TRANSACTIONID, ACCOUNTID, TRANSACTIONDATE, AMOUNT, TRANSACTIONTYPE)
VALUES (2, 2, SYSDATE, 400, 'Withdrawal');

-- Adding records to LOANS
INSERT INTO LOANS (LOANID, CUSTOMERID, LOANAMOUNT, INTERESTRATE, STARTDATE, ENDDATE)
VALUES (1, 1, 7000, 4.5, SYSDATE, ADD_MONTHS(SYSDATE, 48));

-- Adding records to EMPLOYEES
INSERT INTO EMPLOYEES (EMPLOYEEID, NAME, POSITION, SALARY, DEPARTMENT, HIREDATE)
VALUES (1, 'Sophie Turner', 'Manager', 75000, 'HR', TO_DATE('2014-08-12', 'YYYY-MM-DD'));
INSERT INTO EMPLOYEES (EMPLOYEEID, NAME, POSITION, SALARY, DEPARTMENT, HIREDATE)
VALUES (2, 'Chris Evans', 'Developer', 65000, 'IT', TO_DATE('2018-01-10', 'YYYY-MM-DD'));

-- TASKS AND SOLUTIONS

/*

Task 3: Stored Procedures

Situation 1: The bank is required to apply monthly interest to all savings accounts.
        - Task: Develop a stored procedure named ProcessMonthlyInterest that increases the balance of every savings account by 1%.

Situation 2: The bank is introducing a performance-based bonus for employees.
        - Task: Create a stored procedure UpdateEmployeeBonus to increment the salary of employees in a specified department by a given bonus percentage.

Situation 3: Customers should be able to move funds between their accounts.
        - Task: Write a stored procedure TransferFunds to move a specified sum from one account to another, ensuring the source account has enough funds before proceeding.

*/

-- SITUATION 1

SELECT * FROM ACCOUNTS;

DELIMITER //

CREATE PROCEDURE PROCESSMONTHLYINTEREST()
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT CONCAT('Monthly interest process encountered an error: ', ERROR_MESSAGE()) AS MESSAGE;
    END;

    START TRANSACTION;
    
    UPDATE ACCOUNTS
    SET BALANCE = BALANCE * 1.01,
        LASTMODIFIED = NOW()
    WHERE ACCOUNTTYPE = 'Savings';
    
    COMMIT;
    SELECT 'Interest for the month has been applied to all savings accounts.' AS MESSAGE;
END //

DELIMITER ;

CALL PROCESSMONTHLYINTEREST();

SELECT * FROM ACCOUNTS;


-- SITUATION 2

SELECT * FROM EMPLOYEES;

DELIMITER //

CREATE PROCEDURE UPDATEEMPLOYEEBONUS(
    IN P_DEPARTMENT VARCHAR(50),
    IN P_BONUS_PERCENTAGE DECIMAL(5,2)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT CONCAT('Error during bonus update: ', ERROR_MESSAGE()) AS MESSAGE;
    END;

    START TRANSACTION;
    
    UPDATE EMPLOYEES
    SET SALARY = SALARY * (1 + P_BONUS_PERCENTAGE / 100),
        HIREDATE = NOW()
    WHERE DEPARTMENT = P_DEPARTMENT;
    
    COMMIT;
    SELECT CONCAT('Bonus has been granted to employees in the ', P_DEPARTMENT, ' department.') AS MESSAGE;
END //

DELIMITER ;

CALL UPDATEEMPLOYEEBONUS('IT', 5);
CALL UPDATEEMPLOYEEBONUS('HR', 3);

SELECT * FROM EMPLOYEES;


-- SITUATION 3

SELECT * FROM ACCOUNTS;

DELIMITER //

CREATE PROCEDURE TRANSFERFUNDS(
    IN P_FROM_ACCOUNT_ID INT,
    IN P_TO_ACCOUNT_ID INT,
    IN P_AMOUNT DECIMAL(15,2)
)
BEGIN
    DECLARE V_FROM_BALANCE DECIMAL(15,2);
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT CONCAT('Transfer could not be completed: ', ERROR_MESSAGE()) AS MESSAGE;
    END;

    START TRANSACTION;

    SELECT BALANCE INTO V_FROM_BALANCE
    FROM ACCOUNTS
    WHERE ACCOUNTID = P_FROM_ACCOUNT_ID
    FOR UPDATE;

    IF V_FROM_BALANCE < P_AMOUNT THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Source account does not have sufficient funds.';
    END IF;

    UPDATE ACCOUNTS
    SET BALANCE = BALANCE - P_AMOUNT,
        LASTMODIFIED = NOW()
    WHERE ACCOUNTID = P_FROM_ACCOUNT_ID;

    UPDATE ACCOUNTS
    SET BALANCE = BALANCE + P_AMOUNT,
        LASTMODIFIED = NOW()
    WHERE ACCOUNTID = P_TO_ACCOUNT_ID;

    COMMIT;
    SELECT CONCAT('Successfully transferred ', P_AMOUNT, ' from account ', P_FROM_ACCOUNT_ID, ' to account ', P_TO_ACCOUNT_ID, '.') AS MESSAGE;
END //

DELIMITER ;

CALL TRANSFERFUNDS(1, 2, 100);

SELECT * FROM ACCOUNTS;
