package com.timelordtty.study.jvm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName MyClassLoaderTest
 * @Description TODO
 * @Author tianyu.tang
 * @Date 2020/9/8 15:46
 */
public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader{
        private String classPath;

        public MyClassLoader(String classPath){
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws IOException {
            name = name.replaceAll("\\.","/");
            FileInputStream fis = new FileInputStream(classPath+"/"+name+".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                System.out.println("自定义加载器进行加载");
                return defineClass(name,data,0,data.length);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    long t1 = System.nanoTime();
                    if (!name.startsWith("com.timelordtty.study.jvm")){
                        c = this.getParent().loadClass(name);
                    }else{
                        c = findClass(name);
                    }
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("E:/study/test");
        Class<?> aClass = classLoader.loadClass("com.timelordtty.study.jvm.User");
        Object o = aClass.newInstance();
        Method sout = aClass.getDeclaredMethod("sout", null);
        sout.invoke(o,null);
        System.out.println(aClass.getClassLoader().getClass().getName());

        MyClassLoader classLoader1 = new MyClassLoader("E:/study/test1");
        Class<?> aClass1 = classLoader1.loadClass("com.timelordtty.study.jvm.User");
        Object o1 = aClass1.newInstance();
        Method sout1 = aClass1.getDeclaredMethod("sout", null);
        sout1.invoke(o1,null);
        System.out.println(aClass1.getClassLoader().getClass().getName());
    }
}