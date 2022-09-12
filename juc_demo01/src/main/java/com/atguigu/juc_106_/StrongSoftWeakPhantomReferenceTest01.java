package com.atguigu.juc_106_;

import org.apache.tomcat.jni.OS;
import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description: 强软弱虚测试
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_106_
 * @Version: 1.0
 * @CreateTime: 2022-09-07 18:05:31
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class StrongSoftWeakPhantomReferenceTest01 {

    @Test
    public void test04(){

        ReferenceQueue<Object> oRQ01 = new ReferenceQueue<>();

        PhantomReference<Object> oPR01 = new PhantomReference<Object>(new Object(),oRQ01);

        System.out.println(" > "+oPR01.get());//System.gc()都不用加直接就是null了O(∩_∩)O哈哈~

    }



    @Test
    public void test03(){

        WeakReference<Object> oWR01 = new WeakReference<Object>(new Object());

        System.gc();

        System.out.println(" > "+oWR01.get());




    }


    @Test
    public void test02() {

        SoftReference<Object> oSR01 = new SoftReference<Object>(new Object());

        System.out.println(" > " + oSR01.get());//-Xms -Xmx

        System.gc();

        System.out.println(" >> " + oSR01.get());

        try {
            byte[] bytes = new byte[1024 * 1024 * 8];
        } finally {
            System.out.println(" >>> " + oSR01.get());
        }

    }


    @Test
    public void test01() {

        StrongSoftWeakPhantomReferenceTest01 sRFT01 = new StrongSoftWeakPhantomReferenceTest01();

        System.out.println(" > " + sRFT01);

        sRFT01 = null;

        System.gc();

        System.out.println(" >> " + sRFT01);

    }
}
