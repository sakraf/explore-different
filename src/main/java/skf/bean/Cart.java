package skf.bean;


public class Cart {

    private String pID;
    private String pName;
    private int pPrice;
    private String pUrl;
    private int quantity;

    public Cart(String pID, String pName, int pPrice,String pUrl, int quantity) {
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pUrl = pUrl;
        this.quantity = quantity;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpUrl(){return pUrl;}

    public void setpUrl(String pUrl){this.pUrl = pUrl;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}