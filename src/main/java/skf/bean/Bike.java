package skf.bean;

public class Bike {

    //private static final long serialVersionUID = 1L;

    private String bikeId;
    private String bikeName;
    private int bikePrice;
    private String imageUrl;

    public Bike() {
    }



    public Bike(String bikeId, String bikeName, int bikePrice, String imageUrl){
        this.bikeId = bikeId;
        this.bikeName = bikeName;
        this.bikePrice = bikePrice;
        this.imageUrl = imageUrl;
    }

    public String getBikeId(){return bikeId;}
    public String getBikeName() {
        return bikeName;
    }
    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }
    public int getBikePrice(){return bikePrice;}
    public void setBikePrice(int bikePrice){ this.bikePrice = bikePrice;}
    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}


