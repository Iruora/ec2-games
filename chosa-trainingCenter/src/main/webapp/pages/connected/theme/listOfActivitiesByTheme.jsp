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
					<div class="col-md-12">
						<a class="btn green sm z-depth-1 pull-right"
							href="${parenturl}trainingCenter/program/theme/activitiesNotAttach?trainingcenterThemeID=${trainingCenterTheme.tcThemeId}"> Activity</a>
							<a class="btn  sm z-depth-1 pull-right"
							href="${parenturl}trainingCenter/program/themes?trainingcenterProgramID=${program.tcProgramId}"> Go Back</a>
						<div class="col-md-4">
							<img src="../static/theme/image/iconProgram.png" alt="">
						</div>
						<div class="col-md-8">


							<div class="team-detail">

								<h2>${trainingCenterTheme.themeName}</h2>
								<h3>${trainingCenterTheme.themeDescription}</h3>


							</div>

						</div>
					</div>
					<!-- Teachers -->
					<section class="team-grid style-2 tc-padding">
						<table id="example" class="display table"
							style="width: 100%; cellspacing: 0;">
							<thead>
								<tr>
									<th>Activity</th>
									<th>Age</th>
									<th>Duration</th>
									<th></th>
									<th></th>
									<th></th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="listValue"
									items="${listOftrainingCenterActivitiesByTheme}">
									<tr>
										<td>${listValue.trainingCenterActivity.activityName}</td>
										<td>${listValue.trainingCenterActivity.minAge}-${listValue.trainingCenterActivity.maxAge}</td>
										<td>${listValue.trainingCenterActivity.durationActivity}</td>
										<td></td>
										<td></td>
										<td></td>
										<td>
										<a
											href="${parenturl}trainingCenter/program/theme/activity/details?trainingcenterActivityID=${listValue.trainingCenterActivity.tcActivityId}&&
											trainingcenterThemeID=${trainingCenterTheme.tcThemeId}"
											class="btn btn-info sm">view</a>
										<a
											href="${parenturl}trainingCenter/program/theme/activity/add?trainingcenterActivityID=${listValue.trainingCenterActivity.tcActivityId}&&
											trainingcenterThemeID=${trainingCenterTheme.tcThemeId}"
											class="btn btn-success  sm">Edit</a><a
											href="${parenturl}trainingCenter/program/theme/activityThemeDelete?trainingcenterActivityThemeID=${listValue.tcThemeActivityId}&&
											trainingcenterThemeID=${trainingCenterTheme.tcThemeId}"
											class="btn btn-danger  sm">Remove</a></td>
											</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						
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