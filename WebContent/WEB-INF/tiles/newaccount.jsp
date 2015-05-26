<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">

function onLoad(){
	$("#password").keyup(checkPasswordMatch);
	$("#repassword").keyup(checkPasswordMatch);
	
	$("#details").submit(canSubmit);
}

function canSubmit(){
	var password = $("#password").val();
	var confirmpass = $("#repassword").val();
	
	if(password != confirmpass) {
		alert("Passwords dont match.");
		return false;
	}
	else {
		return true;
	}
}

function checkPasswordMatch() {
	var password = $("#password").val();
	var confirmpass = $("#repassword").val();
	
	if(password.length > 3 || confirmpass.lenght > 3){
		if(password == confirmpass){
			$("#matchpass").text("Passwords match");
			$("#matchpass").addClass("alert alert-success");
			$("#matchpass").removeClass("alert alert-danger");
			
		}
		else {
			$("#matchpass").text("Passwords dont match");
			$("#matchpass").addClass("alert alert-danger");
			$("#matchpass").removeClass("alert alert-success");
		}
	}
	

}

$(document).ready(onLoad);
</script>

		<!-- Default panel contents -->
		<div class="panel-heading">
			New Account <span class="label label-primary"><a
				href="${pageContext.request.contextPath }/">homepage</a></span>
		</div>
		<div class="panel-body">
			<p>Create new account</p>
			<sf:form id="details" class="form" method="POST"
				action="${pageContext.request.contextPath }/docreateacc" commandName="user">
				<div class="form-group">
					<label class="col-sm-2 control-label" >Username:</label>
					<div class="control-label">
						<sf:input name="username" path="username"></sf:input>
						<sf:errors path="username" cssClass="alert alert-danger" role="alert"></sf:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label" >Email:</label>
					<div class="control-label">
						<sf:input name="email" path="email"></sf:input>
						<sf:errors path="email" cssClass="alert alert-danger" role="alert"></sf:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" >Password:</label>
					<div class="control-label">
						<sf:input  id="password" type="password" name="password" path="password"></sf:input>
						<sf:errors path="password"  cssClass="alert alert-danger" role="alert"></sf:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" >Repeat Password:</label>
					<div class="control-label">
						<input name="repassword" id="repassword" type="password"></input>
					</div>
				</div>
				<div class="form-group">
					<div  id="matchpass"></div>					
				</div>
				<div class="form-group">
					<div class="col-sm-10 control-label">
						<input class="btn btn-default" value="Create account" type="submit" />
					</div>
				</div>
			</sf:form>
		</div>
