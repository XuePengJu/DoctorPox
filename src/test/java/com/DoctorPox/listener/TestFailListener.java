package com.DoctorPox.listener;

import com.DoctorPox.base.BaseTest;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class TestFailListener implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        System.out.println("当前是IHookable接口的run方法执行");
        //一定要保证测试主体能够去正常执行
        //testResult接收测试执行的结果
        callBack.runTestMethod(testResult);
        //监听到用例执行失败的情况
        if(testResult.getThrowable() != null){
            //执行用例截图
            //怎么访问到BaseTest里面的截图方法
            //BaseTest.getScreenshotAsFile("D:\\test\\"+System.currentTimeMillis()+".png");
            //生成字节数组格式的截图
            byte[] screenshot = BaseTest.getScreenshotAsByte();
            //怎么嵌入到Allure报表中？？
            saveScreenshotToAllure(screenshot);
        }
    }

    @Attachment
    public byte[] saveScreenshotToAllure(byte[] data){
        return data;
    }
}
