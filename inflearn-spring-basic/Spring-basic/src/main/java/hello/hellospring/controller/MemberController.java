package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberSercice;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberSercice = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberSercice.join(member);
        return "redirect:/"; // 처음 페이지로 이동
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberSercice.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
