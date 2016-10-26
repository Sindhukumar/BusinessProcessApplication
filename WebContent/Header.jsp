<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Bpemployer"%>
<!DOCTYPE html>
<html>
<head>
<title>Business Park a corporate category Flat Bootstrap
	Responsive Website Template | Home :: W3layouts</title>
<!-- For-Mobile-Apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Business Processing application, HR Tool, Recruitment Help" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->

<!-- Custom-Stylesheet-Links -->
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/swipebox.css">
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //Custom-Stylesheet-Links -->


<!-- Web-Fonts -->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,300italic,900italic,900,800italic,800,700italic,700,600italic,600,500italic,500'
	rel='stylesheet' type='text/css'>
<!-- //Web-Fonts -->
<script src="js/jquery.min.js"> </script>
<script src="js/bootstrap.js"></script>

</head>
<body>
	<!-- Header -->
	<div class="header">
		<!-- Top-Bar -->
		<div class="top-bar">
			<div class="container">
				<div class="logo">
					<a href="#"><h2>BUSINESS PARK</h2></a>
				</div>
				<div class="header-right">
					<div class="phone">
						<ul>
							<li><span class="glyphicon glyphicon-earphone phone"
								aria-hidden="true"></span></li>
							<li>+123456789</li>
						</ul>
					</div>
					<div class="social-icons-top">
						<ul>
							<li><a class="linkedin" href="#"></a></li>
							<li><a class="twitter" href="#"></a></li>
							<li><a class="facebook" href="#"></a></li>
							

						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- //Top-Bar -->

		<!-- Navbar -->
		<div class="total-navbar">
			<div class="container">
				<nav class="navbar navbar-default">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

					<div id="navbar"
						class="navbar-collapse navbar-right collapse hover-effect">
						<c:if test="${employer==null }">
							<c:if test="${user==null }">
								<ul class="nav navbar-nav">
									<li class="active">
									<li><a href="Home" class="scroll">Jobs</a></li>
									<li><a href="LoginApplicant.jsp">Status</a></li>
									<li><a href="UserLoginPage.jsp" class="scroll">Login</a></li>
									<li><a href="UserSignUp.jsp" class="scroll">Sign Up</a></li>
									<li><a href="Contact.jsp" class="scroll">CONTACT</a></li>
									<li><a href="EmployerLoginPage.jsp" class="scroll">Employer	</a></li>
								</ul>
							</c:if>
						</c:if>
						<c:if test="${employer!=null }">
							<ul class="nav navbar-nav">
								<li><a href="EmployerHomeServlet" class="scroll">Home</a></li>
								<li><a href="EmployerActionServlet">My Action Items</a></li>
								<li><a href="EmployerLoginServlet?logout=true"
									class="scroll">Log out</a></li>
								<li><a href="Contact.jsp" class="scroll">CONTACT</a></li>
								<li><a href =""> User: ${employer.name } - ${employer.role }  </a></li>
							</ul>
						</c:if>
						<c:if test="${user!=null }">
							<ul class="nav navbar-nav">
								<li><a href="UserHomeServlet" class="scroll">Home</a></li>
								<li><a href="Home" class="scroll">Jobs</a></li>
								<!-- <li><a href="UserUpdate.jsp">Edit Profile</a></li> -->
								<li><a href="UserLoginServlet?logout=true" class="scroll">Log
										out</a></li>
								<li><a href="Contact.jsp" class="scroll">CONTACT</a></li>
							</ul>
						</c:if>

					</div>
				</nav>
			</div>
		</div>
		<!-- //Navbar -->
	</div>
	<!-- //Header -->