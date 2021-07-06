package com.jinho.prj.member.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jinho.prj.member.map.MemberMap;
import com.jinho.prj.member.service.MemberService;
import com.jinho.prj.member.vo.MemberVO;

@Repository("memberDao")
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMap map;
	
	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public MemberVO memberLoginCheck(MemberVO vo) {
		return map.memberLoginCheck(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}
	
}
