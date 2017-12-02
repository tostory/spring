package com.spring.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.board.dao.BoardDAO;
import com.spring.study.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public void insertBoard(BoardVO boardVO) {
		boardDAO.insertBoard(boardVO);
	}
	
	public void updateBoard(BoardVO boardVO) {
		boardDAO.updateBoard(boardVO);
	}
	
	public void deleteBoard(BoardVO boardVO) {
		boardDAO.deleteBoard(boardVO);
	}
	
	public BoardVO selectBoard(BoardVO boardVO) {
		return boardDAO.selectBoard(boardVO);
	}
	
	public List<BoardVO> selectBoardList(BoardVO boardVO) {
		return boardDAO.selectBoardList(boardVO);
	}
}
