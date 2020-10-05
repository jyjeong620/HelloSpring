package com.helloSpring.controller;

import com.helloSpring.domain.Member;
import com.helloSpring.service.MemberService;
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

    /**
     * 회원가입 버튼을 눌렀을 경우 뷰리졸브가 members/createMemberForm를 호출
     * @return
     */
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    /**
     * members/createMemberForm 화면에서 input으로 텍스트를 입력받았을때 post방식으로 호출하는 메소드
     * @return
     */
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member= new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
