package hello.core.member;


// MemberService 구현체
public class MemberServiceImpl implements MemberService {

    // 구현체가 어떤 repo를 사용할 것인지 초기화하는 것은
    // 기획자(AppConfig)가 아니라 배우(구현체)가 상대 배우를 고르는 것과 같다.
    // 저장하기 위한 DB repo

    private final MemberRepository memberRepository; // DIP를 잘 지키고 있다..

    // 생성자를 이용해서 구현체 결정 // 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 할인 정책 인터페이스 구현체 호출
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 할인 정책 변경
    // 역할과 구현을 분리했고, 다형성도 활용했지만 DIP,OCP는 지켜지지 않았다.
    // DIP : 의존 역전 원칙(인터페이스에만 의존). 인터페이스 구현체도 의존하고 있다..
    // OCP : 개방 폐쇄 원칙. Fix에서 Rate로 변경하는 순간! OCP 위반이다..
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    
    // 회원 추가 기능
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    // 회원을 memberId 로 조회하는 기능
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
