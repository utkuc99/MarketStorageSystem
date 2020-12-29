import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";


    public static void main(String[] args) {

    try{
        // Get Connection to DataBase
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
        // Create a statement
        Statement mySt = myCon.createStatement();

        String query = "insert into customer (id, firstname, lastname, loginname, gender,city) values" +
                " ('4', 'Wick', 'Wick', 'ew320', 'Female', 'Oslo')";



        mySt.executeUpdate(query);

        if(myCon != null)
            myCon.close();

    }catch (Exception exc){
        exc.printStackTrace();
    }









    }





}
