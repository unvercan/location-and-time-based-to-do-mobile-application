package thesis.whattodo.model;

public class Location {

    // fields
    private Double latitude;

    private Double longitude;

    // constructors
    public Location() {
    }

    @SuppressWarnings("unused")
    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // getters
    public Double getLatitude() {
        return latitude;
    }

    // setters
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    // to string
    @Override
    public String toString() {
        return "Location[latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
