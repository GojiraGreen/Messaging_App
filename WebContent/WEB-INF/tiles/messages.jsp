<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	  <!-- Default panel contents -->
	  <div class="panel-heading">Messages
		<span class="label label-primary"><a href="${pageContext.request.contextPath }/">homepage</a></span>
	  </div>
	  <div class="panel-body">
	    <p>Message Box</p>
	  </div>
	
	  <!-- Table -->
	  <table class="table">
		<c:forEach items="${messages}" var="message">
	
				<tr>
					<td>${message.username }:</td>
					<td>${message.text }</td>
				</tr>
	
		</c:forEach>
	  </table>