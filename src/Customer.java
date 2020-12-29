import java.sql.*;
import java.util.ArrayList;


public class Customer {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";

    public int id_ ;
    public String firstName_;
    public String lastName_ ;
    public String loginName_;
    public String gender_ ;
    public String city_ ;

    public Customer(){}
    public Customer(int id_, String firstName_, String lastName_, String loginName_, String gender_, String city_) {
        this.id_ = id_;
        this.firstName_ = firstName_;
        this.lastName_ = lastName_;
        this.loginName_ = loginName_;
        this.gender_ = gender_;
        this.city_ = city_;
    }

    public static Customer showInfos(int customerID ){
        Customer c = new Customer();
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            query = "select * from customer where id = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1, customerID);
            rs = myPrepSt.executeQuery();


            while (rs.next()){
                c.id_ = rs.getInt(1);
                c.firstName_ = rs.getString(2);
                c.lastName_ = rs.getString(3);
                c.loginName_ = rs.getString(4);
                c.gender_ = rs.getString(5);
                c.city_ = rs.getString(6);
            }


            if(myCon != null)  { myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
        return c;
    }


    public void orderProduct(){

    }


    public void listPendingOrders(){
    }


    public void listPurchasedProducts(){

    }


    public static void addCustomer(String firstname, String lastname, String loginname, String gender, String city){
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