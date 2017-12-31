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
			<h3>Liste des templates</h3>
			<div class="page-breadcrumb">
				<ol class="breadcrumb">
					<li><a href="index.html">Accueil</a></li>
					<li><a href="list">Gestion templates emails</a></li>
				</ol>
			</div>
		</div>
		<div id="main-wrapper">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-white">
						<div class="panel-heading clearfix">
							<h4 class="panel-title">Templates</h4>							
						</div>
						<div class="panel-body">
						<div class="col-lg-4">
					      <button type="button" class="btn btn-success m-b-sm" data-toggle="modal" data-target="#addModal">Ajouter une template</button>
						</div>		
							<div class="col-lg-offset-4 col-lg-4">
							<form action="searchTemplates" method="get" id="searchForm">
							   <select class="form-control" name="langueId"  onmouseout="Search()">
							    <optgroup label="Choisir une langue">
								  <c:forEach var="langue" items="${listOfLanguages}">
									  <option value="${langue.id}">${langue.langueLibelle}</option>
								 </c:forEach>
								 </optgroup>
						    	</select>
						    </form>
							</div>	
						</div>				
											<!-- Add Modal -->
											<form:form modelAttribute="templateMail" method="post" action="${parenturl}admin/templatemail/save">
											<div class="modal fade" id="addModal"
														role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">

														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																	<h4 class="modal-title" id="myModalLabel">Ajouter une template</h4>
																</div>
																
																<div class="modal-body">
																
																	<div class="form-group">
																	<form:select class="form-control" path="emailKey">
																	  <c:forEach var="key" items="${emailKeys}">
																	  <option value="${key}">${key}</option>
																	  </c:forEach>
															      	</form:select>
																	</div>
																	<div class="form-group">
																		<form:input type="text" class="form-control"
																			placeholder="Objet" 
										                                    path="object" />
																	</div>
																	
																     <div class="form-group">
																		<form:textarea path="body" id="bodyarea" style="width:550px;height:200px;"/>
																	</div>
																	
																	<div class="form-group">
																	<form:select class="form-control" path="language.id">
																	  <c:forEach var="langue" items="${listOfLanguages}">
																	  <option value="${langue.id}">${langue.langueLibelle}</option>
																	  </c:forEach>
															      	</form:select>
																	</div>
																   <form:hidden path="id"/>																																																																																														                                                   																
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Annuler</button>
																	<button type="submit" id="add-row"
																		class="btn btn-success">Valider</button>
																</div>
															</div>
														</div>
													</div>
						                       </form:form>
						
						
							<div class="table-responsive">
								<table id="example" class="display table  table-striped"
									style="width: 100%; cellspacing: 0;">
									<thead>
										<tr>
											<th>Type</th>	
											<th>Objet</th>
											<th>Contenu</th>
											<th>Langue</th>	
											<th>Action</th>																																																																											
										</tr>
									</thead>

									<tbody>
										<c:forEach var="template" items="${listAllTemplate}">
											<tr>
											    <td>${template.emailKey}</td>
												<td>${template.object}</td>
											    <td>${template.body}</td>
												<td>${template.language.langueLibelle}</td>																																															
												<td>
												<a href="#" class="btn btn-default"
													data-toggle="modal" data-target="#editModal${template.id}"><span
														class="glyphicon glyphicon-edit"></span> modifier</a> <a
													href="#" class="btn btn-success" data-toggle="modal"
													data-target="#deleteModal${template.id}"><span
														class="glyphicon glyphicon-remove"></span> supprimer</a>



													<div class="modal fade" id="deleteModal${template.id}"
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
																		Supprimer une template</h4>
																</div>
																<div class="modal-body">

																	<div class="alert alert-danger">
																		<span class="glyphicon glyphicon-warning-sign"></span>
																		Vous etes sure de supprimer cette template?
																	</div>

																</div>
																<div class="modal-footer ">
																	<a href="${parenturl}admin/templatemail/delete?templateId=${template.id}"
																		class="btn btn-success"> <span
																		class="glyphicon glyphicon-ok-sign"></span> Oui
																	</a>
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">
																		<span class="glyphicon glyphicon-remove"></span> Non
																	</button>
																</div>
															</div>
															<!-- /.modal-content -->
														</div>
														<!-- /.modal-dialog --></td>
												<!-- edit template -->
												<form action=" <c:url value="${parenturl}admin/templatemail/update"/>" method="post">
													<div class="modal fade" id="editModal${template.id}"
														 role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">

														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																	<h4 class="modal-title" id="myModalLabel">Modifier
																		template</h4>
																</div>
																<div class="modal-body">
																	<div class="form-group">
																		<input type="text" class="form-control"
																			placeholder="Objet" name="object"
																			value="${template.object}" >
																	</div>
																	
																     <div class="form-group">
																     <textarea 
																     placeholder="Contenu" name="body" style="width:550px;height:200px;"
																	 >${template.body}</textarea>																	
																	</div>
																																																																																	
																		
																	<div class="form-group">
																	<select class="form-control" name="languageId">
																	  <c:forEach var="langue" items="${listOfLanguages}">
																	  <option value="${langue.id}">${langue.langueLibelle}</option>
																	  </c:forEach>
															      	</select>
																	</div>
                                                                     <input type="hidden" name="templateId" value="${template.id}" />
																	  <input type="hidden" name="${_csrf.parameterName}"
																		value="${_csrf.token}" />
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-default"
																		data-dismiss="modal">Annuler</button>
																	<button type="submit" id="add-row"
																		class="btn btn-success">Modifier</button>
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
											<a> précédent</a>
											</li>
											</c:when>
											<c:when test="${page > 1}">							  
											<li class="paginate_button previous"><a
												href="${parenturl}admin/templatemail?page=${page-1}"> précédent</a>
											</li>
											</c:when>
											</c:choose>
											
											<c:choose>
										<c:when test="${page < maxNumberPage}">	
											<li class="paginate_button next">
											<a href="${parenturl}admin/templatemail?page=${page+1}">Suivant</a>
											</li>
                                        </c:when>
                                        
                                        <c:when test="${page eq maxNumberPage}">	
										 <li class="paginate_button next  disabled">
											<a> suivant</a>
											</li>
										</c:when>
										</c:choose>
										</ul>
									</div>
								</div>			
							</div>
						</div>
					</div>					
				</div>
			</div>
			<!-- Row -->
		</div>
	<%@ include file="includes/footer_admin.jsp"%>
</body>
</html>