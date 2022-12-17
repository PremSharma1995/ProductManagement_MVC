
<%
String username = (String) session.getAttribute("username");
if (username == null) {
	request.setAttribute("msg", "Plz Login First");
	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);

}
%>


<html>
<head>
<title>Home</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">JBK</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>

				<%
				String role = (String) session.getAttribute("role");
				if (role.equals("Admin")) {
				%>
				<li class="nav-item"><a class="nav-link" href="addCustomerPage">Add
						Customer</a></li>
				<%
				}
				%>


				<li class="nav-item"><a class="nav-link" href="addProductPage">Add
						Product</a></li>
				<li class="nav-item"><a class="nav-link" href="getAllCustomer">List
						Of Customer</a></li>
				<li class="nav-item"><a class="nav-link disabled"
					href="listOfCustomer">List Of Products</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Import
						Customer</a></li>
				<li class="nav-item"><a class="nav-link disabled"
					href="getProfile?username=<%=session.getAttribute("username")%>"><%=session.getAttribute("username")%></a>
				</li>
				<li class="nav-item"><a class="nav-link disabled" href="logout">Logout</a>
				</li>

			</ul>
			<!-- <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul> -->
		</div>
	</nav>
</body>
</html>