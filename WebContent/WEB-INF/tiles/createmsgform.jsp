<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

	<!-- Default panel contents -->
	<div class="panel-heading">New message
		<span class="label label-primary"><a href="${pageContext.request.contextPath }/">homepage</a></span>
	</div>
	<div class="panel-body">
		<sf:form class="form" method="POST" action="${pageContext.request.contextPath }/docreatemsg" commandName="message">
		  <div class="form-group">
		    <label class="col-sm-2 control-label" >Your message:</label>
		    <div class="col-sm-10">
		    	<sf:textarea name="text" path="text"></sf:textarea><sf:errors path="text" cssClass="alert alert-danger" role="alert"></sf:errors>    
		    </div>
		    <input class="btn btn-default" value="Save message" type="submit" />
		  </div>
		</sf:form>	
	</div>
