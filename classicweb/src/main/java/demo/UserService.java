package demo;

import java.util.Collection;

/**
 * Created by libin on 15/7/20.
 */
public interface UserService {
    User getUserById(long id);
    User getUserByEmail(String email);
    Collection<User> getAllUsers();
    User create(String name, String email, String password);
}
