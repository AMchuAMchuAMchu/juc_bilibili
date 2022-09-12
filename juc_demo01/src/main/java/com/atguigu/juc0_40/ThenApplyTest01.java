package com.atguigu.juc0_40;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-13 18:56:33
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class ThenApplyTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ">> come in ...");
            return 1024;
        }).thenApply(v -> {
            System.out.println("111");
            return v + 1;
        }).thenApply(v -> {
            v = v/0;
            System.out.println("222");
            return v + 1;
        }).thenApply(v -> {
            System.out.println("333");
            return v + 1;
        }).whenCompleteAsync((v, e) -> {
            if (e == null) {
                System.out.println("result >> " + v);
            }
        }).exceptionally(e -> {
            System.out.println("errrr::" + e.getMessage());
            return -44;
        });

        System.out.println("最终结果"+completableFuture.get());

    }
}
