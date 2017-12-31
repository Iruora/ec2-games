
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

						<div class="col-sm-8 col-md-offset-2">
							<div
								class="masonry-grid col-lg-8 col-sm-4 col-xs-6 r-full-width a clearfix">
								<div class="team-detail">
									<h2>Program Informations</h2>
									<h4></h4>
									<h4>Program name: ${program.programName}</h4>
									<h4></h4>
									<p>Duration: ${program.programduration} days</p>
									<br> <br> <br>
								</div>
							</div>

						</div>
						<a href="${parenturl}teacher/classes" class="btn blue sm ">Go
							Back</a>
						<div class="col-sm-12">
							<c:forEach var="listValue" items="${listOftrainingCenterTheme}">

								<!-- Team Column -->
								<div
									class="masonry-grid col-lg-3 col-sm-3 col-xs-6 r-full-width a clearfix">
									<div class="team-column style-2 tc-hover">
										<div class="team-img ">
											<img src="../static/theme/image/iconProgram.png" alt="">
											<h4>${listValue.themeName}</h4>
											<p>${listValue.themeDescription}</p>
											<p>${listValue.themeOrdre}</p>
											<a
												href="${parenturl}theme/activities?trainingcenterThemeID=${listValue.tcThemeId}&&role=teacher&&programId=${program.tcProgramId}"
												class="btn blue sm ">activites</a>

										</div>
									</div>
								</div>

							</c:forEach>
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