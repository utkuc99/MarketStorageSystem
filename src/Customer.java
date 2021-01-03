import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;


public class Customer extends User {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Ys6912";


    public Customer(){ super();}
    public Customer(int id_, String firstName_, String lastName_, String loginName_, String gender_, String city_) {
        super(id_, firstName_, lastName_, loginName_, gender_, city_);
    }


    public static void orderProduct(int productID, int customerID, int count){
        try{
            Connection connection =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement prep = null;
            String query = "";
            ResultSet rs = null;


            query = "select * from product where id = ?";
            prep = connection.prepareStatement(query);
            prep.setInt(1,productID);
            rs = prep.executeQuery();

            rs.next();
            if(count > rs.getInt(8)){
                JOptionPane.showMessageDialog(null,"There is no such that product");
                return;
            }

            int newCount = rs.getInt(8) - count;
            int seller_id = rs.getInt(2);



            query = "UPDATE product SET count = ? where( id = ? )";
            prep = connection.prepareStatement(query);
            prep.setInt(1,newCount);
            prep.setInt(2,productID);

            prep.executeUpdate();

            int exist = 0;
            query = "select * from products_purchased where product_ID = ?";
            prep = connection.prepareStatement(query);
            prep.setInt(1,productID);
            rs = prep.executeQuery();

            int previous = 0;
            while (rs.next()){
                exist++;
                if(exist == 1){
                    previous = rs.getInt(4);
                }
            }

            if(exist == 0){
                query = "insert into products_purchased values (?, ?, ?, ? )";
                prep = connection.prepareStatement(query);
                prep.setInt(1,productID);
                prep.setInt(2,seller_id);
                prep.setInt(3,customerID);
                prep.setInt(4,count);

                prep.executeUpdate();

            }else{
                query = "UPDATE products_purchased SET count = ? where( product_ID = ? )";
                prep = connection.prepareStatement(query);
                prep.setInt(1,(count+previous));
                prep.setInt(2,productID);
                prep.executeUpdate();
            }

            if(connection != null){ connection.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    public static ArrayList<Product> listPurchasedProducts(int customerID){
        ArrayList<Product> purchased_product = new ArrayList<Product>();

        try{
            Connection connection =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement prep = null;
            String query = "";
            ResultSet productsSet = null;

            query = "select * from products_purchased , product where customer_ID = ?";
            prep = connection.prepareStatement(query);
            prep.setInt(1,customerID);
            productsSet = prep.executeQuery();
            while (productsSet.next()){

                int id = productsSet.getInt(1);
                int seller_id = productsSet.getInt(2);
                int count = productsSet.getInt(4);
                String name = productsSet.getString(7);
                double price = productsSet.getDouble(8);
                String category = productsSet.getString(9);
                String colour = productsSet.getString(10);
                String description = productsSet.getString(11);

                Product p = new Product(id,seller_id,name,price,category,colour,description,count);
                purchased_product.add(p);

            }

            if(connection!= null){ connection.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return purchased_product;
    }

    public static void addCustomer(String firstname, String lastname, String loginname, String gender, String city){
        try{
            Connection connection =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement prep = null;
            String query = "";
            ResultSet rs = null;
            int id = 0;
            int count = 0;

            if(firstname.length() <3 || lastname.length()<3 ){
                JOptionPane.showMessageDialog(null,
                        "Name, Surname must be larger than 3 letters! ");
                return;
            }else if(loginname.length()<5){
                JOptionPane.showMessageDialog(null,
                        "User Name must be bigger than 5 letters!");
                return;
            }

            query = "select * from customer where loginname = ?";
            prep = connection.prepareStatement(query);
            prep.setString(1,loginname);
            rs = prep.executeQuery();
            while (rs.next()){
                count ++;
            }

            query = "select * from seller where loginname = ?";
            prep = connection.prepareStatement(query);
            prep.setString(1,loginname);
            rs = prep.executeQuery();
            while (rs.next()){
                count ++;
            }



            if(count == 1){
                JOptionPane.showMessageDialog(null, "Enter different login name !");
                return;
            }else
                showMessageDialog(null, "Register Sucessful");

            query = "select max(id) from customer";
            prep = connection.prepareStatement(query);
            rs = prep.executeQuery();

            while (rs.next()){
                id = rs.getInt(1);
            }
            id ++ ;

            query = "insert into customer values (?, ?, ?, ?, ?, ?)";

            prep = connection.prepareStatement(query);
            prep.setInt(1,id);
            prep.setString(2,firstname);
            prep.setString(3,lastname);
            prep.setString(4,loginname);
            prep.setString(5,gender);
            prep.setString(6,city);

            prep.executeUpdate();

            if(connection != null){ connection.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }

    }






}