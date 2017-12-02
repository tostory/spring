package com.spring.study.board.service;

import java.util.List;

import com.spring.study.board.vo.BoardVO;

public interface BoardService {

	/**
	 * �Խ��� �� ���
	 * @param boardVO
	 */
	public void insertBoard(BoardVO boardVO);
	
	/**
	 * �Խ��� �� ����
	 * @param boardVO
	 */
	public void updateBoard(BoardVO boardVO);
	
	/**
	 * �Խ��� �� ����
	 * @param boardVO
	 */
	public void deleteBoard(BoardVO boardVO);
	
	/**
	 * �Խ��� �� ��
	 * @param boardVO
	 * @return
	 */
	public BoardVO selectBoard(BoardVO boardVO);
	
	/**
	 * �Խ��� �� ���
	 * @param boardVO
	 * @return
	 */
	public List<BoardVO> selectBoardList(BoardVO boardVO);
}
