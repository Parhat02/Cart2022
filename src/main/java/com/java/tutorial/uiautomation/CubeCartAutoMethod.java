package com.java.tutorial.uiautomation;

import com.java.tutorial.Exercises.Customer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CubeCartAutoMethod {
    static WebDriver driver;

    public static void explicitWait(WebElement element,int second){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void implicitWait(int second){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }
    public static void fluentWait(WebElement element){
        Wait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).
                pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
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
        //implicitWait(10);
        //fluentWait(driver,dashBoard);
        //explicitWait(driver,dashBoard,10);
        if(dashBoard.isDisplayed()){
            System.out.println("Logged in successfully");
        }else{
            System.out.println("Login failed");
        }
    }
    public static void addCustomer(Customer customer){
        driver.findElement(By.linkText("Customer List")).click();
        driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.id("cust-title")).sendKeys(customer.getTitle());
        driver.findElement(By.id("cust-firstname")).sendKeys(customer.getFirstName());
        driver.findElement(By.id("cust-lastname")).sendKeys(customer.getLastName());
        WebElement type= driver.findElement(By.id("cust-type"));
        Select select=new Select(type); select.selectByVisibleText(customer.getRegister());
        driver.findElement(By.id("cust-email")).sendKeys(customer.getEmail());
        driver.findElement(By.id("cust-phone")).sendKeys(customer.getPhoneNumber());
        WebElement subscribe= driver.findElement(By.id("subscription_status"));
        Select select1=new Select(subscribe); select1.selectByVisibleText(customer.getSubscribed());
        driver.findElement(By.id("cust-password")).sendKeys(customer.getPassword());
        driver.findElement(By.id("cust-passconf")).sendKeys(customer.getConfirmPassword());
        driver.findElement(By.name("save")).click();
        WebElement successMessage=driver.findElement(By.xpath("//*[@class='success']"));
        explicitWait(successMessage,10);
        if (successMessage.isDisplayed()){
            System.out.println("Customer successfully added.");
        }else{
            System.out.println("Add customer failed");
        }
    }
    public static void deleteCustomer(Customer customer){
        driver.findElement(By.linkText("Customer List")).click();
        driver.findElement(By.linkText("Search Customers")).click();
        WebElement searchCustomer= driver.findElement(By.id("customer_id"));
        explicitWait(searchCustomer,10);
        System.out.println(customer.getLastName());
        String lastname= customer.getLastName().replaceAll("[^A-z]","");
        System.out.println(lastname);
        searchCustomer.sendKeys(lastname);
        driver.findElement(By.xpath("//*[@id=\"sidebar_content\"]/div[1]/form/input[3]")).click();//Go button
        driver.findElement(By.xpath("//*[@id=\"customer-list\"]/table/tbody/tr[1]/td[7]/a[3]/i")).click();//delete button
        driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();
        WebElement deleteMessage= driver.findElement(By.xpath("//div[contains(text(),\"Customer successfully deleted.\")]"));
        if (deleteMessage.isDisplayed()){
            System.out.println("Customer deleted successfully");
        }else{
            System.out.println("Customer delete failed");
        }
    }
    public static void updateCustomer(Customer customer){
        driver.findElement(By.linkText("Customer List")).click();
        driver.findElement(By.linkText("Search Customers")).click();
        WebElement searchCustomer= driver.findElement(By.id("customer_id"));
        explicitWait(searchCustomer,10);
        System.out.println(customer.getLastName());
        String lastname= customer.getLastName().replaceAll("[^A-z]","");
        System.out.println(lastname);
        searchCustomer.sendKeys(lastname);
        driver.findElement(By.xpath("//*[@id=\"sidebar_content\"]/div[1]/form/input[3]")).click();//Go button
        driver.findElement(By.cssSelector("i[class='fa fa-pencil-square-o']")).click();//Edit button
        WebElement email=driver.findElement(By.id("cust-email"));
        email.clear(); email.sendKeys(customer.getEmail());
        WebElement phone= driver.findElement(By.id("cust-phone"));
        phone.clear();phone.sendKeys(customer.getPhoneNumber());
        driver.findElement(By.name("save")).click();//save button
        WebElement updateMessage= driver.findElement(By.xpath("//div[contains(text(),\"Customer successfully updated.\")]"));
        if (updateMessage.isDisplayed())
            System.out.println("Customer successfully updated");
        else
            System.out.println("Customer update failed");
    }
    public static void logout(){
        driver.findElement(By.linkText("Log Out")).click();
        driver.close();
        driver.quit();
    }
}
