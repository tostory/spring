package com.spring.study.user.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.study.user.vo.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	public UserVO selectUser(String userId) {
		return sqlSessionTemplate.selectOne("selectUser", userId);
	}

}
