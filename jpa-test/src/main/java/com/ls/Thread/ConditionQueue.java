package com.ls.Thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Lee
 * @Date 2023/5/31 11:19
 */
public class ConditionQueue<T> {

    /**
     * 容器，用来装东西
     */
    private final LinkedList<T> queue = new LinkedList<>();

    /**
     * 显式锁（相对地，synchronized锁被称为隐式锁）
     */
    private final ReentrantLock lock = new ReentrantLock();

    private final Condition producerCondition = lock.newCondition();

    private final Condition consumerCondition = lock.newCondition();

    public void put(T resource) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= 1) {
                // 队列满了，不能再塞东西了，轮询等待消费者取出数据
                System.out.println("生产者：队列已满，无法插入...");
                // 生产者阻塞
                producerCondition.await();
            }
            System.out.println("生产者：插入" + resource + "!!!");
            queue.addFirst(resource);
            // 生产完毕，唤醒消费者
            consumerCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() <= 0) {
                // 队列空了，不能再取东西，轮询等待生产者插入数据
                System.out.println("消费者：队列为空，无法取出...");
                // 消费者阻塞
                consumerCondition.await();
            }
            System.out.println("消费者：取出消息!!!");
            queue.removeLast();
            // 消费完毕，唤醒生产者
            producerCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // 队列
        ConditionQueue<String> queue = new ConditionQueue<>();

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
