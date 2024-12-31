CREATE DATABASE FoodDeliveryDB;

USE FoodDeliveryDB;

CREATE TABLE ContactDetails (
    ContactID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    PhoneNumber VARCHAR(15) NOT NULL
);

CREATE TABLE OrderDetails (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    ContactID INT NOT NULL,
    FoodItem VARCHAR(100) NOT NULL,
    Quantity INT NOT NULL,
    TotalPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ContactID) REFERENCES ContactDetails(ContactID)
);
