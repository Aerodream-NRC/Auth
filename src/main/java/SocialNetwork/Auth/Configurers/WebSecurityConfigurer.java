package SocialNetwork.Auth.Configurers;

import SocialNetwork.Auth.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends SecurityConfigurerAdapter{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
//TODO
//    @Autowired
//    private TokensRedisService tokensRedisService;

}