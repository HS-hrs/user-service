package HS_hrs.user_service.Repository;

import HS_hrs.user_service.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(@Param("userId") Integer userId);
}