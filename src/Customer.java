import java.sql.*;

public class Customer extends User {



    public Customer() {

    }
public void addPurchased(Product product){

};
    //String product_category_code, String product_name, double price, String product_color, String product_description, int count

    public void orderProduct (int product_id,int coun, int seller_id )
    {

        try{
            Connection myCon =  DriverManager.getConnection(url,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;


            query = "SELECT * FROM product WHERE product_id ="+ product_id+  ";" ;
            myPrepSt = myCon.prepareStatement(query);
            rs = myPrepSt.executeQuery();
            rs.next();
            int count = rs.getInt(7);

            count=count-coun ;
            query = "UPDATE product SET count = " + count + " WHERE (product_id  = "+product_id + " )";
            myPrepSt = myCon.prepareStatement(query);
// Database Statement
            myPrepSt.executeUpdate();


            if(myCon != null){ myCon.close();  }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    };



}




