package SocialNetwork.Auth.Pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class LoginRequest {

    @NonNull
    private String login;

    @NonNull
    private String password;
}
