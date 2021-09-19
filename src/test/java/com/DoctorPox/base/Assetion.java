package com.DoctorPox.base;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class Assetion {
    static Logger logger = Logger.getLogger(Assetion.class);

    /**
     * TestNG的assertTrue断言方法二次封装，集成日志
     * @param condition 表达式
     */
    public static void myAssertTrue(boolean condition){
        try {
            Assert.assertTrue(condition);
        }catch (AssertionError e){
            logger.error("断言【"+condition+"】失败");
            logger.error(e);
            //还要继续向TestNG测试框架抛出异常
            throw e;
        }
        logger.info("断言【"+condition+"】是否为真");
    }

    /**
     * 断言实际值与期望值的二次封装
     * @param actual
     * @param expected
     */
    public static void myAssertEquals(int actual, int expected){
        try {
            Assert.assertEquals(actual,expected);
        }catch (AssertionError e){
            logger.error("断言实际值【"+actual+"】与期望值【"+expected+"】失败");
            logger.error(e);
            throw e;
        }
        logger.info("断言实际值【"+actual+"】与期望值【"+expected+"】");
    }

    public static void myAssertEquals(String actual, String expected){
        try {
            Assert.assertEquals(actual,expected);
        }catch (AssertionError e){
            logger.error("断言实际值【"+actual+"】与期望值【"+expected+"】失败");
            logger.error(e);
            throw e;
        }
        logger.info("断言实际值【"+actual+"】与期望值【"+expected+"】");
    }

    public static void myAssertEquals(double actual, double expected){
        try {
            Assert.assertEquals(actual,expected);
        }catch (AssertionError e){
            logger.error("断言实际值【"+actual+"】与期望值【"+expected+"】失败");
            logger.error(e);
            throw e;
        }
        logger.info("断言实际值【"+actual+"】与期望值【"+expected+"】");
    }
}
