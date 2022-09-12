package com.atguigu.juc0_40;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-15 10:16:49
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class ThenCombineTest02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        String join = CompletableFuture.supplyAsync(() -> {
//            System.out.println("111");
//            return "02";
//        }).thenCombine(CompletableFuture.supplyAsync(() -> {
//            System.out.println("222");
//            return "雪乃";
//        }), (v1, v2) -> {
//            System.out.println("333");
//            return v2 + v1;
//        }).join();

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("111");
            return "02";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("222");
            return "雪乃";
        }), (v1, v2) -> {
            System.out.println("333");
            return v2 + v1;
        });

        System.out.println(">>"+stringCompletableFuture.get());

    }
}
