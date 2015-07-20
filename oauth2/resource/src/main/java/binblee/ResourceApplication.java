package binblee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableOAuth2Resource
public class ResourceApplication{

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

    @Component
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic().disable();
            http.authorizeRequests().anyRequest().authenticated();
        }
    }

}
