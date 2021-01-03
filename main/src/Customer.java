import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;


public class Customer extends User {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "418012Utku";


    public Customer(){ super();}
    public Customer(int id_, String firstName_, String lastName_, String loginName_, String gender_, String city_) {
        super(id_, firstName_, lastName_, loginName_, gender_, city_);
    }


    public static boolean orderProduct(int productID, int customerID, int count){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            System.out.println(customerID);


            query = "select * from product where id = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,productID);
            rs = myPrepSt.executeQuery();




            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"There are no such that product!");
                return false;
            }

            if(count > rs.getInt(8)){
                JOptionPane.showMessageDialog(null,"There aren't enough quantity available!");
                return false;
            }



            int newCount = rs.getInt(8) - count;
            int seller_id = rs.getInt(2);



            query = "UPDATE product SET count = ? where( id = ? )";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,newCount);
            myPrepSt.setInt(2,productID);

            myPrepSt.executeUpdate();

            int is_Exist = 0;
            query = "select * from products_purchased where (product_ID = ? AND customer_ID = ?)";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,productID);
            myPrepSt.setInt(2,customerID);
            rs = myPrepSt.executeQuery();

            int previous = 0;
            while (rs.next()){
                is_Exist++;
                if(is_Exist == 1){
                    previous = rs.getInt(4);
                }
            }

            if(is_Exist == 0){
                query = "insert into products_purchased (product_ID, seller_ID, customer_ID, count) values (?, ?, ?, ? )";
                myPrepSt = myCon.prepareStatement(query);
                myPrepSt.setInt(1,productID);
                myPrepSt.setInt(2,seller_id);
                myPrepSt.setInt(3,customerID);
                myPrepSt.setInt(4,count);

                myPrepSt.executeUpdate();

            }else{
                query = "UPDATE products_purchased SET count = ? where( product_ID = ? AND customer_ID = ? )";
                myPrepSt = myCon.prepareStatement(query);
                myPrepSt.setInt(1,(count+previous));
                myPrepSt.setInt(2,productID);
                myPrepSt.setInt(3,customerID);
                myPrepSt.executeUpdate();
            }






            if(myCon != null){ myCon.close();  }
            return true;

        }catch (Exception exc){
            exc.printStackTrace();
            return false;
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
                int count = productsSet.getInt(4);
                String name = productsSet.getString(8);
                double price = productsSet.getDouble(9);
                String category = productsSet.getString(10);
                String colour = productsSet.getString(11);
                String description = productsSet.getString(12);

                Product p = new Product(id,seller_id,name,price,category,colour,description,count);
                purchased_product.add(p);

            }

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return purchased_product;
    }

    public static boolean addCustomer(String firstname, String lastname, String loginname, String gender, String city){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;
            int id = 0;
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

            return true;

        }catch (Exception exc){
            exc.printStackTrace();
            return false;
        }

    }

    public static ArrayList<Product> showProducts(){
        ArrayList<Product> products_all = new ArrayList<Product>();
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;


            query = "select * from product";
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();

            while (rs.next()){

                int id = rs.getInt(1);
                int seller_id = rs.getInt(2);
                String name = rs.getString(3);
                double price = rs.getDouble(4);
                String category = rs.getString(5);
                String colour = rs.getString(6);
                String description = rs.getString(7);
                int count = rs.getInt(8);
                Product p = new Product(id,seller_id,name,price,category,colour,description,count);
                products_all.add(p);

            }

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return products_all;


    }

    public static ArrayList<Product> filterProducts(String type, Object value){
        ArrayList<Product> products_filtered = new ArrayList<Product>();
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            int valI = 0;
            String valS = "";

            if(type.equals("colour"))
                query = "select * from product where colour = ?";
            else if(type.equals("category"))
                query = "select * from product where category = ?";


            myPrepSt = myCon.prepareStatement(query);

            myPrepSt.setObject(1,value);
            rs = myPrepSt.executeQuery();

            while (rs.next()){

                int id = rs.getInt(1);
                int seller_id = rs.getInt(2);
                String name = rs.getString(3);
                double price = rs.getDouble(4);
                String category = rs.getString(5);
                String colour = rs.getString(6);
                String description = rs.getString(7);
                int count = rs.getInt(8);
                Product p = new Product(id,seller_id,name,price,category,colour,description,count);
                products_filtered.add(p);

            }

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return products_filtered;




    }






}