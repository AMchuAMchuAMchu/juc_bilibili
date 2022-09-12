package com.atguigu.juc_41_105.bean;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc_41_.bean
 * @Version: 1.0
 * @CreateTime: 2022-09-01 18:03:00
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class Anime01 {

    private String animeName;

    private Integer time;

    public Anime01() {
    }

    public Anime01(String animeName, Integer time) {
        this.animeName = animeName;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Anime01{" +
                "animeName='" + animeName + '\'' +
                ", time=" + time +
                '}';
    }
}
