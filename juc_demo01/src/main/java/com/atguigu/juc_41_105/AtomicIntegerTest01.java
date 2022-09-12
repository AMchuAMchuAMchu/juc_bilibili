package com.atguigu.juc_41_105;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-08-29 18:31:34
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class AtomicIntegerTest01 {



    @Test
    public void test03(){

        AtomicInteger atomicInteger = new AtomicInteger(2022);

        atomicInteger.getAndIncrement();

        System.out.println(atomicInteger.get());

    }


    @Test
    public void test02(){

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2022)+"::"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,2023)+"::"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2022,2024)+"::"+atomicInteger.get());


    }


    @Test
    public void test01(){


        AtomicInteger atomicInteger = new AtomicInteger();

        System.out.println("01 >> " + atomicInteger.get());

        for (int i = 0; i < 100; i++) {
            atomicInteger.getAndIncrement();
        }

        System.out.println("02 >> " + atomicInteger.get());

//        ReentrantLock reentrantLock = new ReentrantLock();
//
//        Condition condition = reentrantLock.newCondition();
//
//        condition.await();
//
//        condition.signal();




    }
}
