import java.util.*;
import java.util.Locale.Category;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.*;
public class Product {
	
	// Her product icin ID olacak mi? Olursa sell, remove icin daha iyi olur gibi. Ayrica filter yaparken daha kolay olabilir. ID de ekle koda. 

	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    now = new Date();  
	    System.out.println(formatter.format(now));     
	}
	
	
	ArrayList<Product> productList= new ArrayList<Product>();
	ArrayList<String> categoryList = new ArrayList<String>();
	
	String productName;
	String category;
	String brand;
	float buyPrice;
	float sellPrice;
	int quantity;
	Date expDate;
	public static Date now;
	int productId = 1000;
	
	Product(int productId_,String productName_, String category_, String brand_, float buyPrice_, float sellPrice_, int quantity_, Date expDate_){
		this.productId = productId_;
		this.productName = productName_;
		this.category = category_;
		this.brand = brand_;
		this.buyPrice = buyPrice_;
		this.sellPrice = sellPrice_;
		this.quantity = quantity_;
		this.expDate = expDate_;
		AddCategory(category_);
		productId+=1;
	}
	
	// Method will be called from GUI. Will be connected with database. 
	void AddProduct(int productId_,String productName_, String category_, String brand_, float buyPrice_, float sellPrice_, int quantity_, Date expDate_) {
		productList.add(new Product(productId_,productName_, category_, brand_, buyPrice_, sellPrice_, quantity_, expDate_));
	}
	
	
	// Method will be called from GUI. Will be connected with database. 
	void AddCategory(String category_) {
		
		if(!categoryList.contains(category_)) {
			categoryList.add(category_);
		}
		else {
			System.out.println("This category already exists!");
		}
		
	}
	
	
	// Method will be called from GUI. Will be connected with database. 
	void Sell() {
		// Ne yapilacak?
	}
	
	
	// Method will be called from GUI. Will be connected with database. 
	void Remove() {
		// Ne yapilacak?
	}
	
	
	// Method will be called from GUI. Will be connected with database. 
	void CheckExpDate() {
		// Eger product'in tarihi bugunse veya gecmisse tarihi gecti olarak isaretle
		if(this.expDate.compareTo(now) <= 0) {
			System.out.println("Expiration Date Has Expired");	
		}
	}	
}
