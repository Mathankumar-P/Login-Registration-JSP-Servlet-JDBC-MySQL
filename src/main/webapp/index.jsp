<% if(session.getAttribute("username")==null){
	response.sendRedirect("login.jsp"); }
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Info</title>
    <link rel="stylesheet" href="style.css">
   </head>
<body>
  <div class="wrapper">
    <h2>User Info</h2>
	<h3>Welcome <%=session.getAttribute("username") %>!</h3>
	<h3>Mail ID : <%=session.getAttribute("mail") %></h3>
	<h3>Mobile No: <%=session.getAttribute("mobile") %></h3>
	<form method="post" action="logout">
		<div class="input-box button">
	      	<input type="Submit" value="Logout">
	    </div>
    </form>
  </div>

</body>
</html>
