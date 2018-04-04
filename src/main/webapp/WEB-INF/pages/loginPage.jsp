<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" media="screen"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/message.css"
	media="screen" type="text/css" />
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,700">
</head>

<body>

	<div class="container">

		<div id="login">
			<form name='f'
				action="${pageContext.request.contextPath}/j_spring_security_check"
				method='POST'>
				<fieldset class="clearfix">
					<p>
					<h1>Employee Sign In</h1>
					<p>
					<p>
						<span class="fontawesome-user"></span><input type="text"
							name='username' value="Employee Number"
							onBlur="if(this.value == '') this.value = 'Employee Number'"
							onFocus="if(this.value == 'Employee Number') this.value = ''"
							placeholder="Enter Employee Number" required>
					</p>

					<p>
						<span class="fontawesome-lock"></span><input type="password"
							name='password' value="Password"
							onBlur="if(this.value == '') this.value = 'Password'"
							onFocus="if(this.value == 'Password') this.value = ''"
							placeholder="Enter Password" required>
					</p>

					<p>
						<input name="submit" type="submit" value="Login">
					</p>

					<p>
					<h1>
						<a style="letter-spacing: 0.2em; font-size: 50%;"
							href="${pageContext.request.contextPath}/registration"><c:out
								value="Sign Up - Employee Registration" /> </a>
					</h1>
				</fieldset>
			</form>
		</div>
		<!-- end login -->
	</div>
	<br>
	<br>
	<br>

	<div style="margin: 0px 50px 0px 50px;">
		<c:if test="${not empty logout}">
			<div class="isa_info">
				<i class="fa fa-info-circle"></i> Logout Successful!!!
			</div>
		</c:if>
		<c:if test="${param.error == 'true'}">
			<div class="isa_error">
				<i class="fa fa-times-circle"></i> Login Failed!!! Reason :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
	</div>

</body>
</html>