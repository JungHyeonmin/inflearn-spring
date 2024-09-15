package hello.core.member;


// MemberService 구현체
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    
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
