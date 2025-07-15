package HS_hrs.user_service.Controller;

import HS_hrs.user_service.Dto.LoginRequest;
import HS_hrs.user_service.Util.JwtProvider;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final JwtProvider jwtProvider;

    @PostMapping
    @Operation(summary = "로그인", description = "userId와 password로 로그인 JWT 토큰 발급")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (123 == request.getUserId() && "password".equals(request.getPassword())) {
            String token = jwtProvider.generateToken(request.getUserId());
            return ResponseEntity.ok(Map.of("accessToken", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("실패");
        }
    }
}