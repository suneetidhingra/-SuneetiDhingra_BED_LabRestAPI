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

<title>Debate Registration Portal</title>
</head>

<body>

	<div class="container">

		<br>
		<h3>Welcome to Debate Registration</h3>
		<hr>
		
		<a href="/DebateRegistration/users/add" class="btn btn-primary btn-sm mb-3"> Register </a>
		<a href="/DebateRegistration/login" class="btn btn-primary btn-sm mb-3"> Login </a>
		<a href="/DebateRegistration/roles/list" class="btn btn-primary btn-sm mb-3"> List Roles </a>
		
	</div>

</body>
</html>