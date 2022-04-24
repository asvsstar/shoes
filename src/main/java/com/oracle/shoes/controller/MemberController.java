package com.oracle.shoes.controller;

import com.oracle.shoes.domain.MemberVO;
import com.oracle.shoes.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        MemberVO memberVO = new MemberVO();
        memberVO.setUserId(form.getUserId());
        memberVO.setUserPass(form.getUserPass());
        memberVO.setUserName(form.getUserName());
        memberVO.setUserPhon(form.getUserPhon());

        System.out.println("memberVO = " + memberVO);
        memberService.join(memberVO);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<MemberVO> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
