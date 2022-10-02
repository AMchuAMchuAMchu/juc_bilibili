package com.atguigu.juc_158;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description ==> TODO
 * BelongsProject ==> juc_bilibili
 * BelongsPackage ==> com.atguigu.juc_158
 * Version ==> 1.0
 * CreateTime ==> 2022-10-02 18:44:09
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class ReadWriteLockDownTest {



    public static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();


    public static void main(String[] args) {

        ReentrantReadWriteLock.ReadLock readLock = rw.readLock();

        ReentrantReadWriteLock.WriteLock writeLock = rw.writeLock();

        writeLock.lock();
        readLock.lock();
        System.out.println("写入...");
        System.out.println("读取...");
        writeLock.unlock();
        readLock.unlock();



    }

}
