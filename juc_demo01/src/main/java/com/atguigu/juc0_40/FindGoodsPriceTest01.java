package com.atguigu.juc0_40;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @BelongsProject: juc_bilibili
 * @BelongsPackage: com.atguigu.juc
 * @Version: 1.0
 * @CreateTime: 2022-08-13 15:19:04
 * @Author: 02雪乃赤瞳楪祈校条祭制作委员会 wyq_start
 */
public class FindGoodsPriceTest01 {


    static <T> T m1(){
     return null;
    }

    static class  c1<T>{}

    private static List<AnimationTest> list = Arrays.asList(
            new AnimationTest("Darling in the FRANxx"),
            new AnimationTest("我的青春恋爱物语果然有问题"),
            new AnimationTest("罪恶王冠"),
            new AnimationTest("刀剑神域"),
            new AnimationTest("斩!赤红之瞳"));

    static List<String> findAnimePriceSync(List<AnimationTest> list,String animeName){
        return list.stream().map(anime -> String.format(animeName+"%s 's price is %.2f ^_^",anime.getAnimeName(),
                anime.getPriceByAnimeName(animeName))).collect(Collectors.toList());
    }

    static List<String> findAnimePriceAsync(List<AnimationTest> list,String animeName){
        return list.stream().map(anime -> CompletableFuture.supplyAsync(() -> String.format(animeName+"%s 's price is %.2f O(∩_∩)O哈哈~",
                anime.getAnimeName(),anime.getPriceByAnimeName(animeName)))).
                collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        c1<Object> objectc1 = new c1<>();
        m1();

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//        });
//
//        Void unused = voidCompletableFuture.get();


        long s1 = System.currentTimeMillis();
        List<String> animePriceSync = findAnimePriceSync(list, "hayami>>");
        animePriceSync.forEach(System.out::println);
        long e1 = System.currentTimeMillis();
        System.out.println("Sync耗时:" + (e1 - s1));
        long s2 = System.currentTimeMillis();
        List<String> animePriceAsync = findAnimePriceAsync(list, "kayano>>>");
        animePriceAsync.forEach(System.out::println);
        long e2 = System.currentTimeMillis();
        System.out.println("Async耗时:" + (e2 - s2));

    }

}

class AnimationTest {

//    @Getter ///报错,但是可以运行...^_^
    private String animeName;

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public AnimationTest(String animeName){
        this.animeName = animeName;
    }

    public double getPriceByAnimeName(String animeName){

        return ThreadLocalRandom.current().nextDouble()+animeName.charAt(0);

    }

}
