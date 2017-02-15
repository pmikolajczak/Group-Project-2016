package projekt.pizzaby.api;

/**
 * Created by robert on 15.02.2017.
 */

public class Coordinates {

    private String altitude;
    private String course;
    private String horizontalAccuracy;
    private Boolean isUnknown;
    private Double latitude;
    private Double longitude;
    private String speed;
    private String verticalAccuracy;

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    public void setHorizontalAccuracy(String horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
    }

    public Boolean getIsUnknown() {
        return isUnknown;
    }

    public void setIsUnknown(Boolean isUnknown) {
        this.isUnknown = isUnknown;
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

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getVerticalAccuracy() {
        return verticalAccuracy;
    }

    public void setVerticalAccuracy(String verticalAccuracy) {
        this.verticalAccuracy = verticalAccuracy;
    }

}