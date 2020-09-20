package com.timelordtty.study.designpattern.signleton.innerclasssignleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName InnerClassSignletonTest
 * @Description TODO 内部类单例模式
 * @Author tianyu.tang
 * @Date 2020/8/26 18:58
 */
public class InnerClassSignletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<InnerClassSignleton> declaredConstructor = InnerClassSignleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);//设置访问权限可见
        InnerClassSignleton innerClassSignleton = declaredConstructor.newInstance();
        InnerClassSignleton instance = InnerClassSignleton.getInstance();
        System.out.println(innerClassSignleton == instance);

//  多线程
//        new Thread(()->{
//            InnerClassSignleton instance = InnerClassSignleton.getInstance();
//            System.out.println(instance);
//        }).start();
//
//        new Thread(()->{
//            InnerClassSignleton instance = InnerClassSignleton.getInstance();
//            System.out.println(instance);
//        }).start();
    }
}
class InnerClassSignleton{
    private static class InnerClassHolder{
        private static InnerClassSignleton instance = new InnerClassSignleton();
    }
    private InnerClassSignleton() {
        if (InnerClassHolder.instance!=null){
            throw new RuntimeException("单例不允许多个实例");
        }
    }
    public static InnerClassSignleton getInstance(){
        return InnerClassHolder.instance;
    }
}