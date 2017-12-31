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
				<%@ include file="/pages/includes/asidefamily.jsp"%>
				<div class="col-lg-9 col-md-8 col-sm-7">
					<a class="btn green sm z-depth-1 pull-right" href="${parenturl}trainingCenter/activity/add">Create
						Activty</a>
					<div class="row">
						<a href="" class="btn blue  z-depth-1 pull-left sm">Search</a> <input
							class="form-control" type="text"
							placeholder="Search activity ...">
					</div>
					<div class="row ">
					<a class="btn col-md-2 sm z-depth-1 " href="${parenturl}trainingCenter/activitiesBysubject?subject=LOGIC">Logic</a>
					<a class="btn col-md-2 sm z-depth-1 " href="${parenturl}trainingCenter/activitiesBysubject?subject=VISUEL">Visuel</a>
					<a class="btn col-md-2 sm z-depth-1 " href="${parenturl}trainingCenter/activitiesBysubject?subject=SCIENCE">Science</a>
					<a class="btn col-md-2 sm z-depth-1 " href="${parenturl}trainingCenter/activitiesBysubject?subject=LANGUAGE">Language</a>
					<a class="btn col-md-2 sm z-depth-1 " href="${parenturl}trainingCenter/activitiesBysubject?subject=SOCIAL">Social</a>
					</div>
					<!-- Teachers -->
						<section class="team-grid style-2 tc-padding">
						<c:forEach var="listValue" items="${listOfAlltrainingCenterActityBysubject}">



							<!-- Team Column -->
							<div
								class="masonry-grid col-lg-4 col-sm-4 col-xs-6 r-full-width a clearfix">
								<div class="team-column style-2 tc-hover">
								
									<div class="team-detail">
										<h3 >${listValue.activityName}</h3>
										<h5>${listValue.minNumber}-${listValue.maxNumber} Students</h5>
										<h5>${listValue.minAge}-${listValue.maxAge} years</h5>
										<h5>Duration ${listValue.durationActivity}</h5>
										<a
											href="${parenturl}trainingCenter/activity/add?trainingcenterActivityID=${listValue.tcActivityId}"
											class="btn btn-info sm ">update</a>
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