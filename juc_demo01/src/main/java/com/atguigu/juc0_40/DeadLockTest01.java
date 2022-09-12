package com.atguigu.juc0_40;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-17 09:03:22
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class DeadLockTest01 {
    public static void main(String[] args) {

        HashMap threadHashMap01 = new HashMap<Thread,String>();

        HashMap threadHashMap02 = new HashMap<Thread,String>();

        new Thread(()->{
            synchronized (threadHashMap01){
                System.out.println("a111");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (threadHashMap02){
                    System.out.println("a222");
                }
            }
        },"a").start();

        new Thread(()->{
            synchronized (threadHashMap02){
                System.out.println("b111");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (threadHashMap01){
                    System.out.println("b222");
                }
            }
        },"b").start();


        StringBuilder stringBuilder = new StringBuilder(24);

        for (int i = 0; i < 100; i++) {

            stringBuilder.append("雪乃");

        }

        System.out.println("res==>"+stringBuilder);

//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            System.out.println("发生死锁...😭😭😭强行退出...");
//            System.exit(-1);
//        }


    }
}

