import com.ls.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lee
 * @Date 2023/3/27 17:02
 */
public class ReflectionTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);

        Method add = list.getClass().getDeclaredMethod("add", Object.class);
        add.invoke(list, new User("lee", 13));

        for (Object s : list) {
            System.out.println(s);
        }

        Object obj = 666;
        System.out.println(obj);
    }
}
