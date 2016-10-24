<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

	<!-- Banner -->
	<div class="banner">
		<h1>Status Check</h1>
	</div>

	<!-- //Banner -->
	<br><br><br><br><br><br>
	
	
	<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<h2>Hello Applicant!<h2>
					
	<br><br>										
						<h2></h2>
						<br><br>
						<h4> Check your application status by inserting your application id </h4>
						<br>
						<center>
						<form action="LoginApplicantServlet" method ="post">
						<input type="text" value ="" name="applicationid" id="applicationid" placeholder="Enter your application id">
						<input type="submit" id="submit" name="submit" value="submit" >
						<br><br><br><br><br><br><br><br>
					</form>
					</center>
					</div>
				</div>
	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>