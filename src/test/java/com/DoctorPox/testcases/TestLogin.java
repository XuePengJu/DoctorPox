package com.DoctorPox.testcases;

import com.DoctorPox.base.Assetion;
import com.DoctorPox.base.BaseTest;
import com.DoctorPox.data.Constants;
import com.DoctorPox.pages.LoginPage;

import org.testng.annotations.Test;

public class TestLogin extends BaseTest {


    @Test
    public void login_success() throws InterruptedException {
        //执行登录操作
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constants.CORRECT_PHONE, Constants.CORRECT_CAPTCHA);
        Thread.sleep(3000);
        //断言-根据页面的变化来做断言
        String expectedValue = ".ui.main.view.MainActivity";
        String actualValue = driver.currentActivity();
        Assetion.myAssertEquals(actualValue, expectedValue);

    }

}
