package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-21 08:22:18
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class WaitNotifyTest01 {

    public static void main(String[] args) {

        Object mLock = new Object();


        new Thread(() -> {
            synchronized (mLock) {
                System.out.println(Thread.currentThread().getName() + "...come in ...");

                try {
                    System.out.println(Thread.currentThread().getName() + "等待...");
                    mLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...被唤醒");
            }
        }).start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            synchronized (mLock) {
                mLock.notify();
                System.out.println("通知发送...");
            }
        }).start();


    }


}
