package com.selenium.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pc on 2017/4/15.
 */
public class GridTest {

    @Test
    public void gridTest() throws MalformedURLException {
        DesiredCapabilities des;
        des = DesiredCapabilities.chrome();
        String url = "http://192.168.1.106:5555/wb/hub";
        WebDriver driver = new RemoteWebDriver(new URL(url),des);
        driver.get("http://www.baidu.com");


    }
}
