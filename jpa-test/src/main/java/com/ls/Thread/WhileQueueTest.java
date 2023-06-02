package com.ls.Thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lee
 * @Date 2023/5/19 17:51
 */
public class WhileQueueTest<T> {

    private final LinkedList<T> queue = new LinkedList<>();

    public void put(T resource) throws InterruptedException {
        while (queue.size() >= 1) {
            // 队列满了，不能再塞东西了，轮询等待消费者取出数据
            System.out.println("生产者：队列已满，无法插入...");
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("生产者：插入" + resource + "!!!");
        queue.addFirst(resource);
    }

    public void take() throws InterruptedException {
        while (queue.size() <= 0){
            // 队列空了，不能再取东西，轮询等待生产者插入数据
            System.out.println("消费者：队列为空，无法取出...");
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("消费者：取出消息!!!");
        queue.removeLast();
        TimeUnit.MILLISECONDS.sleep(5000);
    }

    public static void main(String[] args) {
        // 队列
        WhileQueueTest<String> queue = new WhileQueueTest<>();

        // 生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        queue.put("消息" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 消费者
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
