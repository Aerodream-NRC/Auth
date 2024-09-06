package SocialNetwork.Auth.Services;

import SocialNetwork.Auth.Dto.UserDto;
import SocialNetwork.Auth.Entities.UserEntity;
import SocialNetwork.Auth.Exceptions.UserAlreadyExistException;
import SocialNetwork.Auth.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (loginExists(userDto.getLogin())) {
            throw new UserAlreadyExistException("There is an account with that login: "
                    + userDto.getLogin());
        }
        UserEntity user = new UserEntity();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setLogin(userDto.getLogin());
        user.setRoles(List.of("USER"));

        return userRepository.save(user);
    }
    private boolean loginExists(String login) {
        return userRepository.findByLogin(login) != null;
    }
}
