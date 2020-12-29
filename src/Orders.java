public class Orders {

    private int order_id;
    private int customer_id;
    private int seller_id;
    private String order_status;




    public Orders(int order_id, int customer_id, int seller_id, String order_status) {
        super();
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.seller_id = seller_id;
        this.order_status = order_status;
    }




    public int getOrder_id() {
        return order_id;
    }




    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }




    public int getCustomer_id() {
        return customer_id;
    }




    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }




    public int getSeller_id() {
        return seller_id;
    }




    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }




    public String getOrder_status() {
        return order_status;
    }




    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

//METHODES

    public static void showAll() {


    }

    public static void filterBy() {


    }

    public static void addOrder() {


    }

    public static void deleteOrder() {


    }










}
