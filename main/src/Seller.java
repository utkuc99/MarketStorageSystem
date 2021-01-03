
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;


public class Seller extends User {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "şifre";

    public Seller(){ super();}
    public Seller(int id_, String firstName_, String lastName_, String loginName_, String gender_, String city_) {
        super(id_, firstName_, lastName_, loginName_, gender_, city_);
    }

    public static boolean addSeller(String firstname, String lastname, String loginname, String gender, String city){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;
            int count = 0;

            if(firstname.length() <3 || lastname.length()<3 ){
                JOptionPane.showMessageDialog(null,
                        "Name, Surname must be larger than 3 letters! ");
                return false;
            }else if(loginname.length()<5){
                JOptionPane.showMessageDialog(null,
                        "User Name must be bigger than 5 letters!");
                return false;
            }

            query = "select * from customer where loginname = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setString(1,loginname);
            rs = myPrepSt.executeQuery();
            while (rs.next()){
                count ++;
            }

            query = "select * from seller where loginname = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setString(1,loginname);
            rs = myPrepSt.executeQuery();
            while (rs.next()){
                count ++;
            }

            if(count == 1){
                JOptionPane.showMessageDialog(null, "Enter different login name !");
                return false;
            }else
                showMessageDialog(null, "Register Sucessful");

            int id = 0;
            query = "select max(id) from seller";
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();

            while(rs.next()){
                id = rs.getInt(1);
                if(rs.getInt(1) == 0)
                    id = 100;
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

            return true;

        }catch (Exception exc){
            exc.printStackTrace();
            return false;
        }
    }

    public static void addProduct(int seller_id, String name, double price,
                                  String category, String colour, String description, int count) {
        try{

            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            if(name.length() < 2){
                JOptionPane.showMessageDialog(null,"Name must be at least 2 letters!");
                return;
            }else if(price < 0.01){
                JOptionPane.showMessageDialog(null,"Enter valid price!");
                return;
            }else if(count < 1){
                JOptionPane.showMessageDialog(null,"Enter valid quantity!");
                return;
            }


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

    public static ArrayList<Product> showProductsOnSale(int sellerID){
        ArrayList<Product> products_on_sale = new ArrayList<Product>();
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            query = "select * from product where seller_id = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,sellerID);
            rs = myPrepSt.executeQuery();
            while (rs.next()){

                int id = rs.getInt(1);
                String name = rs.getString(3);
                double price = rs.getDouble(4);
                String category = rs.getString(5);
                String colour = rs.getString(6);
                String description = rs.getString(7);
                int count = rs.getInt(8);
                if(count != 0){
                    Product p = new Product(id,sellerID,name,price,category,colour,description,count);
                    products_on_sale.add(p);
                }
            }

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return products_on_sale;

    }

    public static void removeProduct(int product_ID){

        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            query = "UPDATE product SET count = " + 0 + " WHERE (id  = "+product_ID + " )";
            myPrepSt = myCon.prepareStatement(query);

            myPrepSt.executeUpdate();

            if(myCon != null){ myCon.close();  }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public static ArrayList<Product> showSoldProducts(int sellerID){
        ArrayList<Product> selled_products = new ArrayList<Product>();
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet productsSet = null;


            query = "select * from products_purchased ,product where product.seller_id = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,sellerID);
            productsSet = myPrepSt.executeQuery();
            while (productsSet.next()){

                int id = productsSet.getInt(1);
                int buyer_id = productsSet.getInt(3);
                int count = productsSet.getInt(4);
                String name = productsSet.getString(7);
                double price = productsSet.getDouble(9);
                String category = productsSet.getString(10);
                String colour = productsSet.getString(11);
                String description = productsSet.getString(12);

                Product p = new Product(id,buyer_id,name,price,category,colour,description, count);
                selled_products.add(p);
            }

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return selled_products;


    }


    public static void addExistingProduct(int product_id,int add_count ){

        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;


            int count = 0;
            query = "SELECT * FROM product WHERE id ="+ product_id+  ";" ;
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();
            rs.next();
            count = rs.getInt(8);

            count=count+add_count ;
            query = "UPDATE product SET count = " + count + " WHERE (id  = "+product_id + " )";
            myPrepSt = myCon.prepareStatement(query);
            // Database Statement

            myPrepSt.executeUpdate();

            if(myCon != null){ myCon.close();  }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }







}