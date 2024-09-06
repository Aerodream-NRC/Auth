package SocialNetwork.Auth.Repositories;

import SocialNetwork.Auth.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByLogin (String login);

}