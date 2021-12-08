<<<<<<< HEAD
INSERT INTO EMPLOYEE(EMPLOYEE_ID, EMPLOYEE_ROLE, EMPLOYEE_FIRST_NAME, 
                    EMPLOYEE_LAST_NAME, EMPLOYEE_HIRE_DATE, EMPLOYEE_TERMINATION_DATE, EMPLOYEE_SALARY) VALUES
( NULL, 'Manager' , 'Joe', 'McCarwash', '2021-01-01', NULL, 123456.99),
( NULL, 'Accountant' , 'Jane', 'Moneyhandler', '2021-01-01', NULL, 79999.23),
( NULL, 'Washer' , 'Jim', 'Buffer', '2021-01-01', '2021-02-02', 40000.24),
( NULL, 'Washer', 'Jack', 'Waxer', '2021-01-01', NULL, 40000.24);

INSERT INTO WASH (WASH_ID, WASH_TYPE, WASH_STATUS, EMPLOYEE_ID, CUSTOMER_ID) VALUES 
(NULL, 'basic', 1, 01, 05),
(NULL, 'basic', 0, 02, 15),
(NULL, 'basic', 0, 01, 20),
(NULL, 'premium', 0, 02, 25),
(NULL, 'executive', 0, 04, 30),
(NULL, 'executive', 0, 05, 35);
