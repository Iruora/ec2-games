<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${countDownStart}" var="result"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="${parenturl}/static/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="${parenturl}/static/css/design.css" rel="stylesheet" media="screen">
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
	<div class="container">
		<div class="row well well-lg">
			<a href="" class="btn btn-warning btn-lg col-md-1">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
			</a>
			<div class="btn-group col-md-6">
				<a href="/exercice" class="btn btn-lg btn-primary ">Retour aux exercices</a>
				<a href="/exercice/${operation}" class="btn btn-lg btn-info">Retour aux nombres</a>
			</div>
			<button class="btn btn-success btn-lg col-md-2" type="button">
				Score <a><span class="badge" id="scoreBadge"> </span></a>
			</button>
			<h2 class="col-md-2"> Time left : </h2>
			<h1 id="chrono" class="btn btn-lg btn-info col-md-1">${countDownStart}</h1>
		</div>
		<div class="row  alert alert-warning">
			<h2 class="col-md-offset-4 col-md-4"> Time left : </h2>
			<h1 id="chrono" class="btn btn-lg btn-info col-md-2">${countDownStart}</h1>
		</div>
	</div>
	<div class="container">
		<%--<div class="row well well-lg text-center">--%>
			<%--<h1> Time left : </h1><h1 id="chrono" class="btn btn-lg btn-info">${countDownStart}</h1>--%>
		<%--</div>--%>
		<div id="calcul" class="row">

			<div id="results" class="row"></div>
			<div class="row">
				<div class="well well-lg col-md-3 col-md-offset-3  h100 ftrem" id="op-str"> ${operationString} </div>

				<div class="well well-lg col-md-3 h100">
					<div class="form-group">
						<label for="userInput">Result :</label> 
						<input type="number" id="userInput" class="form-control" autofocus>
						<div class="row" id="next">
							<a id="refresh-btn" class="btn btn-warning btn-lg col-md-4"> 
								<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							</a>
						</div>
					</div>

				</div>
			</div>

			<div class="row ">
				<button id="verifBtn"
					class="btn btn-success btn-lg col-md-6 col-md-10 col-md-offset-3">verify</button>
			</div>

		</div>

<!-- 		<div class="row" id="next"> -->
<!-- 			<a id="refresh-btn" class="btn btn-warning btn-lg"> <span -->
<!-- 				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> -->
<!-- 			</a> -->
<!-- 		</div> -->
	</div>


	<div class="container"></div>
	<script type="text/javascript" src="${parenturl}/static/js/jquery.js"></script>
	<script type="text/javascript"
		src="${parenturl}/static/bootstrap-3.3.7/js/bootstrap.js"></script>

	<script type="text/javascript">



	$(document).ready( function () {
		
		var operationString;
		var resultExpected;
		$.post(
				"/exercice/${operation}/${firstNumber}/sc",
				{success: true},
				data => {

					console.log("Scooooooooooooore !"+data+"${operation}${firstNumber}");
					$("#scoreBadge").text(data);
				}
        	);
	

		function calculGetter(){
			//console.log("begin calcul getter");
			
			$.get(
					
					"/exercice/${operation}/${firstNumber}/result",
					{},
					data => {
						var arrayOfStrings = data.split("#");

						//console.log("result : "+arrayOfStrings);

						$("#verifBtn").show();
						$("#userInput").show();
						$("#userInput" ).focus();
						console.log(arrayOfStrings.length);
						if (arrayOfStrings.length > 2) {
							operationString = arrayOfStrings[2];
							resultExpected = arrayOfStrings[3];
							console.log(operationString);
							console.log(resultExpected);
							console.log(arrayOfStrings.length);
						}
						else console.log("error ! Wrong String input");
						$("#op-str").html(operationString);
						//===================
						$userInputField = $("#userInput");


						$next = $("#next");
						$next.hide();

						if ($userInputField.val() != "") {
							$("#verifBtn").prop( "disabled", false );
						}
						else $("#verifBtn").prop( "disabled", true );

						$userInputField.on("keyup", e => {
							$userInput = $("#userInput").val();
							//console.log("&&&"+$userInputField.val());
							if ($userInputField.val() != "") {
								$("#verifBtn").prop( "disabled", false );
							}
							else $("#verifBtn").prop( "disabled", true );

							if (e.keyCode === 13) {
			        			$("#verifBtn").click();
			    			}
						});
						//=======================================
			    		$("#verifBtn").on("click", (e) => {
			    			$userInput = $("#userInput").val();

			            	$resultsString = $("#results");


			            	//console.log("server : "+resultExpected);
			            	//console.log("client : "+$userInputField.val());
			            	//console.log("entryDiff : "+($userInput - resultExpected));

			            	if ((resultExpected == $userInputField.val()) ) {
			            		//console.log("gut");
			            		$next.show();
			            		//--------------------------------
			            		
			            		//--------------------------------
			                	$( ".demo-container" ).html( "<p>All new content. <em>You bet!</em></p>" );
			                	$resultsString.html("<div class='alert alert-success alert-text' role='alert' id='success-alert' > Très bien ! </div> ");

								//alert("/exercice/${operation}/${firstNumber}/score");
			                	$.post(
									"/exercice/${operation}/${firstNumber}/score",
									{success: true},
									data => {

										//console.log("Scooooooooooooore !"+data);
										$("#scoreBadge").text(data);
									}
			    	        	);
			                	$("#verifBtn").hide();
			                	$("#verifBtn").off("click");
			                	$("#userInput").val("");
			                	$("#userInput").hide();
			                	$("#refresh-btn").click();
			                    	
			            	}
			            	else {
			            		//console.log("Oh snap!");
			            		$next.hide();
			            		$("#userInput").val("");
			                	$resultsString.html("<div class='alert alert-danger alert-text' role='alert' id='failure-alert'>oops ! Réssayez encore une fois !</div>");
			            	}
						

						//===================		
						});
					}
				);
			//console.log("end  calcul getter");
		}
		
		setTimeout(function(){
			calculGetter();	
			$("#test-res").text(resultExpected);
		}, 100);
		
		
		$("#refresh-btn").on("click", (e) => {
			
			
			setTimeout(function(){
				calculGetter();	
			}, 100);
		});

		
		setInterval(function() {
			let y = parseInt($("#chrono").text());
			if ( ! isNaN(y)) {
				y--;
				$("#chrono").text(y);
				if(y == 0) {
					$("#verifBtn").prop( "disabled", true );
					$("#refresh-btn").prop( "disabled", true );
					window.location.href="/exercice/${operation}";
				}
			}
		 },1000);
});

</script>

</body>
</html>