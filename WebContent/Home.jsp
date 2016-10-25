<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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


<title>Home</title>
</head>

<body>
<jsp:include page="Header.jsp"></jsp:include> 

	<!-- Banner -->
		<div class="banner">
			<h1>BPA </h1>
			<h3>Human Resource Management System</h3>
			<h4>Because our People are our Biggest Assests</h4>
			<a href="#" data-toggle="modal" data-target="#myModal">READ MORE</a>
		</div>
		 <div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<p>Prof.Dave thought it would be a good idea to make a cocktail of all big projects done so far. So he came up with the idea of HDZ Business Process Application. where HDZ stands for Harrison-Dalton-Zork. This application lets the applicant apply for jobs and view status. while the employer can process the application by logging in.</p>
					</div>
				</div>
			</div>
		</div>
		<!-- //Banner -->
<div class="modal-content">
<div class="modal-body">
<br><br>
<h2>New Opportunities everyday</h2>
					</div>
</div>

<br><br><br>

    <table class="table table-bordered table-striped table-hover" border=2>
<center> 	
   
   <tr>  
   <h3>
   <th>Job Title</th>
   <th>Job Description</th>
    <th>Job Type</th>
    <th>Openings</th>
     <th>Action</th>
       </h3>
   
   </tr>


<c:forEach var="jobList" items="${jobList}">
			<tr>
				<c:if test="${jobList.openings > 0 }">
					<td><c:out value="${jobList.tittle}" /></td>
					<td><c:out value="${jobList.jobdescription}" /></td>
					<td><c:out value="${jobList.jobtype}" /></td>
					<td><c:out value="${jobList.openings}" /></td>

					<td>

						<form action="ApplicationServlet" method="get">
							<input type="hidden" name="jobid" id="jobid"
								value="${jobList.jobid}" /> <input type="hidden" value="apply"
								name="action" /> <input type="submit" value="apply" id="apply" />
						</form>

					</td>
				</c:if>
			</tr>

		</c:forEach> 
<center>
	 </table>	
  


<jsp:include page="Footer.jsp"></jsp:include> 
</body>
</html>