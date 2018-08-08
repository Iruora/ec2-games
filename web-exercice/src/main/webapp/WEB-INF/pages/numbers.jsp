<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="/static/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">

<link href="/static/css/design.css" rel="stylesheet" media="screen">

<title>${title}</title>
</head>
<body>
	
	
	<div class="row well well-lg">

		<div class="btn-group col-md-3">
			<a href="/exercice" class="btn btn-lg btn-primary">Back to exercice</a>

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
					<a href="/exercice/${title}/${i}"
						class="btn btn-lg btn-info col-md-2" id="nb-btn-${i}">${i} 
						<span class="badge" id="badge-${i}"></span></a>
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
				let gold = ${goldNumber};
				let silver = ${silverNumber};
				//$("p#44.test").css("background-color", "yellow");
				for( let i = 1; i <= ${maxNumberForGeneration}; i++ ) {
					$("#badge-"+i).text();
					//---------------------------------------------
					if ( gold != null && silver != null) {
						if(i <= silver) {
							//$("#nb-btn-"+i).css("background-color", "#C0C0C0");
							$("#nb-btn-"+i).addClass( "silver-btn" );
						}
						else if (i >= gold) {
							//$("#nb-btn-"+i).css("background-color", "#D4AF37");
							$("#nb-btn-"+i).addClass( "gold-btn" );
						}
						else $("#nb-btn-"+i).addClass( "jupiter" );
					}
					let firstNumber = $("#nb-btn-"+i).text();
					//console.log(firstNumber);
					$.post(
						"/exercice/${operation}/"+firstNumber+"/totscore",
						{},
						(data) => {
							//console.log("***"+i+"***"+data);
							$("#badge-"+i).text(data);
						}
					);
				}
			}
		)();
	</script>
</body>