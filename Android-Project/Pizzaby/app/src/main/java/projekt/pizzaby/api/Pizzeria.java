package projekt.pizzaby.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robert on 15.02.2017.
 */

public class Pizzeria {

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

    @SerializedName("Coordinates")
    @Expose
    private Coordinates coordinates;

    @SerializedName("Latitude")
    @Expose
    private Double latitude;

    @SerializedName("Longitude")
    @Expose
    private Double longitude;

    @SerializedName("PizzeriaPizzas")
    @Expose
    private List<PizzeriaPizza> pizzeriaPizzas = null;


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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
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

    public List<PizzeriaPizza> getPizzeriaPizzas() {
        return pizzeriaPizzas;
    }

    public void setPizzeriaPizzas(List<PizzeriaPizza> pizzeriaPizzas) {
        this.pizzeriaPizzas = pizzeriaPizzas;
    }

}