package cn.sjxy.graduate.utils;

import java.util.ArrayList;

/**
 * @Author dpc
 * @Date 2020/3/29 11:00
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        for (Object a : list) {
            System.out.println(a);
        }
    }
}
