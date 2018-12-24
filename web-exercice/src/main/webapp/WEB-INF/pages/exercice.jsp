<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
			<link href="${parenturl}/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">

			<link href="${parenturl}/static/css/design.css" rel="stylesheet" media="screen">

			<title>exercices</title>
			<style>
				.navbar-custom {
					background-color:#229922;
					color:#ffffff;
					border-radius:0;
				}

				.navbar-custom .navbar-nav > li > a {
					color:#fff;
				}

				.navbar-custom .navbar-nav > .active > a {
					color: #ffffff;
					background-color:transparent;
				}

				.navbar-custom .navbar-nav > li > a:hover,
				.navbar-custom .navbar-nav > li > a:focus,
				.navbar-custom .navbar-nav > .active > a:hover,
				.navbar-custom .navbar-nav > .active > a:focus,
				.navbar-custom .navbar-nav > .open >a {
					text-decoration: none;
					background-color: #33aa33;
				}

				.navbar-custom .navbar-brand {
					color:#eeeeee;
				}
				.navbar-custom .navbar-toggle {
					background-color:#eeeeee;
				}
				.navbar-custom .icon-bar {
					background-color:#33aa33;
				}
			</style>
		</head>

		<body>
		<nav class="navbar navbar-default navbar-custom row">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Juokinga</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/">Home</a></li>
						<li><a href="/geomirror/">Geomiroir</a></li>
						<li><a href="/exercice/">Calculus</a></li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div>
		</nav>
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
			<script type="text/javascript" src="${parenturl}/static/bootstrap-3.3.7/js/bootstrap.js"></script>

		</body>

		</html>