package com.spring.study.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.study.user.vo.UserVO;

public interface UserService extends UserDetailsService {

	/**
	 * 사용자 정보 조회
	 * @param userId
	 * @return
	 */
	public UserVO selectUser(String userId);
}
