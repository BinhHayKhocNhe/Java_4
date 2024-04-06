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
    CategoryID NVARCHAR(20) PRIMARY KEY,
    CategoryName NVARCHAR(100) NOT NULL,
    Note NVARCHAR(200)
);
select * from Categories where CategoryID = '';
INSERT INTO Categories (CategoryID, CategoryName, Note)
VALUES ('C001', N'Giày dép', NULL),
('C002', N'Túi xách', NULL);

CREATE TABLE Products (
    ProductID INT PRIMARY KEY IDENTITY,
    ProductName NVARCHAR(100) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    ImageURL NVARCHAR(255),
    Quantity INT NOT NULL,
    CategoryID NVARCHAR(20) NOT NULL,
    Sale DECIMAL(5, 2) DEFAULT 0,
	Note NVARCHAR(20)
    CONSTRAINT FK_CategoryID FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

SELECT COUNT(ProductID) FROM Products WHERE CategoryID = 'C001';


INSERT INTO Products (ProductName, Price, ImageURL, Quantity, CategoryID, Sale, Note)
VALUES (N'Túi Mini Basic 2', 375000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_Ts1kuHIfU3N8x4NljWhNnjmy.jpg', 10, N'C002', 0, null),
(N'Túi Mini KBUTMINI', 300000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_m8ZR3KAhQF1FKkZ6zWlrBo8F.jpg', 35, N'C002', 15, null),
(N'Túi Mini Vuông Quai Ngọc', 275000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_HZqQVgEDsi1YEmAnq1vOSfFH.jpg', 40, N'C002', 0, null),
(N'Túi Mini Vuông Basic', 235000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_CWhzF7jZHTD08Zbi3RV73n5y.jpg', 70, N'C002', 5, null),
(N'Túi Mini Khóa Tròn', 250000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_MmOXyz47ynz2AVlWBkacRm7y.jpg', 100, N'C002', 12, null),
(N'Túi Mini Ngọc', 200000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_YzvVUg66nRXeigQlFFqevDRk.jpg', 78, N'C002', 0, null),
(N'Túi Đeo Vai Khóa Tròn', 415000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220302_13scJtlI5HSGThUUD0sGF5nq.jpg', 140, N'C002', 0, null);

INSERT INTO Products (ProductName, Price, ImageURL, Quantity, CategoryID, Sale, Note)
VALUES (N'Túi Đeo Vai Vân Cá Sấu', 350000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220302_6kgNoNgb3yoGMgvROYzk3i0X.jpg', 10, N'C002', 0, null),
(N'Túi Đeo Vai Khóa Gương Lệch', 300000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220302_R2kWTE964h2eWJxpNsSfGuH7.jpg', 35, N'C002', 15, null),
(N'Túi Đeo Vai Dáng Vuông Ngang', 475000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220302_UKiv8dULqZv4JDvz1wkGu3jE.jpg', 40, N'C002', 0, null),
(N'Túi Đeo Vai Vuông TV05', 235000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220302_OAHLOGixEOSHKa748cNdi0OD.jpg', 70, N'C002', 5, null),
(N'Túi Đeo Vai Họa Tiết Caro', 250000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220302_OZoQQMvutFwaaByrnYPaPQDM.jpg', 100, N'C002', 12, null),
(N'Túi Đeo Vai Dây Da Xoắn Mini', 200000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220302_VJVp65eeuDJAzuRSXqsNCvdu.jpg', 78, N'C002', 0, null),
(N'Túi Đeo Chéo Vintage', 415000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220302_xoW6sJwI17cgPJPHmcjthCQ6.jpg', 140, N'C002', 0, null);

INSERT INTO Products (ProductName, Price, ImageURL, Quantity, CategoryID, Sale, Note)
VALUES (N'Sandal Đế Phẳng Đi Biển', 350000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220304_Y0oJbvLuZVlJtgei9Uo7VH9d.jpg', 10, N'C001', 0, null),
(N'Sandal Thiết Kế Tam Giác', 300000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220304_aJe09qYUhAjTlVpGi8EKMZcA.jpg', 35, N'C001', 15, null),
(N'Sandal Xỏ Ngón NKSD- 2723', 475000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220304_4Nf0GfHMZNlWv0yNlIicPilV.jpg', 40, N'C001', 0, null),
(N'Sandal Đế Bệt Quai Ngang', 235000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220304_GzcGYc4zamwekJK0jhu6efKd.jpg', 70, N'C001', 5, null),
(N'Sandal Xỏ Ngón Quai Ngang', 250000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220304_dFdLcWRlxzHzmsNX95CUF7Pz.jpg', 100, N'C001', 12, null),
(N'Sandal ULZZANG Quai Bèo', 200000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_bVHdmLisOSCWCYD5VG8teJ6q.jpg', 78, N'C001', 0, null),
(N'Sandal Quai Chéo', 415000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_F5waPLLnOt7JNRrA6Ts84XPn.jpg', 140, N'C001', 0, null);

INSERT INTO Products (ProductName, Price, ImageURL, Quantity, CategoryID, Sale, Note)
VALUES (N'Cao Gót Da Bóng Đính Đá', 350000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_ARQ21QcF9CO6xBRAJiUFCSKi.jpg', 10, N'C001', 0, null),
(N'Cao Gót Phối Dây Hai Màu', 300000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_TR9WamGFjmbGxO7J4diTWGLq.jpg', 35, N'C001', 15, null),
(N'Cao Gót Mũi Nhọn Quai Ngang', 475000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_w5lzeTwko0dmh2gqJlzGUzle.jpg', 40, N'C001', 0, null),
(N'Cao Gót Mũi Vuông', 235000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_tTSROiS8uFw2MDvYmRc5hObc.jpg', 70, N'C001', 5, null),
(N'Cao Gót Xỏ Ngón Dây Mảnh', 250000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_BbSxhPcoDg19xpwiiWNFjmtj.jpg', 100, N'C001', 12, null),
(N'Cao Gót Quai Xếp Nhúm', 200000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_wGBQMokK0NAFGSTIL78Mizps.jpg', 78, N'C001', 0, null),
(N'Cao Gót Chuỗi Ngọc Trai', 415000, N'https://pos.nvncdn.com/a6f18e-116325/ps/20220303_xkTUeoB3fqvBR12TlMXa5nGo.jpg', 140, N'C001', 0, null);

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
