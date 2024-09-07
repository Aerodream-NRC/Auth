package SocialNetwork.Auth.Repositories;

import SocialNetwork.Auth.Entities.RoleEntiity;
import SocialNetwork.Auth.Enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntiity, Long> {

    RoleEntiity findByRole (Role role);

}