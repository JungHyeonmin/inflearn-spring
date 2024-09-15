
package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    // Optional : id, name을 반환하는 데 null값이 있을 수 있다.
    //            요즘은 null 대신 Optional을 이용해서 반환하는 것을 선호한다.
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}