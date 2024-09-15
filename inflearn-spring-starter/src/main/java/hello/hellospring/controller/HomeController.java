package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 회원 등록, 조회를 할 수 있는 링크를 가지고 있는 컨트롤러
@Controller
public class HomeController {
    @GetMapping("/") // localhost:8080 들어오면 가장 먼저 호출된다.
    public String home(){
        return "home"; // home.html이 호출된다.
    }
}
