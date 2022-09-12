package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-18 11:32:11
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class InterruptedTest01 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("西内...");
                    return;
                }
                System.out.println("hello...阔你吃哇...");
            }
        });

        t1.start();

        System.out.println("当前状态::" + t1.isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            t1.interrupt();
            System.out.println("当前状态::" + t1.isInterrupted());
        }




    }

}
