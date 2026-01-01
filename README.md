# Banking-System
Banking System.
# 🏦 Banking System

A **console-based Banking System application** developed using **Java and MySQL**.

---

## 📖 Project Description

The **Banking System Project** is a console-based Java application that simulates basic banking operations.  
It allows users to **register using Aadhaar details**, securely store personal data, and **automatically generate a bank account number** using a MySQL database.

This project demonstrates:
- JDBC connectivity  
- Database transactions  
- Secure data insertion using `PreparedStatement`

---

## 🎯 Objectives

- Understand real-world banking system workflow  
- Implement Java–MySQL connectivity using JDBC  
- Perform secure database insert operations  
- Auto-generate bank account numbers  
- Practice object-oriented programming concepts  

---

## 🛠️ Technologies Used

- **Programming Language:** Java  
- **Database:** MySQL  
- **Connectivity:** JDBC  
- **IDE:** IntelliJ IDEA / Eclipse  
- **Operating System:** Windows  

---

## ⚙️ Features Implemented

- User registration using Aadhaar number  
- Store user details:
  - Name  
  - Date of Birth  
  - Phone Number  
  - Email  
  - Password  
  - Transaction PIN  
- Secure database insertion using `PreparedStatement`  
- Automatic bank account number generation  
- Account creation linked with Aadhaar  
- Exception handling for database operations  

---

## 🗄️ Database Tables Used

### 1️⃣ `registration`

| Column Name | Data Type | Description |
|------------|----------|-------------|
| aadhaar | BIGINT | Aadhaar Number (Primary Key) |
| name | VARCHAR(50) | Full Name |
| dob | VARCHAR(15) | Date of Birth |
| phone | BIGINT | Phone Number |
| email | VARCHAR(30) | Email Address |
| password | VARCHAR(15) | Login Password |
| pin | INT | Transaction PIN |

---

### 2️⃣ `account`

| Column Name | Data Type | Description |
|------------|----------|-------------|
| id | INT | Auto Increment (Primary Key) |
| aadhaar | BIGINT | Linked Aadhaar Number |
| accountn | BIGINT | Bank Account Number |
| balance | BIGINT | Account Balance (Default: 500) |

---

## 🚀 How the System Works

1. User enters personal details  
2. Data is securely inserted into the `registration` table  
3. Latest account number is fetched from the database  
4. A new account number is generated automatically  
5. Account is created and linked with Aadhaar  
6. Confirmation message is displayed  

---

## 🔐 Security Features

- Uses `PreparedStatement` to prevent SQL Injection  
- Secure storage of login password and transaction PIN  
- Exception handling for database failures  

---

## 📂 How to Run the Project

1. Install **Java JDK (8 or above)**  
2. Install **MySQL Server**  
3. Create the required database and tables  
4. Replace database credentials in source files:

   ```java
   String url = "URL";
   String username = "USERNAME";
   String password = "PASSWORD";

