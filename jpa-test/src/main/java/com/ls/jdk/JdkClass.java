package com.ls.jdk;

/**
 * @Author Lee
 * @Date 2023/3/28 16:17
 */
public class JdkClass implements JdkTestService {
    @Override
    public void add() {
        System.out.println("目标类方法");
    }
}
