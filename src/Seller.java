import java.sql.*;

public class Seller extends User {


    public Seller() {
        super();
    }

    void addProduct (String product_category_code, String product_name, double price, String product_color, String product_description,int count, int seller_id )
    {
        try{
            Connection myCon =  DriverManager.getConnection(url,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;

            // Customer burada ana ekrandaki Add User butonuna basacak ve Customer bilgilerini girecek
            // id otomatik olarak atanıyor
            int idp = 0;
            query = "select max(product_id) from product";
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();
            while (rs.next()){
                idp = rs.getInt(1);
            }
            idp ++ ;


// Database Statement
            query = "insert into product values (?, ?, ?, ?, ?, ?, ?, ?)";

            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setInt(1,idp);
            myPrepSt.setString(2,product_category_code);
            myPrepSt.setString(3,product_name);
            myPrepSt.setDouble(4,price);
            myPrepSt.setString(5,product_color);
            myPrepSt.setString(6,product_description);
            myPrepSt.setInt(7,count);
            myPrepSt.setInt(8,seller_id);

            myPrepSt.executeUpdate();

            if(myCon != null){ myCon.close();  }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    };


    void addexistingProduct(int product_id,int addcount ){

        try{
            Connection myCon =  DriverManager.getConnection(url,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;


            int count = 0;
            query = "SELECT * FROM product WHERE product_id ="+ product_id+  ";" ;
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();
            rs.next();
                count = rs.getInt(7);

            count=count+addcount ;
            query = "UPDATE product SET count = " + count + " WHERE (product_id  = "+product_id + " )";
            myPrepSt = myCon.prepareStatement(query);
// Database Statement

            myPrepSt.executeUpdate();

            if(myCon != null){ myCon.close();  }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





    };


    void removeProduct (int product_id )
    {
        try{
            Connection myCon =  DriverManager.getConnection(url,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;


            int idp = 0;
            query = "DELETE FROM product WHERE product_id = " + product_id + ";";
            myPrepSt = myCon.prepareStatement(query);

            myPrepSt.executeUpdate();

            if(myCon != null){ myCon.close();  }





        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    };




}




