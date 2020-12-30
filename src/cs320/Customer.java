package cs320;

import java.sql.*;
import java.util.ArrayList;


public class Customer extends User {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";


    public Customer(){ super();}
    public Customer(int id_, String firstName_, String lastName_, String loginName_, String gender_, String city_) {
        super(id_, firstName_, lastName_, loginName_, gender_, city_);
    }


    public static void orderProduct(int productID, int customerID, int count){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;


            query = "select * from product where id = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,productID);
            rs = myPrepSt.executeQuery();

           rs.next();
           int newCount = rs.getInt(8) - count;
           int seller_id = rs.getInt(2);

            query = "UPDATE product SET count = ? where( id = ? )";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,newCount);
            myPrepSt.setInt(2,productID);

            myPrepSt.executeUpdate();

            query = "insert into products_purchased values (?, ?, ?, ? )";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,productID);
            myPrepSt.setInt(2,seller_id);
            myPrepSt.setInt(3,customerID);
            myPrepSt.setInt(4,count);

            myPrepSt.executeUpdate();


            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }

    }

    public static ArrayList<Product> listPurchasedProducts(int customerID){
        ArrayList<Product> purchased_product = new ArrayList<Product>();
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet productsSet = null;


            query = "select * from products_purchased , product where customer_ID = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,customerID);
            productsSet = myPrepSt.executeQuery();
            while (productsSet.next()){

                int id = productsSet.getInt(1);
                int seller_id = productsSet.getInt(2);
                String name = productsSet.getString(7);
                double price = productsSet.getDouble(8);
                String category = productsSet.getString(9);
                String colour = productsSet.getString(10);
                String description = productsSet.getString(11);

                Product p = new Product(id,seller_id,name,price,category,colour,description);
                purchased_product.add(p);

            }

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return purchased_product;
    }

    public static void addCustomer(String firstname, String lastname, String loginname, String gender, String city){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            // cs320.Customer burada ana ekrandaki Add cs320.User butonuna basacak ve cs320.Customer bilgilerini girecek
            // id otomatik olarak atanıyor
            int id = 0;

            query = "select max(id) from customer";
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();

            while (rs.next()){
                id = rs.getInt(1);
            }
            id ++ ;

            // Database Statement
           query = "insert into customer values (?, ?, ?, ?, ?, ?)";

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







}