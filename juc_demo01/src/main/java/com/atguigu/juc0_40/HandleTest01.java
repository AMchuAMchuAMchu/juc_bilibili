package com.atguigu.juc0_40;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-13 19:05:12
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class HandleTest01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ">> come in ...");
            return 1024;
        }).handle((v,e) -> {
            System.out.println("111");
            return v + 1;
        }).handle((v,e) -> {
            v = v/0;
            System.out.println("222");
            return v + 1;
        }).handle((v,e) -> {
            System.out.println("333");
            return v + 1;
        }).whenCompleteAsync((v, e) -> {
            System.out.println("whenCompleteAsync");
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
