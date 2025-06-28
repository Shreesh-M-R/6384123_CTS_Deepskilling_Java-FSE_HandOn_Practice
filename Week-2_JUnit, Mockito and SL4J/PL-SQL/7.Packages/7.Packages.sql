SET SERVEROUTPUT ON;1

BEGIN
    -- Customer
    CustomerManagement.AddCustomer(101, 'Steve Rogers', TO_DATE('1980-07-04','YYYY-MM-DD'), 15000);
    CustomerManagement.UpdateCustomer(101, 'Steve R.', 20000);
    DBMS_OUTPUT.PUT_LINE('Balance: ' || CustomerManagement.GetCustomerBalance(101));

    -- Employee
    EmployeeManagement.HireEmployee(10, 'Bruce Banner', 'Scientist', 75000, 'Research', SYSDATE);
    EmployeeManagement.UpdateEmployee(10, 80000);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || EmployeeManagement.GetAnnualSalary(10));

    -- Account
    AccountOperations.OpenAccount(201, 101, 'Savings', 15000);
    DBMS_OUTPUT.PUT_LINE('Total Balance: ' || AccountOperations.GetTotalBalance(101));
    AccountOperations.CloseAccount(201);
END;
/


CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_id);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
    END;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
    BEGIN
        UPDATE Customers SET Name = p_name, Balance = p_balance, LastModified = SYSDATE
        WHERE CustomerID = p_id;
        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_id);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error updating customer: ' || SQLERRM);
    END;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Customer not found.');
            RETURN NULL;
    END;
END CustomerManagement;
/


CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hire DATE);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hire DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_pos, p_salary, p_dept, p_hire);
        DBMS_OUTPUT.PUT_LINE(' Employee hired: ' || p_id);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE(' Error hiring employee: ' || SQLERRM);
    END;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER) IS
    BEGIN
        UPDATE Employees SET Salary = p_salary WHERE EmployeeID = p_id;
        DBMS_OUTPUT.PUT_LINE('Salary updated: ' || p_id);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE(' Error updating salary: ' || SQLERRM);
    END;

    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Employee not found.');
            RETURN NULL;
    END;
END EmployeeManagement;
/


CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_acc_id NUMBER);
    FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_acc_id, p_cust_id, p_type, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE(' Account opened: ' || p_acc_id);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error opening account: ' || SQLERRM);
    END;

    PROCEDURE CloseAccount(p_acc_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_acc_id;
        DBMS_OUTPUT.PUT_LINE(' Account closed: ' || p_acc_id);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error closing account: ' || SQLERRM);
    END;

    FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_cust_id;
        RETURN NVL(v_total, 0);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error fetching balance: ' || SQLERRM);
            RETURN NULL;
    END;
END AccountOperations;
/


