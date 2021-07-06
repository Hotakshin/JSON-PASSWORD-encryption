package com.jinho.prj.member.web;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jinho.prj.common.Encryption;
import com.jinho.prj.member.service.MemberService;
import com.jinho.prj.member.vo.MemberVO;

@Controller
@ResponseBody
public class MemberController {
	@Autowired
	MemberService memberDao;
	
	@RequestMapping("memberInsertForm")
	public String memberInsertForm(Model model,@ModelAttribute("member") MemberVO vo) {
		List<String> loginType = new ArrayList<String>();
		loginType.add("일반회원");
		loginType.add("기업회원");
		loginType.add("기타회원");
		model.addAttribute("loginType", loginType);
		return "member/memberInsertForm";
	}
	
	@RequestMapping("memberRegister")
	public String memberRegister(Model model, MultipartFile file,MemberVO vo) throws IOException, NoSuchAlgorithmException {
		Encryption enc = new Encryption();
		file = vo.getFile();
		String fileName = file.getOriginalFilename();
		// DB 입력 후
		vo.setPassword(enc.typeTwo(vo.getPassword()));
		vo.setFilename(fileName);
		int n = memberDao.memberInsert(vo);
		if(n != 0) {
			model.addAttribute("message", "입력성공");
		} else {
			model.addAttribute("message", "입력실패");
		}
		// 파일업로드
		
		return "member/memberRegister";
	}
	//@ModelAttribute("member") 는 수정 삭제 할때 쓴다 (내 페이지에서 내 페이지로 다시 리다이렉트 할때)
	@RequestMapping("memberLoginForm")
	public String memberLoginForm(@ModelAttribute("member")MemberVO
			vo, HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		model.addAttribute("id", id);
		
		return "member/memberLoginForm";
	}
	
	@RequestMapping("memberList")
	public String memberList(MemberVO vo, Model model) {
		List<MemberVO> list = memberDao.memberSelectList();
		model.addAttribute("members", list);
		return "member/memberList";
	}
	
	@PostMapping("memberLogin")
	public String memberLogin(MemberVO vo, Model model, HttpSession session) throws NoSuchAlgorithmException {
		Encryption enc = new Encryption();
		vo.setPassword(enc.typeTwo(vo.getPassword()));
		vo = memberDao.memberLoginCheck(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getEmail());	//	Session 만들기
			session.setAttribute("name", vo.getName());
			model.addAttribute("member", vo);
		} else {
			session.invalidate();
		}
		return "member/memberLogin";
	}
}
