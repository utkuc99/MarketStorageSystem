import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class login_page {
    public static void main(String args[]) {

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

                Main.login(username);

                System.out.println(username);

                if(username.equals("seller")){
                    seller_menu.start(username);
                }else if(username.equals("user")){
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

                        System.out.println(F_fname.getText());
                        System.out.println(F_lname.getText());
                        System.out.println(F_gender.getText());
                        System.out.println(F_city.getText());
                        System.out.println(F_username.getText());

                        boolean sucsessful = true;
                        if(sucsessful) {
                            showMessageDialog(null, "Register Sucessful");
                            g.dispose();
                        }else{
                            showMessageDialog(null, "Register Failed");
                        }

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

                        System.out.println(F_fname.getText());
                        System.out.println(F_lname.getText());
                        System.out.println(F_gender.getText());
                        System.out.println(F_city.getText());
                        System.out.println(F_username.getText());

                        boolean sucsessful = true;
                        if(sucsessful) {
                            showMessageDialog(null, "Register Sucessful");
                            g.dispose();
                        }else{
                            showMessageDialog(null, "Register Failed");
                        }


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

    }
}
