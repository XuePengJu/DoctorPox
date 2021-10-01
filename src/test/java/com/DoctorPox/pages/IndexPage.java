package com.DoctorPox.pages;

import com.DoctorPox.base.BasePage;
import org.openqa.selenium.By;

public class IndexPage extends BasePage {
    //预约管理按钮
    By subscribeBy = By.id("com.xcgl.dbs:id/tv_order_manager");
    By backBy = By.id("com.xcgl.dbs:id/iv_left");


    public void clickSubscriben() {
        click(subscribeBy, "点击预约管理");
    }

    public void clickback() {
        click(backBy, "点击返回主页");
    }

}