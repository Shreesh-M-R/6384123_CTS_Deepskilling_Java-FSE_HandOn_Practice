
SET SERVEROUTPUT ON;

-- 1. Trigger: UpdateCustomerLastModified
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

-- 2. Table: AuditLog
BEGIN
    EXECUTE IMMEDIATE '
    CREATE TABLE AuditLog (
        AuditID NUMBER GENERATED ALWAYS AS IDENTITY,
        TransactionID NUMBER,
        AccountID NUMBER,
        Amount NUMBER,
        TransactionType VARCHAR2(10),
        LoggedDate DATE DEFAULT SYSDATE
    )';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE = -955 THEN
            DBMS_OUTPUT.PUT_LINE('Table AuditLog already exists.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Error creating AuditLog: ' || SQLERRM);
        END IF;
END;
/

-- 3. Trigger: LogTransaction
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AccountID, Amount, TransactionType)
    VALUES (:NEW.TransactionID, :NEW.AccountID, :NEW.Amount, :NEW.TransactionType);
END;
/

-- 4. Trigger: CheckTransactionRules
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds account balance.');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be greater than zero.');
        END IF;
    END IF;
END;
/

-- 5. Test Block 
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Testing Transactions ---');

    
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (1001, 1, SYSDATE, 500, 'Deposit');

   
    BEGIN
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (1002, 1, SYSDATE, 999999, 'Withdrawal');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;
END;
/ 
