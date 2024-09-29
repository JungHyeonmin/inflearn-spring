package hello.core.discoount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    // RateDiscountPolicy 가 정말 10%할인하는 지 확인하는 테스트 코드
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {

        // given // member 가 주어지고
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when // 할인을 적용했을 때
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then // 결과가 지금과 같은지 확인한다.
        System.out.println(discount);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        // given // BASIC은 할인 없음
        Member member = new Member(2L, "memberVIP", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // given
        System.out.println(discount);
        assertThat(discount).isEqualTo(0);
    }
}