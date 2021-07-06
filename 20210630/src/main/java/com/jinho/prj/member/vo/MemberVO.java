package com.jinho.prj.member.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVO {
	private String email;
	private String name;
	private String password;
	private String state;
	private String filename;
	private String directory;
	private String fileuuid;
	private String gubun;
	
	private MultipartFile file;
}
