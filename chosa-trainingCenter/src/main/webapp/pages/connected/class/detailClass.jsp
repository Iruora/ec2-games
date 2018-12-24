
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



				<div class="col-lg-10 col-md-8 col-sm-7">
					<div class="row">
					<div class="col-lg-8 col-md-8 col-sm-7 r-full-width">
						<div class="course-description">
							<%-- <img class="z-depth-2"
							src="${parenturl}static/theme/image/s-course.jpg" alt=""> --%>
							<div class="related-events-holder z-depth-2">

								<div class="related-events-body">

									<div class="related-events-heading">
										<h4>Classe infomations</h4>
									</div>
									<div class="related-events-body">
										<form:form id="contact-form" class="row" method="post"
											modelAttribute="trainingcenter">
											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
													<form:input type="text" path="name" required="required" />
													<label class="control-label">Name</label><i class="bar"></i>
												</div>
											</div>
											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
													<form:input type="number" path="phone" required="required" />
													<label class="control-label">Phone </label><i class="bar"></i>
												</div>
											</div>




											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
													<form:select path="country.id" class="form-control">
														<c:forEach var="country" items="${countryList}">
															<option value="${country.id}"
																<c:if test="${country.iso == cookie.country.value}"> selected="selected" </c:if>>${country.name}</option>
														</c:forEach>
													</form:select>
													<label class="control-label">Country</label><i class="bar"></i>
												</div>
											</div>


											<div class="col-sm-6 col-xs-6">
												<div class="form-group m-0">
													<form:input type="text" path="adress" required="required" />
													<label class="control-label">Adress </label><i class="bar"></i>
												</div>
											</div>
											<br></br>
											<!-- <div class="row">
											<div class="col-sm-12 col-xs-12">
												<div class="form-group">
													<input type="file" name="file" /> <label
														class="control-label">Logo </label>
												</div>
											</div>
										</div> -->
											<form:hidden path="centerId" />

										</form:form>



										<form:form id="contact-form" class="row" method="post"
											modelAttribute="trainingCenterClass"
											action="/class/detail?trainingCenterClassId=${trainingCenterClassId}">


											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
													<form:input type="text" path="className"
														required="required" />
													<label class="control-label">Class Name</label><i
														class="bar"></i>
												</div>
											</div>


											<br></br>
											<form:hidden path="tcClassId" />
											<div class="col-sm-12 col-xs-12">
												<a class="btn btn-primary waves-effect waves-light  sm " href="/teacher/subscribe?trainingcenterClassId=${trainingCenterClassId}">As
													Teacher</a> <a 
													class="btn btn-success waves-effect waves-light  sm"
													href="/student/subscribe?trainingcenterClassId=${trainingCenterClassId}">As
													Student</a> <a class="btn btn-info waves-effect waves-light  sm ">As
													Parent</a>
											</div>
										</form:form>


									</div>
								</div>
							</div>
						</div>
						</div>
						<div class="col-lg-4 col-sm-4 col-xs-6 r-full-width">
							<div class="team-column style-2 tc-hover">
								<div class="team-img">
									<img src="${parenturl}static/theme/image/s-course.jpg">
								</div>
								<div class="team-detail">

									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		</main>

		<%@ include file="../../includes/sidebar.jsp"%>


		<%@ include file="../../includes/footer.jsp"%>
		</div>
</body>
</html>