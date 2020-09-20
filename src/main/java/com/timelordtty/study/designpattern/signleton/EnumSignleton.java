package com.timelordtty.study.designpattern.signleton;

/**
 * @ClassName enumsignleton
 * @Description TODO
 * @Author tianyu.tang
 * @Date 2020/8/27 8:59
 */
public enum EnumSignleton {
    INSTANCE;

    public void print(){
        System.out.println(this.hashCode());
    }
}
class EnumTest{
    public static void main(String[] args) {
        EnumSignleton instance = EnumSignleton.INSTANCE;
        EnumSignleton instance1 = EnumSignleton.INSTANCE;
        System.out.println(instance == instance1);
    }
}