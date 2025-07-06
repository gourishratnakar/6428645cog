
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE savings_accounts';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN RAISE;
        END IF;
END;
/
-
CREATE TABLE savings_accounts (
    account_id NUMBER PRIMARY KEY,
    account_holder VARCHAR2(100),
    balance NUMBER(10,2)
);
/

INSERT INTO savings_accounts VALUES (101, 'John Doe', 5000);
INSERT INTO savings_accounts VALUES (102, 'Jane Smith', 12000);
INSERT INTO savings_accounts VALUES (103, 'Alice Brown', 7000);
COMMIT;
/
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01);
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest has been applied to all savings accounts.');
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
SELECT * FROM savings_accounts;
