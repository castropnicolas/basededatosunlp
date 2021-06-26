package ar.edu.unlp.dto;

public class LocationDTO {

    private String id;
    private Double longitude;
    private Double latitude;

    public LocationDTO() {

    }

    public LocationDTO(String id, Double latitude, Double longitude) {
        this.setId(id);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
