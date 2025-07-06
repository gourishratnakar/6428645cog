-- Drop tables if they already exist (optional, for clean reruns)
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
    NAME VARCHAR2(50),
    AGE NUMBER
);

-- Create LOANS table
CREATE TABLE LOANS (
    LOAN_ID NUMBER PRIMARY KEY,
    CUSTOMER_ID NUMBER,
    INTEREST_RATE NUMBER,
    FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID)
);

-- Insert sample data into CUSTOMERS
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, AGE) VALUES (1, 'John Doe', 65);
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, AGE) VALUES (2, 'Jane Smith', 58);
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, AGE) VALUES (3, 'Alan Brown', 70);

-- Insert sample data into LOANS
INSERT INTO LOANS (LOAN_ID, CUSTOMER_ID, INTEREST_RATE) VALUES (101, 1, 10);
INSERT INTO LOANS (LOAN_ID, CUSTOMER_ID, INTEREST_RATE) VALUES (102, 2, 12);
INSERT INTO LOANS (LOAN_ID, CUSTOMER_ID, INTEREST_RATE) VALUES (103, 3, 9);

COMMIT;

-- PL/SQL Block to apply 1% discount on interest rates for customers above 60
DECLARE
    CURSOR cust_cursor IS
        SELECT CUSTOMER_ID 
        FROM CUSTOMERS
        WHERE AGE > 60;

BEGIN
    -- Loop through all eligible customers
    FOR cust_rec IN cust_cursor LOOP

        -- Update interest rates for each loan of the eligible customer
        UPDATE LOANS
        SET INTEREST_RATE = INTEREST_RATE - 1
        WHERE CUSTOMER_ID = cust_rec.CUSTOMER_ID;

    END LOOP;

    -- Commit the changes
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated for customers above 60 years.');

END;
/

-- Display updated loan details
SELECT * FROM LOANS;
