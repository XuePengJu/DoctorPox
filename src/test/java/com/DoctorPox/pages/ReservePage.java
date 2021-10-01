package com.DoctorPox.pages;

import com.DoctorPox.base.BasePage;
import org.openqa.selenium.By;

public class ReservePage extends BasePage {
    //预约返回主页按钮
    By backBy = By.id("com.xcgl.dbs:id/iv_left");


    public void clickback() {
        click(backBy, "点击返回主页");
    }

}