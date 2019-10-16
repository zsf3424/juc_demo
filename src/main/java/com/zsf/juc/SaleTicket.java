package com.zsf.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();

//		ExecutorService executorService = Executors.newFixedThreadPool(3);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 40; i++) {
			executorService.execute(() -> {
				ticket.sale();
			});
		}
		executorService.shutdown();

		// new Thread(() -> {for (int i = 1; i <=40; i++) ticket.sale();},"A").start();
		// new Thread(() -> {for (int i = 1; i <=40; i++) ticket.sale();},"B").start();
		// new Thread(() -> {for (int i = 1; i <=40; i++) ticket.sale();},"C").start();
		/*
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for (int i = 0; i < 30; i++) { ticket.sale(); }
		 * } }, "A").start(); new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for (int i = 0; i < 30; i++) { ticket.sale(); }
		 * } }, "B").start(); new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for (int i = 0; i < 30; i++) { ticket.sale(); }
		 * } }, "C").start();
		 */
	}
}

class Ticket {
	/*
	 * private int number = 40;
	 * 
	 * public synchronized void sale() { if (number > 0) {
	 * System.out.println(Thread.currentThread().getName() + "\t卖出第" + (number--) +
	 * "张,还剩:" + number); } }
	 */

	private int number = 40;

	Lock lock = new ReentrantLock();

	public void sale() {
		lock.lock();
		try {
			if (number > 0) {
				System.out.println(Thread.currentThread().getName() + "\t卖出第" + (number--) + "张,还剩:" + number);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}