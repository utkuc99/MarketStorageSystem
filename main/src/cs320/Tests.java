package cs320;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tests {

    static final String DB_URL = "jdbc:mysql://localhost:3306/marketstoragesystem";
    static final String USER = "root";
    static final String PASS = "Uc1234";

    @Test
    public void test_1() throws Exception {
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement myPrepSt = null;
        String query = "";
        ResultSet rs = null;

        User user = new User(1,"Umut","Cirak","uc555","Male","Ankara");
        Customer.addCustomer("Umut","Cirak","uc555","Male","Ankara");

        query = "select * from customer where loginname = 'uc555'";
        myPrepSt = myCon.prepareStatement(query);
        rs = myPrepSt.executeQuery();

        String user_name_2 = "";
        while(rs.next())
            user_name_2 = rs.getString(4);


        Assert.assertEquals(user.loginName_,user_name_2);
    }

    @Test
    public void test_2() throws Exception {
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement myPrepSt = null;
        String query = "";
        ResultSet rs = null;

        String user_name_1 = "es555";
        Seller.addSeller("Eray","Sahin","es555","Male","Ankara");

        query = "select * from seller where loginname = 'es555'";
        myPrepSt = myCon.prepareStatement(query);
        rs = myPrepSt.executeQuery();

        String user_name_2 = "";
        while(rs.next())
            user_name_2 = rs.getString(4);

        Assert.assertEquals(user_name_1,user_name_2);
    }

    @Test
    public void test_3() throws Exception {
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement myPrepSt = null;
        String query = "";
        ResultSet rs = null;

        Product p = new Product(25,1,"Test_Name",25,"Electronic","Black","Music",15);
        Seller.addProduct(1,"Test_Name",25,"Electronic","Black","Music",15);

        query = "select * from product where name = 'Test_Name'";
        myPrepSt = myCon.prepareStatement(query);
        rs = myPrepSt.executeQuery();

        String test2= "";
        while(rs.next())
            test2 = rs.getString(3);

        Assert.assertEquals(p.name,test2);
    }

    @Test
    public void test_4() throws Exception {
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);

        Seller.addSeller("John","Wick","jw_123","Male","Ankara");
        Main.login("jw_123");

        Assert.assertEquals(Main.is_Seller,true);
    }

    @Test
    public void test_5() throws Exception {
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);

        Customer.addCustomer("Umut","Cirak","uc555","Male","Ankara");
        Main.login("uc555");

        Assert.assertEquals(Main.is_Customer,true);
    }

    @Test
    public void test_6() throws Exception {
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);

        Customer.addCustomer("Umut","Cirak","uc555","Male","Ankara");
        Main.login("uc555");

        Assert.assertEquals(Main.showInfo().loginName_,"uc555");
    }

    @Test
    public void test_7() throws Exception {
        Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);

        Seller.addSeller("John","Wick","jw_123","Male","Ankara");
        Main.login("jw_123");

        Assert.assertEquals(Main.showInfo().loginName_,"jw_123");
    }




}