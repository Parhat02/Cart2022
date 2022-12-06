package com.java.tutorial.uiautomation;

public class CubeCartDemo2 extends CubeCartProduct{
    public static void main(String[] args) throws InterruptedException{
        openBrowser();
        login();
        ProductInfo product=new ProductInfo();
//        for (ProductObject productObject:product.products){
//            addProduct(productObject);
//        }
        addProduct(product.product1);
        addReview(product.product1);
        reviewUpdate(product.product1);
        deleteProduct(product.product1);
    }
}
