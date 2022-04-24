package com.oracle.shoes;

import com.oracle.shoes.repository.MemberRepository;
import com.oracle.shoes.repository.MemoryMemberRepository;
import com.oracle.shoes.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
