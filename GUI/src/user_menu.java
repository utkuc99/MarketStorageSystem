import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class user_menu {
    public static void start() {
        JFrame f = new JFrame("User Menu");

        JButton view_products = new JButton("View Products");
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
                String[] columnNames = { "Name", "Buy Price", "Sell Price", "Quantity", "Category", "Brand", "Expiration Date" };
                JTable product_list= new JTable(deneme, columnNames);
                JScrollPane scrollPane = new JScrollPane(product_list);
                f.add(scrollPane);

                f.setSize(800, 400);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
        });


        JButton buy_product = new JButton("Buy Product");
        buy_product.setBounds(360, 20, 150, 25);
        buy_product.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("Buy Product");

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


        JButton view_categories = new JButton("View Categories");
        view_categories.setBounds(190, 20, 150, 25);
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
        f.add(buy_product);
        f.add(view_categories);

        f.setSize(600, 200);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}