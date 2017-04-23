package com.selenium.day4;

import org.testng.annotations.DataProvider;

/**
 * Created by pc on 2017/4/22.
 */
public class DataProviderTest {

    @DataProvider(name = "infos")
    public Object[][] getData(){
        return new Object[][]{{"user","pwd"},{}};
    }

}
