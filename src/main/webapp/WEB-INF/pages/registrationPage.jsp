<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/isotope.css"
	media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/fancybox/jquery.fancybox.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-theme.css" />
<link
	href="${pageContext.request.contextPath}/css/responsive-slider.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animate.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/message.css"
	media="screen" type="text/css" />
<title>Employee Registration</title>
</head>

<body>

	<div class="header">
		<section id="header" class="appear">
			<div class="navbar navbar-fixed-top" role="navigation"
				data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);"
				data-300="line-height:60px; height:60px; background-color:rgba(0,0,0,1);">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="fa fa-bars color-white"></span>
					</button>
					<h1>
						<a class="navbar-brand" href="" data-0="line-height:90px;"
							data-300="line-height:50px;">EMPLOYEE MANAGEMENT </a>
					</h1>
				</div>

				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav" data-0="margin-top:20px;"
						data-300="margin-top:5px;">
						<li><a href="${pageContext.request.contextPath}/login"><span>Login</span></a></li>
						<li class="active"><a
							href="${pageContext.request.contextPath}/registration"><span>Sign
									Up</span></a></li>
					</ul>
				</div>
			</div>
		</section>
	</div>

	<section id="section-contact" class="section appear clearfix">
		<div class="container" style="min-height: 600px !important;">

			<div class="row mar-bot40">
				<div class="col-md-offset-3 col-md-6">
					<div class="section-header">
						<h2 class="section-heading animated" data-animation="bounceInUp">Employee
							Registration</h2>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="cform" id="contact-form">

						<form:form modelAttribute="employeeRegistrationForm" method="POST"
							action="processEmployeeRegistrationForm" class="contactForm">

							<c:if test="${not empty errors}">
								<div class="isa_error">
									<i class="fa fa-times-circle"></i>
									<form:errors path="*" />
								</div>
							</c:if>
							<c:if test="${not empty success}">
								<div class="isa_success">
									<i class="fa fa-check"></i> ${success}
								</div>
							</c:if>

							<div class="wow bounceIn">
								<div class="form-group">
									<form:label path="employeeName" id="customlabel"
										name="employeeName">1. Employee Name: </form:label>
									<form:input path="employeeName" type="text" id="employeeName"
										class="form-control" maxlength="25" />
								</div>
							</div>

							<div class="wow bounceIn">
								<div class="form-group">
									<form:label path="employeeNumber" id="customlabel"
										name="employeeNumber">2. Employee Number: </form:label>
									<form:input path="employeeNumber" type="text"
										class="form-control" id="employeeNumber" maxlength="9" />
								</div>
							</div>

							<div class="wow bounceIn">
								<div class="form-group">
									<form:label path="newPassword" id="customlabel"
										name="newPassword">3. New Password: </form:label>
									<form:input path="newPassword" type="password"
										class="form-control" id="newPassword" maxlength="15" />
								</div>
							</div>

							<div class="wow bounceIn">
								<div class="form-group">
									<form:label path="confirmPassword" id="customlabel"
										name="confirmPassword">4. Confirm Password: </form:label>
									<form:input path="confirmPassword" type="password"
										class="form-control" id="confirmPassword" maxlength="15" />
								</div>
							</div>

							<div class="wow bounceIn">
								<div class="form-group">
									<form:label path="designation" id="customlabel">5. Designation: </form:label>
									<form:select path="designation" id="designation"
										class="form-control">
										<form:option value="" label="--- Select ---" />
										<form:options items="${designations}" />
									</form:select>
								</div>
							</div>

							<div class="wow bounceIn">
								<div class="form-group">
									<form:label path="serviceLine" id="customlabel">6. Service Line: </form:label>
									<form:select path="serviceLine" id="serviceLine"
										class="form-control">
										<form:option value="" label="--- Select ---" />
										<form:options items="${serviceLines}" />
									</form:select>
								</div>
							</div>

							<div class="wow bounceIn">
								<div class="form-group">
									<form:label path="role" id="customlabel">7. Role: </form:label>
									<form:select path="role" id="role" class="form-control">
										<form:option value="" label="--- Select ---" />
										<form:options items="${roles}" />
									</form:select>
								</div>
							</div>

							<input type="submit" name="employeeRegistration"
								class="line-btn green" value="Sign Up" />

						</form:form>

					</div>
				</div>
			</div>
		</div>
	</section>

	<section id="footer" class="section footer">
		<div class="container">
			<div class="row align-center copyright">
				<div class="col-sm-12">
					<p>Copyright &copy; 2018 All rights reserved.</p>
				</div>
			</div>
		</div>
	</section>

</body>
</html>