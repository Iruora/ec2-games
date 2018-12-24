<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="includes/head_admin.jsp"%>
<title>Dashboard - Users Management</title>
</head>
<body class="page-header-fixed">
	<div class="overlay"></div>
	<%@ include file="includes/nav.jsp"%>
	<%@ include file="includes/sidebar.jsp"%>

	<div class="page-inner">
		<div class="page-title">

			<div class="page-breadcrumb">
				<ol class="breadcrumb">
					<li><a href="index.html">Classes Management :</a></li>

				</ol>
			</div>
		</div>
		<div class="panel-body">

			<div class="table-responsive">
				<table id="example" class="display table"
					style="width: 100%; cellspacing: 0;">
					<thead>
						<tr>
							<th>Class Name</th>
							<th>Teacher</th>
							<th>Training Center</th>
							<th>Program</th>
							<th>Creation Date</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="classTC" items="${listAllClasses}">
							<tr>
								<td>${classTC.className}</td>
								<td>${classTC.teacher.userName}</td>
								<td>${classTC.trainingCenter.name}</td>
								<td>${classTC.trainingCenterprogramClass.programName}</td>
								<td>${classTC.creationDate}</td>

								<td><%-- <a href="#" class="btn btn-default" data-toggle="modal"
									data-target="#editModal${classTC.tcClassId}"><span
										class="glyphicon glyphicon-edit"></span> update</a> --%> <a href="#"
									class="btn btn-success" data-toggle="modal"
									data-target="#deleteModal${classTC.tcClassId}"><span
										class="glyphicon glyphicon-remove"></span> remove</a>



									<div class="modal fade" id="deleteModal${classTC.tcClassId}"
										tabindex="-1" role="dialog" aria-labelledby="edit"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">
														<span class="glyphicon glyphicon-remove"
															aria-hidden="true"></span>
													</button>
													<h4 class="modal-title custom_align" id="Heading">
														Remove classroom</h4>
												</div>
												<div class="modal-body">

													<div class="alert alert-danger">
														<span class="glyphicon glyphicon-warning-sign"></span> You
														are sure to remove this classroom?
													</div>

												</div>
												<div class="modal-footer ">
													<a href="${parenturl}admin/classes/delete?idClass=${classTC.tcClassId}"
														class="btn btn-success"> <span
														class="glyphicon glyphicon-ok-sign"></span> Yes
													</a>
													<button type="button" class="btn btn-default"
														data-dismiss="modal">
														<span class="glyphicon glyphicon-remove"></span> No
													</button>
												</div>
											</div>
											/.modal-content
										</div>
										/.modal-dialog</td>
								<%-- <form action=" <c:url value="${parenturl}admin/classes/update"/>"
									method="post">
									<div class="modal fade" id="editModal${classTC.tcClassId}" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">

										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4 class="modal-title" id="myModalLabel">Update Classroom</h4>
												</div>
												<div class="modal-body">
													<div class="form-group">
														<input type="text" class="form-control"
															placeholder="Pseudonyme" name="className"
															value="${classTC.className}" />
													</div>

													

													
													<input type="hidden" name="tcClassId" value="${classTC.tcClassId}" /> <input
														type="hidden" name="${_csrf.parameterName}"
														value="${_csrf.token}" />
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Cancel</button>
													<button type="submit" id="add-row" class="btn btn-success">Update</button>
												</div>
											</div>
										</div>
									</div>
								</form> --%>
							</tr> 
						</c:forEach>

					</tbody>

				</table>
				<div class="col-sm-7">
					<div class="dataTables_paginate paging_simple_numbers">
						<ul class="pagination">
							<c:choose>
								<c:when test="${page eq 1}">
									<li class="paginate_button previous disabled"><a>
											previous</a></li>
								</c:when>
								<c:when test="${page > 1}">
									<li class="paginate_button previous"><a
										href="${parenturl}admin/classes?page=${page-1}"> previous</a>
									</li>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${page < maxNumberPage}">
									<li class="paginate_button next"><a
										href="${parenturl}admin/classes?page=${page+1}">Next</a></li>
								</c:when>

								<c:when test="${page eq maxNumberPage}">
									<li class="paginate_button next  disabled"><a> Next</a></li>
								</c:when>
							</c:choose>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<div id="main-wrapper">

			<div class="container">
				<div class="row"></div>
				<div class="row">
					<div class="panel panel-white"></div>
				</div>
				<!-- /.Container -->
			</div>
		</div>
	</div>
	<%@ include file="includes/footer_admin.jsp"%>
</body>
</html>