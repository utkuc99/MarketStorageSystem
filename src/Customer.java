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

            if(connection != null){ connection.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }

    }


}