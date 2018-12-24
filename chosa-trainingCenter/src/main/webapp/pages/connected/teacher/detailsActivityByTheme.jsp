
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


				<div class="col-lg-7 col-md-8 col-sm-7">


					<!-- <object type="application/x-shockwave-flash" width="400"
							height="222"
							data="http://www.youtube.com/v/_etwz7NkemE&hl=fr">
							

							<embed src=""
								type="application/x-shockwave-flash" wmode="transparent"
								width="425" height="355"></embed>
							
						</object> -->
					<iframe width="854" height="480"
						src="https://www.youtube.com/embed/1N0oyMZ8568" frameborder="0"
						gesture="media" allowfullscreen></iframe>

				</div>
				<div class="col-lg-5 col-md-8 col-sm-7">
					
						
					
						
					
					<div class="row">

						<div class="col-sm-12">
							<div class="course-description">

								<div class="related-events-holder z-depth-2">
									<div class="related-events-heading">
										<h4>Description</h4>
									</div>
									<div class="related-events-body">
										${trainingCenterActivity.descriptionActivity}</div>

								</div>

							</div>
						</div>


					</div>
					<!-- Row End -->


				</div>
				

				<div class="row"></div>
				<!-- Row End -->
<a
							href="${parenturl}theme/activities?trainingcenterThemeID=${trainingCenterTheme.tcThemeId}&&programId=${program.tcProgramId}
							&&role=teacher"
							class="btn btn-info sm pull-right">Go back</a>

			</div>
			
		</section>
		</main>

		<%@ include file="../../includes/sidebar.jsp"%>


		<%@ include file="../../includes/footer.jsp"%>
</body>
</html>