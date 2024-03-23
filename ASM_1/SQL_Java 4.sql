create database ASM_Java_4;
use ASM_Java_4;

CREATE TABLE Users (
	ID_User INT PRIMARY KEY IDENTITY,
    Username NVARCHAR(50) NOT NULL,
    Password NVARCHAR(100) NOT NULL,
    Fullname NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Phone NVARCHAR(20) NOT NULL,
    Gender BIT NOT NULL,
    Birthday DATE NOT NULL,
    Role NVARCHAR(20) NOT NULL
);
INSERT INTO Users (Username, Password, Fullname, Email, Phone, Gender, Birthday, Role)
VALUES 
    ('user1', 'password1', 'User One', 'user1@example.com', '123456789', 1, '2000-01-01', 'User'),
    ('user2', 'password2', 'User Two', 'user2@example.com', '987654321', 0, '1995-05-05', 'Admin'),
    ('user3', 'password3', 'User Three', 'user3@example.com', '555555555', 1, '1988-12-12', 'User');

CREATE TABLE Categories (
    CategoryID INT PRIMARY KEY IDENTITY,
    CategoryCode NVARCHAR(20) NOT NULL,
    CategoryName NVARCHAR(100) NOT NULL,
    Note NVARCHAR(200)
);
CREATE TABLE Products (
    ProductID INT PRIMARY KEY IDENTITY,
    ProductCode NVARCHAR(20) NOT NULL,
    ProductName NVARCHAR(100) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    ImageURL NVARCHAR(255),
    Quantity INT NOT NULL,
    CategoryID INT NOT NULL,
    Sale DECIMAL(5, 2) DEFAULT 0,
    CONSTRAINT FK_CategoryID FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

-- Chèn mẫu dữ liệu vào bảng Categories
INSERT INTO Categories (CategoryCode, CategoryName, Note)
VALUES 
    ('C001', 'Electronics', 'Category for electronic devices'),
    ('C002', 'Clothing', 'Category for clothing items'),
    ('C003', 'Books', 'Category for books');

-- Chèn mẫu dữ liệu vào bảng Products
INSERT INTO Products (ProductCode, ProductName, Price, ImageURL, Quantity, CategoryID, Sale)
VALUES 
    ('P001', 'Laptop', 999.99, 'laptop.jpg', 10, 1, 0),
    ('P002', 'T-shirt', 19.99, 'tshirt.jpg', 50, 2, 0),
    ('P003', 'Book: Introduction to SQL', 29.99, 'sql_book.jpg', 20, 3, 0);


CREATE TABLE Invoices (
    ID INT PRIMARY KEY IDENTITY,
    UserID INT NOT NULL,
    TotalAmount DECIMAL(10, 2) NOT NULL,
    PhoneNumber NVARCHAR(20) NOT NULL,
    Address NVARCHAR(255) NOT NULL,
    CONSTRAINT FK_UserID FOREIGN KEY (UserID) REFERENCES Users(ID_User)
);
CREATE TABLE InvoiceDetails (
    ID INT PRIMARY KEY IDENTITY,
    InvoiceID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    CONSTRAINT FK_InvoiceID FOREIGN KEY (InvoiceID) REFERENCES Invoices(ID),
    CONSTRAINT FK_ProductID FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- Chèn mẫu dữ liệu vào bảng Invoices
INSERT INTO Invoices (UserID, TotalAmount, PhoneNumber, Address)
VALUES 
    (1, 150.00, '123456789', '123 Main Street'),
    (2, 250.00, '987654321', '456 Elm Street');

-- Chèn mẫu dữ liệu vào bảng InvoiceDetails
INSERT INTO InvoiceDetails (InvoiceID, ProductID, Quantity, Price)
VALUES 
    (1, 1, 2, 50.00),
    (1, 2, 1, 25.00),
    (2, 3, 3, 30.00),
    (2, 1, 1, 70.00);
