package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pc on 2017/4/22.
 */
public class LoginTest {

    @Test
    public void loginSucces(){
        System.out.printf("==================second start========================");
    }

    @Test
    public void loginError(){
        System.out.printf("this is error====================");
        Assert.assertTrue(false);

    }
}
