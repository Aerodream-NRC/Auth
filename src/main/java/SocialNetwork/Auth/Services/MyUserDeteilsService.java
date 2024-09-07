package SocialNetwork.Auth.Services;

import SocialNetwork.Auth.Entities.RoleEntiity;
import SocialNetwork.Auth.Entities.UserEntity;
import SocialNetwork.Auth.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MyUserDeteilsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername (String login) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + login);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, getAuthorities(user.getRole()));
    }
    private static List<GrantedAuthority> getAuthorities (List<RoleEntiity> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntiity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return authorities;
    }
}