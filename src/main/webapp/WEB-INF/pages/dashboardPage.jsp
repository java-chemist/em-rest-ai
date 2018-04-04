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
<title>Employee Dashboard</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
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
						<li class="active"><a
							href="${pageContext.request.contextPath}/dashboard"><span>Employee
									Dashboard</span></a></li>
						<li><a
							href="${pageContext.request.contextPath}/appointment"><span>Employee
									Appointments</span></a></li>
						<c:if test="${pageContext.request.userPrincipal.name != null}">
							<li><a href="${pageContext.request.contextPath}/logout"><span>Logout</span></a></li>
						</c:if>
					</ul>
				</div>

				<div class="welcome">${welcomeMsg}</div>
			</div>
		</section>
	</div>

	<section id="section-contact" class="section appear clearfix">
		<div class="container">

			<div class="row mar-bot40">
				<div class="col-md-offset-3 col-md-6">
					<div class="section-header">
						<h2 class="section-heading animated" data-animation="bounceInUp">Dashboard</h2>
						<h3 class="section-heading animated" data-animation="bounceInUp">EMPLOYEE
							INFORMATION</h3>
					</div>
				</div>
			</div>

		</div>
	</section>

	<div style="min-height: 475px !important; padding: 0px 50px 0px 50px;">
		<table>
			<tr>
				<th>SERIAL NO.</th>
				<th>EMPLOYEE ID</th>
				<th>EMPLOYEE NAME</th>
				<th>DESIGNATION</th>
				<th>SERVICE LINE</th>
				<th>ROLE</th>
			</tr>
			<c:forEach items="${employeeDashboardForms}"
				var="employeeDashboardForm" varStatus="status">
				<tr>
					<td align="center"><c:out value="${status.count}" /></td>
					<td><c:out value="${employeeDashboardForm.employeeNumber}" /></td>
					<td><c:out value="${employeeDashboardForm.employeeName}" /></td>
					<td><c:out value="${employeeDashboardForm.designation}" /></td>
					<td><c:out value="${employeeDashboardForm.serviceLine}" /></td>
					<td><c:out value="${employeeDashboardForm.role}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<c:if test="${countOfPages > 0}">
			<c:forEach var="i" begin="1" end="${countOfPages}">
				<a style="letter-spacing: 0.5em;"
					href="${pageContext.request.contextPath}/pagination/${i}"><b><c:out
							value="${i}" /></b> </a>
			</c:forEach>
		</c:if>
	</div>

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