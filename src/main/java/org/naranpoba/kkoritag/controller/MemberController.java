package org.naranpoba.kkoritag.controller;


import org.naranpoba.kkoritag.dto.MemberDTO;
import org.naranpoba.kkoritag.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberController {
	//생성자 주입
	@Autowired
	private MemberService memberService;
	
	//회원가입 페이지 출력 요청
	@GetMapping("/save")
	public String saveForm() {
		return "save.html";
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody MemberDTO memberDTO) {
		System.out.println("MemberController.save");
		System.out.println("memberDTO= " +memberDTO);
		memberService.save(memberDTO);
		
		ResponseEntity<String> responseEntity = new ResponseEntity<>("save ok", HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		MemberDTO loginResult = memberService.login(memberDTO);
		if (loginResult !=null) {
			//login 성공
			session.setAttribute("loginEmail", loginResult.getMemberEmail());
			return "main.html";
		}else {
			//login 실패
			return"login.html";
		}
	}

}
