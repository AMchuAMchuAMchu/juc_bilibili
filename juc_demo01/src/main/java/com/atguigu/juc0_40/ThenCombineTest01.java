package com.atguigu.juc0_40;

import java.util.concurrent.CompletableFuture;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-15 10:11:22
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class ThenCombineTest01 {
    public static void main(String[] args) {

        CompletableFuture<String> stringCompletableFuture01 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T1 >>");
            return "02";
        });

        CompletableFuture<String> stringCompletableFuture02 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2 >>");
            return "雪乃";
        });

//        CompletableFuture<String> stringCompletableFuture = stringCompletableFuture01.thenCombine(stringCompletableFuture02, (v1, v2) -> {
//            System.out.println("calc...");
//            return v1 + "+" + v2;
//        });


        String join = stringCompletableFuture01.thenCombine(stringCompletableFuture02, (v1, v2) -> {
            System.out.println("calc...");
            return v1 + "+" + v2;
        }).join();

        System.out.println("==>"+join);


    }
}
