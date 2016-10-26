<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="model.Bpapplication"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home</title>
<script src="js/jquery.min.js">
	
</script>
<script src="js/bootstrap.js"></script>
<style>
img {
	width: 2%;
}
</style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br>
	<c:if test="${usergravatar!=null}">
	<img src="${usergravatar}" height="22" width="22" style="width:2%; height:2%">
	</c:if>
	<table class="table table-bordered table-striped table-hover">
		<tr>
			<td>Email: <c:out value="${user.email}" /></td>
			<td>Objective: <c:out value="${user.objective}" /></td>
			<td>Education: <c:out value="${user.education}" /></td>
		</tr>
		<tr>
			<td>Summary: <c:out value="${user.summary}" /></td>
			<td>Skills: <c:out value="${user.skills}" /></td>
			<td>Awards: <c:out value="${user.awards}" /></td>
		</tr>
	</table>
	<h3>Your Applications:</h3>
	<table class="table table-bordered table-striped table-hover" border=2>
		<thead>
			<tr>
				<th>Application ID</th>
				<th>Job Title</th>
				<th>Status</th>
			</tr>
		</thead>
		<tr>
			<c:forEach var="application" items="${appliedapplications}">
				<tr>
					<td><c:out value="${application.bpapplicationid}" /></td>
					<td><c:out value="${application.bpjob.tittle}" /></td>
					<td><c:out value="${application.status}" /></td>
				</tr>
			</c:forEach>
	</table>

	<center>
		<form method="get" action="Home">
			<button type="submit">Apply Jobs</button>
		</form>
	</center>
</body>
</html>