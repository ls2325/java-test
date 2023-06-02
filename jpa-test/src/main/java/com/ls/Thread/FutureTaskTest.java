package com.ls.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Lee
 * @Date 2023/5/19 14:18
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("callable task start--------");
                return "success";
            }
        });
        futureTask.run();
        String s = futureTask.get();
        System.out.println("callable task :" + s);

        FutureTask<String> futureTask1 = new FutureTask<>(new Runnable(){
            @Override
            public void run() {
                System.out.println("runnable task start-----");
            }
        }, "success");
        futureTask1.run();

        String s1 = futureTask1.get();
        System.out.println("runnable task :" + s1);
    }
}
