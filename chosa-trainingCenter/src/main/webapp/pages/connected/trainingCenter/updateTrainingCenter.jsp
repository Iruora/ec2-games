
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
		<br>
		<main class="main-content"> <!-- Teachers -->
		<section class="team-grid style-2 tc-padding">
			<div class="container">
				<%@ include file="/pages/includes/aside.jsp"%>




				<div class="col-lg-9 col-md-8 col-sm-7">
					<h1 class="visible-lg bg-danger" align="center"
						style="background-color: red;">Your training centre not Yet
						activated .</h1>
					<div class="row">

						<div class="col-sm-8">
							<div class="course-description">

								<div class="related-events-holder z-depth-2">
									<div class="related-events-heading">
										<h4>Training Center infomations</h4>
									</div>
									<div class="related-events-body">
										<form:form id="contact-form" class="row" method="post"
											modelAttribute="connectedTrainingcenter"
											action="${parenturl}/trainingCenter/update">
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
											<div class="col-sm-6 col-xs-6">
												<div class="form-group m-0">
													<form:input type="text" path="adress" required="required" />
													<label class="control-label">Adress </label><i class="bar"></i>
												</div>
											</div>
											<div class="col-sm-6 col-xs-6 r-full-width">
												<label class="control-label">Country</label><i class="bar"></i>
												<div class="form-group ">
													<form:select path="country.id" class="form-control"
														itemValue="country.name">
														<c:forEach var="c" items="${countryList}">
															<option value="${connectedTrainingcenter.country.id}">${connectedTrainingcenter.country.name}</option>
															<option value="${c.id}">${c.name}</option>
														</c:forEach>
													</form:select>
												</div>

											</div>

											<br></br>

											<form:hidden path="centerId" />
											<div class="col-sm-12 col-xs-12">
												<button class="btn blue z-depth-1">Update</button>
											</div>
										</form:form>


									</div>
								</div>

							</div>

						</div>

						<!-- Public Card Column -->
						<div class="col-lg-4 col-sm-4 col-xs-6 r-full-width">
							<div class="team-column style-2 tc-hover">
								<div class="team-img">
									<img id="profilePicture"
										src="${parenturl}getTcPicture?centerId=${connectedTrainingcenter.centerId}" />
								</div>
								<form method="post"
									action="${parenturl}trainingCenter/updatePicture?${_csrf.parameterName}=${_csrf.token}"
									enctype="multipart/form-data">
									<input type="hidden"
										value="${connectedTrainingcenter.centerId }" name="centerId">

									<div class="team-detail">


										<input id="profilePictureUploader" type="file" class="hidden"
											name="picture" accept="image/*"
											onchange="javascript:this.form.submit();" />
									</div>

								</form>
							</div>
						</div>
						<!-- Public Card Column -->

					</div>
					<!-- Row End -->

					<div class="row"></div>
					<!-- Row End -->
				</div>
			</div>

		</section>
		</main>

		<%@ include file="../../includes/sidebar.jsp"%>


		<%@ include file="../../includes/footer.jsp"%>

		<script type="text/javascript">
			$(function() {
				$('#profilePicture').on('click', function() {
					$('#profilePictureUploader').click();
				});
			});

			$(document).ready(function() {

				if ('${updateSuccess}' != '') {
					notifySuccess("Succès", "${updateSuccess}");
				}
			});
		</script>
</body>
</html>