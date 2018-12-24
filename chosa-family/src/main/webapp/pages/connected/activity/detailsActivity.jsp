
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



				<div class="col-lg-6 col-md-8 col-sm-7">
					<c:if test="${trainingCenterTheme ne null }">
						<a
							href="${parenturl}trainingCenter/program/theme/activities?trainingcenterThemeID=${trainingCenterTheme.tcThemeId}&&role=director"
							class="btn btn-info sm pull-left">Go back</a>
					</c:if>
					<c:if test="${trainingCenterTheme eq null }">
						<a href="${parenturl}family/activites?subject=LOGIC"
							class="btn btn-info sm pull-left">Go back</a>
					</c:if>
					<div class="row">

						<div class="col-sm-12">
							<div class="course-description">

								<div class="related-events-holder z-depth-2">
									<div class="related-events-heading">
										<center>
											<h3>Details activity</h3>
										</center>
									</div>
									<div class="related-events-body">
										<form:form id="contact-form" class="row" method="post"
											modelAttribute="trainingCenterActivity">

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


											<div class="col-sm-12 col-xs-12">

												<div class="form-group">
													<h3>Subject : ${trainingCenterActivity.subject}</h3>


												</div>
											</div>


										</form:form>
									</div>

								</div>

							</div>
						</div>


					</div>
					<!-- Row End -->


				</div>
				<div class="col-lg-6 col-md-8 col-sm-7">
					<c:if test="${document ne null}">
						<img
							src="${parenturl}getActivityDocument?activityId=${trainingCenterActivity.tcActivityId}" />
						<a class="btn green sm z-depth-1 full-width"
							href="${parenturl}downloadDocument?activityId=${trainingCenterActivity.tcActivityId}">Dowload</a>

					</c:if>
					<c:if test="${document eq null}">
					<!-- <object type="application/x-shockwave-flash" width="400"
							height="222"
							data="http://www.youtube.com/v/_etwz7NkemE&hl=fr">
							

							<embed src=""
								type="application/x-shockwave-flash" wmode="transparent"
								width="425" height="355"></embed>
							
						</object> -->
					<iframe width="854" height="480"
						src="https://www.youtube.com/embed/${trainingCenterActivity.urlVideo.split('v=')[1].split('&')[0]}" frameborder="0"
						gesture="media" allowfullscreen></iframe>
					
					</c:if>
					
				</div>
			</div>
			
			<!-- Row End -->
	</div>

	</section>
	</main>

	<%@ include file="../../includes/sidebar.jsp"%>


	<%@ include file="../../includes/footer.jsp"%>
</body>
</html>