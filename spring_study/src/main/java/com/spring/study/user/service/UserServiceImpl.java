package com.spring.study.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 * spring security userService.loadUserByUsername override
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDAO.selectUser(username);
		
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority(userVO.getRole()));
		
		return new User(username, userVO.getPassword(), authList);
	}
	
	@Override
	public UserVO selectUser(String userId) {
		return userDAO.selectUser(userId);
	}
}
