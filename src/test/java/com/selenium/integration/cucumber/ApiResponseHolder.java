package com.selenium.integration.cucumber;

public class ApiResponseHolder {
    private static int customerResponseCode;
    private static int totalCustomers;
    private static int productResponseCode;
    private static int addCustomerResponseCode;
    private static int newCustomerId;
    private static int totalProducts;

    public static int getTotalProducts() {
        return totalProducts;
    }

    public static void setTotalProducts(int totalProducts) {
        ApiResponseHolder.totalProducts = totalProducts;
    }

    public static int getCustomerResponseCode() {
        return customerResponseCode;
    }

    public static void setCustomerResponseCode(int customerResponseCode) {
        ApiResponseHolder.customerResponseCode = customerResponseCode;
    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }

    public static void setTotalCustomers(int totalCustomers) {
        ApiResponseHolder.totalCustomers = totalCustomers;
    }

    public static int getProductResponseCode() {
        return productResponseCode;
    }

    public static void setProductResponseCode(int productResponseCode) {
        ApiResponseHolder.productResponseCode = productResponseCode;
    }

    public static int getAddCustomerResponseCode() {
        return addCustomerResponseCode;
    }

    public static void setAddCustomerResponseCode(int addCustomerResponseCode) {
        ApiResponseHolder.addCustomerResponseCode = addCustomerResponseCode;
    }

    public static int getNewCustomerId() {
        return newCustomerId;
    }

    public static void setNewCustomerId(int newCustomerId) {
        ApiResponseHolder.newCustomerId = newCustomerId;
    }
}
