package com.atguigu.juc0_40;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-08 12:52:03
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class RunAsyncTest01 {

    @SneakyThrows
    public static void main(String[] args) {

        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ">> ...come inO(∩_∩)O哈哈~");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task over...");
        });

        System.out.println("res==>" + runAsync.get());

    }
}
