package com.atguigu.juc0_40;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-16 12:14:02
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public  class ReentrantLockSalesFairUnfairTest01 {

    public static void main(String[] args) {

        T3 t3 = new T3();

        new Thread(t3::scaleT03,"a").start();

        new Thread(t3::scaleT03,"b").start();

        new Thread(t3::scaleT03,"c").start();

    }
}

class T3{

    private int tickets = 300;

    ReentrantLock lock = new ReentrantLock();

    public void scaleT03(){

        lock.lock();
        try {

            while (tickets > 0){
                try {
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"售出::" + tickets--);
            }
        } finally {
            lock.unlock();
        }

    }

}
