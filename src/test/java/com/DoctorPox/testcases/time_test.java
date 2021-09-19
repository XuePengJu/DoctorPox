package com.DoctorPox.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class time_test {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(date));
    }

    /*
     * datetime 返回当前时间
     */
    public String datetime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
