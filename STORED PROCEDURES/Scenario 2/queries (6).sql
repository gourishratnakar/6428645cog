BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE employees';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN RAISE;
        END IF;
END;
/

CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    department VARCHAR2(50),
    salary NUMBER(10,2)
);
/

INSERT INTO employees VALUES (1, 'Alice', 'Sales', 40000);
INSERT INTO employees VALUES (2, 'Bob', 'Sales', 42000);
INSERT INTO employees VALUES (3, 'Charlie', 'IT', 50000);
INSERT INTO employees VALUES (4, 'Diana', 'HR', 45000);
COMMIT;
/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percent / 100)
    WHERE department = p_department;
    
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percent || '% applied to ' || p_department || ' department.');
END;
/
BEGIN
    UpdateEmployeeBonus('Sales', 10);
END;
/
SELECT * FROM employees;
