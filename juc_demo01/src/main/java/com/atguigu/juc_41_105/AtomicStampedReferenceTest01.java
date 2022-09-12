package com.atguigu.juc_41_105;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-09-01 18:54:32
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class AtomicStampedReferenceTest01 {


    @Test
    public void test01(){

        int i = 3;

//        System.out.println(i++);//3
        System.out.println(++i);//4

    }


    public static void main(String[] args) {

        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<>(100, 1);

        System.out.println(" > " + integerAtomicStampedReference.getReference() + " || " + integerAtomicStampedReference.getStamp());
        int stamp = integerAtomicStampedReference.getStamp();

        boolean b = integerAtomicStampedReference.compareAndSet(100, 2022, stamp, stamp + 1);

        System.out.println(b ? "成!!" : "Fuck!!" + integerAtomicStampedReference.getReference());
        System.out.println(" >> " + integerAtomicStampedReference.getReference() + " || " + integerAtomicStampedReference.getStamp());

    }
}
