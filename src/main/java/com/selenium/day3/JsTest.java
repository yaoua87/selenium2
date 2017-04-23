package com.selenium.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by pc on 2017/4/15.
 */
public class JsTest {

    private WebDriver driver = null;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\v28\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 直接使用js脚本操作元素并设置其value
     * @throws InterruptedException
     */
    @Test
    public void exJsTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"JavascriptExecutor\");");
        Thread.sleep(3000);
    }

    @AfterTest
    public void quitChrome(){
        driver.quit();
    }

}
