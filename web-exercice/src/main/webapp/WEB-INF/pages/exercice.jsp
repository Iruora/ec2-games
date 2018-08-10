<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="${parenturl}/static/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">

<link href="${parenturl}/static/css/design.css" rel="stylesheet" media="screen">

<title>exercice</title>
</head>
<body>

	<div class="well well-lg">
		<h1 class="well well-lg title">${greet}</h1>
	</div>
	<br>
	<div class="container">
		<div class="row">

			<div class="col-lg-offset-4 col-md-offset-4">
				<div class="btn-group">
					<a href="/exercice/addition" class="btn btn-success btn-lg operation">+</a>
					<a href="/exercice/soustraction" class="btn btn-warning btn-lg operation">-</a>
				</div>
				<div class="btn-group">
					
					<a href="/exercice/multiplication" class="btn btn-info btn-lg operation">X</a>
					<a href="/exercice/division" class="btn btn-danger btn-lg operation">/</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${parenturl}/static/js/jquery.js"></script>
	<script type="text/javascript"
		src="${parenturl}/static/bootstrap-3.3.7/js/bootstrap.js"></script>

</body>
</html>