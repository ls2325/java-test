package com.ls.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author Lee
 * @Date 2023/4/3 16:52
 */
public class FunctionCode {

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        System.out.println(getString(() -> msgA + msgB));

        consumeString(
                s -> System.out.println(s.toUpperCase()),
                s -> System.out.println(s.toLowerCase()+",老婆"),
                "hello");

        method(s -> s.length() > 5);

        method2(s -> Integer.parseInt(s));
    }

    //Supplier接口
    private static String getString(Supplier<String> function) {
        return function.get();
    }

    //Consumer接口
    private static void consumeString(Consumer<String> one, Consumer<String> two, String s) {
        one.andThen(two).accept(s);
    }

    //Predicate接口
    private static void method(Predicate<String> predicate) {
        boolean veryLong = predicate.test("HelloWorld");
        System.out.println("字符串很长吗：" + veryLong);
    }

    //
    private static void method2(Function<String, Integer> function) {
        int num = function.apply("10");
        System.out.println(num);
    }
}
