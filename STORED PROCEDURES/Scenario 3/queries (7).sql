
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE accounts';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN RAISE;
        END IF;
END;
/

CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    account_holder VARCHAR2(100),
    balance NUMBER(10,2)
);
/

INSERT INTO accounts VALUES (1001, 'John Doe', 5000);
INSERT INTO accounts VALUES (1002, 'Jane Smith', 3000);
COMMIT;
/
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account_id;

   
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

  
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;

    
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from account ' ||
                         p_from_account_id || ' to account ' || p_to_account_id);
END;
/
BEGIN
    TransferFunds(1001, 1002, 1000);
END;
/
SELECT * FROM accounts;
