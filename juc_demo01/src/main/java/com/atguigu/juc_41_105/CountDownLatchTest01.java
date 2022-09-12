package com.atguigu.juc_41_105;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-09-02 11:53:43
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */

class MyNumber {

    public AtomicInteger atomicInteger = new AtomicInteger(1999);

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void addPP() {
        atomicInteger.incrementAndGet();
    }

}

public class CountDownLatchTest01 {


    public static void main(String[] args) throws InterruptedException {

        MyNumber myNumber = new MyNumber();

        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 100; j++) {
                        myNumber.addPP();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();

        System.out.println(" >> "+myNumber.getAtomicInteger().get());


    }
}
