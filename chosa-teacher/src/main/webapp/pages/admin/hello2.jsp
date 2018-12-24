<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>

admin dashboard
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>Welcome : ${pageContext.request.userPrincipal.name} 
                 | <a href="#" onClick="logout()"> Logout</a></h2>  
	</c:if>
	
	
	<form action="${parenturl}logout" id="logoutForm" method="post"
        style="display: inline-block;">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />  
    </form>
    <script type="text/javascript">
    
    function logout() {
        document.getElementById("logoutForm").submit();
    }
    </script>
</body>
</html>