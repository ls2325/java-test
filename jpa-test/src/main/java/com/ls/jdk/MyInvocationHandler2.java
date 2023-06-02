package com.ls.jdk;

import java.lang.reflect.Method;

/**
 * @Author Lee
 * @Date 2023/3/30 15:33
 */
public interface MyInvocationHandler2 {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
