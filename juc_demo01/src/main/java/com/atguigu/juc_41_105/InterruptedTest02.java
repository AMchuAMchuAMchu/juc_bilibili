package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-18 11:32:11
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class InterruptedTest02 {


    public static void main(String[] args) {

//        new Thread(()->{
//            for (int i = 0; i < 100; i++) {
//                System.out.println(i);
//                if (i == 50){
//                    System.out.println(">"+Thread.currentThread().isInterrupted());
//                    Thread.currentThread().interrupt();
//                    System.out.println(">>"+Thread.currentThread().isInterrupted());
//                }
//            }
//        }).start();


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {

                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
//                    return;
                }

                System.out.println(i);

            }
        });

        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            t1.interrupt();
        }





    }

}
