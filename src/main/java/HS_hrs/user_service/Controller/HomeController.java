package HS_hrs.user_service.Controller;


import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class HomeController {

  Environment env;

  public HomeController(Environment env) {
    this.env = env;
  }

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
}