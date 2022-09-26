package com.atguigu.juc_106_157;

import java.util.HashMap;

/**
 * Description==>TODO
 * BelongsProject==>juc_bilibili
 * BelongsPackage==>com.atguigu.juc_106_
 * CreateTime==>2022-09-08 20:44:01
 * Version==>1.0
 * Author==>02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class HashMapMemoryLeakNullTest01 {
    public static void main(String[] args) {

        HashMap<Integer, String> animeMap = new HashMap<>();
//
//        animeMap.put(null,"食锈末世录");
//        animeMap.put(null,"影宅");
//        animeMap.put(null,"刀剑神域");
//        animeMap.put(null,"夏岛悬疑");
//        animeMap.put(null,"美妙世界");

        animeMap.put(1,"食锈末世录");
        animeMap.put(2,"影宅");
        animeMap.put(3,"刀剑神域");
        animeMap.put(4,"夏岛悬疑");
        animeMap.put(5,"美妙世界");

        animeMap.entrySet().forEach(System.out::println);



    }
}
