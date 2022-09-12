package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-18 11:23:33
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class AtomicBooleanTest01 {

    private static final AtomicBoolean ATOMIC_BOOLEAN = new AtomicBoolean(true);

    public static void main(String[] args) {

        new Thread(() -> {
            while (ATOMIC_BOOLEAN.get()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello...阔你吃哇...");
            }
            System.out.println("西内...😭😭🍹🍹🍹🍹");
        }).start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ATOMIC_BOOLEAN.set(false);
        }

    }
}
