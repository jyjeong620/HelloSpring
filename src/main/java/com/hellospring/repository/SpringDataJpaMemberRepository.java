package com.hellospring.repository;

import com.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository           ???@Repository 어노테이션은 따로 안적어도 되는건가 ?
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
