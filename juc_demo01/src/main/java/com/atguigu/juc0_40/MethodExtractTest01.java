package com.atguigu.juc0_40;

import com.atguigu.bean.Anime;

import java.lang.reflect.Field;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-18 10:43:35
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class MethodExtractTest01 {

    public static void main(String[] args) {

        Anime anime = new Anime();


        getDeclaredFieldByReflect(anime);


    }

    private static void getDeclaredFieldByReflect(Object clazz) {
        Field[] declaredField = clazz.getClass().getDeclaredFields();

        for (Field field : declaredField) {
            String name = field.getName();
            Class<?> type = field.getType();
            String name1 = type.getName();
            System.out.println(">"+name+">>"+type+">>>"+name1);
        }
    }

}
