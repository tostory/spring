package com.spring.study.board.dao;

import java.util.List;

import com.spring.study.board.vo.BoardVO;

public interface BoardDAO {
	
	public int insertBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
	public int deleteBoard(BoardVO boardVO);
	
	public BoardVO selectBoard(BoardVO boardVO);
	
	public List<BoardVO> selectBoardList(BoardVO boardVO);
}
