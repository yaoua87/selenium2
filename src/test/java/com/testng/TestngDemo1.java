package com.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by pc on 2017/3/25.
 */
public class TestngDemo1 {

    @Test
    public void test1(){

        System.out.println("this is test1");
    }

    @Test
    public void test2(){

        System.out.println("this is test2");
    }

    @BeforeTest
    public void beforeTest1(){

        System.out.println("this is beforeTest1");
    }

    @BeforeMethod
    public void beforeMethod1(){
        System.out.println("this is beforeMethod1");
    }

    @AfterTest
    public void afterMethod1(){

        System.out.println("this is afterMehtod1");
    }


    @AfterTest
    public void afterTest1(){
        System.out.println("this is afterTest1");
    }
}
