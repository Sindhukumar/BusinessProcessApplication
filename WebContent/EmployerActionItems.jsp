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
<script src="js/jquery.min.js"> </script>
<script src="js/bootstrap.js"></script>
<script>
	jQuery(document).ready(function($) {
		$(".clickable-row").click(function() {
			window.document.location = $(this).data("href");
		});
	});
</script>
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
				<th>Citizenship</th>
				<th>Current Stage</th>
				<th>Stage Result</th>
			</tr>
		</thead>
		<tr>
			<c:forEach var="stage" items="${stages}">
				<tr class='clickable-row'
					data-href='UpdateStageServlet?stageid=${stage.bpstageid}'>
					<td><c:out value="${stage.bpapplication.bpapplicationid}" /></td>
					<td><c:out value="${stage.bpapplication.bpjob.tittle}" /></td>
					<td><c:out value="${stage.bpapplication.fullname}" /></td>
					<td><c:out value="${stage.bpapplication.email}" /></td>
					<td><c:out value="${stage.bpapplication.birthday}" /></td>
					<td><c:out value="${stage.bpapplication.address}" /></td>
					<td><c:out value="${stage.bpapplication.education}" /></td>
					<td><c:out value="${stage.bpapplication.jobhistory}" /></td>
					<td><c:out value="${stage.bpapplication.references}" /></td>
					<td><c:out value="${stage.bpapplication.veteran}" /></td>
					<td><c:out value="${stage.bpapplication.druguse}" /></td>
					<td><c:out value="${stage.bpapplication.citizenship}" /></td>
					<td><c:out value="${stage.stagename}" /></td>
					<td><c:out value="${stage.stageresult}" /></td>
				</tr>
			</c:forEach>
	</table>

</body>
</html>