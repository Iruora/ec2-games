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
				
					<a class="btn green sm z-depth-1 pull-right" href="${parenturl}trainingCenter/program/theme/activity/add?trainingcenterThemeID=${trainingCenterTheme.tcThemeId}">Create
						Activty</a>
						<a class="btn  sm z-depth-1 pull-right" href="${parenturl}trainingCenter/program/theme/activities?trainingcenterThemeID=${trainingCenterTheme.tcThemeId}&&role=director">Go Back</a>
					<div class="row">
						<a href="" class="btn blue  z-depth-1 pull-left sm">Search</a> <input
							class="form-control" type="text"
							placeholder="Search activity ...">
					</div>
					<div class="row col-md-offset-1">
					<a class="btn col-md-2   sm z-depth-1 " href="">Logic</a>
					<a class="btn col-md-2 sm z-depth-1 " href="">Visuel</a>
					<a class="btn col-md-2 sm z-depth-1 " href="">Science</a>
					<a class="btn col-md-2 sm z-depth-1 " href="">Language</a>
					<a class="btn col-md-2 sm z-depth-1 " href="">Social</a>
					</div>
					<!-- Teachers -->
						<section class="team-grid style-2 tc-padding">
						<c:forEach var="listValue" items="${listOfactivitiesNotAttachToTheme}">



							<!-- Team Column -->
							<div
								class="masonry-grid col-lg-4 col-sm-4 col-xs-6 r-full-width a clearfix">
								<div class="team-column style-2 tc-hover">
								
									<div class="team-detail">
										<h3 >${listValue.trainingCenterActivity.activityName}</h3>
										<h5>${listValue.trainingCenterActivity.minNumber}-${listValue.trainingCenterActivity.maxNumber} Students</h5>
										<h5>${listValue.trainingCenterActivity.minAge}-${listValue.trainingCenterActivity.maxAge} years</h5>
										<h5>Duration ${listValue.trainingCenterActivity.durationActivity}</h5>
										<a
											href="${parenturl}trainingCenter/program/theme/attachActivity?trainingcenterThemeID=${trainingCenterTheme.tcThemeId}&&trainingcenterActivityID=${listValue.trainingCenterActivity.tcActivityId}"
											class="btn btn-info sm ">subscribe</a>
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