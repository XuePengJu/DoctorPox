package com.DoctorPox.testcases;

import com.DoctorPox.base.BasePage;
import com.DoctorPox.base.BaseTest;
import com.DoctorPox.data.Constants;
import com.DoctorPox.pages.IndexPage;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class reserve extends BaseTest {
    Logger logger = Logger.getLogger(reserve.class);

    @BeforeMethod
    public void setup() {
        System.out.println("进入测试CASE");
    }

    @Test
    public void reserve_test() throws InterruptedException {
//        Thread.sleep(3000);
        IndexPage indexPage = new IndexPage();
//        点击预约管理
//        indexPage.clickSubscriben();

//        窗帘高度160，窗台宽度170

    }
//    @AfterMethod
//    public void teardown(){
//        closeApp();
//        //返回到首页
//      /*  KeyEvent keyEvent = new KeyEvent();
//        keyEvent.withKey(AndroidKey.BACK);
//        driver.pressKey(keyEvent);*/
//        //通过执行启动入口-->首页页面
//        backToIndex();
//    }

}
