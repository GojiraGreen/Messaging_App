<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<!-- Default panel contents -->
		<div class="panel-heading">Simple messaging application.
			<p class="label label-primary"><a href="${pageContext.request.contextPath }/">homepage</a></p>
		</div>
		<div class="panel-body">
			<p>Login with Username and Password</p>
			<c:if test="${param.error == true }">
				<p style="min-width: 10em; width: 20%;" class="alert alert-danger ">Wrong username or password!</p>
			</c:if>
			<form class="navbar-form navbar-left" role="login" name='f'
				action='${pageContext.request.contextPath }/j_spring_security_check'
				method='POST'>
		
				<div style="border: 1px solid; border-bottom: none;">
					<input class="form-control" placeholder="username" type='text'
						name='j_username' value='' />
				</div>
		
				<div style="border: 1px solid;">
					<input type="password" class="form-control" placeholder="password"
						type='password' name='j_password' />
				</div>
				<div class="form-control">
					<input class="btn btn-default" name="submit" type="submit"
						value="Login" />
				</div>
		
			</form>
		</div>