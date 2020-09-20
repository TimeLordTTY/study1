package com.timelordtty.study.jvm;

/**
 * @ClassName Math
 * @Description TODO
 * @Author tianyu.tang
 * @Date 2020/9/9 16:19
 */
public class Math {
    public static final int initData = 666;
    public static User user = new User();

    public int computer() {
        int a = 1;
        int b = 1;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.computer();
        System.out.println("test");
    }
}