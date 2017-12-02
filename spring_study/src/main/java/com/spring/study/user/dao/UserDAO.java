package com.spring.study.user.dao;

import com.spring.study.user.vo.UserVO;

public interface UserDAO {
	
	/**
	 * 사용자 정보 조회
	 * @param userId
	 * @return
	 */
	public UserVO selectUser(String userId);

}
