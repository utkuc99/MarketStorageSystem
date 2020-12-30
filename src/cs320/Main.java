package cs320;

import cs320.Customer;

import java.sql.*;

public class Main {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";

    static boolean is_Customer = false;
    public static boolean is_Seller = false;
    static String loginName = "";
    static User user;

    public static void login(String login_name){
        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement myPrepSt = null;
            String query = "";
            ResultSet rs = null;
            String check = "";
            user = new User();

            // CHECK IS_CUSTOMER
            query = "select * from customer where loginname = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setString(1, login_name);
            rs = myPrepSt.executeQuery();

            while (rs.next()){
                check = rs.getString(4);
                if(login_name.equals(check)){
                    loginName = login_name;
                    user.id_ = rs.getInt(1);
                    user.firstName_ = rs.getString(2);
                    user.lastName_ = rs.getString(3);
                    user.loginName_ = rs.getString(4);
                    user.gender_ = rs.getString(5);
                    user.city_ = rs.getString(6);
                    is_Customer = true;
                }
            }

            // CHECK IS_SELLER
            query = "select * from seller where loginname = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setString(1, login_name);
            rs = myPrepSt.executeQuery();
            while (rs.next()){
                check = rs.getString(4);
                if(login_name.equals(check)){
                    loginName = login_name;
                    user.id_ = rs.getInt(1);
                    user.firstName_ = rs.getString(2);
                    user.lastName_ = rs.getString(3);
                    user.loginName_ = rs.getString(4);
                    user.gender_ = rs.getString(5);
                    user.city_ = rs.getString(6);
                    is_Seller = true;
                }
            }



         if(myCon != null)  { myCon.close();  }
        }
        catch (Exception exc){
        exc.printStackTrace();  }
    }

    public static User showInfos(){
        System.out.println(user.firstName_ + " "+ user.lastName_ + " " + user.loginName_ + " " +
                user.gender_ + " " + user.city_);
        return user;
    }





    public static void main(String[] args) {
        // PreparedStatement myPrepSt = null;
        // ResultSet rs = null;

    try{
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);

        // login(login_name) : GUI anasayfada giris icin login_name alacak, Exm : umut_cirak321
        // Bu login_name ' sahip user customer ise is_Customer = true, seller ise is_Seller = true
        // user = loginName' e sahip olan kisi
        login("loginname");
        System.out.println("IS CUSTOMER: " + is_Customer + " IS SELLER: " + is_Seller);
        showInfos();

        // adCustomer() : 4 parametre aliyor : firstname, lastname, loginname, gender, city
        //Customer.addCustomer("Umut","Cirak","degisik","Male", "Ankara");

        // adSeller() : 4 parametre aliyor : firstname, lastname, loginname, gender, city
        //Seller.addSeller("Name","LastName","loginname","Gender", "City");

        // seller id, name, price, category, colour, description, count
       Seller.addProduct(user.id_, "Pen", 15.5,"School","Black","Perfect", 5);











        if(myCon != null)
            myCon.close();

    }catch (Exception exc){
        exc.printStackTrace();
    }









    }





}