package binblee;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by libin on 15/7/19.
 */
@Controller
@EnableResourceServer
public class AuthserverController {

    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
