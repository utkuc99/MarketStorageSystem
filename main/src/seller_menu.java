import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class seller_menu {
    public static void start(String user_id) {
        JFrame f = new JFrame("Seller Menu");

        JButton show_info_but=new JButton("Show Info");
        show_info_but.setBounds(20,20,150,25);
        show_info_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("User Info");
                User u = Main.user;

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

                String name = u.firstName_, lastname = u.lastName_, gender = u.gender_, city = u.city_, username = u.loginName_;

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


        JButton view_products = new JButton("Products on Sale");
        view_products.setBounds(190, 20, 150, 25);
        view_products.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFrame f = new JFrame("Products Available");

                ArrayList<Product> list = Seller.showProductsOnSale(Main.user.id_);

                int sz = list.size();
                String[][] deneme_2 = new String[sz][8];
                for (int i = 0; i < sz ; i++) {
                    deneme_2[i][0] = Integer.toString(list.get(i).id_);
                    deneme_2[i][1] = list.get(i).name;
                    deneme_2[i][2] = Integer.toString(list.get(i).seller_id_);
                    deneme_2[i][3] = Double.toString(list.get(i).price_);
                    deneme_2[i][4] = list.get(i).category_;
                    deneme_2[i][5] = list.get(i).colour_;
                    deneme_2[i][6] = list.get(i).description_;
                    deneme_2[i][7] = Integer.toString(list.get(i).count_);
                }

                //DATABASE GET PRODUCTS

                String[] columnNames = { "Product ID","Name", "Seller ID", "Price", "Category", "Color", "Description", "Quantity" };
                JTable product_list= new JTable(deneme_2, columnNames);
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


        JButton add_product = new JButton("Add Product");
        add_product.setBounds(20, 60, 150, 25);
        add_product.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("Add Product");

                JLabel l1,l2,l3,l4,l5,l6,l7;
                l2=new JLabel("Name");
                l2.setBounds(30,15, 100,30);
                l3=new JLabel("Price");
                l3.setBounds(30,53, 100,30);
                l4=new JLabel("Category");
                l4.setBounds(30,91, 100,30);
                l5=new JLabel("Color");
                l5.setBounds(30,129, 100,30);
                l6=new JLabel("Description");
                l6.setBounds(30,167, 100,30);
                l7=new JLabel("Count");
                l7.setBounds(30,205, 100,30);

                JTextField F_name=new JTextField();
                F_name.setBounds(110, 15, 200, 30);
                JTextField F_price=new JTextField();
                F_price.setBounds(110, 53, 200, 30);
                JTextField F_categ = new JTextField();
                F_categ.setBounds(110, 91, 200, 30);
                JTextField F_color=new JTextField();
                F_color.setBounds(110, 129, 200, 30);
                JTextField F_desc=new JTextField();
                F_desc.setBounds(110, 167, 200, 30);
                JTextField F_count=new JTextField();
                F_count.setBounds(110, 205, 200, 30);

                JButton submit_but=new JButton("Submit");
                submit_but.setBounds(130,243,80,25);
                submit_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        Seller.addProduct(Main.user.id_, F_name.getText(), Double.parseDouble(F_price.getText())
                                , F_categ.getText(), F_color.getText(), F_desc.getText(),
                                Integer.parseInt(F_count.getText()));

                        boolean sucsessful = true;

                        //DATABASE ADD PRODUCT

                        if(sucsessful) {
                            showMessageDialog(null, "Product is added.");
                            g.dispose();
                        }else{
                            showMessageDialog(null, "Product addition is failed.");
                        }

                    }
                });

                g.add(l2);
                g.add(l3);
                g.add(l4);
                g.add(l5);
                g.add(l6);
                g.add(l7);
                g.add(F_name);
                g.add(F_price);
                g.add(F_categ);
                g.add(F_color);
                g.add(F_desc);
                g.add(F_count);
                g.add(submit_but);

                g.setSize(350,310);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);

            }
        });


        JButton remove_product = new JButton("Remove Product");
        remove_product.setBounds(190, 60, 150, 25);
        remove_product.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFrame g = new JFrame("Remove Product");

                JLabel l1;
                l1=new JLabel("Product ID");
                l1.setBounds(30,15, 100,30);

                JTextField F_id = new JTextField();
                F_id.setBounds(110, 15, 200, 30);

                JButton submit_but=new JButton("Submit");
                submit_but.setBounds(130,65,80,25);
                submit_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        int pID = Integer.parseInt(F_id.getText());
                        Seller.removeProduct(pID, Main.user.id_);
                    }

                });

                g.add(l1);
                g.add(F_id);
                g.add(submit_but);

                g.setSize(350,120);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);
            }
        });

        JButton sold_products = new JButton("Show Sold Products");
        sold_products.setBounds(20, 100, 150, 25);
        sold_products.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFrame f = new JFrame("Products Available");

                ArrayList<Product> list = Seller.showSoldProducts(Main.user.id_);
                int sz = list.size();
                String[][] deneme_2 = new String[sz][8];
                for (int i = 0; i < sz ; i++) {
                    deneme_2[i][0] = Integer.toString(list.get(i).id_);
                    deneme_2[i][1] = list.get(i).name;
                    deneme_2[i][2] = Integer.toString(list.get(i).seller_id_);
                    deneme_2[i][3] = Double.toString(list.get(i).price_);
                    deneme_2[i][4] = list.get(i).category_;
                    deneme_2[i][5] = list.get(i).colour_;
                    deneme_2[i][6] = list.get(i).description_;
                    deneme_2[i][7] = Integer.toString(list.get(i).count_);
                }

                //DATABASE GET PRODUCTS

                String[] columnNames = { "Product ID","Name", "Buyer ID", "Price", "Category", "Color", "Description", "Quantity" };
                JTable product_list= new JTable(deneme_2, columnNames);
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


        JButton change_product_count = new JButton("Upd. Product Count");
        change_product_count.setBounds(190, 100, 150, 25);
        change_product_count.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("Add Product");

                JLabel l2,l3;
                l2=new JLabel("Product_ID");
                l2.setBounds(30,15, 100,30);
                l3=new JLabel("Inc. Amount");
                l3.setBounds(30,53, 100,30);

                JTextField F_product=new JTextField();
                F_product.setBounds(110, 15, 200, 30);
                JTextField F_amount=new JTextField();
                F_amount.setBounds(110, 53, 200, 30);


                JButton submit_but=new JButton("Submit");
                submit_but.setBounds(130,91,80,25);
                submit_but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        int pID = Integer.parseInt(F_product.getText());
                        int cn = Integer.parseInt(F_amount.getText());

                        Seller.addExistingProduct(pID,cn,Main.user.id_);
                    }
                });

                g.add(l2);
                g.add(l3);
                g.add(F_product);
                g.add(F_amount);
                g.add(submit_but);

                g.setSize(350,150);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);

            }
        });


        f.add(view_products);
        f.add(add_product);
        f.add(remove_product);
        f.add(sold_products);
        f.add(show_info_but);
        f.add(change_product_count);

        f.setSize(400, 200);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}