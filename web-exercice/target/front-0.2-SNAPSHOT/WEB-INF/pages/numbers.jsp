<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/static/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">

<link href="/static/css/design.css" rel="stylesheet" media="screen">

<title>${title}</title>
</head>
<body>
	<h1 class="well well-lg text-center">${title}</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2">
				<c:forEach var="i" begin="1" end="${maxNumberForGeneration}">
					<a href="/exercice/${title}/${i}" class="btn btn-lg btn-info col-md-2" id="nb-btn-${i}">${i} <span class="badge" id="bage-${i}"></span></a>
				</c:forEach>
			</div>

		</div>
	</div>

	<script type="text/javascript" src="/static/js/jquery.js"></script>
	<script type="text/javascript"
		src="/static/bootstrap-3.3.7/js/bootstrap.js"></script>
	<script type="text/javascript">
		(function() {
				console.log("enables");
				for( let i = 1; i <= ${maxNumberForGeneration}; i++ ) {
					$("#badge-"+i).text();
					let firstNumber = $("#nb-btn-"+i).text();
					console.log(firstNumber);
					$.post(
						"/exercice/${operation}/"+firstNumber+"/totscore",
						{},
						(data) => {
							console.log("***"+i+"***"+data);
						}
					);
				}
			}
		)();
	</script>
</body>