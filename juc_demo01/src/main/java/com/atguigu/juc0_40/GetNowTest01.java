package com.atguigu.juc0_40;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-13 17:10:54
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class GetNowTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "020202";
        });

//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(">>"+supplyAsync.getNow("没值啊哥们...😂😂"));


    }
}
