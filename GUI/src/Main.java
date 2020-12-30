import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gui {
    public static void main(String args[]) {
        JFrame f = new JFrame("Main Menu");

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

        f.add(view_products);
        f.setSize(600, 200);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);
    }
}