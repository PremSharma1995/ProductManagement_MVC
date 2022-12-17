
<jsp:include page="menu.jsp"></jsp:include><br>




<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>List Of Customer</title>
</head>
<body style="background-color: pink;">


	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<th scope="col">USERNAME</th>

				<%
				String role = (String) session.getAttribute("role");
				if ("Admin".equals(role)) {
				%>

				<th scope="col">PASSWORD</th>
				<%
				}
				%>

				<th scope="col">ROLE</th>
				<th scope="col">GENDER</th>

				<%
				if ("Admin".equals(role)) {
				%>


				<th scope="col">QUESTION</th>
				<th scope="col">ANSWER</th>
				<th scope="col">ACTION</th>
				<%
				}
				%>


			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="cust">
				<tr>
					<td><c:out value="${cust.username}"></c:out></td>


					<%
					if ("Admin".equals(role)) {
					%>

					<td><c:out value="${cust.password}"></c:out></td>
					<%
					}
					%>


					<td><c:out value="${cust.role}"></c:out></td>
					<td><c:out value="${cust.gender}"></c:out></td>
					
					
					<%
					if ("Admin".equals(role)) {
					%>

					<td><c:out value="${cust.question}"></c:out></td>
					<td><c:out value="${cust.answer}"></c:out></td>
					<td><a href="getProfile?username=${cust.username}"
						style="color: green;">Edit</a> <a
						href="deleteCustomer?username=${cust.username}"
						style="color: red;">Delete</a></td>
					<%
					}
					%>
					
					
					
					
				<tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>