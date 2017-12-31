
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

		<main class="main-content"> <!-- Teachers -->

		<section class="team-grid style-2 tc-padding">
			
			<div class="container">
				<%-- <%@ include file="/pages/includes/aside.jsp"%>
 --%>

				<div class="col-lg-12 col-md-8 col-sm-7">
					<a class="btn btn-info col-md-4 btn-xs z-depth-1 "
						href="${parenturl}trainingCenter/member/invite?roleMember=TEACHER">Espace
						Teacher</a> <a class="btn btn-info col-md-4 btn-xs z-depth-1 "
						href="${parenturl}trainingCenter/member/invite?roleMember=STUDENT">Espace
						Student</a>

					<div class="row">

						<div class="col-lg-8 col-md-8 col-sm-7">
							<div class="related-events-heading">
								<h4>Teacher infomations</h4>
							</div>
							<div class="contact-address z-depth-1">
								<form:form id="contact-form" class="row" method="post"
									modelAttribute="user"
									action="${parenturl}trainingCenter/member/register?${_csrf.parameterName}=${_csrf.token}&&roleMember=TEACHER"
									enctype="multipart/form-data">
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:input path="userName" />
											<label class="control-label">User Name</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:input path="userEmail" type="email" />
											<label class="control-label">Email</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:password path="userPassword" />
											<label class="control-label">Password</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<input type="password" name="confirmPassword" /> <label
												class="control-label">Confirme Password</label><i
												class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:input path="firstName" />
											<label class="control-label">First Name</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:input path="lastName" />
											<label class="control-label">Last Name</label><i class="bar"></i>
										</div>
									</div>

									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:input path="phone" type="number" />
											<label class="control-label">Phone Number</label><i
												class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">

										<div class="form-group">
											<form:input path="birthDay" type="date" />
											<label class="control-label">Birthday</label><i class="bar"></i>
										</div>

									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:select path="country.id" class="form-control">
												<c:forEach var="country" items="${countryList}">
													<option value="${country.id}">${country.name}</option>
												</c:forEach>
											</form:select>
											<label class="control-label">Country</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-6 col-xs-6 r-full-width">
										<div class="form-group">
											<form:textarea path="adress" />
											<label class="control-label">Adress</label><i class="bar"></i>
										</div>
									</div>
									<div class="col-sm-12 col-xs-12">
										<!-- 										<div class="form-group"> -->
										<!-- 											<input type="file" name="file" /> <label -->
										<!-- 												class="control-label">Picture </label> -->
										<!-- 										</div> -->
									</div>
									<c:if test="${erreurs ne null}">
										<div class="col-sm-12 col-xs-12">
											<div class="alert alert-danger">
												<ul>
													<c:forEach var="erreur" items="${erreurs}">
														<li>${erreur.getDefaultMessage()}</li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</c:if>
									<button class="btn blue z-depth-1 btn-xs pull-right">save</button>


									<a href="${parenturl}trainingCenter/member?memberRole=REQUEST"
										class="btn blue z-depth-1 btn-xs pull-left"> back</a>
									<form:hidden path="id" />
									<form:hidden path="facebookId" />
									<form:hidden path="googleId" />
									<%-- 								    <form:hidden path="linkedinId"/>										 --%>
								</form:form>
							</div>
						</div>

						<!-- Public Card Column -->
						<div class="col-lg-4 col-sm-4 col-xs-6 r-full-width">
							<div class="team-column style-2 tc-hover">
								<div class="team-img">
									<img id="profilePicture"
										src="${parenturl}getUserPicture?userId=${user.userId}" />
								</div>
								<form method="post"
									action="${parenturl}user/updatePicture?${_csrf.parameterName}=${_csrf.token}&&userId=${user.userId}
									&&roleMember=TEACHER"
									enctype="multipart/form-data">
									<input type="hidden" value="${user.userId }" name="idUser">

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
					notifySuccess("Succ�s", "${updateSuccess}");
				}
			});
		</script>
</body>
</html>