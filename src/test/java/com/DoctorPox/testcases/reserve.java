package com.DoctorPox.testcases;

import com.DoctorPox.base.BaseTest;

import com.DoctorPox.pages.IndexPage;
import com.DoctorPox.pages.ReservePage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class reserve extends BaseTest {

    IndexPage indexPage = new IndexPage();
    ReservePage reservePage = new ReservePage();

    @BeforeMethod
    public void setup() {
        logger.info("进入测试CASE");
    }

        @Test
    public void reserve_test() throws InterruptedException {
        Thread.sleep(3000);

//        点击预约管理
        indexPage.clickSubscriben();
        Thread.sleep(500);
//        点击周六选项卡
        reservePage.clicksaturday();
        Thread.sleep(2000);
//        点击预约17点以后的时间段
        reservePage.clickreserve();
        Thread.sleep(3000);
//        点击我知道了按钮
        reservePage.seeIsee();
//        点击返回按钮
//        reservePage.clickback();
        Thread.sleep(1000);

    }

    @Test
    public void reserve_test2() throws InterruptedException {
        Thread.sleep(3000);
        //        点击预约管理
        indexPage.clickSubscriben();
        Thread.sleep(500);
//        断言预约成功
        String expectstr = reservePage.seeAppointment_succeeded();
        expectstr.equals("预约成功");


    }

    @AfterMethod
    public void teardown() {
        logger.info("结束测试CASE");

    }
}