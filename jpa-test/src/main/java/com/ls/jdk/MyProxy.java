package com.ls.jdk;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @Author Lee
 * @Date 2023/3/30 15:32
 */
public class MyProxy implements java.io.Serializable{

    protected MyInvocationHandler h;

    private MyProxy() {
    }

    protected MyProxy(MyInvocationHandler h) {
        Objects.requireNonNull(h);
        this.h = h;
    }

    public static Object newProxyInstance(ClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h) throws Exception {
        // 拷贝一份接口Class（接口可能有多个，所以拷贝的Class也有多个）
        final Class<?>[] interfaceCls = interfaces.clone();
        // 这里简化处理，只取第一个
        Class<?> copyClazzOfInterface = interfaceCls[0];
        // 获取Proxy带InvocationHandler参数的那个有参构造器
        Constructor<?> constructor = copyClazzOfInterface.getConstructor(MyInvocationHandler.class);
        // 创建一个Proxy代理对象，并把InvocationHandler塞到代理对象内部，返回代理对象
        return constructor.newInstance(h);
    }
}
