import java.sql.*;

public class Main {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";
    public static int customerSize;




    public static void main(String[] args) {
        // PreparedStatement myPrepSt = null;
        // ResultSet rs = null;


    try{
        // Get Connection to DataBase
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
        // Create a statement
        // Statement mySt = myCon.createStatement();

        // adCustomer() : 4 parametre aliyor : firstname, lastname, loginname, gender, city
        Customer.addCustomer("Umut","Cirak","umut_cirak123","Male", "Ankara");

        // adSeller() : 4 parametre aliyor : firstname, lastname, loginname, gender, city
        Seller.addSeller("Name","LastName","loginname","Gender", "City");




        if(myCon != null)
            myCon.close();

    }catch (Exception exc){
        exc.printStackTrace();
    }









    }





}
