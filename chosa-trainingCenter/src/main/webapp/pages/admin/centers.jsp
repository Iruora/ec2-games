<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="includes/head_admin.jsp"%>
<title>Dashboard - Users Management </title>
</head>
<body class="page-header-fixed">
	<div class="overlay"></div>
	<%@ include file="includes/nav.jsp"%>
	<%@ include file="includes/sidebar.jsp"%>

	<div class="page-inner">
		<div class="page-title">

			<div class="page-breadcrumb">
				<ol class="breadcrumb">
					<li><a href="index.html">Users Management :</a></li>

				</ol>
			</div>
		</div>
<div class="panel-body">
					
							<div class="table-responsive">
								<table id="example" class="display table"
									style="width: 100%; cellspacing: 0;">
									<thead>
										<tr>
											<th>Name</th>
											<th>Manager Name</th>
											<th>Adress</th>
											<th>Phone Number</th>
											<th>Country</th>
											<th>Status</th>
											<th>Number of Classes </th>
											<th>Creation Date</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="tCenter" items="${listAllCenters}">
											<tr>
												<td>${tCenter.name}</td>
											    <td>${tCenter.manager.firstName}</td>
												
												<td>${tCenter.adress}</td>
												<td>${tCenter.phone}</td>
												<td>${tCenter.country.name}</td>
												<td>${tCenter.status}</td>
												<td>${tCenter.listOfClass.size()}</td>
												<td>${tCenter.creationDate}</td>

												<td><a href="#" class="btn btn-default"
													data-toggle="modal" data-target="#editModal${tCenter.centerId}"><span
														class="glyphicon glyphicon-edit"></span> update</a> <a
													href="#" class="btn btn-success" data-toggle="modal"
													data-target="#deleteModal${tCenter.centerId}"><span
														class="glyphicon glyphicon-remove"></span> remove</a>



													<div class="modal fade" id="deleteModal${tCenter.centerId}" tabindex="-1"
														role="dialog" aria-labelledby="edit" aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-hidden="true">
																		<span class="glyphicon glyphicon-remove"
																			aria-hidden="true"></span>
																	</button>
																	<h4 class="modal-title custom_align" id="Heading">
																		Remove Training Center</h4>
																</div>
																<div class="modal-body">

																	<div class="alert alert-danger">
																		<span class="glyphicon glyphicon-warning-sign"></span>
																		You are sure to remove this Center?
																	</div>

																</div>
																<div class="modal-footer ">
																	<a href="${parenturl}admin/centers/delete?idCenter=${tCenter.centerId}"
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
												<form action=" <c:url value="${parenturl}admin/centers/update"/>" method="post" >
													<div class="modal fade" id="editModal${tCenter.id}"
														tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">

														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																	<h4 class="modal-title" id="myModalLabel">Update
																		Training Center</h4>
																</div>
																<div class="modal-body">
																	<div class="form-group">
																		<input type="text" class="form-control"
																			placeholder="Pseudonyme" name="centerName"
																			value="${tCenter.name}" />
																	</div>
																	
																     
																
																	
                                                                   <div class="form-group">
																		<select name="countryId" class="form-control">
																		<c:forEach var="country" items="${countryList}">
																		<option value="${country.id}">${country.name}</option>
																		
																		</c:forEach>
																		</select>
																	</div>
																	<div class="form-group">
																		<input type="text" class="form-control"
																			placeholder="Adresse" name="centerAdress"
																			value="${tCenter.adress}" />
																	</div>


																	<div class="form-group">
																		<input type="text" class="form-control"
																			placeholder="Numero télephone" name="centerPhone"
																			value="${tCenter.phone}" />
																	</div>
																	
																	<div class="form-group">
																		<select name="centerStatus" class="form-control">
																		<option value="REQUEST">REQUEST</option>
																	    <option value="VALIDATE" selected="selected">VALIDATE</option>
																		<option value="SUSPENDED">SUSPENDED</option>
																		</select>
																	</div>
                                                                                                                                     	<input type="hidden" name="centerId" value="${tCenter.centerId}" />
																	<input type="hidden" name="${_csrf.parameterName}"
																		value="${_csrf.token}" />
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Cancel</button>
																	<button type="submit" id="add-row"
																		class="btn btn-success">Update</button>
																</div>
															</div>
														</div>
													</div>
												</form>
											</tr>
										</c:forEach>

									</tbody>

								</table>		
											
								<div class="col-sm-7">		
									<div class="dataTables_paginate paging_simple_numbers">
										<ul class="pagination">	
										    <c:choose>
										    <c:when test="${page eq 1}">							  
											<li class="paginate_button previous disabled">
											<a> previous</a>
											</li>
											</c:when>
											<c:when test="${page > 1}">							  
											<li class="paginate_button previous"><a
												href="${parenturl}admin/accueil?page=${page-1}"> previous</a>
											</li>
											</c:when>
											</c:choose>
											<c:choose>
										<c:when test="${page < maxNumberPage}">	
											<li class="paginate_button next">
											<a href="${parenturl}admin/accueil?page=${page+1}">Next</a>
											</li>
                                        </c:when>
                                        
                                        <c:when test="${page eq maxNumberPage}">	
										 <li class="paginate_button next  disabled">
											<a> Next</a>
											</li>
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
	<script type="text/javascript">
	$(function(){ // document ready alias
    $('#my-element').curry(); 
	});
	
    </script>

</body>
</html>