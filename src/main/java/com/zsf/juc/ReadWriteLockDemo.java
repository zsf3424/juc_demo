package com.zsf.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCacheclass myCacheclass = new MyCacheclass();

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {
                myCacheclass.put(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> {
                myCacheclass.get(finalI + "");
            }, String.valueOf(i)).start();
        }

    }
}

class MyCacheclass {
    private volatile Map<String, String> map = new HashMap<>();

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t写入开始");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入开始");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t读取开始");
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取结束result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    /*public void put(String key, String value) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t写入开始");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入开始");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get(String key) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t读取开始");
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取结束result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }*/
}