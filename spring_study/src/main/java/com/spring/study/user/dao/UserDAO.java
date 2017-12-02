package com.spring.study.user.dao;

import com.spring.study.user.vo.UserVO;

public interface UserDAO {
	
	public UserVO selectUser(String userId);

}
