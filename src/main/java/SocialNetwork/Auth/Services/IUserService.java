package SocialNetwork.Auth.Services;

import SocialNetwork.Auth.Dto.UserDto;
import SocialNetwork.Auth.Enriries.UserEntity;
import SocialNetwork.Auth.Exceptions.UserAlreadyExistException;

public interface IUserService {
    UserEntity registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException;
}