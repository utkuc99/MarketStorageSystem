import java.sql.*;
import java.util.ArrayList;


public class Customer {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";



    public static void showInfos(Customer customer){

    }

    public void orderProduct(){

    }


    public void listPendingOrders(){
    }


    public void listPurchasedProducts(){

    }


    public static void addCustomer(){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            // Customer burada ana ekrandaki Add User butonuna basacak ve Customer bilgilerini girecek
            // id otomatik olarak atanıyor
            int id = 32;
            query = "select max(id) from customer";
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }
            id ++ ;

            // Arayuzden - name, lastname, loginname, gender, city - bilgilerinin alinmasi gerekiyor.
            // Bu bilgiler sil guiden gelen inputa esitle
            String firstname = "Zuhasadfasfl";
            String lastname= "Topal";
            String loginname = "zuhal_topal123";
            String gender = "Female";
            String city = "Urfa";

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