package hello.core;

// AppConfig : 애플리케이션의 전체 동작 방식을 구성(config)하기 위해,
//             구현객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스

import hello.core.discoount.DiscountPolicy;
import hello.core.discoount.FixDiscountPolicy;
import hello.core.discoount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 각 생성자의 역할들을 명확하게 알아볼 수 있도록 하는 것이 중요하다!! -> ctrl + art + m

public class AppConfig {


    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 할인 정책 선택 - 할인 정책을 선택하는 것으로 간단하게 수정할 수 있다.
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy(); // 무조건 1000원 할인
        return new RateDiscountPolicy(); // 가격별 10% 할인
    }


    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
