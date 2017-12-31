
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
<%@ include file="/pages/includes/header.jsp"%>
</head>
<body>
	<div class="wrapper push-wrapper">
		<header>
			<%@ include file="/pages/includes/nav.jsp"%>
		</header>
		<div class="inner-banner dark-bg">
			<div class="container">
				<div class="inner-page-heading style-2">
					<div class="main-heading style-2 h-white p-white">
						<h2>::: ProfiL</h2>
						<span class="date">${user.firstName} ${user.lastName}</span>
					</div>
				</div>
			</div>
		</div>

		<main class="main-content"> <!-- Teachers -->
		<section class="team-grid style-2 tc-padding">
			<div class="container">
				<%@ include file="/pages/includes/asidefamily.jsp"%>
				<div class="col-lg-9 col-md-8 col-sm-7">

					<div class="row">

						<div class="col-sm-8">
							<div class="course-description">

								<div class="related-events-holder z-depth-2">
									<div class="related-events-heading">
										<h4>${message }</h4>
									</div>
									<div class="related-events-body">
										<form:form id="contact-form" class="row" method="post"
											modelAttribute="family" action="${parenturl}family/update">
											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
													<form:input type="text" path="familyName"
														required="required" />
													<label class="control-label">Name</label><i class="bar"></i>
												</div>
											</div>
											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
													<form:input type="number" path="phone" required="required" />
													<label class="control-label">Phone </label><i class="bar"></i>
												</div>
											</div>



											<div class="col-sm-12 col-xs-6 r-full-width">
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


											<div class="col-sm-6 col-xs-6 r-full-width">
												<div class="form-group">
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
											<form:hidden path="familyId" />
											<div class="col-sm-12 col-xs-12">
												<button class="btn blue z-depth-1">update</button>
												<!-- <a href="/trainingCenter/update"
													class="btn green z-depth-1 pull-right">Update</a> -->
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
									<img id="profilePicture" src="${parenturl}getFamilyPicture?familyId=${family.familyId}" />
								</div>
							<form method="post" action="${parenturl}family/updatePicture?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" >
							<input type="hidden" value="${family.familyId }" name="idFamily">
								
								<div class="team-detail">

									
								<input id="profilePictureUploader" type="file" class="hidden"  name="picture"
								accept="image/*"  
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

		<%@ include file="/pages/includes/sidebar.jsp"%>


		<%@ include file="/pages/includes/footer.jsp"%>
		<script type="text/javascript">
		$(function() {
			$('#profilePicture').on('click', function() {
				$('#profilePictureUploader').click();
			});
		});
		
$( document ).ready(function() {
			
			if ('${updateSuccess}' != '') {
				notifySuccess("Succ�s", "${updateSuccess}");
			}
		});
		</script>
</body>
</html>