<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<a href="" class="btn btn-warning btn-lg"> <span
				class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
			</a>
			<div class="btn-group">
				<a href="/exercice" class="btn btn-lg btn-primary">Back to exercice</a>
				<a href="/exercice/${operation}" class="btn btn-lg btn-info">Back to numbers</a>
			</div>

		</div>
		<div id="results" class="row"></div>
		<div class="row">
			<div class="well well-lg col-lg-3 col-md-offset-3 h100 ftrem">
				${operationString}</div>

			<div class="well well-lg col-lg-3 h100">
				<div class="form-group">
					<label for="userInput">Result :</label> <input type="number"
						id="userInput" class="form-control">
				</div>

			</div>
		</div>

		<div class="row ">
			<button id="verifBtn"
				class="btn btn-success btn-lg col-lg-6 col-md-10 col-md-offset-3">verify</button>
		</div>
		<div class="row" id="next">
			<a href="" class="btn btn-warning btn-lg"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			</a>
		</div>


	</div>



	<script type="text/javascript" src="/static/js/jquery.js"></script>
	<script type="text/javascript"
		src="/static/bootstrap-3.3.7/js/bootstrap.js"></script>
	<script>
		$(document).ready( function () {

			$userInputField = $("#userInput");
			
			
			$next = $("#next");
			$next.hide();

			$userInputField.on("keyup", e => {
				$userInput = $("#userInput").val();
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
	            
	            
	            $resultsString = $("#results");

	            
	            console.log("server : "+${result});
	            console.log("client : "+$userInput);
	            console.log("entryDiff : "+($userInput - ${result}));

	            if ((${result} == $userInput) ) {
	            	console.log("gut");
	            	$next.show();
	                $( ".demo-container" ).html( "<p>All new content. <em>You bet!</em></p>" );
	                $resultsString.html("<div class='alert alert-success alert-text' role='alert' id='success-alert' > well done ! </div> ");
	            }
	            else {
	            	console.log("Oh snap!");
	            	$next.hide();
	                $resultsString.html("<div class='alert alert-danger alert-text' role='alert' id='failure-alert'>oops !</div>");
	            }
	             
	        });
	        //=====================================
	        
		});
    </script>
</body>
</html>