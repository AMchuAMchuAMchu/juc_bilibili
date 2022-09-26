package com.atguigu.juc_106_157;

import org.openjdk.jol.info.ClassLayout;

/**
 * Description==>TODO
 * BelongsProject==>juc_bilibili
 * BelongsPackage==>com.atguigu.juc_106_
 * CreateTime==>2022-09-10 18:57:45
 * Version==>1.0
 * Author==>02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class JOLVMTest01 {
    public static void main(String[] args) {

//        System.out.println(">>"+VM.current().details());

//        System.out.println(">"+VM.current().objectAlignment());

        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

    }
}
