package com.atguigu.juc0_40;

import java.util.concurrent.CompletableFuture;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-13 17:16:46
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class JoinTest01 {
    public static void main(String[] args) {

        String join = CompletableFuture.supplyAsync(() -> "雪乃亚丝娜赤瞳楪祈伊蕾娜赫斯提亚由琦司").thenApply(v -> v + "020202本间芽衣子").join();
        System.out.println(">>>"+join);

    }
}
