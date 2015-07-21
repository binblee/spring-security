package demo.security;

import demo.domain.Role;
import demo.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by libin on 15/7/20.
 */
public class DemoUserDetails extends org.springframework.security.core.userdetails.User{
    private User user;
    public DemoUserDetails(User user){
        super(user.getEmail(),user.getPasswordHash(),
                AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId(){
        return user.getId();
    }

    public Role getRole(){
        return user.getRole();
    }
}
