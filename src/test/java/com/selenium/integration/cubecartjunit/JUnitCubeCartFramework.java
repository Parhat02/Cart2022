package com.selenium.integration.cubecartjunit;

import com.google.errorprone.annotations.InlineMeValidationDisabled;
import com.java.tutorial.configutility.ApplicationConfig;
import com.java.tutorial.uiautomation.ProductInfo;
import com.java.tutorial.uiautomation.ProductObject;
import com.selenium.integration.cubecartjunit.FunctionLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JUnitCubeCartFramework {
    static WebDriver driver;
    final static String configFile="config.properties";
    final static String qaUrl=ApplicationConfig.readConfigProperties(configFile,"qaUrl");
    static FunctionLibrary functionLibrary;
    static ProductInfo productInfo=new ProductInfo();
    static ProductObject product=productInfo.product1;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        //open the testing site
        driver.get(qaUrl);
        //login
        String userName= ApplicationConfig.readConfigProperties(configFile,"username");
        String password= ApplicationConfig.readConfigProperties(configFile,"password");
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        WebElement dashBoard= driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
        functionLibrary=new FunctionLibrary(driver);
        functionLibrary.waitUntilElementVisible(dashBoard);
        if(dashBoard.isDisplayed()){
            System.out.println("Login successfully");
        }else{
            System.out.println("Login failed");
        }
    }
    @Test
    public void viewCustomerTest(){
        driver.findElement(By.linkText("Customer List")).click();
        WebElement customerTable= driver.findElement(By.xpath("//div[@id='customer-list']/table"));
        functionLibrary.waitUntilElementVisible(customerTable);
        List<WebElement> customerRecords=driver.findElements(By.xpath("//div[@id='customer-list']/table/tbody/tr"));
        functionLibrary.waitUntilElementVisible(customerTable);
        System.out.println(customerRecords.size());
        Assert.assertTrue(customerRecords.size()>10);
    }
    @Test
    public void addProductTest(){
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
        functionLibrary.waitUntilElementVisible(successMessage);
        if (successMessage.isDisplayed()){
            System.out.println("Product added successfully");
        }else
            System.out.println("Product adding failed");
        Assert.assertTrue(successMessage.isDisplayed());
    }
    @Test
    public void addProductCategoryTest(){
        WebElement categoriesLink= driver.findElement(By.id("nav_categories"));
        functionLibrary.waitUntilElementVisible(categoriesLink);
        categoriesLink.click();
        WebElement addCategory= driver.findElement(By.linkText("Add Category"));
        functionLibrary.waitUntilElementVisible(addCategory);
        addCategory.click();
        WebElement categoryName= driver.findElement(By.name("cat[cat_name]"));
        functionLibrary.waitUntilElementVisible(categoryName);
        categoryName.sendKeys("UnitedCoderCategory"+System.currentTimeMillis());
        driver.findElement(By.id("cat_save")).click();
        WebElement successMessage= driver.findElement(By.cssSelector("div.success"));
        functionLibrary.waitUntilElementVisible(successMessage);
        Assert.assertTrue(successMessage.isDisplayed());
    }
    @AfterClass
    public static void tearDown(){
        driver.findElement(By.linkText("Log Out")).click();
        driver.close();
        driver.quit();
    }
}