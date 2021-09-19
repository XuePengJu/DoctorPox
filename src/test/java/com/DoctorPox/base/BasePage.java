package com.DoctorPox.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BasePage {
    Logger logger = Logger.getLogger(BasePage.class);

    /**
     * 点击操作的二次封装
     *
     * @param by
     * @param desc 元素描述信息（页面名_元素名）
     */
    public void click(By by, String desc) {
        try {
            BaseTest.driver.findElement(by).click();
        } catch (Exception e) {
            logger.error("定位元素异常【" + desc + "】");
            logger.error(e);
            throw e;
        }
        //logger.info("点击了元素【"+by+"】");
        logger.info("点击了元素【" + desc + "】");
    }

    /**
     * 随机点击公共方法封装
     *
     * @param by
     * @param desc
     */
    public void randomClick(By by, String desc) {
        List<WebElement> list = null;
        int index;
        try {
            Random random = new Random();
            //生成的随机数范围0-9
            index = random.nextInt(10);
            list = BaseTest.driver.findElements(by);
            list.get(index).click();
        } catch (Exception e) {
            logger.error("定位元素异常【" + desc + "】");
            logger.error(e);
            throw e;
        }
        logger.info("随机点击元素【" + list.get(index).getText() + "】");
    }

    /**
     * 输入操作的二次封装
     *
     * @param by
     * @param desc
     * @param data
     */
    public void type(By by, String desc, String data) {
        try {
            BaseTest.driver.findElement(by).sendKeys(data);
        } catch (Exception e) {
            logger.error("定位元素异常【" + desc + "】");
            logger.error(e);
            throw e;
        }
        logger.info("往元素【" + desc + "】输入了数据【" + data + "】");
    }

    /**
     * 获取元素文本值的二次封装
     *
     * @param by
     * @return
     */
    public String getText(By by, String desc) {
        //显示等待
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 5);
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            logger.error("定位元素异常【" + desc + "】");
            logger.error(e);
            throw e;
        }

        logger.info("获取元素的【" + desc + "】文本【" + webElement.getText() + "】");
        return webElement.getText();
    }

    public String getAttribute(By by, String attributeName, String desc) {
        String value = null;
        try {
            value = BaseTest.driver.findElement(by).getAttribute(attributeName);
        } catch (Exception e) {
            logger.error("定位元素异常【" + desc + "】");
            logger.error(e);
            throw e;
        }

        logger.info("获取元素的【" + desc + "】属性值【" + value + "】");
        return value;
    }

    /**
     * 判断元素是否可见公共封装
     *
     * @param by
     * @param desc
     * @return
     */
    public boolean isElemenVisible(By by, String desc) {
        try {
            BaseTest.driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            logger.error("判断元素【" + desc + "】可见异常");
            logger.error(e);
            throw e;
        }
        logger.info("判断元素【" + desc + "】可见正常");
        return true;
    }

    /**
     * 将时间转换为时间戳
     */
    public long dateToStamp(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strstamp = "";
        if (!"".equals(time)) {//时间不为空
            try {
                strstamp = String.valueOf(sdf.parse(time).getTime() / 1000);
            } catch (Exception e) {
                logger.warn("参数为空！");
            }
        } else {    //时间为空
            long current_time = System.currentTimeMillis();  //获取当前时间
            strstamp = String.valueOf(current_time / 1000);
        }
        long stamp = Integer.parseInt(strstamp);
        logger.info("时间转时间戳,int类型");
        return stamp;
    }

    /*
     * 将时间戳转换为时间
     */
    public String stampToDate(int time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_Date = sdf.format(new Date(time * 1000L));
        return time_Date;
    }

    /*
     * datetime 返回当前时间
     */
    public String datetime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("获取当前时间");
        return formatter.format(date);
    }
}
