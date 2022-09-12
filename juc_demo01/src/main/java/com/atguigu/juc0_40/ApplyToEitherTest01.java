package com.atguigu.juc0_40;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-13 19:45:57
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class ApplyToEitherTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> stringCompletableFuture01 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return "雪乃";
        });

        CompletableFuture<String> stringCompletableFuture02 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("222");
            return "亚丝娜";
        });

        CompletableFuture<String> stringCompletableFuture03 = stringCompletableFuture01.applyToEither(stringCompletableFuture02, v -> {
            System.out.println("calc...");
            return v + "5201314^_^";
        });

        System.out.println(">>"+stringCompletableFuture03.get());




    }
}
