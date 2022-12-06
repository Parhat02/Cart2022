package com.java.tutorial.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

public class CubeCartProduct {
    static WebDriver driver;
    public static void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");
    }
    public static void login(){
        driver.findElement(By.id("username")).sendKeys("testautomation1");
        driver.findElement(By.id("password")).sendKeys("automation123!");
        driver.findElement(By.id("login")).click();
        WebElement dashBoard= driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
        if(dashBoard.isDisplayed()){
            System.out.println("Login successfully");
        }else{
            System.out.println("Login failed");
        }
    }
    public static void addProduct(ProductObject product){
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.linkText("Add Product")).click();
        driver.findElement(By.id("name")).sendKeys(product.getProductName());
        WebElement brand= driver.findElement(By.id("manufacturer"));
        Select select=new Select(brand);
        select.selectByVisibleText(product.getBrand());
        WebElement condition= driver.findElement(By.id("condition"));
        Select select1=new Select(condition);
        select1.selectByVisibleText(product.getCondition());
        driver.findElement(By.id("product_code")).sendKeys(product.getProductCode());
        driver.findElement(By.id("product_weight")).sendKeys(product.getpWeight());
        driver.findElement(By.id("product_width")).sendKeys(product.getpWidth());
        driver.findElement(By.id("product_height")).sendKeys(product.getpHeight());
        driver.findElement(By.id("product_depth")).sendKeys(product.getpDepth());
        driver.findElement(By.id("stock_level")).sendKeys(product.getStockLevel());
        driver.findElement(By.id("stock_warning")).sendKeys(product.getStockLevelWarning());
        driver.findElement(By.linkText("Pricing")).click();
        driver.findElement(By.id("price")).sendKeys(product.getProductPrice());
        WebElement tax=driver.findElement(By.id("tax_type"));
        Select select2=new Select(tax);
        select2.selectByVisibleText(product.getProductTax());
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        WebElement successMessage= driver.findElement(By.cssSelector("div[class='success']"));
        if (successMessage.isDisplayed()){
            System.out.println("Product added successfully");
        }else
            System.out.println("Product adding failed");
    }
//    public static void addBulkPrice(){
//        driver.findElement(By.linkText("Bulk Price Change")).click();
//    }

    public static void addReview(ProductObject product) throws InterruptedException {
        driver.findElement(By.linkText("Reviews")).click();
        driver.findElement(By.linkText("Add review")).click();
        driver.findElement(By.id("ajax_name")).sendKeys(product.getProductName());
        Thread.sleep(1000);
        driver.findElement(By.name("1")).click();
        driver.findElement(By.xpath("//*[@id=\"review\"]/fieldset/div[2]/span/img")).click();
        driver.findElement(By.id("review_name")).sendKeys(product.getProductName());
        driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();
        WebElement successMessage= driver.findElement(By.cssSelector("div[class='success']"));
        if (successMessage.isDisplayed()){
            System.out.println("Review added successfully");
        }else
            System.out.println("Review adding failed");
    }
    public static void reviewUpdate(ProductObject product)throws InterruptedException{
        driver.findElement(By.linkText("Reviews")).click();
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.id("search-products")).sendKeys(product.getProductName());
        Thread.sleep(1000);
        driver.findElement(By.name("1")).click();
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        driver.findElement(By.xpath("//i[@title='Edit']")).click();
        driver.findElement(By.id("review_email")).sendKeys("Abdullah1234@gmail.com");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        WebElement successMessage= driver.findElement(By.cssSelector("div[class='success']"));
        if (successMessage.isDisplayed()){
            System.out.println("Review Updated successfully");
        }else
            System.out.println("Review Updating failed");
    }
    public static void deleteProduct(ProductObject product) throws InterruptedException{
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.linkText("Search Products")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("product")).sendKeys(product.getProductName());
        driver.findElement(By.xpath("//*[@id=\"sidebar_content\"]/div[2]/form/input[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@title='Delete']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        WebElement successMessage= driver.findElement(By.cssSelector("div[class='success']"));
        if (successMessage.isDisplayed()){
            System.out.println("Product deleted successfully");
        }else
            System.out.println("Product deleting failed");
    }
}
