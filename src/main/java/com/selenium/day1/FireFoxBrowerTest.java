package com.selenium.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pc on 2017/3/25.
 */
public class FireFoxBrowerTest {

    /**
     * 打开火狐流程器浏览器
     */
    public void openBr() throws InterruptedException {
        //设置firefox的浏览器路径
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();

        //关闭当前窗口
        webDriver.close();
        Thread.sleep(5000);

        //完全退出当前浏览器
        webDriver.quit();
    }
}
