BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE accounts';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE employees';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- 1. CREATE TABLES

CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    account_type VARCHAR2(20),
    balance NUMBER
);

CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    department_id NUMBER,
    salary NUMBER
);


INSERT INTO accounts VALUES (101, 'savings', 10000);
INSERT INTO accounts VALUES (102, 'current', 15000);
INSERT INTO accounts VALUES (103, 'savings', 20000);

INSERT INTO employees VALUES (1, 'Alice', 10, 50000);
INSERT INTO employees VALUES (2, 'Bob', 10, 45000);
INSERT INTO employees VALUES (3, 'Charlie', 20, 60000);

COMMIT;

-- 3. SCENARIO 1: PROCESS MONTHLY INTEREST

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE LOWER(account_type) = 'savings';

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- SCENARIO 2: UPDATE EMPLOYEE BONUS

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percent IN NUMBER
)
AS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percent / 100)
    WHERE department_id = p_department_id;

    DBMS_OUTPUT.PUT_LINE('Bonuses updated for department: ' || p_department_id);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

--  SCENARIO 3: TRANSFER FUNDS

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Deduct from source
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    -- Credit to target
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from ' || p_from_account || ' to ' || p_to_account);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


SET SERVEROUTPUT ON;

BEGIN
    ProcessMonthlyInterest;
END;
/

-- Test 2: Update Employee Bonus (5% bonus to department 10)
BEGIN
    UpdateEmployeeBonus(10, 5);
END;
/

BEGIN
    TransferFunds(103, 102, 2000);
END;
/

-- View results

SELECT * FROM accounts;
SELECT * FROM employees;