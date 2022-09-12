package com.atguigu.juc0_40;

import java.util.concurrent.CompletableFuture;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-15 09:26:04
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class ThenAcceptTest01 {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(()->{
            System.out.println("111");
            return "02";
        }).thenApply(v->{
            System.out.println("222");
            return v+"雪乃";
        }).thenAccept(r-> System.out.println(">>"+r));

    }
}
