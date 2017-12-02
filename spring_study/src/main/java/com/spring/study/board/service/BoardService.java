package com.spring.study.board.service;

import java.util.List;

import com.spring.study.board.vo.BoardVO;

public interface BoardService {

	/**
	 * 게시판 글 등록
	 * @param boardVO
	 */
	public void insertBoard(BoardVO boardVO);
	
	/**
	 * 게시판 글 수정
	 * @param boardVO
	 */
	public void updateBoard(BoardVO boardVO);
	
	/**
	 * 게시판 글 삭제
	 * @param boardVO
	 */
	public void deleteBoard(BoardVO boardVO);
	
	/**
	 * 게시판 글 상세
	 * @param boardVO
	 * @return
	 */
	public BoardVO selectBoard(BoardVO boardVO);
	
	/**
	 * 게시판 글 목록
	 * @param boardVO
	 * @return
	 */
	public List<BoardVO> selectBoardList(BoardVO boardVO);
}
