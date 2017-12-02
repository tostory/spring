package com.spring.study.board.dao;

import java.util.List;

import com.spring.study.board.vo.BoardVO;

public interface BoardDAO {
	
	/**
	 * �Խ��� �� ���
	 * @param boardVO
	 * @return
	 */
	public int insertBoard(BoardVO boardVO);
	
	/**
	 * �Խ��� �� ����
	 * @param boardVO
	 * @return
	 */
	public int updateBoard(BoardVO boardVO);
	
	/**
	 * �Խ��� �� ����
	 * @param boardVO
	 * @return
	 */
	public int deleteBoard(BoardVO boardVO);
	
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
