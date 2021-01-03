import java.sql.*;

public class Customer extends User {


    public Customer() {

    }


}

//----------------------------------------------------
//CREATE TABLE `customer` (
//  `id` int NOT NULL,
//  `firstname` varchar(30) NOT NULL,
//  `lastname` varchar(30) NOT NULL,
//  `loginname` varchar(50) NOT NULL,
//  `gender` varchar(10) DEFAULT NULL,
//  `city` varchar(20) DEFAULT NULL,
//  PRIMARY KEY (`id`,`loginname`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
//------------------------------------------------------
//CREATE TABLE `product` (
//  `product_id` int NOT NULL,
//  `product_category_code` varchar(255) DEFAULT NULL,
//  `product_name` varchar(255) DEFAULT NULL,
//  `product_price` double DEFAULT NULL,
//  `product_color` varchar(255) DEFAULT NULL,
//  `product_description` varchar(255) DEFAULT NULL,
//  `count` int unsigned DEFAULT NULL,
//  `seller_id` int DEFAULT NULL,
//  PRIMARY KEY (`product_id`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
//------------------------------------------------------
//CREATE TABLE `products_purchased` (
//  `product_ID` int NOT NULL,
//  `seller_ID` int NOT NULL,
//  `customer_ID` int NOT NULL,
//  `count` int DEFAULT NULL,
//  PRIMARY KEY (`product_ID`,`seller_ID`,`customer_ID`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
//------------------------------------------------------
//CREATE TABLE `seller` (
//  `id` int NOT NULL,
//  `firstname` varchar(30) NOT NULL,
//  `lastname` varchar(30) NOT NULL,
//  `loginname` varchar(50) NOT NULL,
//  `gender` varchar(10) DEFAULT NULL,
//  `city` varchar(20) DEFAULT NULL,
//  PRIMARY KEY (`id`,`loginname`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
