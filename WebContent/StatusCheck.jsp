<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, td, th {    
    border: 1px solid #ddd;
    text-align: left;
}
th, td {
    padding: 15px;
    text-align: left;
}
table {
    border-collapse: collapse;
    width: 100%;
      border-spacing: 0.5rem
}
</style>
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
	<br><br>	
<br>
	
	 <table>
<center> 	
   
   <tr>  
   <h3>
   <th>Application ID</th>
   <th>Applicant Name</th>
    <th>Status<th>

       </h3>
   
   </tr>



			<tr>
				
					<td><c:out value=" ${application.bpapplicationid}" /></td>
					<td><c:out value=" ${application.fullname}" /></td>
					<td><c:out value="${application.status}" /></td>

					<td>
</td>
</tr>
</table>
	
	<br><br><br>
	<br><br><br>
	
</body>
</html>