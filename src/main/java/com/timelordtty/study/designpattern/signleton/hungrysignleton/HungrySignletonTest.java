package com.timelordtty.study.designpattern.signleton.hungrysignleton;

/**
 * @ClassName HungrySignletonTest
 * @Description TODO 饿汉模式单例模式
 * @Author tianyu.tang
 * @Date 2020/8/26 18:47
 */
public class HungrySignletonTest {
    public static void main(String[] args) {
        HungrySignleton instance = HungrySignleton.getInstance();
        HungrySignleton instance1 = HungrySignleton.getInstance();
    }
}
class HungrySignleton{
    private static HungrySignleton instance = new HungrySignleton();
    private HungrySignleton(){

    }

    public static HungrySignleton getInstance() {
        return instance;
    }
}