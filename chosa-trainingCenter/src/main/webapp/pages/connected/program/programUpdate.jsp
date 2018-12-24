
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
				<%-- <%@ include file="/pages/includes/aside.jsp"%> --%>



				<div class="col-lg-12 col-md-8 col-sm-7">

					<div class="row">

						<div class="col-sm-8">
							<div class="course-description">

								<div class="related-events-holder z-depth-2">
									<div class="related-events-heading">
										<h4>Update programme</h4>
									</div>
									<div class="related-events-body">
										<form:form id="contact-form" class="row" method="post"
											modelAttribute="trainingCenterprogram" action="${parenturl}trainingCenter/program/addUpdate">
											
												<div class="col-sm-8 col-xs-4 r-full-width">
													<div class="form-group">
														<form:input path="programName" type="text" />
														<label class="control-label">Programme Name</label><i
															class="bar"></i>
													</div>
												</div>
											
												<div class="col-sm-8 col-xs-4 r-full-width">
													<div class="form-group">
														<form:input path="programduration" type="number" />
														<label class="control-label">Duration</label><i
															class="bar"></i>
													</div>
												</div>
											<form:hidden path="tcProgramId"/>
											<div class="col-sm-12 col-xs-12">
												<button class="btn blue z-depth-1 sm pull-right">save</button>
											</div>
										</form:form>
									</div>

								</div>

							</div>
						</div>


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