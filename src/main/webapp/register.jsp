<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration </title>
    <link rel="stylesheet" href="style.css">
   </head>
<body>
	<input type="hidden" id="status" value =<%= request.getAttribute("status") %> >
  <div class="wrapper">
    <h2>Registration</h2>
    <form method="post" action="register">
      <div class="input-box">
        <input type="text" placeholder="Enter your name" name="username" required>
      </div>
      <div class="input-box">
        <input type="email" placeholder="Enter your email" name="email" required>
      </div>
      <div class="input-box">
        <input type="text" placeholder="Enter your mobileno" name="mobile" required>
      </div>
      <div class="input-box">
        <input type="password" placeholder="Create password" name="password1" required>
      </div>
      <div class="policy">
        <input type="checkbox" required>
        <h3>I accept all terms and condition</h3>
      </div>
      <div class="input-box button">
        <input type="Submit" value="Register Now">
      </div>
      <div class="text">
        <h3>Already have an account? <a href="./login.jsp"> Login now</a></h3>
      </div>
    </form>
  </div>
  <!--js-->
  	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status =="sucess"){
		swal("Congrats","Account Created Sucessfully","sucess");
	}	
	else if(status ==  "invalidEmail"){
		swal("Sorry !"," Invalid Email ","error");
	}
	else if(status ==  "invalidPassword"){
		swal("Sorry !","Invalid password","error");
	}
	else if(status ==  "invalidUser"){
		swal("Sorry !","Invalid User name","error");
	}
	else if(status ==  "invalidMobile"){
		swal("Sorry !","Invalid mobile number ","error");
	}
	</script>
	

</body>
</html>
