<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

		<!-- Default panel contents -->
		<div class="panel-heading">Simple messaging application.</div>
		<div class="panel-body">
			<span class="label label-primary"><a href="${pageContext.request.contextPath }/j_spring_security_login">Login</a></span>
			<sec:authorize access="isAuthenticated()">
				<span class="label label-primary"><a href="${pageContext.request.contextPath }/j_spring_security_logout">Logout</a></span>			
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<span class="label label-primary"><a href="${pageContext.request.contextPath }/admin">Administration</a></span>			
			</sec:authorize>
		</div>
		<div>
			<span class="label label-primary"><a href="${pageContext.request.contextPath }/showmsgs">Messages</a></span>
			<span class="label label-primary"><a href="${pageContext.request.contextPath }/createmsg">Create Message</a></span>
			<sec:authorize access="!isAuthenticated()">
				<span class="label label-primary"><a href="${pageContext.request.contextPath }/newacc">Create Account</a></span>			
			</sec:authorize>
		</div>
