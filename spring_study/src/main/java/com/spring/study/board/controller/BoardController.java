package com.spring.study.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.study.board.service.BoardService;
import com.spring.study.board.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	@RequestMapping(value="/dataList.do")
	public String getBoardList(HttpServletRequest request, HttpServletResponse response
			, BoardVO vo
			, Model model){
		
		model.addAttribute("boardList", boardService.selectBoardList(vo));
		return "/board/dataList";
	}
	
	@RequestMapping(value="/data.do")
	public String getBoard(HttpServletRequest request, HttpServletResponse response
			, BoardVO vo
			, Model model){
		
		model.addAttribute("board", boardService.selectBoard(vo));
		return "/board/data";
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard(HttpServletRequest request, HttpServletResponse response){
		return "/board/insertBoard";
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(HttpServletRequest request, HttpServletResponse response
			, BoardVO vo ){
		
		boardService.insertBoard(vo);
		return "redirect:dataList.do";
	}
	
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(HttpServletRequest request, HttpServletResponse response
			, BoardVO vo){
		
		boardService.updateBoard(vo);
		return "redirect:data.do?seq="+vo.getSeq();
	}

	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.GET)
	public String deleteBoard(HttpServletRequest request, HttpServletResponse response
			, BoardVO vo) {
		
		boardService.deleteBoard(vo);
		return "redirect:dataList.do";
	}
}
