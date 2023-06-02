package com.ls.listtest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Lee
 * @Date 2023/4/3 14:58
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(2, 6);
        System.out.println(arrayList);
        arrayList.set(2, 7);
        System.out.println(arrayList);

        int[] intArray = new int[2];
        intArray[0] = 1;
        intArray[1] = 2;
        System.out.println(Arrays.toString(intArray));

        int oldCapacity= 4;
        System.out.println(oldCapacity >> 1);
    }
}
