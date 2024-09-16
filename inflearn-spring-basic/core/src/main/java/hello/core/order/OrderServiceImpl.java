package hello.core.order;

import hello.core.discoount.DiscountPolicy;
import hello.core.discoount.FixDiscountPolicy;
import hello.core.discoount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {



    // 구현체가 어떤 repo를 사용할 것인지 초기화하는 것은
    // 기획자(AppConfig)가 아니라 배우(구현체)가 상대 배우를 고르는 것과 같다.
    // 저장하기 위한 DB repo
    private final MemberRepository memberRepository;

    // 이렇게 선언해야 인터페이스에만 의존한는 것이다!!!(⭐DIP 지킴⭐)
    // 우리가 스프링에서 @Autowired 했던 방식이다!!!
    // 하지만 이대로 사용하는 것은 객체를 생성하지 않았기 때문에 에러가 발생한다.
    // 해결하기 위해서는 누군가가 `OrderServiceImpl`에 `DiscountPolicy`의 구현 객체를 대신 생성하고 주입해줘야 한다!!
    // -> Spring
    private final DiscountPolicy discountPolicy;

    /*
    // 할인 정책 인터페이스 구현체 호출
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    
    // 할인 정책 변경
    // 역할과 구현을 분리했고, 다형성도 활용했지만 DIP,OCP는 지켜지지 않았다.
    // DIP : 의존 역전 원칙(인터페이스에만 의존). 인터페이스 구현체도 의존하고 있다..
    // OCP : 개방 폐쇄 원칙. Fix에서 Rate로 변경하는 순간! OCP 위반이다..
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    */

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
