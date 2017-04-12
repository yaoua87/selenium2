package com.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by pc on 2017/4/8.
 */
public class TaskTest {

    private WebDriver driver = null;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\v28\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 保存网页文件
     */
    @Test
    public void saveFile() throws AWTException, InterruptedException {
        driver.get("http://www.cnblogs.com/TankXiao/p/5246557.html");
        Robot bot = new Robot();
        bot.keyPress(KeyEvent.VK_CONTROL);
        bot.keyPress(KeyEvent.VK_S);
        int s_ch = (int)new Character('S');
        bot.keyRelease(s_ch);
        bot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        bot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        bot.keyPress(KeyEvent.VK_ENTER );
    }

    /**
     * 下载文件
     */
    @Test
    public void downLoadFile() throws AWTException, InterruptedException {

        driver.get("http://rj.baidu.com/");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("");
        WebElement element = driver.findElement(By.xpath(".//*[@id='mainContent']/div[1]/dl[1]/dd[1]/div[1]/ul[1]/li[1]/a[3]"));
//        element.click();
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.moveToElement(element).perform();
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);
//
//        Robot robot = new Robot();
//        Thread.sleep(3000);
//        robot.keyPress(KeyEvent.VK_K);
//
//        Thread.sleep(3000);

    }

    /**
     * 上传文件
     */
    @Test
    public void uploadFile(){
        driver.get("file:///E:/resource/%E4%BA%91%E5%B1%82%E5%A4%A9%E5%92%A8%E8%AF%A2-%E8%87%AA%E5%8A%A8%E5%8C%96%E8%AF%BE%E7%A8%8B%E8%A7%86%E9%A2%91/Selenium/day-3/selenium_html/demo1.html");
        WebElement element = driver.findElement(By.id("load"));
        element.sendKeys("C:\\Users\\pc\\Desktop\\start.vbs");
    }

    @AfterMethod
    public  void quitChrome(){
//        driver.quit();
    }
}
