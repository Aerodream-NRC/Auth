package SocialNetwork.Auth.Services;

import SocialNetwork.Auth.Dto.UserDto;
import SocialNetwork.Auth.Enriries.UserEntity;

public interface IUserService {
    UserEntity registerNewUserAccount(UserDto userDto);
}