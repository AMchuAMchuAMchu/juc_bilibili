package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-08-27 09:52:46
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class VolatileTest02 {

    public volatile int num;

    void add() {
        for (int i = 1; i <= 1000; i++) {
            num++;
        }
//        System.out.println(num);
    }

    public static void main(String[] args) {

        VolatileTest02 volatileTest02 = new VolatileTest02();

        for (int i = 1; i <= 10; i++) {
            new Thread(volatileTest02::add).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(volatileTest02.num);


    }


}
