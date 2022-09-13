package com.atguigu.juc_106_;

import org.openjdk.jol.info.ClassLayout;

/**
 * Description==>TODO
 * BelongsProject==>juc_bilibili
 * BelongsPackage==>com.atguigu.juc_106_
 * CreateTime==>2022-09-13 17:26:35
 * Version==>1.0
 * Author==>02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class HeavyLockTest01 {

    public static Object heavyLockTest01 = new Object();


    public void hello() {
        System.out.println("Hello...");
    }

    public static void main(String[] args) {


        new Thread(() -> {
            synchronized (heavyLockTest01) {
                System.out.println(">>");
                System.out.println(ClassLayout.parseInstance(heavyLockTest01).toPrintable());
            }
        }, "T1").start();

        new Thread(() -> {
            synchronized (heavyLockTest01) {
                System.out.println(">>");
                System.out.println(ClassLayout.parseInstance(heavyLockTest01).toPrintable());
            }
        }, "T2").start();

    }
}
