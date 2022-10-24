package com.atguigu.juc_158;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Description ==> TODO
 * BelongsProject ==> juc_bilibili
 * BelongsPackage ==> com.atguigu.juc_158
 * Version ==> 1.0
 * CreateTime ==> 2022-10-24 19:20:18
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class StampLockTest01 {

    public static int num = 10;

    public static StampedLock stampedLock = new StampedLock();

    public void OPWriteLock(){

        long l = stampedLock.writeLock();

        try {
            System.out.println(Thread.currentThread().getName()+":: 在写的说..");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":: 写完的说..");
        } finally {
            stampedLock.unlock(l);
        }

    }

    public void OPReadLock(){

        long l = stampedLock.readLock();

        try {
            System.out.println(Thread.currentThread().getName()+":: 在读的说..");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":: 读完的说..");
        } finally {
            stampedLock.unlock(l);
        }

    }

    public static void main(String[] args) {

        StampLockTest01 stampLockTest01 = new StampLockTest01();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                stampLockTest01.OPWriteLock();
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                stampLockTest01.OPReadLock();
            },String.valueOf(i)).start();
        }

    }


}
