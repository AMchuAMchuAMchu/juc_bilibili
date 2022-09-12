package com.atguigu.juc_106_;

import com.atguigu.juc_41_105.LongAddrTest01;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_106_
 * @Version: 1.0
 * @CreateTime: 2022-09-07 14:39:22
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class SaleTicketsTest01 {

//    public static Integer tickets = 50;

    public static AtomicInteger tickets = new AtomicInteger(50);




//    @SneakyThrows
    public void salesTickets() throws InterruptedException {

        for (int i = 1; i <= 17; i++) {
            TimeUnit.MICROSECONDS.sleep(200);
            if (tickets.get() > 1) {//因为的话后面有一个"--"的操作的说O(∩_∩)O哈哈~
//                System.out.println("||"+tickets.get());
//                System.out.println(Thread.currentThread().getName() + "::售出第 " + tickets-- + " 张票");
                int andDecrement = tickets.getAndDecrement();
                System.out.println(Thread.currentThread().getName() + "::售出第 " + andDecrement + " 张票");
            } else {
                System.out.println("果咩纳塞~~售完了喔^_^...");
            }
        }
    }

    public static void main(String[] args){

        SaleTicketsTest01 stt01 = new SaleTicketsTest01();

//        System.out.println(02);

        for (int i = 1; i <= 3; i++) {
            new Thread(()->{
                try {
                    stt01.salesTickets();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }


}
