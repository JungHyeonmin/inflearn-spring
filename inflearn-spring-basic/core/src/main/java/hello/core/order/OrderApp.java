package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        // MemberService memberService = new MemberServiceImpl();
        // OrderService orderService = new OrderServiceImpl();


        // AppConfig로 DIP, OCP를 지킨다.
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        // 스프링 컨테이너를 만든다. AppConfig 클래스를 파라미터를 넘긴다.
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // getBean(@"Configuration의 메서드(생성자)", 타입)
        MemberService memberService = ctx.getBean("memberService",MemberService.class);
        OrderService orderService = ctx.getBean("orderService",OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); // 멤버 생성
        memberService.join(member); // 멤버 저장


        Order order = orderService.createOrder(memberId, "itemA", 30000);

        System.out.println("order = " + order);
    }
}
