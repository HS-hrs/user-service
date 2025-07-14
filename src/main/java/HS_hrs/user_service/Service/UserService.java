package HS_hrs.user_service.Service;

import HS_hrs.user_service.Entity.User;
import HS_hrs.user_service.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

public User getUserById(Integer userId) {
        return userRepository.findByUserId(userId)
            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
    }
}