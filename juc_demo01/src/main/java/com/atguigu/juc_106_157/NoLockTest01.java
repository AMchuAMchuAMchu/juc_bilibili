package com.atguigu.juc_106_157;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * Description==>TODO
 * BelongsProject==>juc_bilibili
 * BelongsPackage==>com.atguigu.juc_106_
 * CreateTime==>2022-09-12 13:26:21
 * Version==>1.0
 * Author==>02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class NoLockTest01 {


    @Test
    public void test02() {

        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                System.out.println(" >> ");
            }
        }).start();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());


    }

    @Test
    public void test01() {

        Object o = new Object();

        int i = o.hashCode();

        System.out.println("二进制　>>　" + i);
        System.out.println("十六进制 >> " + Integer.toHexString(i));
        System.out.println("二进制 >> " + Integer.toBinaryString(i));

        System.out.println("GUI　info" + ClassLayout.parseInstance(o).toPrintable());

    }

}
