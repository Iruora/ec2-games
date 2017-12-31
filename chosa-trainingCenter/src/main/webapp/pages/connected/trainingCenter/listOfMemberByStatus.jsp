
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						
						<form id="contact-form" class="row" method="get"
						action="${parenturl}trainingCenter/membersearch">
						<button class="btn blue  z-depth-1 pull-left sm" type="submit">search</button>
						<a class="btn green sm z-depth-1 pull-right"
								href="${parenturl}trainingCenter/member/invite?roleMember=TEACHER">Invite</a>
						<input class="form-control" type="text" name="userName"
							placeholder="Search member..." />

					</form>

							
					</div>
					<div class="row ">
						<a class="btn btn-info col-md-4 sm z-depth-1 "
							href="${parenturl}trainingCenter/member?memberRole=REQUEST">Request</a> <a
							class="btn btn-info col-md-4 sm z-depth-1 "
							href="${parenturl}trainingCenter/member?memberRole=VALIDATE">Valid</a> <a
							class="btn btn-info col-md-4 sm z-depth-1 "
							href="${parenturl}trainingCenter/member?memberRole=BLOQUED">Blocked</a>

					</div>
					<div class="row mt-20">

						<c:forEach var="listValue" items="${listOfMembreBystatus}">
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
										<c:if test="${memberRole eq 'REQUEST' }">
											<a
												href="${parenturl}trainingCenter/member/ValidorBloquedAccount?memberId=${listValue.tcMemberId }&&
												statusMember=REQUEST"
												class="btn blue sm ">Validate</a>
										</c:if>
										<c:if test="${memberRole eq 'VALIDATE' }">
											<a
												href="${parenturl}trainingCenter/member/ValidorBloquedAccount?memberId=${listValue.tcMemberId }&&
												statusMember=VALIDATE"
												class="btn btn-danger waves-effect waves-light sm">Bloqued</a>

										</c:if>
										<c:if test="${memberRole eq 'BLOQUED' }">
											<a
												href="${parenturl}trainingCenter/member/ValidorBloquedAccount?memberId=${listValue.tcMemberId }&&
												statusMember=BLOQUED"
													class="btn blue sm ">Validate</a>

										</c:if>
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