
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE accounts';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/


CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    balance NUMBER
);


INSERT INTO accounts VALUES (101, 10000);
INSERT INTO accounts VALUES (102, 4500);
INSERT INTO accounts VALUES (103, 30000);
COMMIT;


CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE)
RETURN NUMBER
AS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/


CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount     NUMBER,
    p_annual_rate     NUMBER,
    p_years           NUMBER
)
RETURN NUMBER
AS
    v_monthly_rate NUMBER;
    v_months       NUMBER;
    v_emi          NUMBER;
BEGIN
    v_monthly_rate := p_annual_rate / 12 / 100;
    v_months := p_years * 12;

    v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months) /
             (POWER(1 + v_monthly_rate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
END;
/


CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
)
RETURN BOOLEAN
AS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        RETURN FALSE;
END;
/


SET SERVEROUTPUT ON;


BEGIN
    DBMS_OUTPUT.PUT_LINE('Age: ' || CalculateAge(TO_DATE('1995-05-15', 'YYYY-MM-DD')));
END;
/

-- 8. Test: CalculateMonthlyInstallment
BEGIN
    DBMS_OUTPUT.PUT_LINE('Monthly EMI: ' || CalculateMonthlyInstallment(500000, 7.5, 5));
END;
/


DECLARE
    result BOOLEAN;
BEGIN
    result := HasSufficientBalance(101, 7000);
    IF result THEN
        DBMS_OUTPUT.PUT_LINE(' Sufficient balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE(' Insufficient balance');
    END IF;
END;
/


DECLARE
    result BOOLEAN;
BEGIN
    result := HasSufficientBalance(102, 7000);
    IF result THEN
        DBMS_OUTPUT.PUT_LINE(' Sufficient balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE(' Insufficient balance');
    END IF;
END;
/


SELECT * FROM accounts;
