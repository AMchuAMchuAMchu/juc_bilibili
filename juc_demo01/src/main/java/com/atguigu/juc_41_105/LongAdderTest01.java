package com.atguigu.juc_41_105;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-09-03 10:26:17
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class LongAdderTest01 {
    public static void main(String[] args) {

        LongAdder longAdder = new LongAdder();

        longAdder.increment();

        longAdder.increment();

        longAdder.increment();

        long sum = longAdder.sum();

        System.out.println(" > " + sum);

        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x * y, 2);

        long l = longAccumulator.longValue();

        System.out.println(" >> " + l);

    }
}
