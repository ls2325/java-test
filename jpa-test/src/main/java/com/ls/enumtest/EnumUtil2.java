package com.ls.enumtest;

import org.springframework.util.Assert;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * @Author Lee
 * @Date 2023/3/31 14:17
 */
public class EnumUtil2 {
    /**
     * 获取枚举类型的枚举值，通过属性值
     *
     * @param clazz         枚举类
     * @param fieldFunction 属性值获取函数
     * @param fieldValue    属性值
     * @param <E>           枚举类
     * @param <V>           属性值
     * @return 匹配的枚举值，可能为null
     */
    public static <E extends Enum<E>, V> E getEnum(Class<E> clazz, Function<E, V> fieldFunction, V fieldValue) {
        Assert.notNull(clazz);
        E[] es = clazz.getEnumConstants();
        for (E e : es) {
            if (Objects.equals(fieldFunction.apply(e), fieldValue)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 获取枚举类型的枚举值，通过属性值
     *
     * @param clazz         枚举类
     * @param fieldFunction 属性值获取函数
     * @param fieldValue    属性值
     * @param <E>           枚举类
     * @param <V>           属性值
     * @return 匹配的枚举值，Optional类型
     */
    public static <E extends Enum<E>, V> Optional<E> getEnumOptional(Class<E> clazz, Function<E, V> fieldFunction, V fieldValue) {
        Assert.notNull(clazz);
        E[] es = clazz.getEnumConstants();
        for (E e : es) {
            if (Objects.equals(fieldFunction.apply(e), fieldValue)) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }
}
