package com.DoctorPox.pages;

import com.DoctorPox.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    By phoneBy = By.xpath("//android.widget.RelativeLayout");
    By captchaBy = By.xpath("com.xcgl.dbs:id/et_code");
    By getCaptchaBy = By.id("com.xcgl.dbs:id/tv_getCode");
    By loginButtonBy = By.id("com.xcgl.dbs:id/tv_login");

    public void login(String phone, String captcha) {
        type(phoneBy, "登录页面_手机号码输入框", phone);
        click(getCaptchaBy, "登录页面_获取验证码按钮");
        type(captchaBy, "登录页面_验证码输入框", captcha);
        click(loginButtonBy, "登录页面_登录按钮");
    }
}
