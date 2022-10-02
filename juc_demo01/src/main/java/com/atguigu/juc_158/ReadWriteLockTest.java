package com.atguigu.juc_158;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description==>TODO
 * BelongsProject==>juc_bilibili
 * BelongsPackage==>com.atguigu.juc_158
 * CreateTime==>2022-09-26 20:44:13
 * Version==>1.0
 * Author==>02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class ReadWriteLockTest {

    public HashMap<String,String> hashMap = new HashMap<>();

    public ReentrantLock reentrantLock = new ReentrantLock();

    public ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void write(String name01,String name02){
        try {
//            reentrantLock.lock();
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " 正在写入...");
            hashMap.put(name01,name02);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 已经写完...");
        } finally {
//            reentrantLock.unlock();
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void read(String key){
        try {
//            reentrantLock.lock();
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 正在读取...");
            String s = hashMap.get(key);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 读取完毕...");
        } finally {
//            reentrantLock.unlock();
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteLockTest rwt = new ReadWriteLockTest();

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                rwt.write("name01","name02");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                rwt.read("name01");
            },String.valueOf(i)).start();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 3; i++) {
           new Thread(()->{
               rwt.write("name01","name02");
           },String.valueOf(i)).start();
        }


    }





}
