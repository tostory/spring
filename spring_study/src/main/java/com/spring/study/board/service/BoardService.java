package com.spring.study.board.service;

import java.util.List;

import com.spring.study.board.vo.BoardVO;

public interface BoardService {

	public void insertBoard(BoardVO boardVO);
	
	public void updateBoard(BoardVO boardVO);
	
	public void deleteBoard(BoardVO boardVO);
	
	public BoardVO selectBoard(BoardVO boardVO);
	
	public List<BoardVO> selectBoardList(BoardVO boardVO);
}
