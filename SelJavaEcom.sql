CREATE DATABASE SelJavaEcom;

USE SelJavaEcom;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users (username, password) VALUES
    ('user1', 'pass1'),
    ('user2', 'pass2'),
    ('user3', 'pass3');
