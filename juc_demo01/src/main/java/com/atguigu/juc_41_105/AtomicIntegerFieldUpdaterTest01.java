package com.atguigu.juc_41_105;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-09-04 11:06:41
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class AtomicIntegerFieldUpdaterTest01 {


    public volatile int money = 0;

    public AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest01.class, "money");

    public void transferMoneyToMe(AtomicIntegerFieldUpdaterTest01 atomicIntegerFieldUpdaterTest01) {
        atomicIntegerFieldUpdater.incrementAndGet(atomicIntegerFieldUpdaterTest01);
    }


    public static void main(String[] args) throws InterruptedException {

        AtomicIntegerFieldUpdaterTest01 atfut = new AtomicIntegerFieldUpdaterTest01();

        CountDownLatch countDownLatch = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {

                try {
                    atfut.transferMoneyToMe(atfut);
                } finally {
                    countDownLatch.countDown();
                }

            }).start();
        }

        countDownLatch.await();

        System.out.println(" :-) ==> " + atfut.money);


    }

}
