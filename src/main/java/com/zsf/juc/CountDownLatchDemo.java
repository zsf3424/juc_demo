package com.zsf.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }


//        countDownLatch.await(2L, TimeUnit.SECONDS);
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t关门离开");
    }
}
