package com.java.tutorial.uiautomation;

public class ProductObject {
    private String productName;
    private String brand;
    private String condition;
    private String productCode;
    private String pWeight;
    private String pHeight;
    private String pWidth;
    private String pDepth;
    private String stockLevel;
    private String stockLevelWarning;
    private String productPrice;
    private String productTax;

    public ProductObject() {
    }

    public ProductObject(String productName, String brand, String condition, String productCode, String pWeight,
                         String pHeight, String pWidth, String pDepth, String stockLevel, String stockLevelWarning,
                         String productPrice, String productTax) {
        this.productName = productName;
        this.brand = brand;
        this.condition = condition;
        this.productCode = productCode;
        this.pWeight = pWeight;
        this.pHeight = pHeight;
        this.pWidth = pWidth;
        this.pDepth = pDepth;
        this.stockLevel = stockLevel;
        this.stockLevelWarning = stockLevelWarning;
        this.productPrice = productPrice;
        this.productTax = productTax;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTax() {
        return productTax;
    }

    public void setProductTax(String productTax) {
        this.productTax = productTax;
    }

    public String getpWidth() {
        return pWidth;
    }

    public void setpWidth(String pWidth) {
        this.pWidth = pWidth;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getpWeight() {
        return pWeight;
    }

    public void setpWeight(String pWeight) {
        this.pWeight = pWeight;
    }

    public String getpHeight() {
        return pHeight;
    }

    public void setpHeight(String pHeight) {
        this.pHeight = pHeight;
    }

    public String getpDepth() {
        return pDepth;
    }

    public void setpDepth(String pDepth) {
        this.pDepth = pDepth;
    }

    public String getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(String stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getStockLevelWarning() {
        return stockLevelWarning;
    }

    public void setStockLevelWarning(String stockLevelWarning) {
        this.stockLevelWarning = stockLevelWarning;
    }
}
