<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
						<!-- Event Price Figuer -->
						<div class="col-lg-3 col-md-3 col-sm-5">
							
							<!-- Price Figure -->
							<div class="price-figure tc-hover">
								<img src="../../users/picture/${userDTO.user.id}" alt="" width="100%">
								<div class="Price-Figure-deatil style-2">
									<ul>
										<li>
											<span><spring:message code="user.address"/> : </span>
											<span>${userDTO.user.address}</span>
										</li>
										<li>
											<span><spring:message code="user.price"/> :</span>
											<span>9€/min</span>
										</li>
										<li>
											<span><spring:message code="user.review"/> :</span>
											<span>
												<c:if test="${fn:length(userDTO.reviews) != '0'}">
												${userDTO.review * 20}% <spring:message code="index.middle.opinion"/><br/>
												</c:if>
												(${fn:length(userDTO.reviews)} <spring:message code="index.middle.review"/>)
											</span>
											<c:if test="${fn:length(userDTO.reviews) != '0'}">
												<ul class="rating-stars">
													<c:forEach begin="1" end="${userDTO.review}">
														<li><i class="fa fa-star"></i></li>
													</c:forEach>
													<c:forEach begin="1" end="${5 - userDTO.review}">
														<li><i class="fa fa-star-o" aria-hidden="true"></i></li>
													</c:forEach>
												</ul>
											</c:if>
										</li>
									</ul>
                           			<sec:authorize access="isAnonymous()">
	                           			<button class="btn blank dark sm full-width" data-toggle="modal" data-target="#myModal">
			                                <spring:message code="sidebar.contact"/>
			                            </button>
			                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			                                <div class="modal-dialog">
			                                    <div class="modal-content">
			                                        <div class="modal-header">
			                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                                            <h4 class="modal-title" id="myModalLabel"><spring:message code="modal.title"/></h4>
			                                        </div>                                      
			                                        <div class="modal-body">
			                                       		<spring:message code="users.show.contact.show"/>
			                                        </div>
			                                        <div class="modal-footer">
			                                        	<button type="button" class="btn btn-default sm" data-dismiss="modal"><spring:message code="close"/></button>
														<a href="<c:url value="../../../login" />" class="btn btn-success sm"><spring:message code="login.connect"/></a>
														<a href="<c:url value="../../register" />" class="btn blank dark sm"><spring:message code="login.register"/></a>
			                                        </div>
												</div>
		                                	</div>
		                            	</div>
                                    </sec:authorize>
		                            <sec:authorize access="isAuthenticated()">
										<a href="<c:url value="../../demandquote/${userDTO.user.id}/add" />" class="btn btn-info sm full-width"><spring:message code="sidebar.quote"/></a>
										<a href="<c:url value="../../agendainvite/specialist/${userDTO.user.id}" />" class="btn btn-primary sm full-width"><spring:message code="sidebar.appointment"/></a>								
										<button class="btn blue sm full-width" data-toggle="modal" data-target="#myModal">
			                                <spring:message code="sidebar.contact"/>
			                            </button>
			                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			                                <div class="modal-dialog">
			                                    <div class="modal-content">
			                                        <div class="modal-header">
			                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                                        </div>                                      
			                                        <div class="modal-body">
			                                        	<div class="row">
			                                        		<div class="col-md-2">
				                                        	</div>
				                                        	<div class="col-md-3">
					                                       		<a href="<c:url value="../../demandconversation/user/${userDTO.user.id}" />" class="btn blue dark" 
					                                       		style=" min-width: 60px;height: 60px;padding: 10px 16px;font-size: 30px;line-height: 1.33;border-radius: 35px;">
					                                       		<i class="fa fa-commenting" style="margin: 0 0 0 0px;"></i></a>
				                                       		</div>
			                                        		<div class="col-md-3">
					                                       		<button class="btn blue dark" disabled
					                                       		style=" min-width: 60px;height: 60px;padding: 10px 16px;font-size: 30px;line-height: 1.33;border-radius: 35px;">
					                                       		<i class="fa fa-phone" style="margin: 0 0 0 0px;"></i></button>
				                                       		</div>
				                                        	<div class="col-md-3">
					                                       		<button class="btn blue dark" disabled
					                                       		style=" min-width: 60px;height: 60px;padding: 10px 16px;font-size: 30px;line-height: 1.33;border-radius: 35px;">
					                                       		<i class="fa fa-video-camera" style="margin: 0 0 0 0px;"></i></button>
				                                       		</div>				                                       		
			                                       		</div>
			                                        </div>
												</div>
		                                	</div>
		                            	</div>
									</sec:authorize>
								</div>	
							</div>
							<!-- Price Figure -->
						</div>
						<!-- Event Price Figuer -->