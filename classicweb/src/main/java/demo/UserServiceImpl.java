package demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by libin on 15/7/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(long id) {
        if(id==1){
            return new User(id,"a","a@email.com",new BCryptPasswordEncoder().encode("apass"),Role.ADMIN);
        }else if(id==2){
            return new User(id,"b","b@email.com",new BCryptPasswordEncoder().encode("bpass"),Role.ADMIN);
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        if(email.equals("a@email.com")){
            return new User(1,"a","a@email.com",new BCryptPasswordEncoder().encode("apass"),Role.ADMIN);
        }else if(email.equals("b@email.com")){
            return new User(2,"b","b@email.com",new BCryptPasswordEncoder().encode("bpass"),Role.ADMIN);
        }
        return null;
    }

    @Override
    public Collection<User> getAllUsers() {
        return null;
    }

    @Override
    public User create(String name, String email, String password) {
        return null;
    }
}
