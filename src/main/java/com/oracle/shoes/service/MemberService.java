package com.oracle.shoes.service;

import com.oracle.shoes.domain.MemberVO;
import com.oracle.shoes.repository.MemberRepository;
import com.oracle.shoes.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    * 회원 가입
    * */
    public String join(MemberVO memberVO){

        validateDuplicateMemberVO(memberVO);//같은 ID 중복 회원 검증

        memberRepository.save(memberVO);
        return memberVO.getUserId();
    }

    private void validateDuplicateMemberVO(MemberVO memberVO) {
        memberRepository.findByuserId(memberVO.getUserId())
           .ifPresent(m->{
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }
    /*
        전체 회원 조회
     */
    public List<MemberVO> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<MemberVO> findOne(String memberId){
        return memberRepository.findByuserId(memberId);
    }
}
