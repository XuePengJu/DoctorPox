package com.DoctorPox.base;

import com.DoctorPox.data.Constants;
import com.DoctorPox.pages.IndexPage;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    Logger logger = Logger.getLogger(BaseTest.class);
    //定义全局static driver
    public static AndroidDriver driver;

    @BeforeSuite
    public void globalSetup() throws InterruptedException {
        //判断是否到达时间
        //time_judgment();
        //打开测试App-只打开一次
        openApp();
        setImplicitlyWait(10);
    }

    @AfterSuite
    public void globalTeardown() {
        //打开测试App-只打开一次
        closeApp();
    }

    /**
     * 打开测试App公共方法
     */
    public void openApp() {
        //用来去打开测试的App
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", Constants.DEVICE_NAME);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appWaitDuration", 50000);
        desiredCapabilities.setCapability("appPackage", Constants.APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", Constants.APP_LAUNCHABLE);
        //noReset参数-不清楚掉App的数据
        desiredCapabilities.setCapability("noReset", true);
        //URL地址是Appium服务的地址（接口地址）
        try {
            URL remoteUrl = new URL("http://" + Constants.APPIUM_URL + ":" + Constants.APPIUM_PORT + "/wd/hub");
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        logger.info("======================打开测试App===========================");
    }


    /**
     * 隐式等待二次封装
     *
     * @param timeOut
     */
    public void setImplicitlyWait(int timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        logger.info("设置全局隐式等待时间【" + timeOut + "】");
    }


    /**
     * 关闭退出App
     */
    public void closeApp() {
        driver.quit();
        logger.info("关闭测试App");
    }

    /**
     * 生成File文件截图的封装
     *
     * @param picPath 截图文件需要保存的路径
     */
    public static void getScreenshotAsFile(String picPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //1、file对象
        //2、字节数组
        File srcfile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File descFile = new File(picPath);
        try {
            FileUtils.copyFile(srcfile, descFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成字节数组截图的封装
     */
    public static byte[] getScreenshotAsByte() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //1、file对象
        //2、字节数组
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public void time_judgment() throws InterruptedException {
        IndexPage indexPage = new IndexPage();
//        加时间判断
        while (true) {
//        获取设定的时间
            String reserve = Constants.CORRECT_DATE + " " + Constants.CORRECT_time;
//            System.out.println(reserve);
//        转时间戳
//            long stamptime = BaseTest.dateToStamp(reserve);
            long stamptime = indexPage.dateToStamp(reserve);
            logger.debug("设定时间的时间戳：" + stamptime);

            long nowTime = System.currentTimeMillis() / 1000;
            Integer nowTimeInt = new Long(nowTime).intValue();
            logger.debug("现在时间戳：" + nowTimeInt);

            if (nowTimeInt == stamptime) {
                logger.info("时间到了,开始去抢着预约了");
                break;
            } else if (nowTimeInt > stamptime + 10) {
                logger.warn("都过了时间了，别等了");
                System.exit(0);
            } else {
                logger.info("时间还没到,耐心等待");
                Thread.sleep(1000);
            }
        }
    }

}
