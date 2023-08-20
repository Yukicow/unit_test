package com.example.demo.controller;


import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;


    @PostMapping("/join")
    public ResponseEntity<JoinResponse> join(@RequestBody JoinForm form){
        Member member = memberService.join(form);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new JoinResponse(member.getName(), member.getAge()));
    }
}
