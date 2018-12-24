
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
<%@ include file="../../includes/header.jsp"%>


</head>
<body>
	<div class="wrapper push-wrapper">
		<header>
			<%@ include file="../../includes/nav.jsp"%>
		</header>
		<div class="inner-banner dark-bg">
			<div class="container">
				<div class="inner-page-heading style-2">
					<div class="main-heading style-2 h-white p-white">
						<h2>Center training</h2>
						<span class="date">Professeur Hyacinthe</span>
					</div>
				</div>
			</div>
		</div>

		<main class="main-content"> <!-- Teachers -->
		<section class="team-grid style-2 tc-padding">
			<div class="container">
				<%-- <%@ include file="/pages/includes/asidefamily.jsp"%> --%>



				<div class="col-lg-8 col-md-8 col-sm-7">

					<div class="row">

						<div class="col-sm-8">
							<div class="course-description">

								<div class="related-events-holder z-depth-2">
									<div class="related-events-heading">
										<h4>Member infomations</h4>
									</div>
									<div class="related-events-body">
										<form:form id="contact-form" class="row" method="post"
											modelAttribute="user"
											action="${parenturl}family/membres/add?${_csrf.parameterName}=${_csrf.token}"
											enctype="multipart/form-data">
											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
													<form:input path="userName" />
													<label class="control-label">User Name</label><i
														class="bar"></i>
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
													<label class="control-label">First Name</label><i
														class="bar"></i>
												</div>
											</div>
											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
													<form:input path="lastName" />
													<label class="control-label">Last Name</label><i
														class="bar"></i>
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

											<div class="col-sm-12 col-xs-6 r-full-width">
												<div class="form-group">
													<form:textarea path="adress" />
													<label class="control-label">Adress</label><i class="bar"></i>
												</div>
											</div>
											
											
											<div class="col-sm-12 col-xs-12">
												<input type="submit" class="btn blue z-depth-1"
													value="Validate" />
											</div>
											<form:hidden path="id" />
											<form:hidden path="facebookId" />
											<form:hidden path="googleId" />

										</form:form>
									</div>

								</div>

							</div>
						</div>
						<!-- Public Card Column -->
						<div class="col-lg-4 col-sm-4 col-xs-6 r-full-width">
							<div class="team-column style-2 tc-hover">
								<div class="team-img">
									<img src="${parenturl}static/theme/image/s-course.jpg">
								</div>
								<div class="team-detail">

									<button class="btn blue sm mt-20">
										Upload Logo<span class="ripple"></span>
									</button>
								</div>
							</div>
						</div>
						<!-- Public Card Column -->

					</div>
					<!-- Row End -->

					<div class="row"></div>
					<!-- Row End -->
				</div>
		</section>
		</main>

		<%@ include file="../../includes/sidebar.jsp"%>


		<%@ include file="../../includes/footer.jsp"%>
</body>
</html>