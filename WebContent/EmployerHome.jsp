<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="model.Bpapplication"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employer Home</title>
</head>
<body>
	<table class="table table-bordered table-striped table-hover" border=2>
		<thead>
			<tr>
				<th>Application ID</th>
				<th>Job Title</th>
				<th>Name</th>
				<th>Email</th>
				<th>Birthday</th>
				<th>Address</th>
				<th>Education</th>
				<th>Job History</th>
				<th>References</th>
				<th>Veteran</th>
				<th>Drug Use</th>
				<th>Status</th>
			</tr>
		</thead>
		<tr>
			<c:forEach var="application" items="${applications}">
				<tr>
					<td><c:out value="${application.bpapplicationid}" /></td>
					<td><c:out value="${application.bpjob.tittle}" /></td>
					<td><c:out value="${application.fullname}" /></td>
					<td><c:out value="${application.email}" /></td>
					<td><c:out value="${application.birthday}" /></td>
					<td><c:out value="${application.address}" /></td>
					<td><c:out value="${application.education}" /></td>
					<td><c:out value="${application.jobhistory}" /></td>
					<td><c:out value="${application.references}" /></td>
					<td><c:out value="${application.veteran}" /></td>
					<td><c:out value="${application.druguse}" /></td>
					<td><c:out value="${application.status}" /></td>
					 <c:set var="application" value="${application}" scope="session"  />
				</tr>
			</c:forEach>
	</table>
	
	<a href="EmployerActionItems.jsp"> View items needing your action</a>
</body>
</html>