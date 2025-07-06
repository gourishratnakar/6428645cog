-- Drop existing tables if they exist (optional)
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE LOANS';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE CUSTOMERS';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;
/

-- Create CUSTOMERS table
CREATE TABLE CUSTOMERS (
    CUSTOMER_ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(50)
);

-- Create LOANS table
CREATE TABLE LOANS (
    LOAN_ID NUMBER PRIMARY KEY,
    CUSTOMER_ID NUMBER,
    DUE_DATE DATE,
    FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID)
);

-- Insert sample customers
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME) VALUES (1, 'John Doe');
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME) VALUES (2, 'Jane Smith');
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME) VALUES (3, 'Alan Brown');

-- Insert sample loans
INSERT INTO LOANS (LOAN_ID, CUSTOMER_ID, DUE_DATE) VALUES (101, 1, SYSDATE + 10);
INSERT INTO LOANS (LOAN_ID, CUSTOMER_ID, DUE_DATE) VALUES (102, 2, SYSDATE + 25);
INSERT INTO LOANS (LOAN_ID, CUSTOMER_ID, DUE_DATE) VALUES (103, 3, SYSDATE + 40);

COMMIT;

-- PL/SQL Block to send reminders for loans due in the next 30 days
DECLARE
    CURSOR due_soon_cursor IS
        SELECT C.NAME, L.LOAN_ID, L.DUE_DATE
        FROM CUSTOMERS C
        JOIN LOANS L ON C.CUSTOMER_ID = L.CUSTOMER_ID
        WHERE L.DUE_DATE BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN due_soon_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.NAME || 
                             ', your Loan ID ' || rec.LOAN_ID || 
                             ' is due on ' || TO_CHAR(rec.DUE_DATE, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/

-- (optional) check loans
SELECT * FROM LOANS;
