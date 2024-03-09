package com.example.javacw;

public class DealerDetails {
    private String dealerid;
    private String dealerName;
    private String phoneNumber;
    private String location;

    public DealerDetails(String dealerid, String dealerName, String phoneNumber, String location) {
        this.dealerid = dealerid;
        this.dealerName = dealerName;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public String getDealerid() {
        return dealerid;
    }

    public void setDealerid(String dealerid) {
        this.dealerid = dealerid;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
