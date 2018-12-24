
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
				<%-- <%@ include file="/pages/includes/aside.jsp"%> --%>


				<div class="col-lg-9 col-md-8 col-sm-7">
					
					<c:forEach var="listValue" items="${listOfteachers}">
						<div
							class="masonry-grid col-lg-5 col-sm-4 col-xs-6 r-full-width a clearfix">
							<div class="team-column style-2 tc-hover">
								<div class="team-img pull-left">
									<img src="${parenturl}static/theme/image/s-course.jpg" alt="">

								</div>
								<div class="team-detail">
									<h3>${listValue.startDate}</h3>
									
									<p >${listValue.status}</p>
									<p >${listValue.member.userEmail}</p>
									<p >${listValue.member.userName}</p>
									<a href="${parenturl}trainingCenter/teacher/subscribeClasse?teacherID=${listValue.tcMemberId }&&trainingcenterClassId=${tc_class.tcClassId }"
										class="btn blue sm ">Subscribe</a> 
									
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>

		</section>
		</main>

		<%@ include file="/pages/includes/sidebar.jsp"%>


		<%@ include file="/pages/includes/footer.jsp"%>
</body>
</html>