package com.oracle.shoes.repository;

import com.oracle.shoes.domain.MemberVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        MemberVO memberVO = new MemberVO();
        memberVO.setUserId("test");
        memberVO.setUserPass("1234");
        memberVO.setUserName("민호");
        memberVO.setUserAddr("강남구");
        memberVO.setUserMail("akrwosla@naver.com");
        memberVO.setUserPhon("010-2829-8698");

        repository.save((memberVO));

        MemberVO result = repository.findByuserId(memberVO.getUserId()).get();
        assertThat(memberVO).isEqualTo(result);
    }

    @Test
    public void findByName(){
        MemberVO memberVO1 = new MemberVO();
        memberVO1.setUserId("test1");
        memberVO1.setUserPass("1234");
        memberVO1.setUserName("민호");
        memberVO1.setUserAddr("강남구");
        memberVO1.setUserMail("akrwosla@naver.com");
        memberVO1.setUserPhon("010-2829-8698");
        repository.save((memberVO1));

        MemberVO memberVO2 = new MemberVO();
        memberVO2.setUserId("test2");
        memberVO2.setUserPass("1234");
        memberVO2.setUserName("민호");
        memberVO2.setUserAddr("강남구");
        memberVO2.setUserMail("akrwosla@naver.com");
        memberVO2.setUserPhon("010-2829-8698");
        repository.save((memberVO2));


        MemberVO result = repository.findByuserId("test1").get();

        assertThat(result).isEqualTo(memberVO1);

    }

    @Test
    public void findAll(){
        MemberVO memberVO1 = new MemberVO();
        memberVO1.setUserId("test1");
        memberVO1.setUserPass("1234");
        memberVO1.setUserName("민호");
        memberVO1.setUserAddr("강남구");
        memberVO1.setUserMail("akrwosla@naver.com");
        memberVO1.setUserPhon("010-2829-8698");
        repository.save((memberVO1));

        MemberVO memberVO2 = new MemberVO();
        memberVO2.setUserId("test2");
        memberVO2.setUserPass("1234");
        memberVO2.setUserName("민호");
        memberVO2.setUserAddr("강남구");
        memberVO2.setUserMail("akrwosla@naver.com");
        memberVO2.setUserPhon("010-2829-8698");
        repository.save((memberVO2));

        List<MemberVO> result = repository.findAll();
        assertThat(result.size()).isEqualTo(7);
    }
}
