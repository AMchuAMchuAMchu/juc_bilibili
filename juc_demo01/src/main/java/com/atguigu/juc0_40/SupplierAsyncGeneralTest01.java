package com.atguigu.juc0_40;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-09 13:39:43
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class SupplierAsyncGeneralTest01 {

    @SneakyThrows
    public static void main(String[] args) {

        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ">>...come in ...");
            int nextInt = ThreadLocalRandom.current().nextInt(7);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (nextInt > 3) {
                int aa = 10 / 0;
            }
            return nextInt;

        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println(">>随机结果是" + v);
            }
        }).exceptionally(e -> {
                    System.err.println(e.getCause() + "::" + e.getMessage());
                    return -44;
                });

//        TimeUnit.SECONDS.sleep(2);

        System.out.println(">>>"+supplyAsync.get());

    }

}
