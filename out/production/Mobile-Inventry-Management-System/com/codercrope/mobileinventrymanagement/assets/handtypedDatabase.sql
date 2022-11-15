-- -----------------------------------------------------
-- Schema mobile_shop_SMS
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mobile_shop_SMS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS mobile_shop_SMS DEFAULT CHARACTER SET utf8 ;
USE mobile_shop_SMS ;

-- -----------------------------------------------------
-- Table mobile_shop_SMS.Batch
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.batch (
    batch_id VARCHAR(20) NOT NULL,
    batch_dtl VARCHAR(512) NOT NULL,
    date_time DATETIME NOT NULL,
    PRIMARY KEY (batch_id)
);


-- -----------------------------------------------------
-- Table mobile_shop_SMS.administrative-dtl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.administrative_dtl (
    administrative_dtl_id VARCHAR(20) NOT NULL,
    administrative_stats VARCHAR(45) NOT NULL,
    PRIMARY KEY (administrative_dtl_id)
);


-- -----------------------------------------------------
-- Table mobile_shop_SMS.Employee
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.employee (
    employee_id VARCHAR(20) NOT NULL,
    administrative_dtl_id VARCHAR(20) NOT NULL,
    full_name VARCHAR(45) NOT NULL,
    birthday DATE NOT NULL,
    address VARCHAR(45) NOT NULL,
    pwd VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    employee_dtl JSON NULL,
    PRIMARY KEY (employee_id),
    CONSTRAINT FOREIGN KEY (administrative_dtl_id)
    REFERENCES mobile_shop_SMS.administrative_dtl (administrative_dtl_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.payment
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.payment (
    payment_id VARCHAR(20) NOT NULL,
    employee_employee_id VARCHAR(20) NOT NULL,
    payment_amount DECIMAL(8,2) NOT NULL,
    payment_date_time DATETIME NOT NULL,
    PRIMARY KEY (payment_id, employee_employee_id),
    INDEX fk_payment_employee1_idx (employee_employee_id ASC) VISIBLE,
    CONSTRAINT fk_payment_employee1
    FOREIGN KEY (employee_employee_id)
    REFERENCES mobile_shop_SMS.employee (employee_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.online-orders
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.online_orders (
    order_id VARCHAR(20) NOT NULL,
    batch_batch_id VARCHAR(20) NOT NULL,
    payment_payment_id VARCHAR(20) NOT NULL,
    employee_idemployee_id VARCHAR(20) NOT NULL,
    date_time DATETIME NOT NULL,
    online_orders_links JSON NOT NULL,
    PRIMARY KEY (order_id, payment_payment_id, employee_idemployee_id),
    INDEX fk_online_orders_batch1_idx (batch_batch_id ASC) VISIBLE,
    INDEX fk_online_orders_payment1_idx (payment_payment_id ASC) VISIBLE,
    INDEX fk_online_orders_employee1_idx (employee_idemployee_id ASC) VISIBLE,
    CONSTRAINT fk_online_orders_batch1
    FOREIGN KEY (batch_batch_id)
    REFERENCES mobile_shop_SMS.batch (batch_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT fk_online_orders_payment1
    FOREIGN KEY (payment_payment_id)
    REFERENCES mobile_shop_SMS.payment (payment_id)
    ON DELETE CASCADE
    ON UPDATE cascade,
    CONSTRAINT fk_online_orders_employee1
    FOREIGN KEY (employee_idemployee_id)
    REFERENCES mobile_shop_SMS.employee (employee_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.warranty-type
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.warranty_type (
    warranty_type_id VARCHAR(20) NOT NULL,
    warranty_duration VARCHAR(8) NOT NULL,
    warranty_cost VARCHAR(45) NOT NULL,
    warranty_type_dtl JSON NULL,
    PRIMARY KEY (warranty_type_id)
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.warrenty
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.warrenty (
    warranty_id VARCHAR(20) NOT NULL,
    warranty_type_warranty_type_id VARCHAR(20) NOT NULL,
    PRIMARY KEY (warranty_id),
    INDEX fk_warrenty_warranty_type1_idx (warranty_type_warranty_type_id ASC) VISIBLE,
    CONSTRAINT fk_warrenty_warranty_type1
    FOREIGN KEY (warranty_type_warranty_type_id)
    REFERENCES mobile_shop_SMS.warranty_type (warranty_type_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.item
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.item (
    item_id VARCHAR(20) NOT NULL,
    warrenty_warranty VARCHAR(20) NOT NULL,
    item_name VARCHAR(45) NOT NULL,
    item_added_date_time DATETIME NOT NULL,
    ite_price_stock DECIMAL(8,2) NOT NULL,
    profit_percentage INT NOT NULL,
    itm_dtl JSON NULL,
    PRIMARY KEY (item_id),
    INDEX fk_item_warrenty1_idx (warrenty_warranty ASC) VISIBLE,
    CONSTRAINT fk_item_warrenty1
    FOREIGN KEY (warrenty_warranty)
    REFERENCES mobile_shop_SMS.warrenty (warranty_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.BatchHasItem
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.batch_has_item (
    batch_batch_id VARCHAR(20) NOT NULL,
    item_item_id VARCHAR(20) NOT NULL,
    PRIMARY KEY (batch_batch_id, item_item_id),
    INDEX fk_batch_has_item_item1_idx (item_item_id ASC) VISIBLE,
    INDEX fk_batch_has_item_batch_idx (batch_batch_id ASC) VISIBLE,
    CONSTRAINT fk_batch_has_item_batch
    FOREIGN KEY (batch_batch_id)
    REFERENCES mobile_shop_SMS.batch (batch_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT fk_batch_has_item_item1
    FOREIGN KEY (item_item_id)
    REFERENCES mobile_shop_SMS.item (item_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.cust-payment-type
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.cust_payment_type (
    cust_payment_type_id VARCHAR(20) NOT NULL,
    payment_type VARCHAR(45) NOT NULL,
    descreption VARCHAR(100) NOT NULL,
    cust_payment_dtl JSON NULL,
    PRIMARY KEY (cust_payment_type_id, payment_type)
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.cust-order
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.cust_order (
    order_id VARCHAR(20) NOT NULL,
    cust_payment_type_cust_payment_type_id VARCHAR(20) NOT NULL,
    employee_id VARCHAR(20) NOT NULL,
    date_time DATETIME NOT NULL,
    cust_payment_stats VARCHAR(45) NOT NULL,
    cust_order_dtl JSON NULL,
    PRIMARY KEY (order_id, employee_id),
    INDEX fk_order_cust_payment_type1_idx (cust_payment_type_cust_payment_type_id ASC) VISIBLE,
    INDEX fk_cust_order_employee1_idx (employee_id ASC) VISIBLE,
    CONSTRAINT fk_order_cust_payment_type1
    FOREIGN KEY (cust_payment_type_cust_payment_type_id)
    REFERENCES mobile_shop_SMS.cust_payment_type (cust_payment_type_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT fk_cust_order_employee1
    FOREIGN KEY (employee_id)
    REFERENCES mobile_shop_SMS.employee (employee_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.cust-order_has_item
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.cust_order_has_item (
    cust_order_order_id VARCHAR(20) NOT NULL,
    item_item_id VARCHAR(20) NOT NULL,
    qty DOUBLE NULL,
    PRIMARY KEY (cust_order_order_id, item_item_id),
    INDEX fk_order_has_item_item1_idx (item_item_id ASC) VISIBLE,
    INDEX fk_order_has_item_order1_idx (cust_order_order_id ASC) VISIBLE,
    CONSTRAINT fk_order_has_item_order1
    FOREIGN KEY (cust_order_order_id)
    REFERENCES mobile_shop_SMS.cust_order (order_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT fk_orderCASCADW_has_item_item1
    FOREIGN KEY (item_item_id)
    REFERENCES mobile_shop_SMS.item (item_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.cust-payment
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.cust_payment (
    cust_payment_id VARCHAR(20) NOT NULL,
    cust_order_order_id VARCHAR(20) NOT NULL,
    cust_order_employee_idemployee_id VARCHAR(20) NOT NULL,
    payment DECIMAL(8,2) NOT NULL,
    PRIMARY KEY (cust_payment_id, cust_order_order_id, cust_order_employee_idemployee_id),
    INDEX fk_cust_payment_cust_order1_idx (cust_order_order_id ASC, cust_order_employee_idemployee_id ASC) VISIBLE,
    CONSTRAINT fk_cust_payment_cust_order1
    FOREIGN KEY (cust_order_order_id , cust_order_employee_idemployee_id)
    REFERENCES mobile_shop_SMS.cust_order (order_id , employee_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.employee_manage_item
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.employee_manage_item (
    employee_employee_id VARCHAR(20) NOT NULL,
    item_item_id VARCHAR(20) NOT NULL,
    managed_date_time DATETIME NOT NULL,
    PRIMARY KEY (employee_employee_id, item_item_id),
    INDEX fk_employee_has_item_item1_idx (item_item_id ASC) VISIBLE,
    INDEX fk_employee_has_item_employee1_idx (employee_employee_id ASC) VISIBLE,
    CONSTRAINT fk_employee_has_item_employee1
    FOREIGN KEY (employee_employee_id)
    REFERENCES mobile_shop_SMS.employee (employee_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT fk_employee_has_item_item1
    FOREIGN KEY (item_item_id)
    REFERENCES mobile_shop_SMS.item (item_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table mobile_shop_SMS.cust-order_has_warrenty
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mobile_shop_SMS.cust_order_has_warrenty (
    cust_order_order_id VARCHAR(20) NOT NULL,
    cust_order_employee_id VARCHAR(20) NOT NULL,
    warrenty_warranty_id VARCHAR(20) NOT NULL,
    date_time DATETIME NOT NULL,
    PRIMARY KEY (cust_order_order_id, cust_order_employee_id, warrenty_warranty_id),
    INDEX fk_cust_order_has_warrenty_warrenty1_idx (warrenty_warranty_id ASC) VISIBLE,
    INDEX fk_cust_order_has_warrenty_cust_order1_idx (cust_order_order_id ASC, cust_order_employee_id ASC) VISIBLE,
    CONSTRAINT fk_cust_order_has_warrenty_cust_order1
    FOREIGN KEY (cust_order_order_id , cust_order_employee_id)
    REFERENCES mobile_shop_SMS.cust_order (order_id , employee_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT fk_cust_order_has_warrenty_warrenty1
    FOREIGN KEY (warrenty_warranty_id)
    REFERENCES mobile_shop_SMS.warrenty (warranty_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );
