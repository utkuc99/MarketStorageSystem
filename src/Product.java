import java.sql.*;


public class Product {
    public int product_id;
    public String product_category_code;
    public String product_name;
    public double price;
    public String product_color;
    public String product_description;
    public int seller_id;
    public int count;

    /*

     */
    public Product(int seller_id, String product_category_code, String product_name, double price, String product_color, String product_description, int count) {
        this.seller_id = seller_id;
        this.product_category_code = product_category_code;
        this.product_name = product_name;
        this.price = price;
        this.product_color = product_color;
        this.product_description = product_description;
        this.count = count;
    }


    public void showInfos(String product_category_code, String product_name, double price, String product_color, String product_description, int count) {



    };


}