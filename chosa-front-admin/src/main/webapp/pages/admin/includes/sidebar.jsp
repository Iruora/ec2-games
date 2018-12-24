<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	
	<div class="page-sidebar sidebar">
		<div class="page-sidebar-inner slimscroll">
			<div class="sidebar-header">
				<div class="sidebar-profile">
					<a href="${parenturl}admin">

						<div class="sidebar-profile-details">
							<span>Space<br> <small>Administrative</small></span>
						</div>
					</a>
				</div>
			</div>
			<ul class="menu accordion-menu">

				<li><a href="${parenturl}admin/users" class="waves-effect waves-button"><span
						class="menu-icon glyphicon glyphicon-dashboard"></span>
						<p>Dashboard</p></a></li>
				<li><a href="${parenturl}admin/centers" class="waves-effect waves-button"><span
						class="menu-icon glyphicon glyphicon-user"></span>
						<p>Training Centers Management</p></a></li>
				<li><a href="${parenturl}admin/classes"
					class="waves-effect waves-button"><span
						class="menu-icon glyphicon glyphicon-education"></span>
						<p>Classes Management</p></a></li>
					<li><a href="${parenturl}admin/templatemail/"
					class="waves-effect waves-button"><span
						class="menu-icon glyphicon glyphicon-education"></span>
						<p>Email Template Mangement</p></a></li>	
<!-- 				<li><a href="" -->
<!-- 					class="waves-effect waves-button"><span -->
<!-- 						class="menu-icon glyphicon glyphicon-calendar"></span> -->
<!-- 						<p>Agenda</p></a></li>		 -->
<!-- 				<li><a href="" -->
<!-- 					class="waves-effect waves-button"><span -->
<!-- 						class="menu-icon glyphicon glyphicon-list-alt"></span> -->
<!-- 						<p>Exercies Management</p></a></li> -->
				
<!-- 			    <li><a href="" -->
<!-- 					class="waves-effect waves-button"><span -->
<!-- 						class="menu-icon glyphicon  glyphicon-folder-open"></span> -->
<!-- 						<p>Activities</p></a></li> -->
				
<!-- 				 <li><a href="" -->
<!-- 					class="waves-effect waves-button"><span -->
<!-- 						class="menu-icon glyphicon  glyphicon-home"></span> -->
<!-- 						<p>Classes Management</p></a></li> -->
				
				
			</ul>
		</div>
		<!-- Page Sidebar Inner -->
	</div>