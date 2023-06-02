package com.ls.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Lee
 * @Date 2023/3/28 17:24
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before+++++++++++");
        Object invoke = method.invoke(target, args);
        System.out.println("after++++++++++++");
        return invoke;
    }
}
