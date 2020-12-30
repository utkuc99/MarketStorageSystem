package cs320;

import cs320.Customer;

import java.sql.*;
import java.util.ArrayList;

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
        System.out.println(user.id_ + " " + user.firstName_ + " "+ user.lastName_ + " " + user.loginName_ + " " +
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
       // Customer.addCustomer("Umut","Cirak","degisik","Male", "Ankara");

        // adSeller() : 4 parametre aliyor : firstname, lastname, loginname, gender, city
        //Seller.addSeller("Name","LastName","loginname","Gender", "City");

        // seller id, name, price, category, colour, description, count
        //Seller.addProduct(user.id_, "Pen", 15.5,"School","Black","Perfect", 5);

                     /*
        ArrayList<Product> purchased_List = Customer.listPurchasedProducts(user.id_);
        for(Product p : purchased_List){
            System.out.println(p.id_ + " " + " " + p.seller_id_ + " " +p.name + " " +
                    p.price_ + " " + " " + p.category_ + " " +p.colour_ + " " +
                    p.description_);
        }
                     */

       // Customer.orderProduct(1 , user.id_, 5);

        ArrayList<Product> onSale = Seller.showProductsOnSale(user.id_);
        for(Product p : onSale){
            System.out.println(p.id_ + " " + " " + p.seller_id_ + " " +p.name + " " +
                    p.price_ + " " + " " + p.category_ + " " +p.colour_ + " " +
                    p.description_+ " " + p.count_);
        }

        ArrayList<Product> product_ALL = Customer.showProducts();
        for(Product p : product_ALL){
            System.out.println(p.id_ + " " + " " + p.seller_id_ + " " +p.name + " " +
                    p.price_ + " " + " " + p.category_ + " " +p.colour_ + " " +
                    p.description_+ " " + p.count_);
        }

        ArrayList<Product> selled_Products = Seller.showSoldProducts(1);
        for(Product p : product_ALL){
            System.out.println(p.id_ + " " + " " + p.seller_id_ + " " +p.name + " " +
                    p.price_ + " " + " " + p.category_ + " " +p.colour_ + " " +
                    p.description_+ " " + p.count_);
        }

        System.out.println("\nFILTERED PRODUCTS");

        ArrayList<Product> filtered_Products = Customer.filterProducts("category","School");
        for(Product p : filtered_Products){
            System.out.println(p.id_ + " " + " " + p.seller_id_ + " " +p.name + " " +
                    p.price_ + " " + " " + p.category_ + " " +p.colour_ + " " +
                    p.description_+ " " + p.count_);
        }






        if(myCon != null)
            myCon.close();

    }catch (Exception exc){
        exc.printStackTrace();
    }









    }





}
