package com.ls.jdk;

import java.lang.reflect.Proxy;

/**
 * @Author Lee
 * @Date 2023/3/28 17:35
 */
public class JdkTest {

    public static void main(String[] args) {
        //JdkClass jdkClass = new JdkClass();
        JdkTestServiceImpl jdkClass = new JdkTestServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(jdkClass);
        JdkTestService jdkTestService = (JdkTestService) Proxy.newProxyInstance(jdkClass.getClass().getClassLoader(),
                jdkClass.getClass().getInterfaces(), myInvocationHandler);
        jdkTestService.add();
        //打印增强过的类类型
        System.out.println("=============" + jdkTestService.getClass());
    }
}
