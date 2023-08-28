package com.selenium.integration.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPayload {

    @JsonProperty("email")
    private String email;
    @JsonProperty("title")
    private String title;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("country")
    private String country;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("status")
    private int status;
    @JsonProperty("language")
    private String language;
    @JsonProperty("ipAddress")
    private String ipAddress;
    @JsonProperty("registered")
    private int registered;

    public CustomerPayload() {
    }

    public CustomerPayload(String email, String title, String firstName, String lastName, String country, String phone, int status, String language, String ipAddress, int registered) {
        this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.phone = phone;
        this.status = status;
        this.language = language;
        this.ipAddress = ipAddress;
        this.registered = registered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }
}
