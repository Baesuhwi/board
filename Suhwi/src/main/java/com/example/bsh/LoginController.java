package com.example.bsh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bsh.domain.MemberVO;
import com.example.bsh.service.LoginService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;

@Controller
@AllArgsConstructor
public class LoginController {
	private LoginService loginService;
	
	/* 제일 첫 화면이동 메소드 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	/* 로그인 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONObject login(@RequestParam String id, @RequestParam String password, HttpSession session) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<MemberVO> member = loginService.getLogin(id);
		System.out.println(member);
		
		if(member.size() > 0) {
			if(id.equals(member.get(0).getId())) {
				if(password.equals(member.get(0).getPw())) { // 로그인 성공
					System.out.println("로그인 성공");
					session.setAttribute("id", member.get(0).getId());
					map.put("result", 0);
				}else {
					System.out.println("비밀번호 불일치");
					map.put("result", 2);
				}
			}else {
				System.out.println("아이디 불일치");
				map.put("result", 1);
			}
		}
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
}
