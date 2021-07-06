package com.jinho.prj.member.map;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jinho.prj.member.vo.MemberVO;

public interface MemberMap {
	@Select("select * from member")
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo); 
	MemberVO memberLoginCheck(MemberVO vo); // 한사람정보와 로그인시 사용
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
