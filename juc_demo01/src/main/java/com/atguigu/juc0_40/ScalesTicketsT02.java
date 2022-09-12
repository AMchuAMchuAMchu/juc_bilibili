package com.atguigu.juc0_40;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-16 12:09:07
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class ScalesTicketsT02 {


    public static void main(String[] args) {

        T2 t2 = new T2();

        new Thread(t2::scaleT02,"a").start();
        new Thread(t2::scaleT02,"b").start();
        new Thread(t2::scaleT02,"c").start();

    }
}

class T2{

    private int tickets = 30;

    public void scaleT02(){
        while (tickets > 0){
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("售出:>>"+tickets--);
        }

    }



}
