package ar.edu.unlp.model;

public class Location {
    private String id;
    private Double latitude;
    private Double longitude;

    public Location(){
        this.setLongitude(0D);
        this.setLatitude(0D);

    }

    public Location(Double anLatitude, Double anLongitude){
        this.setLatitude(anLatitude);
        this.setLongitude(anLongitude);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
