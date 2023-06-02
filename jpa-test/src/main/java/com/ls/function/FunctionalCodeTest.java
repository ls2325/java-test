package com.ls.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author Lee
 * @Date 2023/4/11 10:12
 */
public class FunctionalCodeTest {

    /**
     * 用Predicate占坑
     * @param uncheckPersonList
     * @param predicate
     * @return
     */
    public static List<Person> getHealthPerson(List<Person> uncheckPersonList, Predicate<Person> predicate) {
        ArrayList<Person> healthyPersonList = new ArrayList<>();

        for (Person person : uncheckPersonList) {
            // 占坑，反正需要检测，但是具体拍CT还是核酸检测具体情况具体分析
            if (predicate.test(person)) {
                healthyPersonList.add(person);
            }
        }
        return healthyPersonList;
    }
}
