<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<% 
	String currentUrl=(String) request.getAttribute("javax.servlet.forward.request_uri");
	currentUrl = currentUrl.replace("/CHOSA", "");
	String[] urlAsArray=currentUrl.split("/");
	String url="";
   	int nbr = urlAsArray.length;
	if (currentUrl.endsWith("/")){
		if (nbr < 3){
			url= "./";
		}
		else {
			url= "../";
		}
	}
   	for(int i=0; i<nbr-3;i++){
   		url= "../"+ url;
   	}
   	String parenturl="";
   	if ( (currentUrl.startsWith("/family"))||(currentUrl.startsWith("/program"))||(currentUrl.startsWith("/guest"))||(currentUrl.startsWith("/member"))||(currentUrl.startsWith("/activity"))||(currentUrl.startsWith("/theme"))||(currentUrl.startsWith("/admin")) || (currentUrl.startsWith("/guest"))|| (currentUrl.startsWith("/trainingCenter"))
   			|| (currentUrl.startsWith("/class"))|| (currentUrl.startsWith("/teacher")|| (currentUrl.startsWith("/user")))) {
   		parenturl = "../";
   	}
  	parenturl = parenturl + url;
%>
   <c:set value='<%=url%>'  var="url"></c:set>
   <c:set value='<%=parenturl%>'  var="parenturl"></c:set>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="google-signin-client_id" content="112829718936-uj7ctbg1bq4hdugaufd57p3mrujpdpno.apps.googleusercontent.com">
	    <title>CHOSA</title>
	    <!-- Favicon -->
		<link rel="shortcut icon" href="${parenturl}static/theme/theme/images/favicon.ico" type="image/x-icon">
		<!-- StyleSheets -->
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.3/summernote.css" rel="stylesheet">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/bootstrap.min.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/style.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/main.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/color.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/custom.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/responsive.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/transition.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/animate.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css//font-awesome.min.css">
		<link rel="stylesheet" href="${parenturl}static/theme/theme/css/bootstrap-social.css">
		<!-- FontsOnline -->
		<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
		<script src="${parenturl}static/theme/theme/js/modernizr.js"></script>
		<script src="https://apis.google.com/js/platform.js" async defer></script>
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
<script>
function redirectPost(url, data) {
    var form = document.createElement('form');
    form.method = 'post';
    form.action = url;
    var input = document.createElement('input');
    input.type = 'hidden';
    input.name = "${_csrf.parameterName}";
    input.value = "${_csrf.token}";
    form.appendChild(input);
    for (var name in data) {
        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = name;
        input.value = data[name];
        form.appendChild(input);
    }
    document.body.appendChild(form);
    form.submit();
}
</script>
<script id="fb-root">
  window.fbAsyncInit = function() {
  FB.init({
    appId      : '1936491386616781',
    oauth   : true,
    status  : true, // check login status
    cookie  : true, // enable cookies to allow the server to access the session
    xfbml   : true,
    version    : 'v2.8'
  });
  };
  (function() {
	    var e = document.createElement('script');
	    e.src = document.location.protocol + '//connect.facebook.net/en_US/all.js';
	    e.async = true;
	    document.getElementById('fb-root').appendChild(e);
	}());
</script>
<form action="${parenturl}/logout" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>