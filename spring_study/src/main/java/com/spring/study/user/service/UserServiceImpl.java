package com.spring.study.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.study.user.dao.UserDAO;
import com.spring.study.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired     
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDAO.selectUser(username);
		
		List<GrantedAuthorityImpl> authorities = new ArrayList<>();
		authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		
		return new User(username, userVO.getPassword(), authorities);
	}
	
	@Override
	public UserVO selectUser(String userId) {
		return userDAO.selectUser(userId);
	}
}
