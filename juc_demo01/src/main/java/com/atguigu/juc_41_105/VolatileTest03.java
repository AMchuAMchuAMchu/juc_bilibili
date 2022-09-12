package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-08-27 09:55:47
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class VolatileTest03 {

    private static volatile boolean  flag = true;


    public static void main(String[] args) {

        new Thread(()->{

            System.out.println("come in...");
            while (flag){


            }
            System.out.println("结束...");
        }).start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;

    }
}
