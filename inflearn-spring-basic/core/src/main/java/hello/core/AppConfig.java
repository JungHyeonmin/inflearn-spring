package hello.core;

// AppConfig : 애플리케이션의 전체 동작 방식을 구성(config)하기 위해,
//             구현객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스

import hello.core.discoount.DiscountPolicy;
import hello.core.discoount.FixDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {


    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy()
        );
    }
}
