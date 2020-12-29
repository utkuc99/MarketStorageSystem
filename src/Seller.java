import java.sql.*;
import java.util.ArrayList;


public class Seller {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";


    public static void addSeller(String firstname, String lastname, String loginname, String gender, String city){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            // Customer burada ana ekrandaki Add User butonuna basacak ve Customer bilgilerini girecek
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







}