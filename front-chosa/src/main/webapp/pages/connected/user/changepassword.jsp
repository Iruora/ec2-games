<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/pages/includes/header.jsp" %>
<body style="background:#3f51b5">
<div class="login-form">
  	<div class="modal-content position-center-center tc-hover">
		<a href="<c:url value="${parenturl}" />"><img src="${parenturl}static/theme/theme/images/logo.png" alt=""></a>
		<br>
		<h4><spring:message code='changePassword.title'/></h4>			
        <form:form class="login-form" method="post" modelAttribute="user" action="../../changepassword">
			<div class="form-group">
				<form:password path="password"/>
                <label class="control-label"><spring:message code="user.password"/></label><i class="bar"></i>
            </div>
           	<div class="form-group">
                 <input type="password" name="confirmPassword"/>
                 <label class="control-label"><spring:message code="user.confirmPassword"/></label><i class="bar"></i>
           	</div> 
           	<c:if test="${erreur != null}">
           	<div class="alert alert-danger">
				<ul>
					<li>${erreur}</li>
				</ul>
			</div>
			</c:if>                                	
           	<ul class="btn-list">
				<li><input class="btn blue sm full-width" type="submit" value="<spring:message code='validate'/>"/></li>
				<li><a href="<c:url value="${parent}login" />" class="btn blank dark sm full-width"><spring:message code="login"/></a></li>
			</ul>	
			<form:hidden path="id"/>											
         </form:form>  
	</div>
</div>
</body>
</html>