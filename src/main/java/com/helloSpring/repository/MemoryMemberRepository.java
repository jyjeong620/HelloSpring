package com.helloSpring.repository;

import com.helloSpring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));      // return 값이 Null 이어도 반환해줌
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();                             //store에서 name을 검색하여 하나라도있으면 반환 없을경우 Null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());         //store에 있는 값을 List로 반환
    }

    public void clearStore(){
        store.clear();
    }
}
