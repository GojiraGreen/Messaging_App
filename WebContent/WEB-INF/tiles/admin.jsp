<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<!-- Default panel contents -->
		<div class="panel-heading">Simple messaging application.
			<p class="label label-primary"><a href="${pageContext.request.contextPath }/">homepage</a></p>
		</div>
	  <div class="panel-body">
	    <p>Administration Page</p>
	  </div>
	
	  <!-- Table -->
	  <table class="table">
		<c:forEach items="${users}" var="user">
	
				<tr>
					<td>${user.username }:</td>
					<td>${user.email }</td>
					<td>${user.authority }</td>
				</tr>
	
		</c:forEach>
	  </table>