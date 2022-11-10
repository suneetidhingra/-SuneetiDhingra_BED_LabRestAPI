<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

<title>User Registration</title>
</head>

<body>

	<div class="container">

		<br>
		<h3>User Registration</h3>
		<hr>

		<p class="h4 mb-4">Enter User Details</p>

		<form action="/DebateRegistration/users/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${User.id}" />

			<div class="form-inline">
				<input type="text" name="username" value="${User.username}"
					class="form-control mb-4 col-4" placeholder="Username">
			</div>
			
			<div class="form-inline">
				<input type="password" name="password" value=""
					class="form-control mb-4 col-4" placeholder="Password">
			</div>
			
			<div class="form-inline">
				<input type="text" name="role_ids" value=""
					class="form-control mb-4 col-4" placeholder="Role Id(s)">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>

		<hr>
		<a href="/DebateRegistration" class="btn btn-primary btn-sm mb-3"> Home </a>
	</div>
</body>

</html>










