<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<sec:authorize access="hasAuthority('ROLE_ADMIN')">
	<li><a href="<c:url value='/admin/main.do'/>">admin</a></li>
	<li><a href="<c:url value='/board/dataList.do'/>">게시판</a></li>
</sec:authorize>
<sec:authorize access="hasAuthority('ROLE_MANAGER')">
	<li><a href="<c:url value='/manager/main.do'/>">manager</a></li>
	<li><a href="<c:url value='/board/dataList.do'/>">게시판</a></li>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<li><a href="<c:url value='/login.do'/>">로그인</a></li>
	<li><a href="<c:url value='/join.do'/>">회원가입</a></li>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<li><a href="<c:url value='/logout.do'/>">로그아웃</a></li>
</sec:authorize>
</ul>
</body>
</html>