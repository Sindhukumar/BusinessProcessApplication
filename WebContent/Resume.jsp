<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 form {
	    padding: 12px 20px;
	     width: 100%;
  border : 5px solid #7bc475;
  padding : 5px;
     margin: 8px 0;
  
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form>
<h2>${application.fullname}</h2>
<br>
<h4> Contact: ${application.address} | ${application.email} </h4>
<br><br> <h4>
Summary:{application.summary}
<br><br><br><br>
Objective : {application.objective}
<br><br><br><br>

Education :  ${application.education}
<br><br><br><br>
Skills: ${application.skills}
<br><br><br><br>
Job History: ${application.jobhistory}
<br><br><br><br>
References : ${application.references}





</form>
</body>
</html>