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
	<jsp:include page="Header.jsp"></jsp:include>
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
				<th>Citizenship</th>
			</tr>
		</thead>
		<tr>
		<tr>
			<td><c:out value="${currenstage.bpapplication.bpapplicationid}" /></td>
			<td><c:out value="${currenstage.bpapplication.bpjob.tittle}" /></td>
			<td><c:out value="${currenstage.bpapplication.fullname}" /></td>
			<td><c:out value="${currenstage.bpapplication.email}" /></td>
			<td><c:out value="${currenstage.bpapplication.birthday}" /></td>
			<td><c:out value="${currenstage.bpapplication.address}" /></td>
			<td><c:out value="${currenstage.bpapplication.education}" /></td>
			<td><c:out value="${currenstage.bpapplication.jobhistory}" /></td>
			<td><c:out value="${currenstage.bpapplication.references}" /></td>
			<td><c:out value="${currenstage.bpapplication.veteran}" /></td>
			<td><c:out value="${currenstage.bpapplication.druguse}" /></td>
			<td><c:out value="${currenstage.bpapplication.citizenship}" /></td>
		</tr>
	</table>
	Current Stage in progress:
	<b><c:out value="${currenstage.stagename}" /></b>
	<br />
	<br />
	<form action="UpdateStageServlet" method="post">
	<label for="stageresult">Set Result as: </label>
		<select name="stageresult" id="stageresult">
			<option selected="selected">failed</option>
			<option>passed</option>
		</select><br />
		<br />
		<textarea name="comment" id="comment" class="form-control" rows="2"
			placeholder="Your comments here" maxlength="200"></textarea>

		<br />
		<br /><center>
		<button id="submit" type="submit" value="Submit">
			<font color="blue">Update</font>
		</button></center>
	</form>

</body>
</html>