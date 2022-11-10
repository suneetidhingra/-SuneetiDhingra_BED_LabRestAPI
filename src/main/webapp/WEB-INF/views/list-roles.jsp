<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Roles Directory</title>
</head>

<body>

	<div class="container">

		<br>
		<h3>Roles Directory</h3>
		<hr>
		
		<a href="/DebateRegistration/roles/add" class="btn btn-primary btn-sm mb-3"> Add Role </a>
		<a href="/DebateRegistration" class="btn btn-primary btn-sm mb-3"> Home </a>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Role Name</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Roles}" var="role">
					<tr>
						<td><c:out value="${role.id}" /></td>
						<td><c:out value="${role.name}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>



