<!DOCTYPE html>
<html lang="en-us">

<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>GeoMiroir</title>
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<link href="${parenturl}/static/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="/static/css/style.css" rel="stylesheet" media="screen">
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
		<img src="/static/image/wallpaper.png" style = "background-size: cover;
		width : 100vw;
		height: 100vh;
		z-index: -100;	
		position: absolute;">
		<div id="gameContainer" style="width: 960px; height: 600px"></div>
		<div class="footer">
			<div class="webgl-logo"></div>
			<div class="fullscreen" onclick="gameInstance.SetFullscreen(1)"></div>
			<div class="title">GeoMirror</div>
			<ul class="nav navbar-nav">
				<li>
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
	</div>
	<script type="text/javascript" src="${parenturl}/static/js/jquery.js"></script>
	<script type="text/javascript" src="${parenturl}/static/bootstrap-3.3.7/js/bootstrap.js"></script>
</body>

</html>