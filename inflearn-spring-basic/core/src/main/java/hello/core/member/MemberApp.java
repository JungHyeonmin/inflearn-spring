package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// 순수 자바코드로 개발
public class MemberApp {
    public static void main(String[] args) {

        // MemberService memberService = new MemberServiceImpl();

        // AppConfig로 DIP, OCP를 지킨다.
        // AppConfig appConfig = new AppConfig(); // @Bean 추가
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // getBean("메서드 이름", 반환 타입)
        MemberService memberService
                = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
        System.out.println(findMember == member);
    }
}
