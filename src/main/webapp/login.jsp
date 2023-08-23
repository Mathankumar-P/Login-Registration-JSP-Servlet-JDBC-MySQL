<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Log in</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<input type="hidden" id="status"
		value=<%= request.getAttribute("status") %>>
	<div class="wrapper">
		<h2>LogIn..</h2>
		<form method="post" action="login">
			<div class="input-box">
				<input type="email" placeholder="Email" name="email" required>
			</div>
			<div class="input-box">
				<input type="password" placeholder="password" name="password"
					required>
			</div>
			<div class="policy">
				<input type="checkbox">
				<h3>Remember me</h3>
			</div>
			<div class="input-box button">
				<input type="Submit" value="Login">
			</div>
			<div class="text">
				<h3>
					New here? <a href="./register.jsp">Create Account</a>
				</h3>
			</div>
		</form>
	</div>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	var status = document.getElementById("status").value;
	console.log(status);
	if(status ==  "failure"){
		swal("Sorry !","Wrong Email or password","error");
	}
	else if(status ==  "invalidEmail"){
		swal("Sorry !"," Invalid Email ","error");
	}
	else if(status ==  "invalidPassword"){
		swal("Sorry !","Invalid password","error");
	}
	</script>

</body>
</html>
