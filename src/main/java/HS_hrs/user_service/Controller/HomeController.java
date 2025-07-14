package HS_hrs.user_service.Controller;


import HS_hrs.user_service.Dto.UserResponseVacationDto;
import HS_hrs.user_service.Entity.User;
import HS_hrs.user_service.Service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class HomeController {

 private final Environment env;
 private final UserService userService;


    @GetMapping
    @Operation(summary = "유저 서비스 홈", description = "유저 서비스 기본 엔드포인트")
    public String home() {
        return "유저 서비스입니다.";
    }

    @GetMapping("/check")
    @Operation(summary = "서버 포트 확인", description = "서버 포트 확인 엔드포인트")
    public String check(HttpServletRequest request) {
      log.info("Server port={}", request.getServerPort());
      return String.format("Check from Server running at port %s", env.getProperty("local.server.port"));

    }

    @GetMapping("/{userId}")
    @Operation(summary = "유저 아이디 USER_ID", description = "유저 아이디")
    @Parameters({
        @Parameter(name = "userId",description = "userId", in = ParameterIn.PATH),
    })
    public ResponseEntity<UserResponseVacationDto> getUserByUserId(@PathVariable("userId")  Integer userId) {
      User user = userService.getUserById(userId);

      return ResponseEntity.ok(UserResponseVacationDto.fromEntity(user));
    }
}