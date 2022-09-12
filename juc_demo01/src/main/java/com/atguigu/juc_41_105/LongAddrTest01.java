package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-09-02 14:35:11
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class LongAddrTest01 {

    public static AtomicLong atomicLong = new AtomicLong();

    public static void atomicLongAdd() {
        atomicLong.incrementAndGet();
    }

    public static LongAdder longAdder = new LongAdder();

    public static void longAdderAdd() {

        longAdder.increment();

    }

    public static void main(String[] args) {

        long start01 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    atomicLongAdd();
                }
            }).start();
        }
        long end01 = System.currentTimeMillis();
        System.out.println("atomicLongAdd耗时>>"+(end01 - start01)+"毫秒");


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long start02 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000000; j++) {
                    longAdderAdd();
                }
            }).start();
        }
        long end02 = System.currentTimeMillis();
        System.out.println("longAdderAdd耗时>>"+(end02 - start02)+"毫秒");





    }


}
