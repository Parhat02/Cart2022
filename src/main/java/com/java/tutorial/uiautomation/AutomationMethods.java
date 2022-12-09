package com.java.tutorial.uiautomation;

import com.java.tutorial.classtutorial.UserLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AutomationMethods {
    WebDriver driver;
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.mahara.org/");
    }
    public void longIn(UserLogin user) throws InterruptedException {
        WebElement userName= driver.findElement(By.id("login_login_username"));
        userName.sendKeys(user.getUserName());
        driver.findElement(By.id("login_login_password")).sendKeys(user.getPassWord());
        WebElement loginButton= driver.findElement(By.id("login_submit"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement search=driver.findElement(By.name("query"));
        WebElement about= driver.findElement(By.id("messages"));
        if (search.isDisplayed())
            System.out.println("Login passed");
        else
            System.out.println("Login failed");
    }

    public void createGroup(){
        DateTime time=new DateTime();
        driver.findElement(By.linkText(("My groups:"))).click();
        driver.findElement(By.cssSelector("a[class='btn btn-secondary creategroup']")).click();
        WebElement box= driver.findElement(By.id("editgroup_name"));
        box.click();
        box.sendKeys("Group"+time);
        driver.findElement(By.id("editgroup_submit")).click();
        WebElement verifySuccess= driver.findElement(By.xpath("//div[contains(text(),'Group saved successfully')]"));
        String message=verifySuccess.getText();
        System.out.println(message);
    }

    public void updateGroup() throws InterruptedException{
        driver.findElement(By.linkText(("My groups:"))).click();
        driver.findElement(By.linkText(("Group1"))).click();
        driver.findElement(By.xpath("//span[contains(text(),'Edit')]")).click();
        driver.findElement(By.xpath("//span[@class='icon icon-pencil-alt icon-lg']")).click();
        Thread.sleep(1000);
        WebElement textBox=driver.findElement(By.name("limit"));
        textBox.clear();
        textBox.sendKeys("15");
        WebElement retractable= driver.findElement(By.name("retractable"));
        Select select=new Select(retractable);
        select.selectByValue("1");
        driver.findElement(By.id("instconf_action_configureblockinstance_id_1087")).click();
    }
}
