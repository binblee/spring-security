package binblee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableRedisHttpSession
public class ResourceApplication {

    @Bean
    HeaderHttpSessionStrategy sessionStrategy(){
        return new HeaderHttpSessionStrategy();
    }

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}
