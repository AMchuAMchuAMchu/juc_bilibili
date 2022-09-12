package com.atguigu.juc_41_105;

import com.atguigu.juc_41_105.bean.Anime01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-09-01 18:19:43
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class SpinLockTest01 {

    public static AtomicReference<Anime01> atomicReference = new AtomicReference<>();

    public static Anime01 anime01 = new Anime01("终末的女武神", 2021);

    public void lock() {

        System.out.println(Thread.currentThread().getName() + " > " + atomicReference.get());
        while (!atomicReference.compareAndSet(null, anime01)) {
        }

    }

    public void unlock() {

        System.out.println(Thread.currentThread().getName() + " >> " + atomicReference.get());
        atomicReference.compareAndSet(anime01, null);

    }

    public static void main(String [] args){

        SpinLockTest01 spinLockTest01 = new SpinLockTest01();

        new Thread(() -> {
            spinLockTest01.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockTest01.unlock();
        }, "T1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockTest01.lock();
            spinLockTest01.unlock();
        }, "T2").start();


    }


}
