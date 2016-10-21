<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@page import="model.Bpapplication"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Confirmation</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include> 

<!-- Banner -->
		<div class="banner">
			<h1>Confirmation</h1>
					</div>

		<!-- //Banner -->
	<br><br>
			<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<h2>Thank you for your Application , ${application.fullname}  !<h2>
					
	<br><br>										
						<h2>Your application id is  ${application.bpapplicationid}</h2>
						<br><br>
						<h4> Thank you so much for taking the time to send in your application </h4>
						<br>
						<h4> An email with your confirmation details will be sent to  ${application.email} </h4>					
						<br>
						<h4> Should your application match our requirments, an HR officer from our team will get in touch with you </h4>
						<br>
						<h4>If you would like to check the status of your application, Please login in <a href ="/checkstatus.jsp">HERE</a> by using your application id and email</h4>
						<br>
						<h4> Good Luck!</h4>
						
					</div>
				</div>
	
<br><br><br><br>


</body>
</html>