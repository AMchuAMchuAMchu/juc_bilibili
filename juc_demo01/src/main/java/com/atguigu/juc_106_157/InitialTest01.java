package com.atguigu.juc_106_157;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_106_
 * @Version: 1.0
 * @CreateTime: 2022-09-07 17:15:13
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class InitialTest01 {

    public ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void add() {
        for (int i = 0; i < 100; i++) {

            Integer integer = threadLocal.get();

            integer++;

            threadLocal.set(integer);
        }

    }

//    public Integer tickets = 0;
//
//    public void add() {
//        for (int i = 0; i < 100; i++) {
//            tickets++;
//        }
//
//    }


    public static void main(String[] args) {

        InitialTest01 initialTest01 = new InitialTest01();

        for (int i = 0; i < 5; i++) {

            new Thread(() -> {
                initialTest01.add();
                System.out.println(Thread.currentThread().getName() + "::" + initialTest01.threadLocal.get());
            }).start();

        }


//        InitialTest01 initialTest02 = new InitialTest01();
//
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                initialTest02.add();
//                System.out.println(Thread.currentThread().getName() + "::" + initialTest02.tickets);
//            }).start();
//        }


    }

}
