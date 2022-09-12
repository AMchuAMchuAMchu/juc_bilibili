package com.atguigu.juc_106_;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_106_
 * @Version: 1.0
 * @CreateTime: 2022-09-07 17:44:00
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class ThreadLocalRemoveExecutorsTest01 {

    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void add() {
        Integer integer = threadLocal.get();
        integer++;
        threadLocal.set(integer);

    }

    public static ExecutorService executors = Executors.newFixedThreadPool(3);


    public static void main(String[] args) {

        ThreadLocalRemoveExecutorsTest01 tLT01 = new ThreadLocalRemoveExecutorsTest01();

        for (int i = 0; i < 10; i++) {

            executors.submit(() -> {

                try {
                    for (int j = 0; j < 10; j++) {//为什么是10个呢?反正的话只要比三个多即可,主要的话是体现那个线程的复用数据也被重新复用的说O(∩_∩)O哈哈~
                        tLT01.add();
                    }
                    System.out.println(Thread.currentThread().getName() + " >> " + ThreadLocalRemoveExecutorsTest01.threadLocal.get());
                } finally {
                    threadLocal.remove();
                }

            });


        }

        executors.shutdown();//避免内存泄漏....


    }

}
