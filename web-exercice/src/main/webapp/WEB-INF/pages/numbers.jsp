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

	<title>${title}</title>
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
	<div class="row well well-lg">

		<div class="btn-group col-md-3">
			<a href="/exercice" class="btn btn-lg btn-primary">Back to exercices</a>

		</div>
		<div class="well well-lg text-center">
			<h1 class="title">${title}</h1>
		</div>

	</div>


	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2">
				<c:forEach var="i" begin="1" end="${maxNumberForGeneration}">
					<a href="/exercice/${title}/${i}" class="btn btn-lg btn-primary col-md-2" id="nb-btn-${i}">${i}
						<span class="badge" id="badge-${i}"></span></a>
				</c:forEach>
			</div>

		</div>
	</div>

	<script type="text/javascript" src="${parenturl}/static/js/jquery.js"></script>
	<script type="text/javascript" src="${parenturl}/static/bootstrap-3.3.7/js/bootstrap.js"></script>
	<script type="text/javascript">
		(function () {
			console.log("enables");
			let gold = ${goldNumber};
			let silver = ${silverNumber};
			//$("p#44.test").css("background-color", "yellow");
			for (let i = 1; i <= ${maxNumberForGeneration}; i++) {
				let scoreBadge = $("#badge-" + i).text();
				//---------------------------------------------
				if (gold != null && silver != null) {
					if (scoreBadge <= silver) {
						//$("#nb-btn-"+i).css("background-color", "#C0C0C0");
						// $("#nb-btn-"+i).addClass( "silver-btn" );
						//$("#nb-btn-"+i).addClass( "silver-btn" );
					} else if (i >= gold) {
						//$("#nb-btn-"+i).css("background-color", "#D4AF37");
						//$("#nb-btn-"+i).addClass( "gold-btn" );
					}
					//else $("#nb-btn-"+i).addClass( "jupiter" );
				}
				let firstNumber = $("#nb-btn-" + i).text();
				console.log("firstNumber" + firstNumber + "--" + "/exercice/${operation}/" + firstNumber + "/totscore");
				$.post(
					"/exercice/${operation}/" + firstNumber + "/totscore", {},
					(data) => {
						let gold = ${goldNumber};
						let silver = ${silverNumber};
						console.log("***"+i+"***"+data);
						var scoreValue = data.split(" ")[2];
						if (gold != null && silver != null) {
							$("#badge-" + i).text(data);
							if (scoreValue <= silver) {
								$("#badge-" + i).addClass("silver-btn");
							} else if (scoreValue >= gold) {
								//$("#nb-btn-"+i).css("background-color", "#D4AF37");
								$("#badge-" + i).addClass("gold-btn");
							}
						}
					}
				);
			}
		})();
	</script>
</body>