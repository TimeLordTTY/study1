package com.timelordtty.study.designpattern.signleton.lazysignleton;

/**
 * @ClassName LazySignleton
 * @Description TODO 懒汉模式单例模式
 * @Author tianyu.tang
 * @Date 2020/8/26 9:10
 */
public class LazySignletonTest {
//    public static void main(String[] args) {
//
//
//        new Thread(()->{
//            LazySignLeton instance = LazySignLeton.getInstance();
//            System.out.println(instance);
//        }).start();
//        new Thread(()->{
//            LazySignLeton instance1 = LazySignLeton.getInstance();
//            System.out.println(instance1);
//        }).start();
//    }

}
class LazySignLeton{
    private static LazySignLeton instance;
    private LazySignLeton(){

    }
    public static LazySignLeton getInstance(){
        if (instance == null){
            synchronized(LazySignLeton.class){
                if (instance == null){
                    instance = new LazySignLeton();
                }
            }
        }
        return instance;
    }
}