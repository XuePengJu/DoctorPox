package com.DoctorPox.pages;

import com.DoctorPox.base.BasePage;
import org.openqa.selenium.By;

public class ReservePage extends BasePage {
    //预约返回主页按钮
    By backBy = By.id("com.xcgl.dbs:id/iv_left");

    //    点击周六的位置
    By saturdayBy = By.xpath("//*[@text=\"星期六\"]");
    //    预约按钮
    By reserveBy = By.id("com.xcgl.dbs:id/tv_state");

    public void clickback() {
        click(backBy, "点击返回主页");
    }

    public void clicksaturday() {
        click(saturdayBy, "点击周六选项卡");
    }

    public void clickreserve() {
        randomClick(reserveBy, "点击预约定位的全部文案");
    }


}