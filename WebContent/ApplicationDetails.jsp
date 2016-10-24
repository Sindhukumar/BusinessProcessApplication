<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="model.Bpapplication"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application Detail</title>
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
			
				<tr>
					<td><c:out value="${currentapplication.bpapplicationid}" /></td>
					<td><c:out value="${currentapplication.bpjob.tittle}" /></td>
					<td><c:out value="${currentapplication.fullname}" /></td>
					<td><c:out value="${currentapplication.email}" /></td>
					<td><c:out value="${currentapplication.birthday}" /></td>
					<td><c:out value="${currentapplication.address}" /></td>
					<td><c:out value="${currentapplication.education}" /></td>
					<td><c:out value="${currentapplication.jobhistory}" /></td>
					<td><c:out value="${currentapplication.references}" /></td>
					<td><c:out value="${currentapplication.veteran}" /></td>
					<td><c:out value="${currentapplication.druguse}" /></td>
					<td><c:out value="${currentapplication.status}" /></td>
					 
				</tr>
			
	</table>
	
	<a href="EmployerActionItems.jsp"> View items needing your action</a>
</body>
</html>