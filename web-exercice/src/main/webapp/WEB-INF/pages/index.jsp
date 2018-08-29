<!DOCTYPE html>
<html lang="en-us">

<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>GeoMiroir</title>
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<link href="${parenturl}/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="${parenturl}/static/css/style.css" rel="stylesheet" media="screen">
	<link rel="shortcut icon" href="${parenturl}/static/TemplateData/favicon.ico">
	<link rel="stylesheet" href="${parenturl}/static/TemplateData/style.css">
	<script src="${parenturl}/static/TemplateData/UnityProgress.js"></script>
	<script src="${parenturl}/static/Build/UnityLoader.js"></script>
	<script>
		var gameInstance = UnityLoader.instantiate("gameContainer",
			"${parenturl}/static/Build/WebBuilds.json", {
				onProgress: UnityProgress
			});
	</script>
</head>

<body>
	
	<div class="webgl-content game-container">
		<div id="gameContainer" style="width: 960px; height: 600px"></div>
		<div class="footer">
			<div class="webgl-logo"></div>
			<div class="fullscreen" onclick="gameInstance.SetFullscreen(1)"></div>
			<div class="title">GeoMirror</div>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Juokinga</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="webgl-logo"></li>
						<li class="fullscreen" onclick="gameInstance.SetFullscreen(1)"></li>
						<li >
							<a href="/">Home</a>
						</li>
						<li class="active">
							<a href="/geomirror/">Geomiroir</a>
						</li>
						<li>
							<a href="/exercice/">Calculus</a>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	<script type="text/javascript" src="${parenturl}/static/js/jquery.js"></script>
	<script type="text/javascript" src="${parenturl}/static/bootstrap-3.3.7/js/bootstrap.js"></script>
</body>

</html>