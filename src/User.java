
import java.sql.*;
public class User {

    static final String url = "jdbc:mysql://localhost:3306/storage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String jdbc_driver ="com.mysql.cj.jdbc.Driver";
    static final String USER = "root";
    static final String PASS = "1234";

    public User() {

    }

    public static void addSeller(String firstname, String lastname, String login_name, String gender, String city){
        try{
            Connection myCon =  DriverManager.getConnection(url,USER,PASS);
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
            myPrepSt.setString(4,login_name);
            myPrepSt.setString(5,gender);
            myPrepSt.setString(6,city);

            myPrepSt.executeUpdate();

            if(myCon != null){ myCon.close();  }

        }catch (Exception exc){
            exc.printStackTrace();
        }
    };


     public static void addCustomer(String firstname, String lastname, String login_name, String gender, String city){
    try{
        Connection myCon =  DriverManager.getConnection(url,USER,PASS);
        PreparedStatement myPrepSt = null;
        String query = "";
        ResultSet rs = null;

        // Customer burada ana ekrandaki Add User butonuna basacak ve Customer bilgilerini girecek
        // id otomatik olarak atanıyor
        int id = 0;
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
        myPrepSt.setString(4,login_name);
        myPrepSt.setString(5,gender);
        myPrepSt.setString(6,city);

        myPrepSt.executeUpdate();

        if(myCon != null){ myCon.close();  }

    }catch (Exception exc){
        exc.printStackTrace();
    }
};




}