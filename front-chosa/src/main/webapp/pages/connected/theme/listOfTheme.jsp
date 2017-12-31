

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
					<a class="btn green sm z-depth-1 pull-right"
						href="${parenturl}trainingCenter/program/theme/add?trainingcenterProgramID=${trainingCenterProgram.tcProgramId}">Create
						Theme</a>
					<div class="row">
						<a href="" class="btn blue  z-depth-1 pull-left sm">Searche</a> <input
							class="form-control" type="text"
							placeholder="Chercher un contact...">
						<hr />
					</div>

					<div
						class="masonry-grid col-lg-4 col-sm-4 col-xs-6 r-full-width a clearfix">
						<img src="${parenturl}static/theme/image/iconProgram.png" alt="">
					</div>

					<div
						class="masonry-grid col-lg-8 col-sm-4 col-xs-6 r-full-width a clearfix">
						<div class="team-detail">
							<h2>Program Informations</h2>
							<h4></h4>
							<h4>Program name: ${trainingCenterProgram.programName}</h4>
							<h4></h4>
							<p>Duration: ${trainingCenterProgram.programduration}</p>
							<br> <br> <br>
						</div>
					</div>

					<!-- Teachers -->
					<section class="team-grid style-2 tc-padding">
						<c:forEach var="listValue" items="${listOftrainingCenterTheme}">

							<!-- Team Column -->
							<div
								class="masonry-grid col-lg-4 col-sm-4 col-xs-6 r-full-width a clearfix">
								<div class="team-column style-2 tc-hover">
									<div class="team-img ">
										<img src="${parenturl}static/theme/image/iconProgram.png" alt="">
										<h4>${listValue.themeName}</h4>
										<p>${listValue.themeDescription}</p>
										<p>${listValue.themeOrdre}</p>
										<a
											href="${parenturl}trainingCenter/program/theme/add?trainingcenterProgramID=${trainingCenterProgram.tcProgramId}&&trainingcenterThemeID=${listValue.tcThemeId}"
											class="btn btn-info full-width sm ">Update</a> <a
											href="${parenturl}trainingCenter/program/theme/activities?trainingcenterThemeID=${listValue.tcThemeId}&&role=director"
											class="btn btn-success full-width sm">Activities</a>

									</div>
								</div>
							</div>

						</c:forEach>
					</section>
				</div>
			</div>

		</section>
		</main>
	</div>
	<%@ include file="../../includes/sidebar.jsp"%>


	<%@ include file="../../includes/footer.jsp"%>
</body>
</html>