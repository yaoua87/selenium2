package com.selenium.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by pc on 2017/4/15.
 */
public class MailDemoTest {

    /**
     * 1、完成163邮箱的注册
     * 2、完成正确的账号登陆
     * 3、完成错误的账号登陆
     * 4、完成附带附件的发送邮件
     */

    private WebDriver driver = null;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\v28\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 1、打开163邮箱首页
     * 2、点击注册按钮
     */
    @Test
    public void registerFailTest() throws InterruptedException {
        driver.get("http://mail.163.com/");
        Thread.sleep(9000);
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.id("changepage")).click();
        String handle = driver.getWindowHandle();

        Thread.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        for(String h: handles){
            if(!h.equals(handle)){
                driver.switchTo().window(h);
                break;
            }
        }
        long randrom = System.currentTimeMillis();
        driver.findElement(By.id("nameIpt")).sendKeys("register"+randrom);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("registerMail123");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("registerMail123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys("18998009890");
        driver.findElement(By.id("vcodeIpt")).sendKeys("1234");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("1234");
        driver.findElement(By.id("mainRegA")).click();

//        waitElement(By.xpath(".//*[@id='m_mainAcode']/span/b"));
        Thread.sleep(9000);
        String result = driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span/b")).getText();
        Assert.assertEquals(result,"  手机验证码不正确，请重新填写");



    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("file:///E:/resource/%E4%BA%91%E5%B1%82%E5%A4%A9%E5%92%A8%E8%AF%A2-%E8%87%AA%E5%8A%A8%E5%8C%96%E8%AF%BE%E7%A8%8B%E8%A7%86%E9%A2%91/Selenium/day-3/selenium_html/index.html");

        WebElement element = driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span/b"));
        System.out.printf("======" + element.getText());
    }

    @Test
    public void loginSuccessTest() throws InterruptedException {

        driver.get("http://mail.163.com/");
        Thread.sleep(3000);
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("lc1017lc");
        driver.findElement(By.name("password")).sendKeys("Wangyi#520");
        driver.findElement(By.id("dologin")).click();

        Thread.sleep(9000);

        String result = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(result,"退出");
    }

    /**
     * 1、打开163邮箱登陆界面
     * 2、控制权切换到iframe，输入错误的邮箱，密码点击登陆按钮
     * 3、断言结果
     * @throws InterruptedException
     */
    @Test
    public void loginFailTest() throws InterruptedException {

        driver.get("http://mail.163.com/");
        Thread.sleep(3000);
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("lc1017lc");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.id("dologin")).click();

//        Thread.sleep(3000);
        waitElement(By.xpath("//*[id='nerror']/div[2]"));
        String result = driver.findElement(By.xpath("//*[id='nerror']/div[2]")).getText();
        Assert.assertEquals(result,"账号或密码错误");

    }

    @Test
    public void sendEmailTest() throws InterruptedException {

        //
        driver.get("http://mail.163.com/");
        Thread.sleep(8000);
        loginEmail(driver,"lc1017lc","Wangyi#520");
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        Thread.sleep(8000);
        //wait
        driver.findElement(By.xpath("//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']")).sendKeys("315055890@qq.com;");
        driver.findElement(By.xpath("//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("sendMailTest");
//        driver.findElement(By.xpath("//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("");
        driver.findElement(By.xpath("//*[text()='发送']")).click();

        String result ;
        Assert.assertTrue(true);
        //aria-label="收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开"
        //aria-label="邮件主题输入框，请输入邮件主题">/input
        //title="一次可发送2000张照片，600首MP3，一部高清电影"/input
        // <iframe class="APP-editor-iframe" tabindex="1" style="position:absolute" frameborder="0">/class nui-scroll
        ////*[text()='发送']
    }

    @AfterTest
    public void quitChrome(){
//        driver.quit();
    }

    /**
     * 登陆邮箱
     * @param driver
     * @param email
     * @param pwd
     */
    private void loginEmail(WebDriver driver,String email,String pwd){

        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }

    private void waitElement(By by){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

    }
}
