package com.zsf.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.increament();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.decreament();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.increament();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.decreament();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class AirConditioner {
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increament() throws Exception {
        lock.lock();
        try {
            //1.判断
            while (number != 0) {
                condition.await();
            }
            //2.干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decreament() throws Exception {
        lock.lock();
        try {
            //1.判断
            while (number == 0) {
                condition.await();
            }
            //2.干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    /*public synchronized void increament() throws Exception {
        //1.判断
        while (number != 0) {
            this.wait();
        }
        //2.干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //3.通知
        this.notifyAll();
    }

    public synchronized void decreament() throws Exception {
        //1.判断
        while (number == 0) {
            this.wait();
        }
        //2.干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //3.通知
        this.notifyAll();
    }*/
}