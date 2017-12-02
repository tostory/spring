package com.spring.study.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.study.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertBoard(BoardVO boardVO){
		return (Integer) sqlSessionTemplate.insert("insertBoard", boardVO);
	}
	
	public int updateBoard(BoardVO boardVO) {
		return (Integer) sqlSessionTemplate.update("updateBoard", boardVO);
	}
	
	public int deleteBoard(BoardVO boardVO) {
		return (Integer) sqlSessionTemplate.delete("deleteBoard", boardVO);
	}
	
	public BoardVO selectBoard(BoardVO boardVO) {
		return sqlSessionTemplate.selectOne("selectBoard", boardVO);
	}
	
	public List<BoardVO> selectBoardList(BoardVO boardVO) {
		return sqlSessionTemplate.selectList("selectBoardList", boardVO);
	}
}
