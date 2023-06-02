import com.ls.dao.UserDao;
import com.ls.entity.User;

/**
 * @Author Lee
 * @Date 2023/3/27 16:14
 */
public class JpaTest {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("Lee", 18);
        userDao.add(user);
    }
}
