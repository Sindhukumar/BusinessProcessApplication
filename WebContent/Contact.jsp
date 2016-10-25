<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<form role="form" action="ContactServlet" method="post">
	<br/>
		<b>Programmers: </b><br /><br /> <input type="radio" name="to"
			value="anjukumar@gmail.com"> Anju Kumar<br> <input
			type="radio" name="to" value="sindhukumar@gmail.com">
		Sindhukumar<br>
		<br /> <b>Your Email:</b><br /> <input type="text" name="from"
			value="">
		<div class="form-group">
			<label for="post">Subject:</label>
			<textarea name="subject" id="subject" class="form-control" rows="1"
				placeholder="What is it about?" maxlength="100"></textarea>
			<label for="post">Type your Message here (Maximum 200
				character):</label>
			<textarea name="body" id="body" class="form-control" rows="2"
				placeholder="We value your feedback!" maxlength="200"></textarea>
		</div>
		<div class="form-group">
			<input type="submit" value="send" id="submit" /> <input type="reset"
				value="Clear">
		</div>
	</form>
</body>
</html>