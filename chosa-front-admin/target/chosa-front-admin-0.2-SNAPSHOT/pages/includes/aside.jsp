<div class="col-lg-2 col-md-3 col-sm-12">
	<div class="aside">

		<!-- Aside Widget -->
		<div class="aside-widet">
			<h4>Navigation</h4>
			<ul class="categories-list">
				<li>
					<h5>
						<a href="${parenturl}trainingCenter/update">Training Centre Profil</a>
					</h5>
				</li>
				<c:if test="${connectedTrainingcenter ne null }"> 
				
				<li>
					<h5>
						<a href="${parenturl}trainingCenter/member?memberRole=REQUEST">Members</a>
					</h5>
				</li>
				<li>
					<h5>
						<a href="${parenturl}trainingCenter/classes">Classes<span class="pull-right">(3)</span></a>
					</h5>
				</li>
				<li>
					<h5>
						<a href="${parenturl}trainingCenter/programmes">Programmes<span class="pull-right">(6)</span></a>
					</h5>
				</li>
				<li>
					<h5>
						<a href="${parenturl}trainingCenter/activities">Activities<span class="pull-right">(12)</span></a>
					</h5>
				</li>
				<li>
					<h5>
						<a href="${parenturl}trainingCenter/agenda">Agenda<span class="pull-right">(12)</span></a>
					</h5>
				</li>
				</c:if>
				
				
				<li>
					<h5>
						<a href="javascript:logout()">Logout</a>
					</h5>
				</li>
			</ul>
		</div>
		<!-- Aside Widget -->

	</div>
</div>