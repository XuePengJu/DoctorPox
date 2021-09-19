//package com.DoctorPox.testcases;
//
//
//import com.DoctorPox.base.BasePage;
//import com.DoctorPox.base.BaseTest;
//import com.DoctorPox.data.Constants;
//
//import java.util.concurrent.TimeUnit;
//
//public class sedsnj extends BaseTest {
//
//
//    public void comparison_time() {
//        while (true) {
////        获取设定的时间
//            String reserve = Constants.CORRECT_DATE + " " + Constants.CORRECT_time;
////            System.out.println(reserve);
////        转时间戳
//            long stamptime = BasePage.dateToStamp(reserve);
////            System.out.println(reserveStamp);
//
//            long nowTime = System.currentTimeMillis() / 1000;
//            Integer nowTimeInt = new Long(nowTime).intValue();
////            System.out.println(nowTimeInt);
//
//            if (nowTimeInt == stamptime) {
//                System.out.println("时间到了");
//                break;
//            } else if (nowTimeInt > stamptime) {
//                System.out.println("都过了时间了，别等了");
//                break;
//            } else {
//                System.out.println("时间还没到");
//                try {
//                    TimeUnit.MILLISECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }
//
//}