package com.spring.study.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.study.user.service.UserService;
import com.spring.study.user.vo.UserVO;

@Controller
public class LoginController {
	
	@Resource(name="userService")
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response
			, @ModelAttribute("user") UserVO user
			, Model model) {
		user.setId("test");
		user.setPassword("1111");
		return "/login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response
			, UserVO vo
			, HttpSession session) {
		
		UserVO user = userService.selectUser(vo.getId());
		
		if (userService.selectUser(vo.getId()) != null) {
			session.setAttribute("userName", user.getName());
			return "redirect:/board/dataList.do";
		} else {
			return "/login";
		}
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}

	@RequestMapping(value = "/main.do")
	public String main(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return "/main";
	}
}
