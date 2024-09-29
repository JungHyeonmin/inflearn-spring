package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Slf4j
@RestController
public class LogTestController {

    // @Slf4J 로 객체 자동 생성
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // System.out.println("name = " + name); // 과거

        log.trace("trace log ={}", name);
        log.debug("debug log ={}", name);

        log.info("info log ={}", name);
        log.warn("warn log ={}", name);
        log.error("error log ={}", name);

        return "ok"; // restController라서 뷰 대신 해당 문자열을 반환
    }
}
