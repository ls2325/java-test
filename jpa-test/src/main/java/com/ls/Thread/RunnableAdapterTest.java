package com.ls.Thread;

import java.util.concurrent.Callable;

/**
 * @Author Lee
 * @Date 2023/5/19 16:41
 */
public class RunnableAdapterTest<T> implements Callable<T> {

    final Runnable task;

    final T result;

    RunnableAdapterTest(Runnable task, T result) {
        this.task = task;
        this.result = result;
    }

    @Override
    public T call() {
        task.run();
        return result;
    }

    public static void main(String[] args) {
        RunnableAdapterTest<String> success = new RunnableAdapterTest<>(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable start --------");
            }
        }, "success");


    }
}
