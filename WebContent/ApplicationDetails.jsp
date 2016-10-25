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
<jsp:include page="Header.jsp"></jsp:include> 
	<table class="table table-bordered table-striped table-hover" border=2>
		<tr>
			
				<tr>
					<td><b>Application ID: </b><c:out value="${currentapplication.bpapplicationid}" /></td>
					<td><b>Name: </b><c:out value="${currentapplication.fullname}" /></td>
					<td><b>Birthday: </b><c:out value="${currentapplication.birthday}" /></td>
<%-- 					<td><b>Education: </b><c:out value="${currentapplication.education}" /></td> --%>
<%-- 					<td><b>References:</b> <c:out value="${currentapplication.references}" /></td> --%>
<%-- 					<td><b>Drug Use: </b><c:out value="${currentapplication.druguse}" /></td> --%>
				</tr>
				<tr>
					<td><b>Job Title: </b><c:out value="${currentapplication.bpjob.tittle}" /></td>
					<td><b>Email: </b><c:out value="${currentapplication.email}" /></td>
<%-- 					<td><b>Address: </b><c:out value="${currentapplication.address}" /></td> --%>
<%-- 					<td><b>Job History: </b><c:out value="${currentapplication.jobhistory}" /></td> --%>
<%-- 					<td><b>Veteran: </b><c:out value="${currentapplication.veteran}" /></td> --%>
					<td><b>Status: </b><c:out value="${currentapplication.status}" /></td>
				
				</tr>
			
	</table>
	
	<h3>Work Flow</h3>
	<table class="table table-bordered table-striped table-hover" border=2>
		<thead>
			<tr>
				<th>Stage</th>
				<th>Result</th>
				<th>Comment</th>
				
			</tr>
		</thead>
		<tr>
			<c:forEach var="stage" items="${currentapplicationstages}">
				<tr>
					<td><c:out value="${stage.stagename}" /></td>
					<td><c:out value="${stage.stageresult}" /></td>
					<td><c:out value="${stage.stagecomment}" /></td>
				</tr>
			</c:forEach>
	</table>
	
	<a href="EmployerActionServlet"> View items needing your action</a>
</body>
</html>