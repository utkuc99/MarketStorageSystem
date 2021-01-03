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









}