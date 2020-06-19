package thesis.whattodo.model;

public class LocationBasedReminder {

    // fields
    private Integer id;

    private Location location;

    private Double radius;

    private Boolean isEntered;

    // constructors
    public LocationBasedReminder() {
    }

    @SuppressWarnings("unused")
    public LocationBasedReminder(Integer id, Location location, Double radius, Boolean isEntered) {
        this.id = id;
        this.location = location;
        this.radius = radius;
        this.isEntered = isEntered;
    }

    // getters
    public Integer getId() {
        return this.id;
    }

    // setters
    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Boolean isEntered() {
        return this.isEntered;
    }

    public void setEntered(Boolean entered) {
        isEntered = entered;
    }

    // to string
    @Override
    public String toString() {
        return "LocationBasedReminder[id=" + id + ", location=" + location + ", radius=" + radius + ", isEntered=" + isEntered + "]";
    }
}
