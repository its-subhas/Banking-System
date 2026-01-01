# Banking-System
Banking System.

🏦 Banking System Project
📖 Project Description

The Banking System Project is a console-based Java application that simulates basic banking operations.
It allows users to register using Aadhaar details, securely store personal data, and automatically generate a bank account number using a MySQL database.

This project demonstrates JDBC connectivity, database transactions, and secure data insertion using PreparedStatement.

🎯 Objectives

To understand real-world banking system workflow

To implement Java–MySQL connectivity using JDBC

To perform secure database insert operations

To auto-generate bank account numbers

To practice object-oriented programming concepts

🛠️ Technologies Used

Programming Language: Java

Database: MySQL

Connectivity: JDBC

IDE: IntelliJ IDEA / Eclipse

OS: Windows

⚙️ Features Implemented

User Registration using Aadhaar Number

Store user details (Name, DOB, Phone, Email, Password, PIN)

Secure database insertion using PreparedStatement

Automatic Account Number generation

Account creation linked with Aadhaar

Exception handling for database operations

🗄️ Database Tables Used
1️⃣ registration
Column Name	Description
aadhaar	Aadhaar Number
name	Full Name
dob	Date of Birth
phone	Phone Number
email	Email Address
password	Login Password
pin	Transaction PIN
2️⃣ account
Column Name	Description
id	Auto Increment ID
aadhaar	Linked Aadhaar Number
accountn	Bank Account Number
🚀 How the System Works

User enters personal details

Data is securely inserted into the registration table

The latest account number is fetched from the database

A new account number is generated automatically

Account is created and linked to Aadhaar

Confirmation message is displayed

🔐 Security Features

Uses PreparedStatement to prevent SQL Injection

Secure storage of login password and transaction PIN

Exception handling for database failures

📂 How to Run the Project

Install Java JDK (8 or above)

Install MySQL Server

Create the required database and tables

Update database credentials in Java code

Compile and run the program

📚 Learning Outcomes

Strong understanding of JDBC

Hands-on experience with MySQL

Real-world banking system logic

Secure database handling techniques

Improved Java programming skills

🧑‍💻 Author

Name: Subhas Biswas
Department: COMPUTER SCIENCE & ENGINEERING
University: UTU

📌 Conclusion

This Banking System project successfully demonstrates how Java and MySQL can be combined to build a real-world application.
The project can be enhanced further by adding login modules, fund transfer, transaction history, and GUI support.


 DATABASE SCHEMA

PLEASE MAKE SURE REPLACE CREDENTIALS WITH REAL ONE IN SOURCE FILES.

        String url = "URL";
        String username = "USERNAME";
        String password = "PASSWORD";



 TABLE NAME - REGISTRATION
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| aadhaar  | bigint      | NO   | PRI | NULL    |       |
| name     | varchar(50) | NO   |     | NULL    |       |
| dob      | varchar(15) | NO   |     | NULL    |       |
| phone    | bigint      | NO   |     | NULL    |       |
| email    | varchar(30) | NO   |     | NULL    |       |
| password | varchar(15) | NO   |     | NULL    |       |
| pin      | int         | NO   |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+



 TABLE NAME - ACCOUNT
+----------+--------+------+-----+---------+----------------+
| Field    | Type   | Null | Key | Default | Extra          |
+----------+--------+------+-----+---------+----------------+
| id       | int    | NO   | PRI | NULL    | auto_increment |
| aadhaar  | bigint | NO   |     | NULL    |                |
| accountn | bigint | NO   |     | NULL    |                |
| balance  | bigint | YES  |     | 500     |                |
+----------+--------+------+-----+---------+----------------+

