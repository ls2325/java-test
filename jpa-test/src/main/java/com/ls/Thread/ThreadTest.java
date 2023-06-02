package com.ls.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author Lee
 * @Date 2023/5/18 15:56
 */
public class ThreadTest extends Thread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadTest t = new ThreadTest();
        t.start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> result = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "========>正在执行");
            Thread.sleep(3 * 1000L);
            return "success";
        });

        System.out.println("result:" + result.get());
    }

}
