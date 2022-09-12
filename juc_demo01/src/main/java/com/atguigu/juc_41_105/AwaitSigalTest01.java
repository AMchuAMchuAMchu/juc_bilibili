package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-21 08:32:03
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class AwaitSigalTest01 {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "...come in ...");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "...被唤醒...");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {

            try {
                lock.lock();
                condition.signal();
                System.out.println("...发送通知...");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }
}
