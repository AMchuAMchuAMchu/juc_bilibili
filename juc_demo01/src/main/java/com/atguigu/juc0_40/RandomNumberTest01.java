package com.atguigu.juc0_40;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-08 13:06:28
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class RandomNumberTest01 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(5));
//            System.out.println(ThreadLocalRandom.current().nextDouble());
        }

    }
}
