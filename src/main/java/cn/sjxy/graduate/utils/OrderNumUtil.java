package cn.sjxy.graduate.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author dpc
 * @Date 2020/4/4 10:16
 */
public class OrderNumUtil {
    public static String getOrderNo() {
        long No = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowdate = sdf.format(new Date());
        No = Long.parseLong(nowdate) * 1000;
        No += getNo();
        return getUserId() + No;
    }

    public static int getNo() {
        return 001;
    }

    public static String getUserId() {
        return "123";
    }

    public static void main(String[] args) {
        System.out.println("getOrderNo() = " + getOrderNo());
    }

}
