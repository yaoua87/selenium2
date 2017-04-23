package com.selenium.po.page;

import org.openqa.selenium.By;

/**
 * Created by pc on 2017/4/22.
 */
public class LoginPage {

    //定义 邮箱输入框的定位方式
    public static By emailInput = By.name("email");

    //定义 密码输入框的定位方式
    public static By pwdIput = By.name("passwork");

    //定义 登陆按钮的定位方式
    public static By loginBtn = By.id("dologin");

    //定义 注册按钮的定位方式
    public static By registerBtn = By.id("changepage");
}
