package projekt.pizzaby.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robert on 15.02.2017.
 */

public class PizzeriaMapped {

    @SerializedName("PizzeriaID")
    @Expose
    private Integer pizzeriaID;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Address")
    @Expose
    private String address;

    @SerializedName("Phone")
    @Expose
    private String phone;

    @SerializedName("Latitude")
    @Expose
    private Double latitude;

    @SerializedName("Longitude")
    @Expose
    private Double longitude;

    @SerializedName("SizeMin")
    @Expose
    private Integer sizeMin;

    @SerializedName("SizeMax")
    @Expose
    private Integer sizeMax;

    @SerializedName("PriceMin")
    @Expose
    private Integer priceMin;

    @SerializedName("PriceMax")
    @Expose
    private Integer priceMax;

    @SerializedName("Distance")
    @Expose
    private Double distance;

    @SerializedName("Pizzas")
    @Expose
    private List<PizzaMapped> pizzas = null;



    public Integer getPizzeriaID() {
        return pizzeriaID;
    }

    public void setPizzeriaID(Integer pizzeriaID) {
        this.pizzeriaID = pizzeriaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getSizeMin() {
        return sizeMin;
    }

    public void setSizeMin(Integer sizeMin) {
        this.sizeMin = sizeMin;
    }

    public Integer getSizeMax() {
        return sizeMax;
    }

    public void setSizeMax(Integer sizeMax) {
        this.sizeMax = sizeMax;
    }

    public Integer getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Integer priceMin) {
        this.priceMin = priceMin;
    }

    public Integer getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Integer priceMax) {
        this.priceMax = priceMax;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<PizzaMapped> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaMapped> pizzas) {
        this.pizzas = pizzas;
    }

}