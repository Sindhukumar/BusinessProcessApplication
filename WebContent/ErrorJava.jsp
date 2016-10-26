<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include> 
<!-- Banner -->
		<div class="banner">
		<h1>Java Error</h1>
					</div>

		<!-- //Banner -->
<br><br><br><br>
<center> 
<h4>Sorry, Java has thrown an exception.</h4>
<h4>To continue, click the back button.</h4>
<br><br><br>

<h3>Details</h3><br><br>
<p>Type: ${pageContext.exception["class"]}</p>
<p>Message: ${pageContext.exception.message}</p>
</center>
</body>
</html>