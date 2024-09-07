package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // "hello" 라는 url 로 오는 요청을 받는다.
    @GetMapping("hello")
    public String hello(Model model) { // 데이터를 전송할 Model 객체를 선언
        // model 에 data 라는 키와 "hello!!"라는 값을 넣는다.
        model.addAttribute("data", "hello!!");
        // hello.html 반환
        return "hello";
    }

    @GetMapping("hello-mvc")
    // @RequestParam : 웹에서 파라미터를 받을 때 사용
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }


    // api 는 데이터를 보여주기 위한 방식으로 json 방식으로 데이터를 전달한다. 뷰에서는 키:값 형태로 보여준다.
    @GetMapping("hello-api")
    @ResponseBody // HTTP <body>에 문자 내용을 직접 반환
                  // - 원래는 맞는 html 을 뷰로 보여주지만 ResponseBody 는 return 으로 작성한 것을 뷰로 보여준다.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // hello + name
    }

    static class Hello {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
