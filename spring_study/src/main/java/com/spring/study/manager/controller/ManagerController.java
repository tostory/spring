package com.spring.study.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/manager")
public class ManagerController {
	
	@RequestMapping(value="/main.do")
	public String getBoardList(HttpServletRequest request, HttpServletResponse response){
		
		return "/manager/main";
	}
}
