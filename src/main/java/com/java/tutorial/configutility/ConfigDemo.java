package com.java.tutorial.configutility;

public class ConfigDemo {
    public static void main(String[] args) {
        String configFile="config.properties";
        ApplicationConfig.readConfigProperties(configFile,"username");
        ApplicationConfig.readConfigProperties(configFile,"password");
        ApplicationConfig.readConfigProperties(configFile,"prodUrl");
        ApplicationConfig.readConfigProperties(configFile,"qaUrl");
        ApplicationConfig.readConfigProperties(configFile,"timeout");
    }
}
