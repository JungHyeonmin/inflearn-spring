package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;


// 순수 자바코드로 개발
public class MemberApp {
    public static void main(String[] args) {

        // MemberService memberService = new MemberServiceImpl();

        // AppConfig로 DIP, OCP를 지킨다.
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
        System.out.println(findMember == member);
    }
}
