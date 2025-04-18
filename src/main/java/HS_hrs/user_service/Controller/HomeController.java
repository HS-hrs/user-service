package HS_hrs.user_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HomeController {

    @GetMapping
    public String home() {
        return "유저 서비스입니다.";
    }

}