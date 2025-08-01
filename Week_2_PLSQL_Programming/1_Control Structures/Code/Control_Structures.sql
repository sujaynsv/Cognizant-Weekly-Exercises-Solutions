-- Step 1: Initialize and select the working database
CREATE DATABASE IF NOT EXISTS bank_system;
USE bank_system;

-- Step 2: Define the schema (MySQL Syntax)

CREATE TABLE CUSTOMERS (
    CUSTOMERID   INT AUTO_INCREMENT PRIMARY KEY,
    NAME         VARCHAR(100),
    DOB          DATE,
    BALANCE      DECIMAL(15,2),
    LASTMODIFIED DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE ACCOUNTS (
    ACCOUNTID    INT AUTO_INCREMENT PRIMARY KEY,
    CUSTOMERID   INT,
    ACCOUNTTYPE  VARCHAR(20),
    BALANCE      DECIMAL(15,2),
    LASTMODIFIED DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMERS(CUSTOMERID)
);

CREATE TABLE TRANSACTIONS (
    TRANSACTIONID   INT AUTO_INCREMENT PRIMARY KEY,
    ACCOUNTID       INT,
    TRANSACTIONDATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    AMOUNT          DECIMAL(15,2),
    TRANSACTIONTYPE VARCHAR(10),
    FOREIGN KEY (ACCOUNTID) REFERENCES ACCOUNTS(ACCOUNTID)
);

CREATE TABLE LOANS (
    LOANID       INT AUTO_INCREMENT PRIMARY KEY,
    CUSTOMERID   INT,
    LOANAMOUNT   DECIMAL(15,2),
    INTERESTRATE DECIMAL(5,2),
    STARTDATE    DATE,
    ENDDATE      DATE,
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMERS(CUSTOMERID)
);

CREATE TABLE EMPLOYEES (
    EMPLOYEEID INT AUTO_INCREMENT PRIMARY KEY,
    NAME       VARCHAR(100),
    POSITION   VARCHAR(50),
    SALARY     DECIMAL(15,2),
    DEPARTMENT VARCHAR(50),
    HIREDATE   DATE
);

-- Step 3: Insert sample records

INSERT INTO CUSTOMERS (CUSTOMERID, NAME, DOB, BALANCE, LASTMODIFIED)
VALUES (1, 'John Doe', '1985-05-15', 1000, NOW()),
       (2, 'Jane Smith', '1990-07-20', 1500, NOW());

INSERT INTO ACCOUNTS (ACCOUNTID, CUSTOMERID, ACCOUNTTYPE, BALANCE, LASTMODIFIED)
VALUES (1, 1, 'Savings', 1000, NOW()),
       (2, 2, 'Checking', 1500, NOW());

INSERT INTO TRANSACTIONS (TRANSACTIONID, ACCOUNTID, TRANSACTIONDATE, AMOUNT, TRANSACTIONTYPE)
VALUES (1, 1, NOW(), 200, 'Deposit'),
       (2, 2, NOW(), 300, 'Withdrawal');

INSERT INTO LOANS (LOANID, CUSTOMERID, LOANAMOUNT, INTERESTRATE, STARTDATE, ENDDATE)
VALUES (1, 1, 5000, 5, NOW(), DATE_ADD(NOW(), INTERVAL 60 MONTH));

INSERT INTO EMPLOYEES (EMPLOYEEID, NAME, POSITION, SALARY, DEPARTMENT, HIREDATE)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', '2015-06-15'),
       (2, 'Bob Brown', 'Developer', 60000, 'IT', '2017-03-20');

-- ===========================================
-- STORED PROCEDURES (MySQL, PL/SQL style)
-- ===========================================

-- Task 1: Reduce interest rate for senior customers (age > 60)

DELIMITER //

CREATE PROCEDURE UpdateLoanInterest()
BEGIN
    DECLARE finished INT DEFAULT 0;
    DECLARE var_customer_id INT;
    DECLARE var_age INT;

    DECLARE cur CURSOR FOR
        SELECT CUSTOMERID, TIMESTAMPDIFF(YEAR, DOB, CURDATE()) AS AGE
        FROM CUSTOMERS;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;

    OPEN cur;
    process_loop: LOOP
        FETCH cur INTO var_customer_id, var_age;
        IF finished THEN
            LEAVE process_loop;
        END IF;

        IF var_age > 60 THEN
            UPDATE LOANS
            SET INTERESTRATE = INTERESTRATE - 1
            WHERE CUSTOMERID = var_customer_id;
        ELSE
            SELECT CONCAT('CUSTOMER WITH CUSTOMER ID : ', var_customer_id, ' IS OF AGE : ', var_age) AS MESSAGE;
            SELECT 'NO CHANGE IN LOAN' AS MESSAGE;
        END IF;
    END LOOP;
    CLOSE cur;
END //

DELIMITER ;

CALL UpdateLoanInterest();

-- Task 2: Mark customers as VIP if their balance exceeds 10,000

ALTER TABLE CUSTOMERS ADD COLUMN ISVIP ENUM('TRUE','FALSE');

DELIMITER //

CREATE PROCEDURE UpdateVIPStatus()
BEGIN
    DECLARE finished INT DEFAULT 0;
    DECLARE var_customer_id INT;
    DECLARE var_balance DECIMAL(15,2);

    DECLARE cur CURSOR FOR
        SELECT CUSTOMERID, BALANCE FROM CUSTOMERS;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;

    OPEN cur;
    vip_loop: LOOP
        FETCH cur INTO var_customer_id, var_balance;
        IF finished THEN
            LEAVE vip_loop;
        END IF;

        IF var_balance > 10000 THEN
            SELECT CONCAT('CUSTOMER ID : ', var_customer_id, ' HAS BALANCE GREATER THAN 10000') AS MESSAGE;
            UPDATE CUSTOMERS SET ISVIP = 'TRUE' WHERE CUSTOMERID = var_customer_id;
        ELSE
            SELECT CONCAT('CUSTOMER ID : ', var_customer_id, ' HAS BALANCE LESSER THAN 10000') AS MESSAGE;
            UPDATE CUSTOMERS SET ISVIP = 'FALSE' WHERE CUSTOMERID = var_customer_id;
        END IF;
    END LOOP;
    CLOSE cur;
END //

DELIMITER ;

CALL UpdateVIPStatus();

-- Task 3: Notify about loans maturing in the next 30 days

DELIMITER //

CREATE PROCEDURE LoanReminder()
BEGIN
    DECLARE finished INT DEFAULT 0;
    DECLARE v_loan_id INT;
    DECLARE v_customer_id INT;
    DECLARE v_customer_name VARCHAR(100);
    DECLARE v_end_date DATE;
    DECLARE v_found INT DEFAULT 0;

    DECLARE cur CURSOR FOR
        SELECT L.LOANID, L.CUSTOMERID, C.NAME, L.ENDDATE
        FROM LOANS L
        JOIN CUSTOMERS C ON L.CUSTOMERID = C.CUSTOMERID
        WHERE L.ENDDATE BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;

    OPEN cur;
    reminder_loop: LOOP
        FETCH cur INTO v_loan_id, v_customer_id, v_customer_name, v_end_date;
        IF finished THEN
            LEAVE reminder_loop;
        END IF;

        SET v_found = 1;
        SELECT CONCAT('Reminder: Loan ', v_loan_id, ' for customer ', v_customer_name, ' (ID: ', v_customer_id, ') is due on ', DATE_FORMAT(v_end_date, '%Y-%m-%d')) AS MESSAGE;
    END LOOP;
    CLOSE cur;

    IF v_found = 0 THEN
        SELECT 'No loans are due within the next 30 days.' AS MESSAGE;
    END IF;
END //

DELIMITER ;

CALL LoanReminder();

-- ===========================================
-- ALTERNATIVE: Direct SQL statements
-- ===========================================

-- List customers older than 60 and show their age
SELECT 
    CUSTOMERID, 
    NAME,
    TIMESTAMPDIFF(YEAR, DOB, CURDATE()) AS AGE
FROM CUSTOMERS 
WHERE TIMESTAMPDIFF(YEAR, DOB, CURDATE()) > 60;

-- Decrease interest rate for loans of customers above 60
UPDATE LOANS L
JOIN CUSTOMERS C ON L.CUSTOMERID = C.CUSTOMERID
SET L.INTERESTRATE = L.INTERESTRATE - 1
WHERE TIMESTAMPDIFF(YEAR, C.DOB, CURDATE()) > 60;

-- Show which customers should be VIP
SELECT CUSTOMERID, NAME, BALANCE,
       CASE WHEN BALANCE > 10000 THEN 'TRUE' ELSE 'FALSE' END AS SHOULD_BE_VIP
FROM CUSTOMERS;

-- Update VIP status for all customers
UPDATE CUSTOMERS 
SET ISVIP = CASE WHEN BALANCE > 10000 THEN 'TRUE' ELSE 'FALSE' END;

-- List loans that are due in the next 30 days
SELECT 
    L.LOANID, 
    L.CUSTOMERID, 
    C.NAME, 
    L.ENDDATE,
    DATEDIFF(L.ENDDATE, CURDATE()) AS DAYS_UNTIL_DUE
FROM LOANS L
JOIN CUSTOMERS C ON L.CUSTOMERID = C.CUSTOMERID
WHERE L.ENDDATE BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)
ORDER BY L.ENDDATE;