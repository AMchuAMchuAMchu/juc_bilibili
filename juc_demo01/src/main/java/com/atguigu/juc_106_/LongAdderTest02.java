package com.atguigu.juc_106_;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_106_
 * @Version: 1.0
 * @CreateTime: 2022-09-07 16:02:02
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class LongAdderTest02 {

    public static LongAdder longAdder = new LongAdder();

    public String name = "NNN";

    public void add() {
        for (int i = 1; i <= 100; i++) {
//            longAdder.add(-1);
            longAdder.increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        LongAdderTest02 longAdderTest02 = new LongAdderTest02();

//        System.out.println(longAdderTest02.longAdder);

        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {

            new Thread(() -> {
                try {
                    longAdderTest02.add();
                } finally {
                    countDownLatch.countDown();
                }
            }
            ).start();


        }

        countDownLatch.await();

//        TimeUnit.SECONDS.sleep(1);

        System.out.println(" >> " + longAdder.sum());

    }

}
