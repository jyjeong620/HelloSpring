package com.helloSpring;

import com.helloSpring.repository.MemberRepository;
import com.helloSpring.repository.MemoryMemberRepository;
import com.helloSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 자바코드로 직접 스프링 빈 등록하는 방법
 */
//@Configuration
//public class SpringConfig {
//
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}
