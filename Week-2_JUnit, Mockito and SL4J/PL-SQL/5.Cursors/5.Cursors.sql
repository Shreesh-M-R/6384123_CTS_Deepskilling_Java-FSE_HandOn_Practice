-- Enable output
SET SERVEROUTPUT ON;

-- 1. Scenario: Generate Monthly Statements for All Customers
DECLARE
    CURSOR trans_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY c.CustomerID;

    rec trans_cursor%ROWTYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Monthly Statements ---');
    OPEN trans_cursor;
    LOOP
        FETCH trans_cursor INTO rec;
        EXIT WHEN trans_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || rec.CustomerID || ', Name: ' || rec.Name);
        DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || rec.TransactionID || ', Date: ' || TO_CHAR(rec.TransactionDate, 'YYYY-MM-DD') ||
                             ', Amount: ' || rec.Amount || ', Type: ' || rec.TransactionType);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------');
    END LOOP;
    CLOSE trans_cursor;
END;
/

-- 2. Scenario: Apply Annual Fee to All Accounts
DECLARE
    CURSOR account_cursor IS
        SELECT AccountID, Balance FROM Accounts;

    v_fee CONSTANT NUMBER := 200; -- Annual fee
    rec account_cursor%ROWTYPE;
BEGIN
    OPEN account_cursor;
    LOOP
        FETCH account_cursor INTO rec;
        EXIT WHEN account_cursor%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee,
            LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Annual fee of ' || v_fee || ' deducted from Account ID: ' || rec.AccountID);
    END LOOP;
    CLOSE account_cursor;

    COMMIT;
END;
/

-- 3. Scenario: Update Loan Interest Rates Based on Policy
DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, InterestRate, LoanAmount FROM Loans;

    rec loan_cursor%ROWTYPE;
    v_new_rate NUMBER;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO rec;
        EXIT WHEN loan_cursor%NOTFOUND;

        -- Apply new policy: if loan > 5000, increase interest by 0.5%, else decrease by 0.25%
        IF rec.LoanAmount > 5000 THEN
            v_new_rate := rec.InterestRate + 0.5;
        ELSE
            v_new_rate := rec.InterestRate - 0.25;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || rec.LoanID || ' interest updated to: ' || v_new_rate);
    END LOOP;
    CLOSE loan_cursor;

    COMMIT;
END;
/
