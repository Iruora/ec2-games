

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
					<a class="btn green sm z-depth-1 full-width"
						href="${parenturl}trainingCenter/class/add?trainingCenterId=${trainingCenterId }">Create
						Classe</a>
					<!-- Teachers -->
					<section class="team-grid style-2 tc-padding">
						<c:forEach var="listValue" items="${listOfclasses}">



							<!-- Team Column -->
							<div
								class="masonry-grid col-lg-5 col-sm-4 col-xs-6 r-full-width a clearfix">
								<div class="team-column style-2 tc-hover">
									<div class="team-detail">
									<div class="col-lg-6">
										<h3>${listValue.className}</h3>
										
										<p>Teacher: ${listValue.teacher.userName}</p>
										</div>
										<div class="col-lg-6">
										
										<a
											href="${parenturl}trainingCenter/classes/teacher?trainingCenterClassId=${listValue.tcClassId}"
											class="btn blue sm  ">Teacher</a>
											<br></br>
											<a
											href="${parenturl}trainingCenter/programmes?trainingCenterClassId=${listValue.tcClassId}"
											class="btn blue sm  ">Program</a>
											<br></br>
											</div>
											
											<a
											href="${parenturl}trainingCenter/class/update?trainingCenterClassId=${listValue.tcClassId}"
											class="btn blue sm full-width">Update</a>
											</div>
									</div>
								</div>
							</div>





						</c:forEach>
					</section>
				</div>
			</div>

		</section>
		</main>

		<%@ include file="../../includes/sidebar.jsp"%>


		<%@ include file="../../includes/footer.jsp"%>
</body>
</html>