import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class user_menu {
    public static void start() {
        JFrame f = new JFrame("User Menu");

        JButton show_info_but=new JButton("Show Info");
        show_info_but.setBounds(190,20,150,25);
        show_info_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("User Info");

                JLabel l1,l2,l3,l4,l5,l6;
                JLabel l12,l22,l32,l42,l52,l62;
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

                String name = "Utku", lastname = "Çelebiöven", gender = "Male", city = "İzmir", username = "utkuc99";

                l12=new JLabel(name);
                l12.setBounds(110,15, 100,30);
                l22=new JLabel(lastname);
                l22.setBounds(110,53, 100,30);
                l32=new JLabel(gender);
                l32.setBounds(110,91, 100,30);
                l42=new JLabel(city);
                l42.setBounds(110,129, 100,30);
                l52=new JLabel(username);
                l52.setBounds(110,167, 100,30);


                JButton submit_but=new JButton("Close");
                submit_but.setBounds(130,205,80,25);
                submit_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        g.dispose();
                    }
                });

                g.add(l1);
                g.add(l2);
                g.add(l3);
                g.add(l4);
                g.add(l5);
                g.add(l12);
                g.add(l22);
                g.add(l32);
                g.add(l42);
                g.add(l52);
                g.add(submit_but);

                g.setSize(350,260);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);

            }
        });

        JButton view_products = new JButton("Show Products");
        view_products.setBounds(20, 20, 150, 25);
        view_products.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFrame f = new JFrame("Products Available");
                String[][] deneme = {
                        { "Toilet Paper", "5", "10", "100", "Deneme", "Selpak", "18.07.2021" },
                        { "Biskrem", "5", "10", "100", "Deneme", "Eti", "18.07.2021" },
                        { "Water", "5", "10", "100", "Deneme", "Erikli", "18.07.2021" },
                        { "Choclate", "5", "10", "100", "Deneme", "Nestle", "18.07.2021" }
                };

                //DATABASE GET PRODUCTS

                String[] columnNames = { "Name", "Buy Price", "Sell Price", "Quantity", "Category", "Brand", "Expiration Date" };
                JTable product_list= new JTable(deneme, columnNames);

                JTableHeader anHeader2 = product_list.getTableHeader();
                anHeader2.setForeground(new Color(0).yellow);
                anHeader2.setBackground(new Color(0).black);

                JScrollPane scrollPane = new JScrollPane(product_list);
                f.add(scrollPane);

                f.setSize(800, 400);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
        });


        JButton view_purchased = new JButton("Show Purchased Products");
        view_purchased.setBounds(20, 60, 150, 25);
        view_purchased.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFrame f = new JFrame("Past Purchases");

                /*
                JButton main_but=new JButton("Main Page");
                main_but.setBounds(20,355,150,25);
                main_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                    }
                });
                f.add(main_but);
                 */

                String[][] deneme = {
                        { "Toilet Paper", "5", "10", "100", "Deneme", "Selpak", "18.07.2021", "aaa" },
                        { "Biskrem", "5", "10", "100", "Deneme", "Eti", "18.07.2021", "aaa" },
                        { "Water", "5", "10", "100", "Deneme", "Erikli", "18.07.2021", "aaa" },
                        { "Choclate", "5", "10", "100", "Deneme", "Nestle", "18.07.2021", "aaa" }
                };

                //DATABASE GET PRODUCTS

                String[] columnNames = { "ID", "Seller ID", "Name", "Price", "Category", "Color", "Description", "Count" };
                JTable purchase_list= new JTable(deneme, columnNames);
                JTableHeader anHeader = purchase_list.getTableHeader();
                anHeader.setForeground(new Color(0).yellow);
                anHeader.setBackground(new Color(0).black);
                JScrollPane scrollPane = new JScrollPane(purchase_list);
                f.add(scrollPane);

                f.setSize(800, 400);
                f.setVisible(true);
                f.setLocationRelativeTo(null);

            }
        });


        f.add(view_products);
        f.add(view_purchased);
        f.add(show_info_but);

        f.setSize(360, 180);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}