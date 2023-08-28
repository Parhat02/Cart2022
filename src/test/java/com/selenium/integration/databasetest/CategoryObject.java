package com.selenium.integration.databasetest;

public class CategoryObject {
    private String CatName;
    private String CatDesc;
    private int CatParentId;
    private int CatImage;
    private double PerShip;
    private double itemShip;
    private double itemIntShip;
    private double perIntShip;
    private int hide;
    private String seoMetaTitle;
    private String seoMetaDescription;
    private String seoMetaKeywords;
    private int priority;
    private int status;

    public CategoryObject(String catName, String catDesc, int catParentId, int catImage, double perShip, double itemShip, double itemIntShip, double perIntShip, int hide, String seoMetaTitle, String seoMetaDescription, String seoMetaKeywords, int priority, int status) {
        CatName = catName;
        CatDesc = catDesc;
        CatParentId = catParentId;
        CatImage = catImage;
        PerShip = perShip;
        this.itemShip = itemShip;
        this.itemIntShip = itemIntShip;
        this.perIntShip = perIntShip;
        this.hide = hide;
        this.seoMetaTitle = seoMetaTitle;
        this.seoMetaDescription = seoMetaDescription;
        this.seoMetaKeywords = seoMetaKeywords;
        this.priority = priority;
        this.status = status;
    }

    public String getCatName() {
        return CatName;
    }

    public String getCatDesc() {
        return CatDesc;
    }

    public int getCatParentId() {
        return CatParentId;
    }

    public int getCatImage() {
        return CatImage;
    }

    public double getPerShip() {
        return PerShip;
    }

    public double getItemShip() {
        return itemShip;
    }

    public double getItemIntShip() {
        return itemIntShip;
    }

    public double getPerIntShip() {
        return perIntShip;
    }

    public int getHide() {
        return hide;
    }

    public String getSeoMetaTitle() {
        return seoMetaTitle;
    }

    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    public String getSeoMetaKeywords() {
        return seoMetaKeywords;
    }

    public int getPriority() {
        return priority;
    }

    public int getStatus() {
        return status;
    }
}
