<html>
	<head>
		<meta charset="utf-8">
		<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
		<link href="${parenturl}/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="${parenturl}/static/css/style.css" rel="stylesheet" media="screen">
		
		
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Juokinga</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<li><a href="/geomirror/">Geomiroir</a></li>
					<li><a href="/exercice/">Calculus</a></li>
				</ul>
			</div>
		</nav>

		<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
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
		<img src="/static/image/bg.png" id="bg-pic">
		<div class="container">
			<div class="row">
				<img id="penguin" alt="geomirroir" src="/static/image/penguin.png" width="200px" height="250px" class="col-md-3 col-md-offset-5">
			</div>
			<div class="row">
				<div class="col-md-offset-2 col-md-5"><a href="${parenturl}geomirror/"><img class="zoom" alt="geomirroir" src="/static/image/geomirror.png" width="250px" height="250px"></a></div>
				<div class=" col-md-5"><a href="${parenturl}exercice/"><img class="zoom" alt="calculus" src="/static/image/calculus.png" width="250px" height="250px"></a></div>
			</div>
			
		</div>
		
		<script type="text/javascript" src="${parenturl}/static/js/jquery.js"></script>
		<script type="text/javascript" src="${parenturl}/static/bootstrap-3.3.7/js/bootstrap.js"></script>
	
	</body>
</html>