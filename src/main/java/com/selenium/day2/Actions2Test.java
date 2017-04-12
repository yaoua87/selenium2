package com.selenium.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by pc on 2017/4/8.
 */
public class Actions2Test {

    private WebDriver driver = null;
    public static String url = "file:///E:/resource/%E4%BA%91%E5%B1%82%E5%A4%A9%E5%92%A8%E8%AF%A2-%E8%87%AA%E5%8A%A8%E5%8C%96%E8%AF%BE%E7%A8%8B%E8%A7%86%E9%A2%91/Selenium/day-3/selenium_html/index.html";

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\v28\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test1(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='radio']/input[1]"));
        element.click();
        Assert.assertTrue(element.isSelected(),"单选按钮已经被选中");
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get(url);
        WebElement element = driver.findElement(By.name("buttonhtml"));
        Assert.assertFalse(element.isEnabled(),"按钮不可用");
    }

    /**
     * 1、获取select元素
     * 2、根据value选中
     * 3、根据index选中
     * 4、根据显示值选中
     * @throws InterruptedException
     */
    @Test
    public void test3() throws InterruptedException {
        driver.get(url);
        WebElement element = driver.findElement(By.id("moreSelect"));
        Select select = new Select(element);
        select.selectByValue("vivo");
        Thread.sleep(3000);
        select.selectByIndex(4);
        Thread.sleep(3000);
        select.selectByVisibleText("iphone");
        Thread.sleep(3000);
    }

    /**
     * 1、获取链接元素
     * 2、点击打开新窗口
     * 3、获取新窗口的元素
     */
    @Test
    public void test4(){
        driver.get(url);
        WebElement element = driver.findElement(By.linkText("Open new window"));
        element.click();

        String currentWin = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        String otherWin = null;
        for(String win:windows){
            if(!currentWin.equals(win)){
                otherWin = win;
                break;
            }
        }
        driver.switchTo().window(otherWin);
        driver.findElement(By.linkText("baidu")).click();
    }

    /**
     * 1、打开index.html
     * 2、点击alert按钮
     * 3、在alert警告框点击确定按钮
     */
    @Test
    public void test5()  {
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='alert']/input[1]"));
        element.click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    /**
     * 1、打开index.html
     * 2、点击confirm按钮
     * 3、在confirm警告框点击确定按钮
     * 4、点击confirm按钮
     * 5、在confirm警告框点击取消按钮
     */
    @Test
    public void test6() throws InterruptedException {
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='confirm']/input"));
        element.click();
        Alert alert = driver.switchTo().alert();
        String confirmText = alert.getText();
        Thread.sleep(3000);
        alert.accept();
        alert = driver.switchTo().alert();
        String yesText = alert.getText();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);
        alert.dismiss();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        String noText = alert.getText();
        Assert.assertEquals(confirmText,"我是提示信息");
        Assert.assertEquals(yesText,"你点击的结果是-确定");
        Assert.assertEquals(noText,"你点击的结果是--取消");
    }

    /**
     * 1、打开界面
     * 2、点击wait按钮
     * 3、获取文本，并判断是否为wait for display
     */
    @Test
    public void test7(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='wait']/input"));
        element.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //全局等待，显示等待
        WebElement divElement = driver.findElement(By.xpath("//*[@id='display']/div"));
        Assert.assertEquals(divElement.getText(),"wait for display");
    }

    /**
     * 1、打开界面
     * 2、点击wait按钮
     * 3、获取文本，并判断是否为wait for display
     */
    @Test
    public void test8(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='wait']/input"));
        element.click();
        //局部等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='display']/div")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //全局等待，显示等待
        WebElement divElement = driver.findElement(By.xpath("//*[@id='display']/div"));
        Assert.assertEquals(divElement.getText(),"wait for display");
    }

    /**
     * 1、打开界面
     * 2、点击prompt按钮
     * 3、在弹窗输入内容
     * 4、点击prompt的确定/取消按钮
     * @throws InterruptedException
     */
    @Test
    public void test9() throws InterruptedException {
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//*[@id='prompt']/input"));
        element.click();
        Alert prompt = driver.switchTo().alert();
        Thread.sleep(3000);
        //TODO
        prompt.sendKeys("hello world!");
        Thread.sleep(3000);
//        prompt.accept();
//        prompt.dismiss();
    }

    /**
     * 1、打开界面
     * 2、将控制权移交到指定iframe
     * 3、获取iframe中的元素并赋值/点击
     * 4、控制权恢复默认窗口
     * @throws InterruptedException
     */
    @Test
    public void test10() throws InterruptedException {
        driver.get(url);
        WebElement element = driver.findElement(By.name("aa"));
        driver.switchTo().frame(element);
//        driver.switchTo().frame(0);
//        driver.switchTo().frame("aa");
        driver.findElement(By.id("user")).sendKeys("this is iframe input");
        Thread.sleep(3000);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='checkbox']/input[2]")).click();
        driver.findElement(By.xpath("//*[@id='checkbox']/input[3]")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void quitChrome(){

        driver.quit();
    }


}
