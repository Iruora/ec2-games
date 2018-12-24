
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
					<div class="row">

						<div class="col-md-12 mb-20">

							<!-- Single button -->

							<a class="btn blue sm z-depth-1 pull-right"
								href="${parenturl}family/membres/add">Add</a>

							<div class="row">
								<a href="" class="btn green  pull-left sm">Searche</a> <input
									class="form-control" type="text"
									placeholder="Chercher un contact...">
								<hr />
							</div>
						</div>
					</div>
					<div class="row mt-20">
						<c:forEach var="listValue" items="${listofMemberByFamily}">
							<!-- Team Column -->
							<div class="col-lg-4 col-sm-4 col-xs-6 r-full-width">
								<div class="team-column">

									<img src="${parenturl}static/theme/image/img-01.jpg" alt="">

									<div class="team-detail">
										<br>
										<p>${listValue.user.userEmail}</p>
										<p>${listValue.user.userName}</p>

										<a href="${parenturl}family/membres/update?failyMemberID=${listValue.familyMemberId}" class="btn blue   sm">update</a>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>













				</div>
			</div>

		</section>
		</main>

		<%@ include file="/pages/includes/sidebar.jsp"%>


		<%@ include file="/pages/includes/footer.jsp"%>
</body>
</html>