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
        login_but.setBounds(130,90,80,25);
        login_but.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e){

                String username = F_user.getText();
                String password = F_pass.getText();

                System.out.println(username);
                System.out.println(password);

                seller_menu.seller();

            }
        });


        f.add(F_pass);
        f.add(login_but);
        f.add(F_user);
        f.add(l1);
        f.add(l2);

        f.setSize(400,180);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

    }
}
