package com.zsf.juc;

import java.util.concurrent.TimeUnit;

/*
    题目：多线程8锁
 * 1  标准访问，请问先打印邮件还是短信？
 * 2  邮件新增暂停4秒钟的方法，请问先打印邮件还是短信？
 * 3  新增普通的hello方法，请问先打印邮件还是hello
 * 4  有两部手机，请问先打印邮件还是短信？
 * 5  两个静态同步方法，同一部手机，请问先打印邮件还是短信？
 * 6  两个静态同步方法，2部手机，请问先打印邮件还是短信？
 * 7  1个静态同步方法,1个普通同步方法，1部手机，请问先打印邮件还是短信？
 * 8  1个静态同步方法,1个普通同步方法，2部手机，请问先打印邮件还是短信？
 */
public class Lock8 {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone1.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
//                phone1.sendSMS();
//                phone1.hello();
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

    }


}

class Phone {
    public static synchronized void sendEmail() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("------sendEmail-----");
    }

    public /*static*/ synchronized void sendSMS() throws Exception {
        System.out.println("------sendSMS-----");
    }

    public void hello() {
        System.out.println("Hello world");
    }
}
