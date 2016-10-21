<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
  function checkDrug() {
	    if (document.getElementById('yes').checked) {
	      	document.getElementById('druguse').value = '';
	    	document.getElementById('drugusecheck').style.visibility = 'visible';
	    }
	    
	    else if (document.getElementById('no').checked) {
	    	document.getElementById('druguse').value = 'no';
	    	document.getElementById('drugusecheck').style.visiblity = 'visible';
	    }
  }
  
  
	    </script>
	    
	    <style>
	    form {
	    padding: 12px 20px;
	     width: 90%;
  border : 5px solid #7bc475;
  padding : 5px;
  alignment : center
  
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
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include> 

<!-- Banner -->
		<div class="banner">
			<h1>Application</h1>
					</div>

		<!-- //Banner -->
	
	
<br><br><br><br>
 <form action ="ApplicationServlet" method ="post">
 
  <div class="form-group">
    <label for="fullname">Name*:</label>
    <input type="text" class="form-control" id="fullname" name="fullname">
  </div>
  
   <div class="form-group">
    <label for="email">Email*:</label>
    <input type="text" class="form-control" id="email" name="email">
  </div>
  
   <div class="form-group">
    <label for="birthday">Birthday*:</label>
    <input type="text" class="form-control" id="birthday" name="birthday">
  </div>
  
     <div class="form-group">
    <label for="education">Education*:</label>
    <input type="text" class="form-control" id="education" name="education">
  </div>
  
   <div class="form-group">
    <label for="address">Address*:</label>
    <input type="text" class="form-control" id="address" name="address">
  </div>
  
  
  
     <div class="form-group">
    <label for="jobhistory">Job history*:</label>
    <input type="text" class="form-control" id="jobhistory" name="jobhistory">
  </div>
	  
     <div class="form-group">
    <label for="references">References*:</label>
    <input type="text" class="form-control" id="references" name="references">
  </div>
  
    <div class="form-group">
    <label for="druguse">Drug Use:</label>
    Yes <input type="radio" onclick="javascript:checkDrug();" name="check" id="yes" value="yes"/>
     No<input type="radio" onclick="javascript:checkDrug();" name="check" id="no" value="no"/>			      
  </div>
  
  <div id="drugusecheck" class="form-group" style="visibility: hidden">
   Type of drug   <input type="text" class="form-control" id="druguse" name="druguse" value= "">
  </div>

		<div class="form-group">
			<label for="veteran">Veteran*:</label> 
 	 Yes <input type="radio"  name="veteran" id="yes" value="yes"/>
     No<input type="radio"  name="veteran" id="no" value="no"/>			    
		</div>


		<div class="form-group">
			<label for="citizenship">Citizenship*:</label> 
			<input type="text" class="form-control" id="citizenship" name="citizenship">
		</div>

<center>
		<input type="hidden" value="apply"	name="action" />
		<input type="submit" value="submit" id="submit" /></center>

</form>
          	
	
	
</body>
</html>