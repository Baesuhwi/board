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
import com.example.bsh.domain.PostVO;
import com.example.bsh.service.PostService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@AllArgsConstructor
public class PostController {
	private PostService postService;
	
	/* 게시판 메인 */
	@RequestMapping(value = "/boardMain", method = RequestMethod.GET)
	public String boardMain() {
		return "boardMain";
	}
	
	/* 게시판 목록 출력 */
	@ResponseBody
	@RequestMapping(value = "/postList", method = RequestMethod.POST)
	public JSONObject postList() {

		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<PostVO> postList = postService.getPostList();
		
		JSONArray jpostList = JSONArray.fromObject(postList);
		map.put("result", jpostList);
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	//////////////////////////////////////////////////////////////////
	/* 글쓰기 페이지 이동 */
	@RequestMapping(value = "/postWriteMain", method = RequestMethod.GET)
	public String postWriteMain() {
		return "postWrite";
	}
	
	/* 글 등록하기 */
	@ResponseBody
	@RequestMapping(value = "/postInsert", method = RequestMethod.POST)
	public JSONObject postInsert(PostVO postVO, HttpSession session) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		postVO.setId((String)session.getAttribute("id"));
		
		int checkNum = postService.postInsert(postVO);
		map.put("result", checkNum);
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	//////////////////////////////////////////////////////////////////
	/* 세부게시글 이동 */
	@RequestMapping(value = "/detailPage", method = RequestMethod.GET)
	public String detailPage() {
		return "detailPage";
	}
	
	/* 세부게시글 가져오기 or 글 수정할때 데이터 불러오기용*/
	@ResponseBody
	@RequestMapping(value = "/getDetailPage", method = RequestMethod.POST)
	public JSONObject getDetailPage(@RequestParam("post_code") String post_code) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		PostVO postvo = postService.getDetailPage(post_code);
		
		JSONArray jpostvo = JSONArray.fromObject(postvo);
		map.put("result", jpostvo);
		System.out.println("jpostvo: " + jpostvo);
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	
	//////////////////////////////////////////////////////////////////
	
	/* 글 수정하기 */
	@ResponseBody
	@RequestMapping(value = "/postUpdate", method = RequestMethod.POST)
	public JSONObject postUpdate(PostVO postVO, HttpSession session) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		
		if(!(postVO.getId().equals((String)session.getAttribute("id")))) {
			Map<String, String> err_map = new HashMap<String, String>();
			err_map.put("result", "fail");
			
			JSONObject json = JSONObject.fromObject(err_map);
			return json;
		}
		int checkNum = postService.postUpdate(postVO);
		map.put("result", checkNum);
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	/* 글 삭제하기 */
	@ResponseBody
	@RequestMapping(value = "/postDelete", method = RequestMethod.POST)
	public JSONObject postDelete(PostVO postVO, HttpSession session) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		
		if(!(postVO.getId().equals((String)session.getAttribute("id")))) {
			Map<String, String> err_map = new HashMap<String, String>();
			err_map.put("result", "fail");
			
			JSONObject json = JSONObject.fromObject(err_map);
			return json;
		}
		int checkNum = postService.postDelete(postVO.getPost_code());
		map.put("result", checkNum);
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	//////////////////////////////////////////////////////////////////
	
	/* 글 수정 비밀번호 확인 메소드 */
	@ResponseBody
	@RequestMapping(value = "/passCheck", method = RequestMethod.POST)
	public JSONObject passCheck(@RequestParam String pass, HttpSession session) {

		Map<String, Object> map = new HashMap<String, Object>();
		String id = (String)session.getAttribute("id");
		PostVO postvo = postService.passCheck(id);
		
		if(!(postvo.getPw().equals(pass))) {
			Map<String, String> err_map = new HashMap<String, String>();
			err_map.put("result", "fail");
			
			JSONObject json = JSONObject.fromObject(err_map);
			return json;
		}
		map.put("result", "success");
		
		JSONObject json = JSONObject.fromObject(map);
//		
		return json;
	}
	
	/* 글 삭제 비밀번호 확인 메소드 */
	@ResponseBody
	@RequestMapping(value = "/DelpassCheck", method = RequestMethod.POST)
	public JSONObject DelpassCheck(@RequestParam String pass, HttpSession session, PostVO postVO) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		String id = (String)session.getAttribute("id");
		PostVO postvo = postService.passCheck(id);
		
		if(!(postvo.getPw().equals(pass))) {
			Map<String, String> err_map = new HashMap<String, String>();
			err_map.put("result", "fail");
			
			JSONObject json = JSONObject.fromObject(err_map);
			return json;
		}
		
		int checkNum = postService.postDelete(postVO.getPost_code());
		map.put("result", checkNum);
		
		JSONObject json = JSONObject.fromObject(map);		

		return json;
	}
	
	//////////////////////////////////////////////////////////////////
	
	/* 댓글 출력 */
	@ResponseBody
	@RequestMapping(value = "/postReply", method = RequestMethod.POST)
	public JSONObject reply(@RequestParam String post_code, HttpSession session, PostVO postVO) {
		System.out.println("이거뭐냐???" + post_code);
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<PostVO> postReply = postService.getPostReply(post_code);
		
		JSONArray jpostReply = JSONArray.fromObject(postReply);
		map.put("result", jpostReply);
		
		JSONObject json = JSONObject.fromObject(map);
		System.out.println("댓글: " + json);
		
		return json;
	}
}
