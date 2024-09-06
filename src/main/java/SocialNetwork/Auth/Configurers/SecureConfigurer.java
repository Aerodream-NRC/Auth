package SocialNetwork.Auth.Configurers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static SocialNetwork.Auth.Enums.Roles.Names.USER;
//TODO
//@Configuration
//@EnableMethodSecurity
//public class SecureConfigurer {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/reg").permitAll()
//                );
//        return httpSecurity.build();
//
//    }
//}
