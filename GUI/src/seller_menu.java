import javax.swing.*;
import java.awt.event.*;

public class seller_menu {
    public static void start() {
        JFrame f = new JFrame("Seller Menu");

        JButton view_products = new JButton("View Products");
        view_products.setBounds(20, 20, 120, 25);
        view_products.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFrame f = new JFrame("Products Available");
                String[][] deneme = {
                        { "Toilet Paper", "5", "10", "100", "Deneme", "Selpak", "18.07.2021" },
                        { "Biskrem", "5", "10", "100", "Deneme", "Eti", "18.07.2021" },
                        { "Water", "5", "10", "100", "Deneme", "Erikli", "18.07.2021" },
                        { "Choclate", "5", "10", "100", "Deneme", "Nestle", "18.07.2021" }
                };
                String[] columnNames = { "Name", "Buy Price", "Sell Price", "Quantity", "Category", "Brand", "Expiration Date" };
                JTable product_list= new JTable(deneme, columnNames);
                JScrollPane scrollPane = new JScrollPane(product_list);
                f.add(scrollPane);

                f.setSize(800, 400);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
        });


        JButton add_product = new JButton("Add Product");
        add_product.setBounds(150, 20, 120, 25);
        add_product.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("Add Product");

                JLabel l1,l2,l3,l4,l5,l6,l7;
                l1=new JLabel("Name");
                l1.setBounds(30,15, 100,30);
                l2=new JLabel("Buy Price");
                l2.setBounds(30,53, 100,30);
                l3=new JLabel("Sell Price");
                l3.setBounds(30,91, 100,30);
                l4=new JLabel("Quantity");
                l4.setBounds(30,129, 100,30);
                l5=new JLabel("Category");
                l5.setBounds(30,167, 100,30);
                l6=new JLabel("Brand");
                l6.setBounds(30,205, 100,30);
                l7=new JLabel("Exp. Date");
                l7.setBounds(30,243, 100,30);

                JTextField F_name = new JTextField();
                F_name.setBounds(110, 15, 200, 30);
                JTextField F_buyp=new JTextField();
                F_buyp.setBounds(110, 53, 200, 30);
                JTextField F_sellp=new JTextField();
                F_sellp.setBounds(110, 91, 200, 30);
                JTextField F_quan = new JTextField();
                F_quan.setBounds(110, 129, 200, 30);
                JTextField F_categ=new JTextField();
                F_categ.setBounds(110, 167, 200, 30);
                JTextField F_brand=new JTextField();
                F_brand.setBounds(110, 205, 200, 30);
                JTextField F_expd=new JTextField();
                F_expd.setBounds(110, 243, 200, 30);

                JButton submit_but=new JButton("Submit");
                submit_but.setBounds(130,281,80,25);

                g.add(l1);
                g.add(l2);
                g.add(l3);
                g.add(l4);
                g.add(l5);
                g.add(l6);
                g.add(l7);
                g.add(F_name);
                g.add(F_buyp);
                g.add(F_sellp);
                g.add(F_quan);
                g.add(F_categ);
                g.add(F_brand);
                g.add(F_expd);
                g.add(submit_but);

                g.setSize(350,350);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);

            }
        });


        JButton sell_product = new JButton("Sell Product");
        sell_product.setBounds(280, 20, 130, 25);
        sell_product.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("Sell Product");

                JLabel l1,l2,l3;
                l1=new JLabel("Name");
                l1.setBounds(30,15, 100,30);
                l2=new JLabel("Brand");
                l2.setBounds(30,53, 100,30);
                l3=new JLabel("Sell Quant.");
                l3.setBounds(30,91, 150,30);

                JTextField F_name = new JTextField();
                F_name.setBounds(110, 15, 200, 30);
                JTextField F_brand=new JTextField();
                F_brand.setBounds(110, 53, 200, 30);
                JTextField F_quan=new JTextField();
                F_quan.setBounds(110, 91, 200, 30);

                JButton submit_but=new JButton("Submit");
                submit_but.setBounds(130,140,80,25);

                g.add(l1);
                g.add(l2);
                g.add(l3);
                g.add(F_name);
                g.add(F_brand);
                g.add(F_quan);
                g.add(submit_but);

                g.setSize(350,220);
                g.setLayout(null);
                g.setVisible(true);
                g.setLocationRelativeTo(null);

            }
        });


        JButton remove_product = new JButton("Remove Product");
        remove_product.setBounds(420, 20, 150, 25);
        remove_product.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFrame g = new JFrame("Remove Product");

                JLabel l1,l2,l3;
                l1=new JLabel("Name");
                l1.setBounds(30,15, 100,30);
                l2=new JLabel("Brand");
                l2.setBounds(30,53, 100,30);

                JTextField F_name = new JTextField();
                F_name.setBounds(110, 15, 200, 30);
                JTextField F_brand=new JTextField();
                F_brand.setBounds(110, 53, 200, 30);

                JButton submit_but=new JButton("Submit");
                submit_but.setBounds(130,100,80,25);

                g.add(l1);
                g.add(l2);
                g.add(F_name);
                g.add(F_brand);
                g.add(submit_but);

                g.setSize(350,200);//400 width and 500 height
                g.setLayout(null);//using no layout managers
                g.setVisible(true);//making the frame visible
                g.setLocationRelativeTo(null);
            }
        });


        JButton view_categories = new JButton("View Categories");
        view_categories.setBounds(20, 60, 150, 25);
        view_categories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                JFrame f = new JFrame("Categories Avaliable");
                String[][] data = {
                        {"Hygiene"},
                        {"Chocolate / Candy"},
                        {"Drinks"}
                };
                String[] columnNames = { "Name" };
                JTable categories_list= new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(categories_list);
                f.add(scrollPane);

                f.setSize(800, 400);
                f.setVisible(true);
                f.setLocationRelativeTo(null);


            }
        });


        f.add(view_products);
        f.add(add_product);
        f.add(sell_product);
        f.add(remove_product);
        f.add(view_categories);

        f.setSize(600, 200);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}