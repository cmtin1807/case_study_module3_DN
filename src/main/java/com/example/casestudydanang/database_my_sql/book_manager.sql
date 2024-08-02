CREATE DATABASE book_manager;
USE book_manager;

CREATE TABLE Category
(
    category_id   INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(250) NOT NULL
);
CREATE TABLE Publisher
(
    publisher_id   INT AUTO_INCREMENT PRIMARY KEY,
    publisher_name VARCHAR(250) NOT NULL
);

CREATE TABLE Book
(
    book_id      INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(250) NOT NULL,
    description  VARCHAR(250),
    image_url    VARCHAR(250),
    status       BIT          NOT NULL,
    category_id  INT,
    publisher_id INT,
    FOREIGN KEY (category_id) REFERENCES Category (category_id),
    FOREIGN KEY (publisher_id) REFERENCES Publisher (publisher_id),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE Customers
(
    customer_id        INT AUTO_INCREMENT PRIMARY KEY,
    customer_name      VARCHAR(250) NOT NULL,
    customer_code      VARCHAR(250) NOT NULL,
    customer_class     VARCHAR(250),
    customer_address   VARCHAR(250),
    customer_birthday  DATE,
    customer_is_active BOOLEAN DEFAULT TRUE
);
CREATE TABLE status_borrow
(
    status_borrow_id   INT AUTO_INCREMENT PRIMARY KEY,
    status_borrow_type VARCHAR(250)
);
CREATE TABLE borrow_transactions
(
    borrow_transactions_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id            INT,
    book_id                INT,
    borrow_date            DATE NOT NULL,
    return_date            DATE,
    status                 ENUM ('borrow','over','return')
);

DELIMITER //
CREATE PROCEDURE show_list(
)
BEGIN
    SELECT book.name, book.description, book.image_url, book.status, category.category_name, Publisher.publisher_name
    FROM book
             Join Publisher on book.publisher_id = Publisher.publisher_id
             join category on book.category_id = category.category_id;
end //
DELIMITER ;