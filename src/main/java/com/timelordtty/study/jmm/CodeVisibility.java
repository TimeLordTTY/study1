package com.timelordtty.study.jmm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeVisibility {
private static boolean initflag = false;

//    public static void main(String[] args) {
//        Thread threada = new Thread(()->{
//            while (!initflag){
//
//            };
//            log.info("线程："+Thread.currentThread().getName()+"当前线程嗅探到initflag状态改变了");
//        },"ThreadA");
//        Thread threadb = new Thread(()->{
//            while (!initflag){
//                initflag = false;
//            };
//        },"ThreadB");
//    }
}
