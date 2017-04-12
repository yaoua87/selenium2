package com.selenium.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by pc on 2017/4/8.
 */
public class ActionsTest {

    private WebDriver driver = null;
    public static String url = "";

    @BeforeMethod
    public void openChrome(){

        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\v28\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void test1(){
        String url = "https://www.baidu.com/";
        driver.get(url);
        WebElement element = driver.findElement(By.linkText("新闻"));
        element.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"http://news.baidu.com/");
    }

    @Test
    public void test2() throws InterruptedException {
        String url = "https://www.baidu.com/";
        driver.get(url);
        WebElement kwInput = driver.findElement(By.id("kw"));
        kwInput.sendKeys("selenium");
        WebElement suButton = driver.findElement(By.id("su"));
        suButton.click();
        Thread.sleep(1000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    @Test
    public void test3() throws InterruptedException {
        String url = "https://www.baidu.com/";
        driver.get(url);
        WebElement element = driver.findElement(By.linkText("新闻"));
        String text1 = element.getText();
        Assert.assertEquals(text1,"新闻");
    }

    @Test
    public void test4(){
        String url = "https://www.baidu.com/";
        driver.get(url);
        WebElement element = driver.findElement(By.id("kw"));
        String tagName = element.getTagName();
        Assert.assertEquals(tagName,"input");
    }

    @Test
    public void test5(){
        String url = "https://www.baidu.com/";
        driver.get(url);
//        WebElement element = driver.findElement(By.id("kw"));
//        element.sendKeys("selenium");
//        String attr = element.getAttribute("value");
//        Assert.assertEquals(attr,"selenium");

        WebElement element = driver.findElement(By.id("su"));
        String attr = element.getAttribute("value");
        Assert.assertEquals(attr,"百度一下");
    }

    @Test
    public void test6(){
        String url = "https://www.baidu.com/";
        driver.get(url);
        WebElement element = driver.findElement(By.id("su"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void test7(){
        String url = "https://www.baidu.com/";
        driver.get(url);
        WebElement element = driver.findElement(By.id("su"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void test8(){
        String url = "https://www.baidu.com/";
        //TODO
        driver.get(url);
        WebElement element = driver.findElement(By.id("su"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void test9(){
        String url = "https://www.baidu.com/";
        //TODO
        driver.get(url);
        WebElement element = driver.findElement(By.id("su"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void shotTest(){

        String url = "https://www.baidu.com/";
        driver.get(url);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("F:/IdeaProjectsWork/selenium2/img/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @AfterMethod
    public void quitChrome(){

        driver.quit();
    }


}
