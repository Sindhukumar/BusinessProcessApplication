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
  <script>
  $( function() {

    $( "#number" )
      .selectmenu()
      .selectmenu( "menuWidget" )
        .addClass( "overflow" );
    
    $( "#score" )
    .selectmenu()
    .selectmenu( "menuWidget" )
      .addClass( "overflow" );
 

  } );
  </script>
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
	
	
	<table>
   	 <thead>
   	 <td>Questions</td>
   	 <td>Evaluation</td>
   	 </thead>
   	 
   	 <c:if test="${questions!=null }">
   	 <c:forEach var="questions" items="${questions}">
   	 <tr>
	<td><c:out value="${questions.question}" /></td>
	<td><input type=text value="" id="comments" name="comments"  placeholder =""></td>
	<td>
	    <select name="number" id="number">
	   <option selected="selected">Score</option>
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
      <option>6</option>
      <option>7</option>
      <option>8</option>
      <option>9</option>
      <option>10</option>
    </select>
	</td>
	</tr>
   	 </c:forEach></c:if>
   	 </table>
	

	
	
	<form action="UpdateStageServlet" method="post">
	<label for="stageresult">Set Result as: </label>
		<select name="stageresult" id="stageresult">
			<option >failed</option>
			<option selected="selected">passed</option>
		</select><br />
		<label for="score">*Score: </label>   <select name="score" id="score">
	   <option selected="selected">Overall Score</option>
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
      <option>6</option>
      <option>7</option>
      <option>8</option>
      <option>9</option>
      <option>10</option>
    </select>
		
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