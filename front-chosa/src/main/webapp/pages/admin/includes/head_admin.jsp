<%@ include file="../../taglibs.jsp"%>
<%
	String currentUrl = (String) request.getAttribute("javax.servlet.forward.request_uri");
	currentUrl = currentUrl.replace("/front", "");
	String[] urlAsArray = currentUrl.split("/");
	String url = "";
	int nbr = urlAsArray.length;
	if (currentUrl.endsWith("/")) {
		if (nbr < 3) {
			url = "./";
		} else {
			url = "../";
		}
	}
	for (int i = 0; i < nbr - 3; i++) {
		url = "../" + url;
	}
	String parenturl = "";
	if ((currentUrl.startsWith("/admin")) || (currentUrl.startsWith("/connected"))) {
		parenturl = "../";
	}
	
	parenturl = parenturl + url;
%>
<c:set value='<%=url%>' var="url"></c:set>
<c:set value='<%=parenturl%>' var="parenturl"></c:set>

<link rel="icon" href="${parenturl}static/images/favicon.ico" />
<!-- Styles -->

<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/bootstrap.admin.min.css"/>"
	rel="stylesheet">

<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/font-awesome.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/pace-theme-flash.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/uniform.default.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/simple-line-icons.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/menu_cornerbox.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/waves.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/switchery.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/myStyle.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/component.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/jquery.datatables.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/jquery.datatables_themeroller.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/bootstrap-editable.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/bootstrap-editable.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/datepicker3.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/modern.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="${parenturl}static/theme/chosa-admin/css/green.css"/>"
	rel="stylesheet">	
<!-- import js files -->
<script src="<c:url value="${parenturl}static/theme/chosa-admin/js/modernizr.js"/>"></script>
<script src="<c:url value="${parenturl}static/theme/chosa-admin/js/snap.svg-min.js"/>"></script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-104378477-1', 'auto');
  ga('send', 'pageview');
</script>