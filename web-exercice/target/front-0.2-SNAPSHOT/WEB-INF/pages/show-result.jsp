<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${result}" var="result"></c:set>

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

	
	<div class="row well well-lg">
		<a href="" class="btn btn-warning btn-lg"> <span
			class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
		</a>
		<div class="btn-group">
			<a href="/exercice" class="btn btn-lg btn-primary">Back to
				exercice</a> <a href="/exercice/${operation}"
				class="btn btn-lg btn-info">Back to numbers</a>
		</div>
		<a>Score :<span class="badge" id="scoreBadge"> </span></a>

	</div>
	<div class="container">
		<div id="calcul"></div>
		<div class="row" id="next">
			<a id="refresh-btn" class="btn btn-warning btn-lg"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			</a>
		</div>
	</div>


	<div class="container"></div>
	<script type="text/javascript" src="/static/js/jquery.js"></script>
	<script type="text/javascript"
		src="/static/bootstrap-3.3.7/js/bootstrap.js"></script>

	<script type="text/javascript">



	$(document).ready( function () {
		var res;

		$.post(
				"/exercice/${operation}/${firstNumber}/sc",
				{success: true},
				data => {

					console.log("Scooooooooooooore !"+data);
					$("#scoreBadge").text(data);
				}
        	);
		function getResult() {
			
			$.get(
					"/exercice/${operation}/${firstNumber}/result",
					{},
					data => {
						console.log("your data :: "+data);
						//return data;
						res = data;
						console.log("your res :: "+data);
					}	
			);

			
			
			return res;
		}

		function calculGetter(res){
			console.log("begin");
			
			$.get(
					"/exercice/${operation}/${firstNumber}/load",
					{},
					data => {
						
						//console.log("result : "+${result});
						$("#calcul").html(data);
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

							if (event.keyCode === 13) {
			        			$("#verifBtn").click();
			    			}
						});
						//=======================================
			    		$("#verifBtn").on("click", (e)=> {
			    			$userInput = $("#userInput").val();

			            	$resultsString = $("#results");


			            	console.log("server : "+res);
			            	console.log("client : "+$userInputField.val());
			            	console.log("entryDiff : "+($userInput - res));

			            	if ((res == $userInputField.val()) ) {
			            		console.log("gut");
			            		$next.show();
			                	$( ".demo-container" ).html( "<p>All new content. <em>You bet!</em></p>" );
			                	$resultsString.html("<div class='alert alert-success alert-text' role='alert' id='success-alert' > well done ! </div> ");

								//alert("/exercice/${operation}/${firstNumber}/score");
			                	$.post(
									"/exercice/${operation}/${firstNumber}/score",
									{success: true},
									data => {

										console.log("Scooooooooooooore !"+data);
										$("#scoreBadge").text(data);
									}
			    	        	);
			                	$("#verifBtn").hide();
			                	$("#verifBtn").off("click");
			            	}
			            	else {
			            		console.log("Oh snap!");
			            		$next.hide();
			                	$resultsString.html("<div class='alert alert-danger alert-text' role='alert' id='failure-alert'>oops !</div>");
			            	}
						

						//===================		
						});
					}
				);
			console.log("end");
		}
		res = getResult();
		setTimeout(function(){
			calculGetter(res);	
			console.log("res = "+res);
		}, 100);
		//alert(res);
		
		$("#refresh-btn").on("click", (e) => {
			
			res = getResult();
			setTimeout(function(){
				calculGetter(res);	
				console.log("res = "+res);
			}, 100);
		});
});

</script>

</body>
</html>