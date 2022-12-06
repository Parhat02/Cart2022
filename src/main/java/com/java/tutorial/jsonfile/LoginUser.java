package com.java.tutorial.jsonfile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUser {
    @JsonProperty("users")
    private List<User> users;
    @JsonProperty("application")
    private String applicationName;

    public LoginUser() {
    }

    public LoginUser(List<User> users) {
        this.users = users;
    }

    public LoginUser(List<User> users, String applicationName) {
        this.users = users;
        this.applicationName = applicationName;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getApplicationName() {
        return applicationName;
    }
}
