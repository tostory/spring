package com.spring.study.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@RequestMapping(value="/main.do")
	public String getBoardList(HttpServletRequest request, HttpServletResponse response){
		
		return "/admin/main";
	}
}
