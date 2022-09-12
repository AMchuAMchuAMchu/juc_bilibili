package com.atguigu.juc0_40;


import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-16 11:10:21
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */

class T1{

    private int tickets = 100;

    public  void salesT01(){


        for (int i = 100; i > 0 ; i--) {
            if (tickets > 0){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"售出>>"+tickets--);
            }else {
                return;
            }

        }


//        ReentrantLock lock = new ReentrantLock();
//
//        try {
//
//            lock.lock();
//
//
//
//        } finally {
//
//            lock.unlock();
//
//        }



    }




}


public class ScaleTicketsTest01 {
    public static void main(String[] args) {

        T1 t1 = new T1();

//
//        t1.salesT01();
//        t1.salesT01();
//        t1.salesT01();

            new Thread(t1::salesT01,"a").start();

            new Thread(t1::salesT01,"b").start();

            new Thread(t1::salesT01,"c").start();




    }
}
