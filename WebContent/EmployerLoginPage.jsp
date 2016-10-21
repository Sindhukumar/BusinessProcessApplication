<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script>
function validateForm() {
    var a = document.forms["LoginForm"]["useremail"].value;
    var b = document.forms["LoginForm"]["userpassword"].value;

    if (a == null || a == "") {
        alert("Email must be filled out");
        return false;
    }
    if (b == null || b == "") {
        alert("Password must be filled out");
        return false;
    }
    if (!validateEmail(a)) {
    	alert("Enter a valid email address");
        return false;
    }
}
function validateEmail(email) {
	  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
	}
</script>
</head>
<body bgcolor="green">

	<center>
		<br> <br> <br> <br>
		<br> <br> <br> <br>
	<%if("nomatch".equalsIgnoreCase(request.getParameter("error"))){ %>
	<font color="red">Email and Password does not match.</font>
	<%} %>
	<br>
		<form name="LoginForm" action="EmployerLoginServlet" method="post" onsubmit="return validateForm()">

			Email:<input type="text" name="useremail" id="useremail"> <br>
			<br> Password: <input type="password" name="userpassword"
				id="userpassword"> <br> <br> <input type="submit"
				value="Submit" id="submit" />
		</form>
		<a href="ForgotPassword.jsp">Forgot Password?</a>
	</center>
</body>
</html>