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












};

}
