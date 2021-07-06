package com.jinho.prj;

import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinho.prj.common.BouncyModule;

@Controller
public class HomeController {
	
	@RequestMapping("home.do")
	public String home(Model model) throws NoSuchAlgorithmException {
		BouncyModule bn = new BouncyModule();
		String plainText = "1020201-29124851"; // 평문
		byte[] bytes = bn.encrypt(plainText);
		String cyperText = Base64.toBase64String(bytes); // 암호화
		String decrytionText = Base64.toBase64String(bn.decrypt(cyperText)); //복호화
		
		//Encryption enc = new Encryption(); // 암호화 메소드 생성
		model.addAttribute("plainText", plainText);
		model.addAttribute("cyperText", cyperText);
		model.addAttribute("decrytionText", decrytionText);
		return "home";
	}
	
	@RequestMapping("step1")
	public String step1(Model model) {
		return "step1";
	}
}
