package cs320;

import java.sql.*;
import java.util.ArrayList;


public class Seller extends User {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";

    public Seller(){ super();}
    public Seller(int id_, String firstName_, String lastName_, String loginName_, String gender_, String city_) {
        super(id_, firstName_, lastName_, loginName_, gender_, city_);
    }

    public static void addSeller(String firstname, String lastname, String loginname, String gender, String city){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            // cs320.Customer burada ana ekrandaki Add cs320.User butonuna basacak ve cs320.Customer bilgilerini girecek
            // id otomatik olarak atanıyor
            int id = 0;
            query = "select max(id) from seller";
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }
            id ++ ;

            // Database Statement
            query = "insert into seller values (?, ?, ?, ?, ?, ?)";

            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,id);
            myPrepSt.setString(2,firstname);
            myPrepSt.setString(3,lastname);
            myPrepSt.setString(4,loginname);
            myPrepSt.setString(5,gender);
            myPrepSt.setString(6,city);

            myPrepSt.executeUpdate();

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    public static void addProduct(int seller_id, String name, double price,
                           String category, String colour, String description, int count) {
        try{

            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            int id = 0;
            query = "select max(id) from product";
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }
            id ++ ;


            query = "insert into product values (?, ?, ?, ?, ?, ?, ?, ?)";

            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,id);
            myPrepSt.setInt(2,seller_id);
            myPrepSt.setString(3,name);
            myPrepSt.setDouble(4,price);
            myPrepSt.setString(5,category);
            myPrepSt.setString(6,colour);
            myPrepSt.setString(7,description);
            myPrepSt.setInt(8,count);

            myPrepSt.executeUpdate();



            if(myCon != null){ myCon.close();  }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    public static ArrayList<Product> showProductsOnSale(int seller_ID){
        ArrayList<Product> products_on_sale = new ArrayList<Product>();
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;


            query = "select * from product where sellerID = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,seller_ID);
            rs = myPrepSt.executeQuery();
            while (rs.next()){

                int id = rs.getInt(1);
                String name = rs.getString(3);
                double price = rs.getDouble(4);
                String category = rs.getString(5);
                String colour = rs.getString(6);
                String description = rs.getString(7);
                int count = rs.getInt(8);
                Product p = new Product(id,seller_ID,name,price,category,colour,description,count);
                products_on_sale.add(p);

            }

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return products_on_sale;


    }








}