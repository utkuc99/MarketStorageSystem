import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;



public class CS320 {



        public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/storage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String kullaniciad = "root";

            String sifre = "1234";

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection(url, kullaniciad, sifre);

            st = con.createStatement();

            System.out.println("Baglandi");

        } catch (ClassNotFoundException ex) {

            ex.printStackTrace();

            System.out.println("Sürücü projeye eklenmemiş!");

        } catch (SQLException ex) {

            ex.printStackTrace();

            System.out.println("Veritabanına bağlantı sağlanamadı!");
        }

  User customer1=new User();
        customer1.addCustomer("Eray ","Erdoğan","eray.erdogan","male","Tarsus");


        User seller1=new User();

            seller1.addSeller("Eray ",
                    "Erdoğan",
                    "eray.erdogan",
                    "male",
                    "Tarsus");













};

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
