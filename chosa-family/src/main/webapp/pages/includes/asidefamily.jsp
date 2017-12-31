<div class="col-lg-3 col-md-3 col-sm-12">
	<div class="aside">

		<!-- Aside Widget -->
		<div class="aside-widet">
			<h4>Navigation</h4>
			<ul class="categories-list">
				<li class="active">
					<h5>
						<a href="${parenturl}family/profil">Family Profil</a>
					</h5>
				</li>

				<c:if test="${connectedfamily ne null }">
					<li>
						<h5>
							<a href="${parenturl}family/membres">Members</a>
						</h5>
					</li>
					<li>
						<h5>
							<a href="${parenturl}family/activites?subject=LOGIC">Activites<span
								class="pull-right">(3)</span></a>
						</h5>
					</li>
					<li>
						<h5>
							<a href="${parenturl}family/trainingCenter/Valid">trainingCenter<span
								class="pull-right">(3)</span></a>
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