package com.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by pc on 2017/4/8.
 */
public class Actions3Test {

    private WebDriver driver = null;
    private String url = "https://www.baidu.com/";

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\v28\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * 1、打开页面
     * 2、按钮点击右键
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get(url);
        WebElement element = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        Thread.sleep(3000);
    }

    /**
     * 1、打开页面
     * 2、按钮双击
     */
    @Test
    public void test2() throws InterruptedException {
        driver.get(url);
        WebElement element = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
        Thread.sleep(3000);
    }

    /**
     * 1、打开页面
     * 2、鼠标移动到元素上
     */
    @Test
    public void test3() throws InterruptedException {
        driver.get("file:///E:/resource/%E4%BA%91%E5%B1%82%E5%A4%A9%E5%92%A8%E8%AF%A2-%E8%87%AA%E5%8A%A8%E5%8C%96%E8%AF%BE%E7%A8%8B%E8%A7%86%E9%A2%91/Selenium/day-3/selenium_html/index.html");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//*[@id='action']/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//*[@id='over']/div")).getText();
        Assert.assertEquals(text,"Hello World!");
    }

    /**
     * 1、打开页面
     * 2、拖拽元素到指定坐标
     */
    @Test
    public void test4() throws InterruptedException {
        driver.get("file:///E:/resource/%E4%BA%91%E5%B1%82%E5%A4%A9%E5%92%A8%E8%AF%A2-%E8%87%AA%E5%8A%A8%E5%8C%96%E8%AF%BE%E7%A8%8B%E8%A7%86%E9%A2%91/Selenium/day-3/selenium_html/dragAndDrop.html");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(3000);
    }

    /**
     * 1、打开页面
     * 2、拖拽元素到指定元素
     */
    @Test
    public void test5() throws InterruptedException {
        driver.get("file:///E:/resource/%E4%BA%91%E5%B1%82%E5%A4%A9%E5%92%A8%E8%AF%A2-%E8%87%AA%E5%8A%A8%E5%8C%96%E8%AF%BE%E7%A8%8B%E8%A7%86%E9%A2%91/Selenium/day-3/selenium_html/dragAndDrop.html");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("drag"));
        WebElement otherElement = driver.findElement(By.xpath("//html/body/h1"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).moveToElement(otherElement).release(otherElement).perform();
        Thread.sleep(3000);
    }

    /**
     * 1、打开页面
     * 2、下拉框多选
     */
    @Test
    public void test6() throws InterruptedException {
        driver.get("file:///E:/resource/%E4%BA%91%E5%B1%82%E5%A4%A9%E5%92%A8%E8%AF%A2-%E8%87%AA%E5%8A%A8%E5%8C%96%E8%AF%BE%E7%A8%8B%E8%A7%86%E9%A2%91/Selenium/day-3/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> elments = element.findElements(By.tagName("option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(elments.get(0)).click(elments.get(2)).perform();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void quitChrome(){
       driver.quit();
    }

}
