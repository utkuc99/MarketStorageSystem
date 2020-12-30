import javax.swing.*;
import java.awt.event.*;

public class login_page {
    public static void main(String args[]) {

        JFrame f=new JFrame("Login");
        JLabel l1,l2;
        l1=new JLabel("Username");
        l1.setBounds(30,15, 100,30);

        l2=new JLabel("Password");
        l2.setBounds(30,50, 100,30);

        JTextField F_user = new JTextField();
        F_user.setBounds(110, 15, 200, 30);

        JPasswordField F_pass=new JPasswordField();
        F_pass.setBounds(110, 50, 200, 30);

        JButton login_but=new JButton("Login");
        login_but.setBounds(180,90,100,25);
        login_but.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e){

                String username = F_user.getText();
                String password = F_pass.getText();

                System.out.println(username);
                System.out.println(password);

                if(username.equals("seller")){
                    seller_menu.start();
                }else if(username.equals("user")){
                    user_menu.start();
                }
            }
        });

        JButton register_but=new JButton("Register");
        register_but.setBounds(70,90,100,25);
        register_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("Register");

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
                l6=new JLabel("password");
                l6.setBounds(30,205, 100,30);

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
                JTextField F_pass=new JTextField();
                F_pass.setBounds(110, 205, 200, 30);

                JButton submit_but=new JButton("Submit");
                submit_but.setBounds(130,255,80,25);

                g.add(l1);
                g.add(l2);
                g.add(l3);
                g.add(l4);
                g.add(l5);
                g.add(l6);
                g.add(F_fname);
                g.add(F_lname);
                g.add(F_gender);
                g.add(F_city);
                g.add(F_username);
                g.add(F_pass);
                g.add(submit_but);

                g.setSize(350,330);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);

            }
        });



        f.add(F_pass);
        f.add(login_but);
        f.add(F_user);
        f.add(l1);
        f.add(l2);
        f.add(register_but);

        f.setSize(350,180);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }
}
