package com.atguigu.juc_41_105;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-18 11:14:40
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class VolatileTest01 {

    private static volatile boolean isStop = false;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println("撒有哪啦...😭😭😭");
                    return;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello...框帮哇...🤣🤣");
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            isStop = true;
        }


    }
}
