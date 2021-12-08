DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE
(
    EMPLOYEE_ID INT PRIMARY KEY AUTO_INCREMENT,
    EMPLOYEE_ROLE VARCHAR(10),
    EMPLOYEE_FIRST_NAME VARCHAR(15),
    EMPLOYEE_LAST_NAME VARCHAR(25),
    EMPLOYEE_HIRE_DATE DATE,
    EMPLOYEE_TERMINATION_DATE DATE,
    EMPLOYEE_SALARY DECIMAL (8,2)
    
);

DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER
(
    CUSTOMER_ID INT PRIMARY KEY AUTO_INCREMENT,
    CUSTOMER_FIRST_NAME VARCHAR(15),
    CUSTOMER_LAST_NAME VARCHAR(25)
);

DROP TABLE IF EXISTS WASH;

CREATE TABLE WASH (
    WASH_ID INT PRIMARY KEY AUTO_INCREMENT,
    WASH_TYPE ENUM('basic', 'premium', 'executive'),
    WASH_STATUS BOOL NOT NULL DEFAULT 0,
    EMPLOYEE_ID INT,
    CUSTOMER_ID INT,
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID),
    FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID)   

);

DROP TABLE IF EXISTS INVOICE;

CREATE TABLE INVOICE (
    INVOICE_ID INT PRIMARY KEY AUTO_INCREMENT,
    WASH_ID INT,
    CUSTOMER_ID INT,
    INVOICE_TOTAL DECIMAL(6,2),
    INVOICE_BALANCE DECIMAL(6,2),
    CREATED_DATE DATE,
    PAID_DATE DATE,
    FOREIGN KEY (WASH_ID) REFERENCES WASH(WASH_ID),
    FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID)
);

DROP TABLE IF EXISTS PAYMENT;
CREATE TABLE PAYMENT (
    PAYMENT_ID INT PRIMARY KEY AUTO_INCREMENT,
    INVOICE_ID INT,
    PAYMENT_AMOUNT DECIMAL(6,2),
    FOREIGN KEY (INVOICE_ID) REFERENCES INVOICE(INVOICE_ID)
);