package com.atguigu.juc_158;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Description ==> TODO
 * BelongsProject ==> juc_bilibili
 * BelongsPackage ==> com.atguigu.juc_158
 * Version ==> 1.0
 * CreateTime ==> 2022-10-24 19:50:10
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class StampLockDemo01 {

    static int num = 10;

    public static StampedLock stampedLock = new StampedLock();


    public void readLock() {

//        long l = stampedLock.readLock();

        long l = stampedLock.tryOptimisticRead();


        try {
            int num_read = num;
            System.out.println(Thread.currentThread().getName() + ":: 在读的说...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":: 读完的说...结果::" + num_read);
        } finally {
            stampedLock.unlock(l);
        }


    }

    public void writeLock() {

        long l = stampedLock.writeLock();

        try {
            num += 10;
            System.out.println(Thread.currentThread().getName() + ":: 在写的说...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":: 写完的说...结果::"+num);
        } finally {
            stampedLock.unlock(l);
        }

    }

    public static void main(String[] args) {

        StampLockDemo01 stampLockDemo01 = new StampLockDemo01();

            new Thread(stampLockDemo01::readLock,"read").start();


        for (int i = 0; i < 5; i++) {
            new Thread(stampLockDemo01::writeLock,String.valueOf(i)).start();
        }


    }

}
