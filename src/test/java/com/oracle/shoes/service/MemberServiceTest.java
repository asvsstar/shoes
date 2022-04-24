package com.oracle.shoes.service;

import com.oracle.shoes.domain.MemberVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();


    @Test
    void 회원가입() {
        MemberVO memberVO = new MemberVO();
        memberVO.setUserId("test1");
        memberVO.setUserPass("1234");
        memberVO.setUserName("민호");
        memberVO.setUserAddr("강남구");
        memberVO.setUserMail("akrwosla@naver.com");
        memberVO.setUserPhon("010-2829-8698");

        String saveId = memberService.join(memberVO);


        MemberVO findMember = memberService.findOne(saveId).get();
        assertThat(memberVO.getUserId()).isEqualTo(findMember.getUserId());


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}