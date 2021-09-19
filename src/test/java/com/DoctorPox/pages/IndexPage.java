package com.DoctorPox.pages;

import com.DoctorPox.base.BasePage;
import org.openqa.selenium.By;

public class IndexPage extends BasePage {
    //预约管理按钮
    By subscribeBy = By.xpath("//*[@resource-id=\"com.xcgl.dbs:id/ll_bottom\"]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]'");


    public void clickSubscriben() {
        click(subscribeBy, "点击预约管理");
    }

}