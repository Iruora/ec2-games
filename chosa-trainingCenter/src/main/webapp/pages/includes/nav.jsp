<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Top Bar -->
<div class="top-bar">
	<div class="container">

		<!-- Address List -->
		<div class="address-list-top">
			
		</div>
		<!-- Address List -->

		<!-- Login -->
		<div class="login-option">
			<ul class="nav navbar-top-links navbar-right">
				<sec:authorize access="isAnonymous()">
					<li><a style="padding: 0"
						href="<c:url value="${parenturl}login" />">Anonymos<i
							class="fa fa-sign-out"></i></a></li>
				</sec:authorize>
				<!-- /.dropdown -->
				<sec:authorize access="isAuthenticated()">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" style="padding: 0"> <i
							class="fa fa-user fa-fw"></i><i class="fa fa-caret-down"></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="<c:url value="/user/myprofil" />"><i
									class="fa fa-user fa-fw"></i>Profile</a> <sec:authorize
									access="hasRole('ROLE_ADMIN')">
									<a href="<c:url value="${parenturl}admin/users" />"><i
										class="fa fa-dashboard fa-fw"></i> Admin</a>
								</sec:authorize> <sec:authorize
									access="hasAnyRole('ROLE_CLIENT','ROLE_FINANCIAL','ROLE_COMMUNICATION')">
									<a href="<c:url value="${url}bankaccount/" />"><i
										class="fa fa-user fa-fw"></i>Bank account</a>
								</sec:authorize> <sec:authorize
									access="hasAnyRole('ROLE_FINANCIAL','ROLE_COMMUNICATION')">
									<a href="<c:url value="${url}bankaccount/company/" />"><i
										class="fa fa-user fa-fw"></i>Bank account</a>
									<a href="<c:url value="${url}availability" />"><i
										class="fa fa-user fa-fw"></i>Avaiblity</a>
								</sec:authorize></li>
							<li class="divider"></li>
							<li><a href="javascript:logout()"><i
									class="fa fa-sign-out fa-fw"></i> Logout </a></li>
						</ul> <!-- /.dropdown-user --></li>
				</sec:authorize>
				<!-- /.dropdown -->
			</ul>
		</div>
		<!-- Login -->

	</div>
</div>
<!-- Top Bar -->

<!-- Nav -->
<div class="nav-holder style-2 z-depth-1">
	<div class="container">

		<!-- Logo -->
		<div class="logo">
			<%-- <a href="${parenturl}"><img src="${parenturl}static/theme/theme/images/logo.png" alt=""></a> --%>
			<h1><a href="${parenturl}member">CHOSA</a></h1>
		</div>
		<!-- Logo -->

		<!-- Search Nd Cart -->
		<div class="search-nd-cart">
			<ul>
				<li class="link search"><a class="fa fa-search" href="#"></a></li>
			</ul>
		</div>
		<!-- Search Nd Cart -->

		<!-- Search Popup -->
		<div id="searching">
			<div id="searchThis">
				<input type="text" placeholder="Recherche">
				<div id="closeSearch">X</div>
			</div>
			<div id="searchResults"></div>
		</div>
		<!-- Search Popup -->

		<!-- Navigation -->
		<div class="nav-list">
			<ul>
			<li>
					<a
					href="${parenturl}trainingCenter/save">Training Center</a>
				</li>
				<li
					<c:if test="${existSpeciality == 'Psychologie'}"> class="active"</c:if>>
					<a
					href="javascript:logout()">Family</a>
				</li>
			</ul>
		</div>
		<!-- Navigation -->

	</div>
	
</div>

<!-- Nav -->