<!DOCTYPE html>
<html lang="en-us">

<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Unity WebGL Player | Stage</title>
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
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
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Juokinga</a>
			</div>
			<ul class="nav navbar-nav">
				<li >
					<a href="${parenturl}">Home</a>
				</li>
				<li class="active">
					<a href="${parenturl}geomirror/">Geomiroir</a>
				</li>
				<li>
					<a href="${parenturl}exercice/">Calculus</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="webgl-content game-container">
		<div id="gameContainer" style="width: 760px; height: 400px"></div>
		<div class="footer">
			<div class="webgl-logo"></div>
			<div class="fullscreen" onclick="gameInstance.SetFullscreen(1)"></div>
			<div class="title">GeoMirror</div>
		</div>
	</div>
</body>

</html>