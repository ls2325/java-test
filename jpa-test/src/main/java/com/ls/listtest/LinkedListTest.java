package com.ls.listtest;

import java.util.LinkedList;

/**
 * @Author Lee
 * @Date 2023/3/31 17:01
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        Object o = linkedList.get(0);
        int size = linkedList.size();
        System.out.println("size:" + size);
        linkedList.remove();
        Integer first = linkedList.getFirst();
        System.out.println("first:" + first);
    }
}
