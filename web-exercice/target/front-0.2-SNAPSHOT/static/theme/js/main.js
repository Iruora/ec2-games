		$(document).ready( function () {

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

	            
	            //console.log("server : "+${result});
	            //console.log("client : "+$userInputField.val());
	            //console.log("entryDiff : "+($userInput - ${result}));

	            if ((${result} == $userInputField.val()) ) {
	            	console.log("gut");
	            	$next.show();
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
	            }
	            else {
	            	//console.log("Oh snap!");
	            	$next.hide();
	                $resultsString.html("<div class='alert alert-danger alert-text' role='alert' id='failure-alert'>oops !</div>");
	            }
	             
	        });
	        //=====================================
	        
		});