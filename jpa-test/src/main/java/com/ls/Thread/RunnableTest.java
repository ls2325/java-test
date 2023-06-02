package com.ls.Thread;

/**
 * @Author Lee
 * @Date 2023/5/18 16:09
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("线程执行run方法");
    }

    public static void main(String[] args) {
//        RunnableTest r = new RunnableTest();
//        Thread t = new Thread(r);
//        t.start();

//        new Thread(new Runnable() {
//            public void run() {
//                System.out.println("Runnable's run method is running");
//            }
//        }){
//            @Override
//            public void run() {
//                System.out.println("Thread's run method is running");
//            }
//        }.start();

        new Thread(() -> {
            System.out.println("run方法");
        }).start();
    }
}
