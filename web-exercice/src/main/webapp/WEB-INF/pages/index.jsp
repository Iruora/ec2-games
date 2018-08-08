<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Unity WebGL Player | Stage</title>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet" media="screen">
<link rel="shortcut icon" href="/static/TemplateData/favicon.ico">
<link rel="stylesheet" href="/static/TemplateData/style.css">
<script src="/static/TemplateData/UnityProgress.js"></script>
<script src="/static/Build/UnityLoader.js"></script>
<script>
	var gameInstance = UnityLoader.instantiate("gameContainer",
			"/static/Build/WebBuilds.json", {
				onProgress : UnityProgress
			});
</script>
</head>
<body>
	<div class="webgl-content game-container">
		<div id="gameContainer" style="width: 960px; height: 600px"></div>
		<div class="footer">
			<div class="webgl-logo"></div>
			<div class="fullscreen" onclick="gameInstance.SetFullscreen(1)"></div>
			<div class="title">Stage</div>
		</div>
	</div>
</body>
</html>