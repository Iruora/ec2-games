
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
				<%@ include file="/pages/includes/aside.jsp"%>


				<div class="col-lg-9 col-md-8 col-sm-7">
				
					<div class="row">

						<div class="col-md-12 mb-20">

							<!-- Single button -->

							<a class="btn blue sm z-depth-1 pull-right" href="${parenturl}trainingCenter/member/invite?roleMember=TEACHER">Invite</a> <input
								class="form-control" type="text"
								placeholder="Chercher un contact...">
							<hr />
						</div>
					</div>
					<div class="row ">
					<a class="btn btn-info col-md-4 sm z-depth-1 " href="">Request</a>
					<a class="btn btn-info col-md-4 sm z-depth-1 " href="">Valid</a>
					<a class="btn btn-info col-md-4 sm z-depth-1 " href="">Blocked</a>
					
					</div>
					<div class="row mt-20">
					
						<c:forEach var="listValue" items="${listOfAllMembre}">
							<!-- Team Column -->
							<div class="col-lg-4 col-sm-4 col-xs-6 r-full-width">
								<div class="team-column">
									<div class="team-img ">
										<img src="${parenturl}static/theme/image/img-01.jpg" alt="">
									</div>
									<div class="team-detail">
										<p>${listValue.member.userEmail}</p>
										<p>${listValue.member.userName}</p>
										<p>${listValue.role}</p>
										<a
											href="/teacher/validateAccount?teacherId=${listValue.tcMemberId }"
											class="btn blue sm pull-left"">Validate</a> <a
											href="/teacher/bloquedAccount?teacherId=${listValue.tcMemberId }"
											class="btn btn-danger waves-effect waves-light sm">Bloqued</a>

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