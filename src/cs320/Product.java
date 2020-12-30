package cs320;

public class Product {

    public int id_;
    public int seller_id_;
    public String name;
    public double price_;
    public String category_;
    public String colour_;
    public String description_;


    public Product(){ }

    public Product(int id_, int seller_id_, String name, double price_, String category_, String colour_, String description_) {
        this.id_ = id_;
        this.seller_id_ = seller_id_;
        this.name = name;
        this.price_ = price_;
        this.category_ = category_;
        this.colour_ = colour_;
        this.description_ = description_;
    }



}
