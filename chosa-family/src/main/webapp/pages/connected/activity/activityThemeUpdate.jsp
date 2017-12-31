
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
										<h4>Create activity</h4>
									</div>
									<div class="related-events-body">
										<form:form id="contact-form" class="row" method="post"
											modelAttribute="trainingCenterActivity"
											action="${parenturl}theme/activity/addUpdate?trainingcenterThemeID=${trainingCenterTheme.tcThemeId}">

											<div class="col-sm-6 col-xs-4 r-full-width">
												<div class="form-group">
													<form:input path="activityName" type="text" />
													<label class="control-label">Activity Name</label><i
														class="bar"></i>
												</div>
											</div>
											<div class="col-sm-6 col-xs-4 r-full-width">
												<div class="form-group">
													<form:input path="durationActivity" type="number" />
													<label class="control-label">Duration</label><i class="bar"></i>
												</div>
											</div>

											<div class="col-sm-3 col-xs-4 r-full-width">
												<div class="form-group">
													<form:input path="minNumber" type="number" />
													<label class="control-label">Number Min</label><i
														class="bar"></i>
												</div>
											</div>
											<div class="col-sm-3 col-xs-4 r-full-width">
												<div class="form-group">
													<form:input path="maxNumber" type="number" />
													<label class="control-label">Number Max</label><i
														class="bar"></i>
												</div>
											</div>
											<div class="col-sm-3 col-xs-4 r-full-width">
												<div class="form-group">
													<form:input path="minAge" type="number" />
													<label class="control-label">Age Min</label><i class="bar"></i>
												</div>
											</div>
											<div class="col-sm-3 col-xs-4 r-full-width">
												<div class="form-group">
													<form:input path="maxAge" type="number" />
													<label class="control-label">Age Max</label><i class="bar"></i>
												</div>
											</div>
											<div class="col-sm-12 col-xs-4 r-full-width">
												<div class="form-group">
													<form:input path="urlVideo" type="string" />
													<label class="control-label">Video</label><i class="bar"></i>
												</div>
											</div>

											<div class="col-sm-12 col-xs-12">
												<h4>Subject</h4>
												<div class="form-group">

													<label class="radio"> <form:radiobutton
															name="radio-btn" path="subject" value="LOGIC" /> <i></i>
														LOGIC
													</label> <label class="radio"> <form:radiobutton
															name="radio-btn" path="subject" value="VISUEL" /> <i></i>
														VISUEL
													</label> <label class="radio"> <form:radiobutton
															name="radio-btn" path="subject" value="SCIENCE" /> <i></i>
														SCIENCE
													</label> <label class="radio"> <form:radiobutton
															name="radio-btn" path="subject" value="LANGUAGE" /> <i></i>
														LANGUAGE
													</label> <label class="radio"> <form:radiobutton
															path="subject" value="SOCIAL" /> <i></i> SOCIAL
													</label>
												</div>
											</div>
											<form:hidden path="tcActivityId" />
											<div class="col-sm-12 col-xs-12">
												<button class="btn blue z-depth-1 sm pull-right">save</button>
											</div>
										</form:form>
									</div>

								</div>

							</div>
						</div>

						<div class="col-lg-4 col-sm-4 col-xs-6 r-full-width">
							<div class="team-column style-2 tc-hover">
								<%-- <div class="team-img">
									<img
										src="${parenturl}getActivityDocument?activityId=${trainingCenterActivity.tcActivityId}" />
								</div> --%>
								<form method="post"
									action="${parenturl}trainingCenter/activity/updateDocument?${_csrf.parameterName}=${_csrf.token}&&
							activityId=${trainingCenterActivity.tcActivityId}&&trainingcenterThemeID=${trainingCenterTheme.tcThemeId}"
									enctype="multipart/form-data">
									<div>
										<div class="form-group label-floating">
											<h4>upload File</h4>
											<input type="file" class="form-control" name="document" />
										</div>
									</div>
									<input type="hidden"
										value="${trainingCenterActivity.tcActivityId }" name="idUser">

									<div class="col-sm-12 col-xs-12">
										<button class="btn blue z-depth-1 sm pull-right">save</button>
									</div>

								</form>
							</div>
						</div>


					</div>
					<!-- Row End -->

					<div class="row"></div>
					<!-- Row End -->
				</div>
			</div>
		</section>
		</main>

		<%@ include file="../../includes/sidebar.jsp"%>


		<%@ include file="../../includes/footer.jsp"%>
</body>
</html>