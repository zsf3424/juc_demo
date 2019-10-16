package com.zsf.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotSafeDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// List list = Arrays.asList("a","b","c","d");
		// System.out.println(list);

		 List list = new ArrayList();

		// List list = new Vector();

		//List list = new CopyOnWriteArrayList();

		for (int i = 0; i < 40; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0, 6));
				System.out.println("线程" + Thread.currentThread().getName() + list);
			}, String.valueOf(i)).start();
			;
		}

	}

}
