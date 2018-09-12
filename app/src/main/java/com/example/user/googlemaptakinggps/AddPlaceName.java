package com.example.user.googlemaptakinggps;

public class AddPlaceName {

    private int id;
    private String placeName;
    private double latitudeNo;
    private double longitudeNo;

    public AddPlaceName(int id, String placeName, double latitudeNo, double longitudeNo) {
        this.id = id;
        this.placeName = placeName;
        this.latitudeNo = latitudeNo;
        this.longitudeNo = longitudeNo;
    }

    public AddPlaceName(String placeName, double latitudeNo, double longitudeNo) {
        this.placeName = placeName;
        this.latitudeNo = latitudeNo;
        this.longitudeNo = longitudeNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public double getLatitudeNo() {
        return latitudeNo;
    }

    public void setLatitudeNo(double latitudeNo) {
        this.latitudeNo = latitudeNo;
    }

    public double getLongitudeNo() {
        return longitudeNo;
    }

    public void setLongitudeNo(double longitudeNo) {
        this.longitudeNo = longitudeNo;
    }
}
