package com.atguigu.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.bean
 * @Version: 1.0
 * @CreateTime: 2022-08-18 10:41:54
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class Anime implements Serializable {

    public void test(){

        AnimeInfo animeInfo = new AnimeInfo();
        animeInfo.test(9);


        ArrayList<String> strings = new ArrayList<>();
        strings.forEach(System.out::println);

    }

    private String animeName;

    private String author;

    private Timestamp time;


}
