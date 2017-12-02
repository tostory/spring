package com.spring.study.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.study.user.vo.UserVO;

public interface UserService extends UserDetailsService {

	/**
	 * ����� ���� ��ȸ
	 * @param userId
	 * @return
	 */
	public UserVO selectUser(String userId);
}
