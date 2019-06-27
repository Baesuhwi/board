package com.example.bsh.mapper;

import java.util.ArrayList;

import com.example.bsh.domain.PostVO;

public interface PostMapper {

	// 게시글 목록
	public ArrayList<PostVO> getPostList();

	// 글 등록하기
	public int postInsert(PostVO postVO);

	// 글 수정하기
	public int postUpdate(PostVO postVO);

	// 세부게시글 가져오기
	public PostVO getDetailPage(String post_code);

	// 글 삭제
	public int postDelete(int post_code);

	// 비밀번호 체크
	public PostVO passCheck(String id);

	// 댓글 가져오기
	public ArrayList<PostVO> getPostReply(String post_code);

}
