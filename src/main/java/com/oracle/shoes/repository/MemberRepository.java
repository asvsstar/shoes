package com.oracle.shoes.repository;

import com.oracle.shoes.domain.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberVO save(MemberVO memberVO);
    Optional<MemberVO> findByuserId(String userId);
    Optional<MemberVO> findMyuserName(String userName);
    List<MemberVO> findAll();
}
