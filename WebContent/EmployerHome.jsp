<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employer Home</title>

</head>
<body>
	
	
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th></th>
				<th>Account Number</th>
				<th></th>
				<th>Transfer</th>
				<th>Activity</th>
				<th></th>
				
				
			</tr>
		</thead>

		<tr>



			<c:forEach var="account" items="${accounts}">
				<tr>
					<td><c:out value="${account.dcuuser.name}" /></td>
					<td><c:out value="${account.accountid}" /></td>
					<td><c:out value="${account.type}" /></td>
					
					<td> <form action ="TransactionMediator" method="post">
							<input type="hidden" name="accountid" value="<c:out value="${account.accountid}"/>"> 
							<input type="hidden" name="action" value="Transact">
							 <input type="submit" value="Transact"> 
							 </form> </td>
				
					<c:if test="${account.status == 1 }"> 
					<td> <form action ="AccountServlet" method="post">
							<input type="hidden" name="Accountid" value="<c:out value="${account.accountid}"/>"> 
							<input type="hidden" name="action" value="Close">
							 <input type="submit" value="Close"> 
							 </form> </td>
				</c:if>
						<c:if test="${account.status == 0 }"> 
						<td><form action ="AccountServlet" method="post">
							<input type="hidden" name="Accountid" value="<c:out value="${account.accountid}"/>"> 
							<input type="hidden" name="action" value="Reopen">
								 <input type="submit" value="Reopen"> 
							</form></td>
						</c:if>
				</tr>

			</c:forEach>
	</table>
	
	<form action="AddAccount.jsp" method="post">
			 <input type="hidden" name="action" value="Add Account"> <input
			type="submit" value="Add Account">
	</form>


</body>
</html>