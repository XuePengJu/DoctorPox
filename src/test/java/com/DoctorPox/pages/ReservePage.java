package com.DoctorPox.pages;

import com.DoctorPox.base.BasePage;
import com.DoctorPox.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReservePage extends BasePage {
    //预约返回主页按钮
    By backBy = By.id("com.xcgl.dbs:id/iv_left");

    //    点击周六的位置
    By saturdayBy = By.xpath("//*[@text=\"星期五\"]");
    //    By saturdayBy = By.xpath("//*[@text=\"星期六\"]");
    //    预约按钮
    By reserveBy = By.id("com.xcgl.dbs:id/tv_state");
    //    预约成功后 ，显示我知道了按钮定位
    By IseeBy = By.id("com.xcgl.dbs:id/tv_cancel");
    //预约成功 显示
    By Appointment_succeededBy = By.id("com.xcgl.dbs:id/tv1");


    public void clickback() {
        click(backBy, "点击返回主页");
    }

    public void clicksaturday() {
        click(saturdayBy, "点击周六选项卡");
    }

    public void clickreserve() {
        randomClick(reserveBy, "点击预约");
    }

    public void seeIsee() {
        getText(IseeBy, "我知道了按钮");
        click(IseeBy, "点击我知道了");
    }

    public String seeAppointment_succeeded() {
        String expectstr = getText(Appointment_succeededBy, "预约成功");
        return expectstr;
    }

    /**
     * 预约方法封装
     *
     * @param by
     * @param desc
     */
    public void randomClick(By by, String desc) {
        List<WebElement> list = null;
        list = BaseTest.driver.findElements(by);
        int index = 0;
        for (Object obj : list) {
            if (index >= 6) {
                logger.info("输出预约状态【" + index + list.get(index).getText() + "】");
//                判断在17点以后，index为6
                if (list.get(index).getText().equals("可预约")) {
                    list.get(index).click();
                    logger.info("__跑到这里，基本上就是预约成功了");
                    break;
                }
            }
            index += 1;
        }
    }


}