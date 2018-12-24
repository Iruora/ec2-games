<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/pages/includes/header.jsp" %>
<body style="background:#3f51b5">
<div class="login-form">
	  	<div class="modal-content position-center-center tc-hover">
			<a href="<c:url value="${parenturl}" />"><img src="${parenturl}static/theme/theme/images/logo.jpg" alt=""></a>
			<br>
			<h4>Forget password </h4>
			<p>Please write your Email..</p>			
            <form:form class="login-form" method="post" modelAttribute="user" action="forgetpassword">
                <div class="form-group">
                    <form:input path="userEmail"  type="email"/>
                    <label class="control-label">Email</label><i class="bar"></i>
                </div>
                <br>	                              	
                <ul class="btn-list">
					<li><input type="submit" class="btn blue sm full-width" value="validate"/></li>
			    	<li><a href="<c:url value="${parenturl}login" />" class="btn blank dark sm full-width">Login</a></li>
				</ul>	
            </form:form>  
		</div>
	</div>
</body>
</html>