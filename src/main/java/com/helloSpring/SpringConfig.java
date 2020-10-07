package com.helloSpring;

import com.helloSpring.repository.JdbcMemberRepository;
import com.helloSpring.repository.JdbcTemplateMemberRepository;
import com.helloSpring.repository.MemberRepository;
import com.helloSpring.repository.MemoryMemberRepository;
import com.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 자바코드로 직접 스프링 빈 등록하는 방법
 */
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);          //Jdbc를 이용
        return new JdbcTemplateMemberRepository(dataSource);    //jdbcTemplate을 이용
    }
}
