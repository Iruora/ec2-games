
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


		<section class="team-grid style-2 tc-padding">
			<div class="container">

				<%@ include file="/pages/includes/asidefamily.jsp"%>
				<div class="col-lg-9 col-md-8 col-sm-7">
					<div class="row ">
						<a class="btn col-md-2 pull-left sm z-depth-1 " href="${parenturl}family/trainingCenter/Valid">all</a> <a
							class="btn col-md-2 sm z-depth-1 pull-right " href="${parenturl}family/trainingCenter/subscription">subscription</a>
					</div>
					<section class="team-grid style-2 tc-padding">
					<c:forEach var="listValue" items="${listOfTrainingCenterValid}">
						<div
							class="masonry-grid col-lg-4 col-sm-4 col-xs-6 r-full-width a clearfix">
							<div class="team-column style-2 tc-hover">
								<div class="team-img pull-left">
									<img src="${parenturl}static/theme/image/s-course.jpg" alt="">

								</div>
								<div class="team-detail">
									<h3>${listValue.name}</h3>

									<p>${listValue.adress}</p>
									<p>${listValue.manager.userEmail}</p>
									<p>${listValue.manager.userName}</p>
									<a
										href="${parenturl}family/subscribeMember?trainingcenterId=${listValue.centerId}"
										class="btn blue sm  ">Subscribe</a>

								</div>
							</div>
						</div>
					</c:forEach>
					</section>

				</div>
			</div>

		</section>


		<%@ include file="../../includes/sidebar.jsp"%>


		<%@ include file="../../includes/footer.jsp"%>
	</div>
</body>
</html>