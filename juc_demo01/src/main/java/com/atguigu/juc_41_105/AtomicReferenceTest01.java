package com.atguigu.juc_41_105;

import com.atguigu.juc_41_105.bean.Anime01;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_
 * @Version: 1.0
 * @CreateTime: 2022-09-01 18:02:06
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class AtomicReferenceTest01 {

    @Test
    public void test01() {

        Anime01 anime01 = new Anime01("夏岛悬疑", 2018);

        Anime01 anime02 = new Anime01("魔女之旅", 2020);

        AtomicReference<Anime01> aAR = new AtomicReference<>();

        aAR.set(anime01);

        System.out.println(aAR.get());

        System.out.println(aAR.compareAndSet(anime01, anime02) + ">>" + aAR.get());

        System.out.println(aAR.compareAndSet(anime01, anime02) + ">>" + aAR.get());


    }


}
