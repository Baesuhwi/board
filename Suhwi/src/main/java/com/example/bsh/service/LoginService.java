package com.example.bsh.service;

import java.util.ArrayList;

import com.example.bsh.domain.MemberVO;

public interface LoginService {

	// 로그인
	public ArrayList<MemberVO> getLogin(String id);

}
