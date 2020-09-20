package com.timelordtty.study.jvm;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author tianyu.tang
 * @Date 2020/9/8 16:10
 */
@Data
public class TestDynamicLoad {

    static {
        System.out.println("========load TestDynamicLoad========");
    }

    public static void main(String[] args) {
        TestDynamicLoad t = new TestDynamicLoad();
        new A();
        System.out.println("========load test========");
        B b = null;
    }
    public TestDynamicLoad(){
        System.out.println("========TestDynamicLoad Construction========");
    }

}
class A{
    static {
        System.out.println("========load A========");
    }
    public A(){
        System.out.println("========initial A========");
    }
}
class B{
    static {
        System.out.println("========load B========");
    }
    public B(){
        System.out.println("========initial B========");
    }
}