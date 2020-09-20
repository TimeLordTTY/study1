package com.timelordtty.study.jvm;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author tianyu.tang
 * @Date 2020/9/8 16:10
 */
@Data
public class User {
    String name;
    Integer age;
    private void eat(String name){
        System.out.println(name+"在吃东西");
    }
    public User(String name,Integer age) {
        System.out.println(name+"今年"+age+"岁了");
        eat(name);
    }
    public User() {
        System.out.println("无参构造方法");
    }
    public static void main(String[] args) {
        User user = new User("张三",1);
    }
    public void sout(){
        System.out.println("-------另外一个版本的：MyClassLoaderTest调用方法-------");
    }
}