package hello.core.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

// MemberRepository 구현체
public class MemoryMemberRepository implements MemberRepository {

    //  ConcurrentHashMap 이란?
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        // HashMap put 메서드
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        // HashMap get 메서드
        return store.get(memberId);
    }
}