package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-08-23 09:49:05
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class LockSupportTest01 {


    public static void main(String[] args) {




        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::come in ...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(Thread.currentThread().getName() + "::等待...");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "::被唤醒 ...");
        });

        t1.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::发通行证 ...");
            LockSupport.unpark(t1);
        }).start();


    }
}
