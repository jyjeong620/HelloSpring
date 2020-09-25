package com.helloSpring.service;

import com.helloSpring.domain.Member;
import com.helloSpring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 꿀팁!! 해당 메소드에서 Ctrl + Shift + T 를 누를 경우 해당 메서드에 대한 테스트 코드가 자동으로 만들어짐!!!
 * 테스트코드는 메소드명을 한글로 해도 상관은 없다
 */
class MemberServiceTest {

    MemberService memberService ;

    //두개를 선언할 경우 뭔가 찝찝함 (MemberService 에서 선언한 repository 랑 밑에선언한 rep랑 다르기때문) 그래서 밑에처럼 선언
//    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    MemoryMemberRepository memoryMemberRepository;

    /**
     * 실행하기전에 실행해주는것
     */
    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        //밑에  try catch 문을 사용하기보단 assertThrows 이용하여 테스트 하는게 더 좋은 코드다
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try{
            memberService.join(member2);
            fail("예외가 발생해야합니다");
        }
        catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}