Billing Invoice Generator

A Java-based billing and invoice management application that allows users to enter product details, calculate item totals, apply discounts, and store product/invoice data in a MySQL database using JDBC.

Features

Add product details such as ID, name, price, and quantity

Calculate total amount using price × quantity

Apply discount and calculate final amount

Store product data in MySQL using JDBC

View stored product records from the database

Dynamic product handling using ArrayList

Console-based user interaction using Scanner

Technologies Used

Java

OOP (Classes, Objects, Constructors, Methods)

ArrayList / Collections

JDBC

MySQL

XAMPP (Apache / MySQL and phpMyAdmin)

VS Code

Project Structure

BillingInvoice.java
├── Product class
│   ├── id
│   ├── name
│   ├── price
│   ├── quantity
│   ├── discount
│   └── calculateAmount()
├── ArrayList<Product>
├── Scanner input
└── JDBC database operations

MySQL Database Setup Using XAMPP

1. Open XAMPP Control Panel.

2. Start MySQL.

3. Open phpMyAdmin.

4. Create a database named billing_db.

5. Create the products table using the following SQL:

CREATE DATABASE billing_db;

USE billing_db;

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    price DOUBLE,
    quantity INT,
    discount DOUBLE,
    total DOUBLE
);

JDBC Connection

Add the MySQL Connector/J library to the Java project. The application connects to the XAMPP MySQL server using JDBC.

String url = "jdbc:mysql://localhost:3306/billing_db";
String username = "root";
String password = "";

Connection con = DriverManager.getConnection(url, username, password);

Database Operations

Product information is inserted into the products table using a PreparedStatement. This allows Java objects to be stored permanently in MySQL.

INSERT INTO products
(name, price, quantity, discount, total)
VALUES (?, ?, ?, ?, ?);

How the Application Works

Start XAMPP MySQL server.

Run the Java application.

Enter product ID, name, price, quantity, and discount.

Create a Product object from the entered information.

Calculate the product total.

Store the product in an ArrayList.

Save the product data into MySQL using JDBC.

Use SELECT * FROM products to verify saved records.

Sample Output

Enter number of products: 2

Enter Product Name: Ball Pen
Enter Price: 20
Enter Quantity: 3

Enter Product Name: Notebook
Enter Price: 50
Enter Quantity: 2

Product saved in database!
Product saved in database!

Future Scope

Add customer management

Generate complete invoices with invoice numbers and dates

Add update and delete product operations

Add search functionality

Create a GUI or web frontend

Connect the project with Spring Boot and a frontend

Generate printable or PDF invoices

Author

Developed as a Java + JDBC + MySQL practice/project application.
