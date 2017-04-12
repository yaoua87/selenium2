package com.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by pc on 2017/3/25.
 */
public class WebDriverDemo {

    private WebDriver driver ;
    @BeforeTest
    public void openBrower(){

        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();//最大化浏览器
        driver.get("http://www.baidu.com");
    }

    @Test
    public void testCase1() throws InterruptedException {

        if(driver == null){
            return;
        }
//        Thread.sleep(3000);
        //获取浏览器url
        String url = driver.getCurrentUrl();
//        Assert.assertEquals(url,"https://www.baidu.com/");
        String title = driver.getTitle();
        Assert.assertNotNull(title);
    }

    @Test
    public void testCase2(){

        if(driver == null){
            return;
        }
        //根据id获取元素
        WebElement element = driver.findElement(By.id("kw"));
        if(element != null){
            //获取元素的class属性
            String classAttr = element.getAttribute("class");
            Assert.assertEquals(classAttr,"s_ipt");
        }
    }

    @Test
    public void testCase3(){

        if(driver == null){
            return;
        }
        //根据name获取元素
        List<WebElement> elementList = driver.findElements(By.name("tj_briicon"));
        for (WebElement e:elementList){
            if(e != null){
                System.out.println(e.getText());
            }
        }
    }

    @Test
    public  void testCase5(){

        //根据link内容获取元素
        WebElement linkElement = driver.findElement(By.linkText("糯米"));
        //获取元素的class属性
        if(linkElement != null){

            String tagName = linkElement.getTagName();
            Assert.assertEquals(tagName,"a");
            //根据link部分内容获取元素
            linkElement = driver.findElement(By.partialLinkText("糯"));
            tagName = linkElement.getTagName();
            Assert.assertEquals(tagName,"a");
        }
    }

    @Test
    public  void testCase6(){
        //根据xpath获取元素
        WebElement linkElement = driver.findElement(By.xpath("//span[@id='s_btn_wr']"));
    }

    @Test
    public  void testCase7(){
        //根据css获取元素
        WebElement element = driver.findElement(By.className("s_ipt"));
    }

    @Test
    public  void testCase8(){
        //根据tag名字获取元素
        WebElement element = driver.findElement(By.tagName("a"));
    }

    @AfterTest
    public void quitBrower(){
        if(driver != null){
            driver.quit();
        }
    }
}
