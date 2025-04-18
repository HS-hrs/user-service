package HS_hrs.user_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/user")
    public String home() {
        return "유저 서비스입니다.";
    }

}