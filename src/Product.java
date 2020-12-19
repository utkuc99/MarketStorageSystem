import java.util.*;
import java.text.SimpleDateFormat;

public class Product {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        now = new Date();
        System.out.println(formatter.format(now));
    }



    ArrayList<Product> productList= new ArrayList<Product>();
    ArrayList<String> categoryList = new ArrayList<String>();

    private int productId = 1000;
    private String productName;
    private String category;
    private float product_price;
    private String product_color;
    private String product_description;
    private int seller_id;
    private int quantity;
    private int seller_id; // Seller Class'i olusturulunca eklenecek
    private Date expDate;
    private static Date now;


    Product(int productId_, String productName_, Category category_, float product_price, String product_color_, int quantity_, Date expDate_){
        this.productId = productId_;
        this.productName = productName_;
        this.category = category_.product_category_code;
        this.product_price = product_price;
        this.product_color = product_color_;
        this.product_description = category_.product_category_description;
        this.quantity = quantity_;
        this.expDate = expDate_;
        AddCategory(category_);
        productId+=1;
    }

    // Method will be called from GUI. Will be connected with database.
    void AddProduct(int productId_, String productName_, Category category_, float product_price, String product_color_, int quantity_, Date expDate_) {
        productList.add(new Product(productId_,productName_, category_, product_price, product_color_, quantity_, expDate_));
    }

    // Method will be called from GUI. Will be connected with database.
    void AddCategory(Category category_) {
        if(!categoryList.contains(category_.product_category_code)) {
            categoryList.add(category_.product_category_code);
        }
        else {
            System.out.println("This category already exists!");
        }
    }


    // Method will be called from GUI. Will be connected with database.
    void Sell(int productId_, int quantity_) {
        for(Product product : productList) {
            if(product.productId == productId_ ){
                if(product.quantity >= quantity_){
                    if(product.quantity - quantity_ == 0){
                        System.out.println("Product with ID: " + product.productId + " has successfully been sold");
                        productList.remove(product);
                    }
                    else{
                        product.quantity -= quantity_;
                        System.out.println(quantity_ + "of products sold from Product with ID: " + product.productId);
                    }
                }
                else{
                    System.out.println("There is a quantity mismatch!");
                }
            }
            else{
                System.out.println("There is no such product with product ID " + productId_);
            }
        }
    }


    // Method will be called from GUI. Will be connected with database.
    void Remove(int productId_, int quantity_) {
        for(Product product : productList) {
            if(product.productId == productId_ ){
                if(product.quantity >= quantity_){
                    if(product.quantity - quantity_ == 0){
                        System.out.println("Product with ID: " + product.productId + " has successfully been removed");
                        productList.remove(product);
                    }
                    else{
                        product.quantity -= quantity_;
                        System.out.println(quantity_ + "of products removed from Product with ID: " + product.productId);
                    }
                }
                else{
                    System.out.println("There is a quantity mismatch!");
                }
            }
            else{
                System.out.println("There is no such product with product ID " + productId_);
            }
        }
    }


    // Method will be called from GUI. Will be connected with database.
    void CheckExpDate() {
        // Eger product'in tarihi bugunse veya gecmisse tarihi gecti olarak isaretle
        if(this.expDate.compareTo(now) <= 0) {
            System.out.println("Expiration Date Has Expired");
        }

        // veya bu methodu bool yapip -> return (this.expDate.compareTo(now) <= 0);
    }

     void showAll(){
        for(Product product : productList){
            System.out.println("Product Name: " + product.productName + "Product ID: " + product.productId +
                    "Category: " + product.category +"Sell Price: " + product.product_price + "Quantity: " + product.quantity +
                    "Expiration Date: " +product.expDate + "\n");
        }
    }

    void filterBy(){
        // Filter GUI uzerinden yapilacak
    }

}
