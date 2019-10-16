package com.zsf.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        FutureTask<String> future = new FutureTask(new MyThread());

        new Thread(future, "aaa").start();

        String result = future.get();
        System.out.println(result);

        System.out.println("******主线程： "+Thread.currentThread().getName());
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t ******come in call");
        return "java0615";
    }
}