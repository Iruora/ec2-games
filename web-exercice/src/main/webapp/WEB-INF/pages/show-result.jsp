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
<link href="/static/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="/static/css/design.css" rel="stylesheet" media="screen">
</head>
<body>
	<div class="container">
		<div class="row well well-lg">
			<a href="" class="btn btn-warning btn-lg "> <span
				class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
			</a>
			<div class="btn-group ">
				<a href="/exercice" class="btn btn-lg btn-primary">Back to
					exercice</a> <a href="/exercice/${operation}"
					class="btn btn-lg btn-info">Back to numbers</a>
			</div>
			<button class="btn btn-success btn-lg" type="button">
				Score <a><span class="badge" id="scoreBadge"> </span></a>
			</button>


		</div>
	</div>
	<div class="container">
		<div class="row well well-lg text-center">
			<h1 id="chrono"> ${countDownStart}</h1>
		</div>
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
	<script type="text/javascript" src="/static/js/jquery.js"></script>
	<script type="text/javascript"
		src="/static/bootstrap-3.3.7/js/bootstrap.js"></script>

	<script type="text/javascript">



	$(document).ready( function () {
		
		var operationString;
		var resultExpected;
		$.post(
				"/exercice/${operation}/${firstNumber}/sc",
				{success: true},
				data => {

					//console.log("Scooooooooooooore !"+data);
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
			    		$("#verifBtn").on("click", (e)=> {
			    			$userInput = $("#userInput").val();

			            	$resultsString = $("#results");


			            	//console.log("server : "+resultExpected);
			            	//console.log("client : "+$userInputField.val());
			            	//console.log("entryDiff : "+($userInput - resultExpected));

			            	if ((resultExpected == $userInputField.val()) ) {
			            		//console.log("gut");
			            		$next.show();
			            		//--------------------------------
			            		
			            		//$userInputField.on("keyup", e => {
// 									if ($userInputField.val() != "") {
// 										$("#verifBtn").prop( "disabled", false );
// 									}
// 									else $("#verifBtn").prop( "disabled", true );

									if (e.keyCode === 39) {
										console.log("fleche=>");
			        					$("#next").click();
			    					}
								
			            		//--------------------------------
			                	$( ".demo-container" ).html( "<p>All new content. <em>You bet!</em></p>" );
			                	$resultsString.html("<div class='alert alert-success alert-text' role='alert' id='success-alert' > well done ! </div> ");

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
			            	}
			            	else {
			            		//console.log("Oh snap!");
			            		$next.hide();
			            		$("#userInput").val("");
			                	$resultsString.html("<div class='alert alert-danger alert-text' role='alert' id='failure-alert'>oops !</div>");
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