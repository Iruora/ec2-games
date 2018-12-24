				<div class="col-lg-3 col-md-3 col-sm-12">
					<div class="aside">
						<div class="aside-widet">
							<h4>Navigation</h4>
							<ul class="categories-list">
								<sec:authorize
									access="hasAnyRole('ROLE_FINANCIAL','ROLE_COMMUNICATION')">
									<li><h5>
											<a href="<c:url value="${url}professionalpresentation" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.professionalPresentation"/></a>
										</h5></li>
									<li><h5>
											<a href="<c:url value="${url}service" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.service"/></a>
										</h5></li>																			
									<li><h5>
											<a href="<c:url value="${url}company" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.company"/></a>
										</h5></li>									
									<li><h5>
											<a href="<c:url value="${url}documenttype" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.document"/></a>
										</h5></li>
								</sec:authorize>
								<sec:authorize
									access="hasAnyRole('ROLE_FINANCIAL','ROLE_COMMUNICATION','ROLE_CLIENT')">
									<li><h5>
											<a href="<c:url value="${url}demandconversation" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.demandConversation"/></a>
										</h5></li>
									<li><h5>
											<a href="<c:url value="${url}conversation" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.conversation"/></a>
										</h5></li>
									<li><h5>
										<a href="<c:url value="${url}groupconversation" />"><i
											class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.groupConversation"/></a>
									</h5></li>
									<li><h5>
											<a href="<c:url value="${url}agenda" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.agenda"/></a>
										</h5></li>
									<li><h5>
											<a href="<c:url value="${url}quote" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.quote"/></a>
										</h5></li>
									<li><h5>
											<a href="<c:url value="${url}bill" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.bill"/></a>
										</h5></li>
								</sec:authorize>
								<sec:authorize access="(hasRole('ROLE_CLIENT') && !hasAnyRole('ROLE_FINANCIAL','ROLE_COMMUNICATION'))">
									<li><h5>
											<a href="<c:url value="${url}documentoutput" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.document"/></a>
										</h5></li>
									<li><h5>
											<a href="<c:url value="${url}demandexpert" />"><i
												class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.demandexpert"/></a>
										</h5></li>																					
								</sec:authorize>

								<%-- <li><h5>
									<a href="<c:url value="${url}contact" />"><i
										class="fa fa-dashboard fa-fw"></i><spring:message code="sidebar.contact"/></a>
								</h5></li> --%>
							</ul>
						</div>
					</div>
				</div>