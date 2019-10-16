package com.zsf.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d",2L, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L,TimeUnit.SECONDS));

/*        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());*/

/*        System.out.println(blockingQueue.offer("A"));
        System.out.println(blockingQueue.offer("B"));
        System.out.println(blockingQueue.offer("C"));
        System.out.println(blockingQueue.offer("D"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/


/*        blockingQueue.add("A");
        blockingQueue.add("B");
        blockingQueue.add("C");
//        blockingQueue.add("D");

//        String element = blockingQueue.element();
//        System.out.println(element);

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());*/

    }
}
