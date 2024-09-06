package SocialNetwork.Auth.Dto;

import SocialNetwork.Auth.Configurers.PasswordMatches;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@PasswordMatches
public class UserDto {

    @NonNull
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String password;
    private String matchingPassword;

    @NonNull
    private String login;

    private List<String> roles;
}
