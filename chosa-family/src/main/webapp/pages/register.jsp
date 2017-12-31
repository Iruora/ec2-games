<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/pages/includes/header.jsp"%>

<body>
	<!-- Wrapper -->
	<div class="wrapper push-wrapper">
		<!-- Header -->
		<header>
			<%@ include file="/pages/includes/nav.jsp"%>
			<!-- Inner Banner -->
			<div class="inner-banner dark-bg">
				<div class="container">
					<div class="inner-page-heading">
						<div
							class="main-heading style-2 h-white p-white position-center-x">
							<h2>Register</h2>
						</div>
					</div>
				</div>
			</div>
			<!-- Inner Banner -->
			<!-- Header -->
		</header>
		<!-- Main Content -->
		<main class="main-content">
			<!-- Adress Nd Map -->
			<div class="tc-padding-bottom">
				<div class="container">
					<div class="contact-inner">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-7">
								<div class="contact-address z-depth-1">		
               						<form:form id="contact-form" class="row" method="post" modelAttribute="user" action="${parenturl}register?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" >
					                   <div class="col-sm-6 col-xs-6 r-full-width">
				                   			<div class="form-group">
					                       		<form:input path="userName" />
					                       		<label class="control-label">User Name</label><i class="bar"></i>
					                   		</div>
				                   		</div>
				                   		<div class="col-sm-6 col-xs-6 r-full-width">
					                   		<div class="form-group">
					                       		<form:input path="userEmail" type="email"/>
					                       		<label class="control-label">Email</label><i class="bar"></i>
					                   		</div>
				                   		</div>
				                   		<div class="col-sm-6 col-xs-6 r-full-width">
					                   		<div class="form-group">
					                       		<form:password path="userPassword"/>
					                       		<label class="control-label">Password</label><i class="bar"></i>
					                   		</div>
				                   		</div>
			                   			<div class="col-sm-6 col-xs-6 r-full-width">
					                  		<div class="form-group">
					                       		<input type="password" name="confirmPassword"/>
					                       		<label class="control-label">Confirme Password</label><i class="bar"></i>
					                   		</div>
				                   		</div>
				                   		<div class="col-sm-6 col-xs-6 r-full-width">                                 
					                   		<div class="form-group">
					                       		<form:input path="firstName" />
					                       		<label class="control-label">First Name</label><i class="bar"></i>
					                   		</div>
				                   		</div>
				                   		<div class="col-sm-6 col-xs-6 r-full-width">
					                   		<div class="form-group">
					                       		<form:input path="lastName" />
					                       		<label class="control-label">Last Name</label><i class="bar"></i>
					                   		</div>
				                   		</div>
				                   		
				                   		<div class="col-sm-6 col-xs-6 r-full-width">
					                   		<div class="form-group">
					                       		<form:input path="phone" type="number"/>
					                       		<label class="control-label">Phone Number</label><i class="bar"></i>
					                   		</div>
				                   		</div>
				                   		<div class="col-sm-6 col-xs-6 r-full-width">
				                   		
				                   		<div class="form-group">
					                       		<form:input path="birthDay" type="date"/>
					                       		<label class="control-label">Birthday</label><i class="bar"></i>
					                   		</div>
				                   		
				                   		</div>
				                   		<div class="col-sm-6 col-xs-6 r-full-width">
					                   		<div class="form-group">
			                                    <form:select path="country.id" class="form-control">
			                                 		<c:forEach var="country" items="${countryList}">
							               				<option value="${country.id}">${country.name}</option>
						               				</c:forEach>
												</form:select>
					                       		<label class="control-label">Country</label><i class="bar"></i>
					                   		</div>
				                   		</div>
				                   		<div class="col-sm-6 col-xs-6 r-full-width">
					                   		<div class="form-group">
					                       		<form:textarea path="adress" />
					                       		<label class="control-label">Adress</label><i class="bar"></i>
					                       	</div>	
					                   </div>
									<div class="col-sm-12 col-xs-12">
<!-- 										<div class="form-group"> -->
<!-- 											<input type="file" name="file" /> <label -->
<!-- 												class="control-label">Picture </label> -->
<!-- 										</div> -->
									</div>
									<c:if test="${erreurs ne null}">
										<div class="col-sm-12 col-xs-12">
											<div class="alert alert-danger">
												<ul>
													<c:forEach var="erreur" items="${erreurs}">
														<li>${erreur.getDefaultMessage()}</li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</c:if>
									<div class="col-sm-12 col-xs-12">
										<input type="submit" class="btn blue z-depth-1"
											value="Validate" />
									</div>
									<form:hidden path="id" />
																	    <form:hidden path="facebookId"/>
																	    <form:hidden path="googleId"/>
									<%-- 								    <form:hidden path="linkedinId"/>										 --%>
								</form:form>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-5">
							<div class="pricing-plan-holder bg-1 p-50">
								<p class="white">
									<b>Chosa.com</b>
								</p>
								<ul class="check-list">
									<li>ligne 1</li>
									<li>ligne 2</li>
									<li>ligne 3</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Adress Nd Map --> </main>
	</div>
	<!-- Main Content -->
	<%@ include file="/pages/includes/footer.jsp"%>
</body>
</html>