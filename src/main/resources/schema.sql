DROP TABLE IF EXISTS WASH;

CREATE TABLE WASH (
    WASH_ID INT PRIMARY KEY AUTO_INCREMENT,
    WASH_TYPE ENUM('basic', 'premium', 'executive'),
    WASH_STATUS BOOL NOT NULL DEFAULT 0,
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID),
    FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID)   
);