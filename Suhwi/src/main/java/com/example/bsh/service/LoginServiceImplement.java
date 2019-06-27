package com.example.bsh.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.bsh.domain.MemberVO;
import com.example.bsh.mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImplement implements LoginService  {
	private MemberMapper memberMapper;
	
	@Override
	public ArrayList<MemberVO> getLogin(String id) {
		return memberMapper.getLogin(id);
	}

}
