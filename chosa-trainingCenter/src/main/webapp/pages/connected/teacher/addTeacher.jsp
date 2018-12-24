
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
<%@ include file="/pages/includes/header.jsp"%>
</head>
<body>
	<div class="wrapper push-wrapper">
		<header>
			<%@ include file="/pages/includes/nav.jsp"%>
		</header>
		<div class="inner-banner dark-bg">
			<div class="container">
				<div class="inner-page-heading style-2">
					<div class="main-heading style-2 h-white p-white">
						<h2>Training Center</h2>
						<span class="date">Professeur Hyacinthe</span>
					</div>
				</div>
			</div>
		</div>

		<main class="main-content"> <!-- Teachers -->
		<section class="team-grid style-2 tc-padding">
			<div class="container">
				<%@ include file="/pages/includes/aside.jsp"%>


				<div class="col-lg-9 col-md-8 col-sm-7">
					<div class="course-description">
						<img class="z-depth-2" src="static/theme/image/s-course.jpg"
							alt="">
						<div class="related-events-holder z-depth-2">

							<div class="related-events-body">
								<form:form id="contact-form" class="row" method="post"
									modelAttribute="user" action="${parenturl}/teacher/add">
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:input path="userName" />
											<label class="control-label">User Name</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:input path="userEmail" type="email" />
											<label class="control-label">Email</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:password path="userPassword" />
											<label class="control-label">Password</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<input type="password" name="confirmPassword" /> <label
												class="control-label">Confirme Password</label><i
												class="bar"></i>
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
											<form:input path="phone" type="number" />
											<label class="control-label">Phone Number</label><i
												class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">

										<div class="form-group">
											<form:input path="birthDay" type="date" />
											<label class="control-label">Birthday</label><i class="bar"></i>
										</div>

									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:select path="country.id" class="form-control">
												<c:forEach var="country" items="${countryList}">
													<option value="${country.id}"
														<c:if test="${country.iso == cookie.country.value}"> selected="selected" </c:if>>${country.name}</option>
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
										<div class="form-group">
											<input type="file" name="file" /> <label
												class="control-label">Picture </label>
										</div>
									</div>



									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<input type="date" name="startDate" required="required" />
											<label class="control-label">Start </label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<input type="date" name="releaseDate"
												required="required" />
											<label class="control-label">Release</label><i class="bar"></i>
										</div>
									</div>


									<form:hidden path="id" />
									<form:hidden path="facebookId" />
									<form:hidden path="googleId" />




									<div class="col-sm-12 col-xs-12">
										<button class="btn blue z-depth-1">save</button>
									</div>
								</form:form>


							</div>
						</div>
					</div>
				</div>
			</div>

		</section>
		</main>

		<%@ include file="/pages/includes/sidebar.jsp"%>


		<%@ include file="/pages/includes/footer.jsp"%>
</body>
</html>