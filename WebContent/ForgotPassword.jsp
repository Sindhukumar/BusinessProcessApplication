<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot Password</title>
<script>
function validateForm() {
    var a = document.forms["PasswordForm"]["useremail"].value;
    var b = document.forms["PasswordForm"]["userpassword"].value;
    var c = document.forms["PasswordForm"]["confirmpassword"].value;

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
    if (b != c ) {
        alert("Password does not match");
        return false;
    }
}
function validateEmail(email) {
	  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
	}
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<center>
	<%if("notfound".equalsIgnoreCase(request.getParameter("error"))){ %>
	<font color="red">Email not found.</font>
	<%} %>
		<form name="PasswordForm" action="ForgotPassword" method="post" onsubmit="return validateForm()">

			            Email: <input type="text" name="useremail" id="useremail"> <br>
			<br> New Password: <input type="password" name="userpassword"
				id="userpassword"> <br> 
				confirm Password: <input type="password" name="confirmpassword"
				id="confirmpassword"> <br>
				<br> <input type="submit"
				value="Submit" id="submit" />
		</form>
	</center>
</body>
</html>