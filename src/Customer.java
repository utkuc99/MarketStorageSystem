import java.util.List;

public class Customer {

    private int user_id;
    private String first_name;
    private String last_name;
    private String login_name;
    private String gender;
    private String city;

    List<Customer> customerList;

    public static void main(String[] args) {
        Customer customer = new Customer(100, "Kubilay", "Yilmaz", "Login Name", "Male", "Istanbul");
        showInfos(customer);
    }

    Customer(int user_id_, String first_name_, String last_name_, String login_name_, String gender_, String city_){
        this.user_id = user_id_; // ??? Degismesi gerekecek id'nin, +1 olarak arttir her seferinde
        this.first_name = first_name_;
        this.last_name = last_name_;
        this.login_name = login_name_;
        this.gender = gender_;
        this.city = city_;
    }

    public static void showInfos(Customer customer){
        System.out.println("Customer ID: " + customer.user_id + "\nFirst Name: " + customer.first_name +
                "\nlast Name: " + customer.last_name + "\nLogin Name: " + customer.login_name +
                "\nGender: " +  customer.gender + "\nCity: "+  customer.city);
    }

    // Orders Class'i ile baglanacak
    public void orderProduct(){
        //product = new Product();
    }

    // Orders Class'i ile baglanacak
    public void listPendingOrders(){
    }


    public void listPurchasedProducts(){

    }

    public void addCustomer(int user_id_, String first_name_, String last_name_, String login_name_, String gender_, String city_){

        // Eger customerList'te bu customer yoksa ekle.
        if(!customerList.contains(user_id_)){
            customerList.add(new Customer(user_id_,first_name_, last_name_, login_name_, gender_, city_));
        }
    }

}
