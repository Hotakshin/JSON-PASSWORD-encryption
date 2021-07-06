package com.jinho.prj.member.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jinho.prj.member.service.MemberService;
import com.jinho.prj.member.vo.MemberVO;


@RestController
public class MemberResetController {
	
	@Autowired
	private MemberService memberDao;
	
	@RequestMapping(value="api/members", method = {RequestMethod.GET, RequestMethod.POST})
	public List<MemberVO> members(){
		return memberDao.memberSelectList();
	}
	
	@RequestMapping("ajax/memberList")
	@ResponseBody
	public List<MemberVO> memberList(@RequestBody String body){
		System.out.println(body);
		return memberDao.memberSelectList();
	}

}
