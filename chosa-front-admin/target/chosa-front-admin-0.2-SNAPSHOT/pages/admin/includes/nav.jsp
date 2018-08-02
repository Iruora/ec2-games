<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="menu-wrap">
		<nav class="profile-menu">
			<div class="profile">
				<img src="${parenturl}static/theme/chosa-admin/assets/images/profile-menu-image.png" width="60"
					alt="David Green" /><span>David Green</span>
			</div>
			<div class="profile-menu-list">
				<a href="#"><i class="fa fa-bell"></i><span>Alerts</span></a>
			</div>
		</nav>
		<button class="close-button" id="close-button">Close Menu</button>
	</div>

	<form class="search-form" action="#" method="GET">
		<div class="input-group">
			<input type="text" name="search" class="form-control search-input"
				placeholder="Search..."> <span class="input-group-btn">
				<button
					class="btn btn-default close-search waves-effect waves-button waves-classic"
					type="button">
					<i class="fa fa-times"></i>
				</button>
			</span>
		</div>
		<!-- Input Group -->
	</form>
	<!-- Search Form -->
	
	<main class="page-content content-wrap">
	<div class="navbar">
		<div class="navbar-inner">
			<div class="sidebar-pusher">
				<a href="javascript:void(0);"
					class="waves-effect waves-button waves-classic push-sidebar"> <i
					class="fa fa-bars"></i>
				</a>
			</div>
			<div class="logo-box">
				
			</div>
			<!-- Logo Box -->
			<div class="topmenu-outer">
				<div class="top-menu">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="javascript:void(0);"
							class="waves-effect waves-button waves-classic show-search"><i
								class="fa fa-search"></i></a></li>
						<li class="dropdown"><a href="#"
							class="dropdown-toggle waves-effect waves-button waves-classic"
							data-toggle="dropdown"><i class="fa fa-bell"></i><span
								class="badge badge-success pull-right">3</span></a>
							<ul class="dropdown-menu title-caret dropdown-lg" role="menu">
								<li><p class="drop-title">You have 3 pending tasks !</p></li>
								<li class="dropdown-menu-list slimscroll tasks">
									<ul class="list-unstyled">
										<li><a href="#">
												<div class="task-icon badge badge-success">
													<i class="icon-user"></i>
												</div> <span
												class="badge badge-roundless badge-default pull-right">1min
													ago</span>
												<p class="task-details">New user registered.</p>
										</a></li>
										<li><a href="#">
												<div class="task-icon badge badge-danger">
													<i class="icon-energy"></i>
												</div> <span
												class="badge badge-roundless badge-default pull-right">24min
													ago</span>
												<p class="task-details">Database error.</p>
										</a></li>
										<li><a href="#">
												<div class="task-icon badge badge-info">
													<i class="icon-heart"></i>
												</div> <span
												class="badge badge-roundless badge-default pull-right">1h
													ago</span>
												<p class="task-details">Reached 24k likes</p>
										</a></li>
									</ul>
								</li>
								<li class="drop-all"><a href="#" class="text-center">All
										Tasks</a></li>
							</ul></li>
						
						<li><a onclick="Logout()"
							class="log-out waves-effect waves-button waves-classic"> <span><i
									class="fa fa-sign-out m-r-xs"></i>Déconnexion</span>
						</a></li>
					</ul>
					<!-- Nav -->
				</div>
				<!-- Top Menu -->
			</div>
		</div>
	</div>
	<form action="${parenturl}logout" id="logoutForm" method="post"
        style="display: inline-block;">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />  
    </form>
	<!-- Navbar -->