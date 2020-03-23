package cn.sjxy.graduate.utils;

import java.util.Random;

/**
 * @author :
 * @date : 2019/12/17
 */
public class RandomCode {
    public static String randomCode() {
        StringBuffer str = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
