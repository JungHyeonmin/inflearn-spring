package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    OrderService orderService;

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig AppConfig = new AppConfig();
        memberService = AppConfig.memberService();
        orderService = AppConfig.orderService();
    }

    @Test
    void createOrder() {

        // given
        Long memberId = 1L;

        // when
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // then
        Order order = orderService.createOrder(memberId, "iteamA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
