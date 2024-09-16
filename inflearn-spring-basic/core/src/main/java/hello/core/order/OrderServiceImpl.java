package hello.core.order;

import hello.core.discoount.DiscountPolicy;
import hello.core.discoount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 저장하기 위한 DB repo
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인 정책 인터페이스 구현체 호출
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
