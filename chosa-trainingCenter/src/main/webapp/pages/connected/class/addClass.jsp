
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
						<h2> Training Center</h2>
						<span class="date">Professeur Hyacinthe</span>
					</div>
				</div>
			</div>
		</div>

		<main class="main-content"> <!-- Teachers -->
		<section class="team-grid style-2 tc-padding">
			<div class="container">
			


				<div class="col-lg-9 col-md-8 col-sm-7">
					<div class="course-description">
						<img class="z-depth-2"
							src="${parenturl}static/theme/image/s-course.jpg" alt="">
						<div class="related-events-holder z-depth-2">

							<div class="related-events-body">
								<form:form id="contact-form" class="row" method="post"
									modelAttribute="trainingCenterclass" action="${parenturl}trainingCenter/class/add">
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:input type="text" path="className" required="required" />
											<label class="control-label">Name</label><i class="bar"></i>
										</div>
									</div>
									


									

									<%-- <div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:select path="teacher" class="form-control">
												<c:forEach var="user" items="${listOfTeacherValid}">
													<option value="${user.tcMemberId}">
													${user.member.userEmail}</option>
												</c:forEach>
											</form:select>
											<label class="control-label">teacher</label><i class="bar"></i>
										</div>
									</div>
 --%>

									
									<br></br>
									
									<div class="col-sm-12 col-xs-12">
										<button class="btn blue z-depth-1">save</button>
									</div>
								</form:form>


							</div>
						</div>
					</div>
				</div>
			</div>

		</section>
		</main>

		<%@ include file="../../includes/sidebar.jsp"%>


		<%@ include file="../../includes/footer.jsp"%>
</body>
</html>