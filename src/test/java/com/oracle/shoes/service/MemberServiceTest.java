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
        memberVO.setUserPhon("010-0000-1111");

        String saveId = memberService.join(memberVO);


        MemberVO findMember = memberService.findOne(saveId).get();
        assertThat(memberVO.getUserId()).isEqualTo(findMember.getUserId());


    }

    @Test
    public  void 중복_회원_예외(){
        MemberVO memberVO1 = new MemberVO();
        memberVO1.setUserId("test1");
        memberVO1.setUserPass("1234");
        memberVO1.setUserName("민호");
        memberVO1.setUserAddr("강남구");
        memberVO1.setUserMail("akrwosla@naver.com");
        memberVO1.setUserPhon("010-0000-1111");

        MemberVO memberVO2 = new MemberVO();
        memberVO2.setUserId("test1");
        memberVO2.setUserPass("1234");
        memberVO2.setUserName("지선");
        memberVO2.setUserAddr("강남구");
        memberVO2.setUserMail("akrwosla@naver.com");
        memberVO2.setUserPhon("010-1111-0000");

        //
        memberService.join(memberVO1);
        assertThrows(IllegalStateException.class,()-> memberService.join(memberVO2));

        /*
        try {
            memberService.join(memberVO2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}