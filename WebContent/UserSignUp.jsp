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
	width: 90%;
	border: 5px solid #7bc475;
	padding: 5px;
	margin: 8px 0;
}

input[type=text] {
	width: 90%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	background-image: url('searchicon.png');
}

input[type=text]:focus {
	background-color: #7bc475;
}
</style>
<script>
function validateForm() {
    var a = document.forms["PasswordForm"]["email"].value;
    var b = document.forms["PasswordForm"]["password"].value;
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
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(a);
}
</script>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>

	<form name="PasswordForm" action="UserSignUpServlet" method="post" onsubmit="return validateForm()">


		<div class="form-group">
			Email*: <input type="text" class="form-control" id="email"
				name="email">
		</div>

		<div class="form-group">
			<label for="address">Address*:</label> <input type="text"
				class="form-control" id="address" name="address">
		</div>


		<div class="form-group">
			<label for="education">Education*:</label> <input type="text"
				class="form-control" id="education" name="education">
		</div>

		<div class="form-group">
			<label for="summary">Summary*:</label> <input type="text"
				class="form-control" id="summary" name="summary">
		</div>

		<div class="form-group">
			<label for="objective">Objective*:</label> <input type="text"
				class="form-control" id="objective" name="objective">
		</div>

		<div class="form-group">
			<label for="skill">Skills*:</label> <input type="text"
				class="form-control" id="skills" name="skills">
		</div>
		
		<div class="form-group">
			<label for="awards">Awards*:</label> <input type="text"
				class="form-control" id="awards" name="awards">
		</div>
		
		<div class="form-group">
			<label for="password">Password*:</label> <input type="text"
				class="form-control" id="password" name="password">
		</div>
		
		<div class="form-group">
			<label for="confirmpassword">Confirm Password*:</label> <input type="text"
				class="form-control" id="confirmpassword" name="confirmpassword">
		</div>

		<center>

			<input type="submit" id="signup"	value="Sign Up" />

		</center>

	</form>

</body>
</html>