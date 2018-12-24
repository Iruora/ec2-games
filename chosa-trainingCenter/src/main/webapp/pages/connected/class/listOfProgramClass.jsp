

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

			<div class="inner-page-heading style-2">
				<div class="main-heading style-2 h-white p-white">
					<h2>Training Center</h2>
					<span class="date">Professeur Hyacinthe</span>
				</div>
			</div>

		</div>

		<main class="main-content"> <!-- Teachers -->
		<section class="team-grid style-2 tc-padding">
			<div class="container">
<a
						href="${parenturl}trainingCenter/classes"
						class="btn  blue pull-left btn-xs ">Back</a>
				<div class="col-lg-12 col-md-8 col-sm-7">
					
					<!-- Teachers -->
					<section class="team-grid style-2 tc-padding">
						<c:forEach var="listValue" items="${listOftrainingCenterProgramNotAttach}">

							<!-- Team Column -->
							<div
								class="masonry-grid col-lg-3 col-sm-4 col-xs-6 r-full-width a clearfix">
								<div class="team-column style-2 tc-hover">
									<div class="team-img pull-left">
										<img src="${parenturl}static/theme/image/iconProgram.png"
											alt="">
									</div>
									<div class="team-detail">
										<h4>Program name</h4>
										<h4>${listValue.programName}</h4>
										<p>Duration: ${listValue.programduration}</p>
										<a
											href="${parenturl}trainingCenter/program/attahToClass?trainingcenterProgramID=${listValue.tcProgramId}
											&&trainingcenterClassID=${connectedTrainingcenterClass.tcClassId}"
											class="btn btn-info sm full-width ">Subscibe</a>

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