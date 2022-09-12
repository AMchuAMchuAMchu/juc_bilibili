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
 * @CreateTime: 2022-08-08 13:09:30
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class SupplierAsyncTest01 {

    @SneakyThrows
    public static void main(String[] args) {

        CompletableFuture<Object> supplyAsync = CompletableFuture.supplyAsync(() -> {

            System.out.println(Thread.currentThread().getName() + ">>...come in..");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("task over...");

            return ThreadLocalRandom.current().nextInt(5);

        });

        System.out.println(">>" + supplyAsync.get());

    }
}
