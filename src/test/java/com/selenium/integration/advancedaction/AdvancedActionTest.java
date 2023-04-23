package com.selenium.integration.advancedaction;

import com.selenium.integration.pageobjectpattern.FunctionPage;
import com.selenium.integration.testframework.ScreenShotUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AdvancedActionTest {
    WebDriver driver;
    FunctionPage functionPage;
    @BeforeClass
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/");
        functionPage=new FunctionPage(driver);
    }
    @Test(priority = 1)
    public void dragDropTest(){
        driver.findElement(By.linkText("Droppable")).click();
        WebElement iframe= driver.findElement(By.tagName("iframe"));
        functionPage.waitUntilElementPresent(iframe,30);
        //move web driver to the iframe
        driver.switchTo().frame(iframe);
        WebElement draggable= driver.findElement(By.id("draggable"));
        functionPage.waitUntilElementPresent(draggable,30);
        WebElement droppable= driver.findElement(By.id("droppable"));
        functionPage.waitUntilElementPresent(droppable,30);
        //define action: drag and drop
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(draggable,20,0);
        actions.dragAndDrop(draggable,droppable).build().perform();
        //assertion
        Assert.assertTrue(droppable.getText().contains("Dropped"));
    }
    @Test(priority = 2)
    public void menuTest(){
        driver.get("https://jqueryui.com/menu/");
        WebElement iframe= driver.findElement(By.cssSelector(".demo-frame"));
        functionPage.waitUntilElementPresent(iframe,30);
        driver.switchTo().frame(iframe);
        WebElement music=driver.findElement(By.id("ui-id-9"));
        functionPage.waitUntilElementPresent(music,30);
        Actions actions=new Actions(driver);
        actions.moveToElement(music).build().perform();
        functionPage.sleep(2);
        WebElement rock= driver.findElement(By.id("ui-id-10"));
        functionPage.waitUntilElementPresent(rock,30);
        actions.moveToElement(rock).build().perform();
        functionPage.sleep(2);
        WebElement classic= driver.findElement(By.id("ui-id-12"));
        functionPage.waitUntilElementPresent(classic,30);
        Assert.assertTrue(classic.isDisplayed());
    }
    @Test(description = "Multiple window verification", priority = 3)
    public void multipleWindowTest(){
        driver.get("https://www.google.com/");
        WebElement newWindow= driver.findElement(By.linkText("Gmail"));
        functionPage.waitUntilElementPresent(newWindow,30);
        String mainWindowName= driver.getWindowHandle();
        System.out.println("Main window name: "+mainWindowName);
        newWindow.click();
        for (String eachWindow: driver.getWindowHandles()){
            System.out.println("Window name: "+eachWindow);
            if (!eachWindow.equalsIgnoreCase(mainWindowName)){
                driver.switchTo().window(eachWindow);
                WebElement gmail= driver.findElement(By.partialLinkText("Gmail"));
                functionPage.waitUntilElementPresent(gmail,30);
                Assert.assertTrue(gmail.isDisplayed());
            }
        }
    }
    @Test(description = "multiple window amazon", priority = 4)
    public void multipleWindowAmazonTest(){
        driver.get("https://www.amazon.com/ref=nav_logo");
        String mainWindowName= driver.getWindowHandle();
        System.out.println("Main window name: "+mainWindowName);
        driver.findElement(By.id("nav-logo-sprites")).click();
        WebElement newWindow= driver.findElement(By.xpath("//div/a[contains(text(),\"Today's Deals\")]"));
        functionPage.waitUntilElementPresent(newWindow,30);
        newWindow.click();
        for (String eachWindow: driver.getWindowHandles()) {
            System.out.println("Window name: " + eachWindow);
            if (!eachWindow.equalsIgnoreCase(mainWindowName)) {
                driver.switchTo().window(eachWindow);
                WebElement computerAccessories = driver.findElement(By.linkText("Computers & Accessories"));
                functionPage.waitUntilElementPresent(computerAccessories, 30);
                Assert.assertTrue(computerAccessories.isDisplayed());
            }
        }
    }
    @Test(description = "Multiple Elements Test")
    public void selectableElementsTest(){
        driver.get("https://jqueryui.com/selectable/");
        WebElement iframe= driver.findElement(By.cssSelector(".demo-frame"));
        functionPage.waitUntilElementPresent(iframe,30);
        driver.switchTo().frame(iframe);
        //find all selectable elements
        List<WebElement> selectableItems=driver.findElements(By.xpath("//ol[@id=\"selectable\"]/li"));
        int totalItems=selectableItems.size();
        System.out.println("Total items: "+totalItems);
        int clickCount=0;
        for (WebElement eachItem:selectableItems){
            functionPage.waitUntilElementPresent(eachItem,30);
            System.out.println(eachItem.getText());
            eachItem.click();
            clickCount++;
        }
        Assert.assertTrue(totalItems==clickCount);
    }
    @Test(description = "Multiple Link Test")
    public void multipleLinkTest(){
        driver.get("https://jqueryui.com/");
        List<WebElement> allLinks=driver.findElements(By.xpath("//div[@id=\"sidebar\"]//a"));
        int totalLinks=allLinks.size();
        System.out.println("Total links: "+totalLinks);
        List<String> urls=new ArrayList<>();
        for (WebElement link:allLinks){
            String url=link.getAttribute("href");
            urls.add(url);
        }
        for (String url:urls){
            driver.navigate().to(url);
            //functionPage.sleep(2);
            if (url.contains("draggable")){
                System.out.println(url);
                ScreenShotUtility screenShot=new ScreenShotUtility();
                String fileName=url.replace("/","");
                fileName=fileName.replace("http:jqueryui.com","");
                System.out.println(fileName);
                screenShot.takeScreenShot(fileName,driver);
            }
        }
        Assert.assertTrue(urls.size()>1);
    }
    @Test
    public void resizableTest(){
        driver.get("https://jqueryui.com/resizable/");
        WebElement iframe= driver.findElement(By.cssSelector(".demo-frame"));
        functionPage.waitUntilElementPresent(iframe,30);
        driver.switchTo().frame(iframe);
        WebElement resizable= driver.findElement(By.id("resizable"));
        functionPage.waitUntilElementPresent(resizable,30);
        Dimension originalSize=resizable.getSize();
        System.out.println(originalSize);
        WebElement resize= driver.findElement(By.cssSelector(".ui-resizable-se"));
        functionPage.waitUntilElementPresent(resize,30);
        WebElement resized= driver.findElement(By.cssSelector(".ui-resizable-se"));
        functionPage.waitUntilElementPresent(resized,30);
        Actions actions=new Actions(driver);
        functionPage.sleep(2);
        //actions.clickAndHold(resize).moveByOffset(100,100).release().perform();
        actions.clickAndHold(resize).moveToElement(resized,50,50).release().build().perform();
        WebElement afterResize= driver.findElement(By.id("resizable"));
        Dimension afterSize=afterResize.getSize();
        System.out.println(afterSize);
        Assert.assertNotEquals(originalSize,afterResize);
    }

    @Test
    public void sliderTest(){
        driver.get("https://jqueryui.com/slider/");
        WebElement iframe= driver.findElement(By.cssSelector(".demo-frame"));
        functionPage.waitUntilElementPresent(iframe,30);
        driver.switchTo().frame(iframe);
        WebElement slider= driver.findElement(By.cssSelector(".ui-slider-handle"));
        functionPage.waitUntilElementPresent(slider,30);
        Point originalPoint=slider.getLocation();
        System.out.println(originalPoint);
        Actions actions=new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(100,0).release().perform();
        WebElement afterSlider= driver.findElement(By.cssSelector(".ui-slider-handle"));
        Point afterSliderPoint=afterSlider.getLocation();
        System.out.println(afterSliderPoint);
        Assert.assertNotEquals(originalPoint,afterSliderPoint);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
