package com.java.tutorial.Exercises;

public class Category {
    private String name;
    private String status;
    private boolean visible;
    private String patentCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getPatentCategory() {
        return patentCategory;
    }

    public void setPatentCategory(String patentCategory) {
        this.patentCategory = patentCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", visible=" + visible +
                ", patentCategory='" + patentCategory + '\'' +
                '}';
    }
}
