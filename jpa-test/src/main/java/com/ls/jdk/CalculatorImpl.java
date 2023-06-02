package com.ls.jdk;

import org.springframework.cglib.proxy.InvocationHandler;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @Author Lee
 * @Date 2023/3/30 10:21
 */
public class CalculatorImpl implements Calculator, Serializable, InvocationHandler {
    @Override
    public int add(int a, int b) {
        System.out.println("方法a+b");
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("方法a-b");
        return a - b;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }
}
