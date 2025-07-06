-- Drop existing table if it exists (optional)
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
    BALANCE NUMBER,
    ISVIP CHAR(1) DEFAULT 'N'
);

-- Insert sample data
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, BALANCE) VALUES (1, 'John Doe', 5000);
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, BALANCE) VALUES (2, 'Jane Smith', 15000);
INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, BALANCE) VALUES (3, 'Alan Brown', 25000);

COMMIT;

-- PL/SQL Block to promote customers with balance > 10000 to VIP
DECLARE
    CURSOR cust_cursor IS
        SELECT CUSTOMER_ID 
        FROM CUSTOMERS
        WHERE BALANCE > 10000;

BEGIN
    -- Loop through all eligible customers
    FOR cust_rec IN cust_cursor LOOP

        -- Set ISVIP flag to 'Y' for each eligible customer
        UPDATE CUSTOMERS
        SET ISVIP = 'Y'
        WHERE CUSTOMER_ID = cust_rec.CUSTOMER_ID;

    END LOOP;

    -- Commit the changes
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated for customers with balance over 10000.');

END;
/

-- Display updated customer records
SELECT * FROM CUSTOMERS;
