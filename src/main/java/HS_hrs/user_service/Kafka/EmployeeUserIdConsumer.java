package HS_hrs.user_service.Kafka;

import HS_hrs.user_service.Entity.User;
import HS_hrs.user_service.Repository.UserRepository;
import com.example.Dto.EmployeeUserIdSendEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeUserIdConsumer {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "userId", groupId = "user-group")
    public void consume(String message) {

        try {
            EmployeeUserIdSendEvent event = objectMapper.readValue(message, EmployeeUserIdSendEvent.class);
            Integer userId = event.getUserId();
            User user = User.createWithUserId(userId);

            userRepository.save(user);

            System.out.println("userId 등록: " + event.getUserId());
        } catch (Exception e) {
            System.err.println("kafka 처리 실패: " + e.getMessage());

        }
    }
}