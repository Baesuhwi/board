package com.example.bsh.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.bsh.domain.PostVO;
import com.example.bsh.mapper.PostMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImplement implements PostService {
	private PostMapper postMapper;
	
	@Override
	public ArrayList<PostVO> getPostList() {
		return postMapper.getPostList();
	}

	// 글 등록하기
	@Override
	public int postInsert(PostVO postVO) {
		return postMapper.postInsert(postVO);
	}

	// 글 수정하기
	@Override
	public int postUpdate(PostVO postVO) {
		return postMapper.postUpdate(postVO);
	}

	// 세부게시글 가져오기
	@Override
	public PostVO getDetailPage(String post_code) {
		return postMapper.getDetailPage(post_code);
	}

	// 글 삭제
	@Override
	public int postDelete(int post_code) {
		return postMapper.postDelete(post_code);
	}

	// 비밀번호 체크
	@Override
	public PostVO passCheck(String id) {
		return postMapper.passCheck(id);
	}

	// 댓글 가져오기
	@Override
	public ArrayList<PostVO> getPostReply(String post_code) {
		return postMapper.getPostReply(post_code);
	}

}
