
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

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
            int count = 0;

            // CHECK IS_CUSTOMER
            query = "select * from customer where loginname = ?";
            myPrepSt = myCon.prepareStatement(query);
            myPrepSt.setString(1, login_name);
            rs = myPrepSt.executeQuery();

            while (rs.next()){
                check = rs.getString(4);
                if(login_name.equals(check)){
                    count ++;
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
                    count ++;
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
            if(count == 0)
                JOptionPane.showMessageDialog(null, "Invalid login name !");


            if(myCon != null)  { myCon.close();  }
        }
        catch (Exception exc){
            exc.printStackTrace();  }
    }

    public static void showInfo(){
        String info = "ID: " + user.id_ + "\nName: " + user.firstName_  + "\nLast Name: " + user.lastName_
                + "\nLogin Name: " + user.loginName_ + "\nGender: " + user.gender_ +"\nCity: " +user.city_  ;
        JOptionPane.showMessageDialog(null, info);
    }


    public static void main(String[] args) {

        try{
            Connection myCon =  DriverManager.getConnection(DB_URL,USER,PASS);


            JFrame f=new JFrame("Login");
            JLabel l1,l2;
            l1=new JLabel("Username");
            l1.setBounds(30,15, 100,30);

            JTextField F_user = new JTextField();
            F_user.setBounds(110, 15, 200, 30);

            JButton login_but=new JButton("Login");
            login_but.setBounds(120,55,120,25);
            login_but.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e){

                    String username = F_user.getText();

                    login(username);

                    if(is_Seller){
                        seller_menu.start(username);
                    }else if(is_Customer){
                        user_menu.start(username);
                    }
                }
            });

            JButton seller_register_but=new JButton("Register Seller");
            seller_register_but.setBounds(26,95,140,25);
            seller_register_but.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JFrame g = new JFrame("Register Seller");

                    JLabel l1,l2,l3,l4,l5,l6;
                    l1=new JLabel("First Name");
                    l1.setBounds(30,15, 100,30);
                    l2=new JLabel("Last Name");
                    l2.setBounds(30,53, 100,30);
                    l3=new JLabel("Gender");
                    l3.setBounds(30,91, 100,30);
                    l4=new JLabel("City");
                    l4.setBounds(30,129, 100,30);
                    l5=new JLabel("username");
                    l5.setBounds(30,167, 100,30);

                    JTextField F_fname = new JTextField();
                    F_fname.setBounds(110, 15, 200, 30);
                    JTextField F_lname=new JTextField();
                    F_lname.setBounds(110, 53, 200, 30);
                    JTextField F_gender=new JTextField();
                    F_gender.setBounds(110, 91, 200, 30);
                    JTextField F_city = new JTextField();
                    F_city.setBounds(110, 129, 200, 30);
                    JTextField F_username=new JTextField();
                    F_username.setBounds(110, 167, 200, 30);

                    JButton submit_but=new JButton("Submit");
                    submit_but.setBounds(130,205,80,25);
                    submit_but.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            Seller.addSeller(F_fname.getText(), F_lname.getText(),
                                    F_username.getText(), F_gender.getText(),F_city.getText() );

                        }
                    });

                    g.add(l1);
                    g.add(l2);
                    g.add(l3);
                    g.add(l4);
                    g.add(l5);
                    g.add(F_fname);
                    g.add(F_lname);
                    g.add(F_gender);
                    g.add(F_city);
                    g.add(F_username);
                    g.add(submit_but);

                    g.setSize(350,260);
                    g.setLayout(null);
                    g.setVisible(true);
                    g.setLocationRelativeTo(null);

                }
            });

            JButton customer_register_but=new JButton("Register Customer");
            customer_register_but.setBounds(193,95,140,25);
            customer_register_but.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JFrame g = new JFrame("Register Customer");

                    JLabel l1,l2,l3,l4,l5,l6;
                    l1=new JLabel("First Name");
                    l1.setBounds(30,15, 100,30);
                    l2=new JLabel("Last Name");
                    l2.setBounds(30,53, 100,30);
                    l3=new JLabel("Gender");
                    l3.setBounds(30,91, 100,30);
                    l4=new JLabel("City");
                    l4.setBounds(30,129, 100,30);
                    l5=new JLabel("username");
                    l5.setBounds(30,167, 100,30);

                    JTextField F_fname = new JTextField();
                    F_fname.setBounds(110, 15, 200, 30);
                    JTextField F_lname=new JTextField();
                    F_lname.setBounds(110, 53, 200, 30);
                    JTextField F_gender=new JTextField();
                    F_gender.setBounds(110, 91, 200, 30);
                    JTextField F_city = new JTextField();
                    F_city.setBounds(110, 129, 200, 30);
                    JTextField F_username=new JTextField();
                    F_username.setBounds(110, 167, 200, 30);

                    JButton submit_but=new JButton("Submit");
                    submit_but.setBounds(130,205,80,25);
                    submit_but.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){

                            Customer.addCustomer(F_fname.getText(), F_lname.getText(),
                                    F_username.getText(), F_gender.getText(),F_city.getText() );

                        }
                    });

                    g.add(l1);
                    g.add(l2);
                    g.add(l3);
                    g.add(l4);
                    g.add(l5);
                    g.add(F_fname);
                    g.add(F_lname);
                    g.add(F_gender);
                    g.add(F_city);
                    g.add(F_username);
                    g.add(submit_but);

                    g.setSize(350,260);
                    g.setLayout(null);
                    g.setVisible(true);
                    g.setLocationRelativeTo(null);

                }
            });

            f.add(login_but);
            f.add(F_user);
            f.add(l1);
            f.add(seller_register_but);
            f.add(customer_register_but);

            f.setSize(360,180);
            f.setLayout(null);
            f.setVisible(true);
            f.setLocationRelativeTo(null);







            if(myCon != null)
                myCon.close();

        }catch (Exception exc){
            exc.printStackTrace();
        }









    }





}