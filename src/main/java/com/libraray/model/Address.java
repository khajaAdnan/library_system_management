package com.libraray.model;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String addressLine1;
    private String addAddressLine2;
    private String city;
    private String pinCode;
    private String state;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddAddressLine2() {
        return addAddressLine2;
    }

    public void setAddAddressLine2(String addAddressLine2) {
        this.addAddressLine2 = addAddressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", addAddressLine2='" + addAddressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
