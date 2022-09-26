package com.atguigu.juc_106_157;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_106_
 * @Version: 1.0
 * @CreateTime: 2022-09-06 21:55:18
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class SimpleDateFormatterTest01 {


    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Date parseStringToDate(String string) throws ParseException {
        return sdf.parse(string);
    }

    public static void main(String[] args) {

        SimpleDateFormatterTest01 sdft01 = new SimpleDateFormatterTest01();


        for (int i = 1; i <= 20; i++) {
//            new Thread(() -> {加了多线程之后就直接报错了....^_^
                try {
                    Date date = sdft01.parseStringToDate("2022-09-06 21:58:38");
                    System.out.println(Thread.currentThread().getName() + i+" >> " + date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
//            }, i + "").start();
        }

    }

}
