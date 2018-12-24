

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
				<%@ include file="/pages/includes/aside.jsp"%>
				<div class="col-lg-9 col-md-8 col-sm-7">
					
					
					
						<form id="contact-form" class="row" method="get"
							action="${parenturl}trainingCenter/programSearch">
							<button class="btn blue z-depth-1 sm pull-left" type="submit">search</button>
							<a class="btn green sm z-depth-1 pull-right" href="${parenturl}trainingCenter/program/add">Create
						Program</a>
							<input class="form-control" type="text" name="className"
								placeholder="Chercher un contact..." />

						</form>
						
					
					<!-- Teachers -->
					<section class="team-grid style-2 tc-padding">
						<c:forEach var="listValue" items="${listOftrainingCenterProgramByName}">

							<!-- Team Column -->
							<div
								class="masonry-grid col-lg-4 col-sm-4 col-xs-6  a clearfix">
								<div class="team-column style-2 tc-hover">
									<div>
										<img src="${parenturl}static/theme/image/iconProgram.png" alt="">
									</div>
									<div class="team-detail">
										<h4>Program name</h4>
										<h4>${listValue.programName}</h4>
										<p>Duration: ${listValue.programduration}</p>
										<a href="${parenturl}trainingCenter/program/add?trainingcenterProgramID=${listValue.tcProgramId}" class="btn btn-info full-width sm ">Update</a>
										 <a
											href="${parenturl}trainingCenter/program/themes?trainingcenterProgramID=${listValue.tcProgramId}" class="btn btn-success full-width sm ">Themes</a>
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