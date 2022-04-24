package com.oracle.shoes.repository;

import com.oracle.shoes.domain.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<String, MemberVO> store = new HashMap<>();

    @Override
    public MemberVO save(MemberVO memberVO) {
        store.put(memberVO.getUserId(),memberVO);
        store.put(memberVO.getUserPass(),memberVO);
        store.put(memberVO.getUserName(),memberVO);
        store.put(memberVO.getUserMail(),memberVO);
        store.put(memberVO.getUserPhon(),memberVO);
        store.put(memberVO.getUserAddr(),memberVO);
        return null;
    }

    @Override
    public Optional<MemberVO> findByuserId(String userId) {
        return Optional.ofNullable(store.get(userId));
    }

    @Override
    public Optional<MemberVO> findMyuserName(String userName) {
        return store.values().stream()
                .filter(memberVO -> memberVO.getUserName().equals(userName))
                .findAny();
    }

    @Override
    public List<MemberVO> findAll() {
        return new ArrayList<>(store.values());
    }


    public void clearStore(){
        store.clear();
    }
}
