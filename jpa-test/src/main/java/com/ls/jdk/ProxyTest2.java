package com.ls.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Lee
 * @Date 2023/3/30 10:55
 */
public class ProxyTest2 {

    public static void main(String[] args) throws Throwable {
        // 1.得到目标对象
        CalculatorImpl target = new CalculatorImpl();
        // 2.传入目标对象，得到增强对象（如果需要对目标对象进行别的增强，可以另外编写getXxInvocationHandler）
        InvocationHandler logInvocationHandler = getLogInvocationHandler(target);
        // 3.传入接口+增强对象（含目标对象），得到代理对象
        Calculator calculatorProxy = (Calculator) getProxy(
                logInvocationHandler,                 // 增强对象（包含 目标对象 + 增强代码）
                target.getClass().getClassLoader(),   // 随便传入一个类加载器
                target.getClass().getInterfaces()     // 需要代理的接口
        );
        calculatorProxy.add(1, 2);

        Class<?>[] interfaces = target.getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }

    /**
     * 传入接口+增强（已经包含了目标对象），获取代理对象
     *
     * @param handler
     * @param classLoader
     * @param interfaces
     * @return
     * @throws Exception
     */
    private static Object getProxy(final InvocationHandler handler, final ClassLoader classLoader, final Class<?>... interfaces) throws Exception {
        // 参数1：随便找个类加载器给它 参数2：需要代理的接口
        Class<?> proxyClazz = Proxy.getProxyClass(classLoader, interfaces);
        Constructor<?> constructor = proxyClazz.getConstructor(InvocationHandler.class);
        return constructor.newInstance(handler);
    }

    /**
     * 日志增强代码
     *
     * @param target
     * @return
     */
    private static InvocationHandler getLogInvocationHandler(final CalculatorImpl target) {
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy1, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "方法开始执行...");
                Object result = method.invoke(target, args);
                System.out.println(result);
                System.out.println(method.getName() + "方法执行结束...");
                return result;
            }
        };
    }
}
