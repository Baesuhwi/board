package com.example.bsh.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.example.bsh.domain.MemberVO;

public interface MemberMapper {

	// 로그인
	public ArrayList<MemberVO> getLogin(@Param("id")String id);

}
