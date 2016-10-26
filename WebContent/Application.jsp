<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
  function checkDrug() 
  {
	    if (document.getElementById('yes').checked)
	    {
	      	document.getElementById('druguse').value = '';
	    	document.getElementById('drugusecheck').style.visibility = 'visible';
	    }
	    
	    else if (document.getElementById('no').checked) {
	    	document.getElementById('druguse').value = 'no';
	    	document.getElementById('drugusecheck').style.visiblity = 'visible';
	    }
  }
  

	function checkResume() {
		alert("Please press ok to view your resume");
		document.getElementById('action').value = 'resume';
	}
	function checkApply() {
		alert("You will not be able to make changes once you submit");
		document.getElementById('action').value = 'apply';

	}
</script>
	    
	    <style>
	    form {
	    padding: 12px 20px;
	     width: 90%;

  padding : 5px;
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
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include> 


	
	
<br><br><br><br>

 <form   action ="ApplicationServlet" method ="post">
 
 
  <div class="form-group">
  Name*: <input type="text" class="form-control" id="fullname" name="fullname">
  </div>
  
   <div class="form-group">
  Email*: <input type="text" class="form-control" id="email" name="email">
  </div>
  
   <div class="form-group">
   Birthday*:<input type="text" class="form-control" id="birthday" name="birthday">
  </div>
  

   <div class="form-group">
    <label for="address">Address*:</label>
    <input type="text" class="form-control" id="address" name="address">
  </div>
  
  
    <div class="form-group">
  <label for="education">Education*:</label>
  <input type="text" class="form-control" id="education" name="education">
  </div>
  
     <div class="form-group">
    <label for="jobhistory">Job history*:</label>
    <input type="text" class="form-control" id="jobhistory" name="jobhistory">
  </div>
	  
	   <div class="form-group">
    <label for="summary">Summary*:</label>
    <input type="text" class="form-control" id="summary" name="summary">
  </div>
	  
	    <div class="form-group">
    <label for="objective">Objective*:</label>
    <input type="text" class="form-control" id="objective" name="objective">
  </div>
	   
	      <div class="form-group">
    <label for="skill">Skills*:</label>
    <input type="text" class="form-control" id="skills" name="skills">
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

	 <input type="submit" onclick="javascript:checkResume();"  id="resume" value="Export as Resume"/>
	 <input type="hidden" name="action" id="action" value="">
	 
	 <input type="submit" onclick="javascript:checkApply();"  id="apply" value="Apply to the job"/>
	 
</center>

</form>
	
</body>
</html>