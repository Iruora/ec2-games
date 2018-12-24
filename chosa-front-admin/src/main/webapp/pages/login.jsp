
<%@ include file="/pages/includes/header.jsp"%>
<script>
	function fb_login() {
		FB
				.login(function(response) {
					if (response.authResponse) {
						FB
								.api(
										'/me?fields=email,first_name,last_name,birthday,id',
										function(response) {
											console
													.log('Successful login for: '
															+ response.id);
											redirectPost(
													'./guest/facebook/callback',
													response);
										});
					} else {
						//user hit cancel button
						console
								.log('User cancelled login or did not fully authorize.');
					}
				});
	}
</script>
<script type="text/javascript">
	var googleUser = {};
	var startApp = function() {
		gapi
				.load(
						'auth2',
						function() {
							// Retrieve the singleton for the GoogleAuth library and set up the client.
							auth2 = gapi.auth2
									.init({
										client_id : '930523828492-5ep04ve0eaivht14qb99fng99dn4u12c.apps.googleusercontent.com',
									});
							attachSignin(document.getElementById('customBtn'));
						});
	};

	function attachSignin(element) {
		auth2.attachClickHandler(element, {}, function(googleUser) {
			var profile = googleUser.getBasicProfile();
			redirectPost('./guest/google/callback', profile);
		}, function(error) {
		});
	}
</script>

<body style="background: #3f51b5" onload="javascript:onload()">
	<div id="fb-root"></div>
	<div class="login-form">
		<div class="modal-content position-center-center tc-hover">
			<a href="<c:url value="./" />"><img src="${parenturl}static/theme/theme/images/logo.jpg" alt=""></a>
			<br>
			<h4>CHOSA</h4>
			<br>
			<form class="login-form" action="${parenturl}login" method="post">
				<div class="form-group">
					<input required="required" name="username" type="email" autofocus />
					<label class="control-label">Email</label><i class="bar"></i>
				</div>
				<div class="form-group">
					<input type="password" required="required" name="password" /> <label
						class="control-label">Password</label><i class="bar"></i>
				</div>
				<c:if test="${param.error ne null}">
					<div class="alert alert-danger">login</div>
				</c:if>
				<c:if test="${param.logout ne null}">
					<div class="alert alert-info">logout</div>
				</c:if>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<ul class="btn-list">
					<li><input type="submit" class="btn blue sm full-width"
						value="Connect" style="padding: 0 10px;" /></li>
					<li><a href="<c:url value="register" />"
						class="btn blank dark sm full-width">Signup</a></li>
				</ul>
				<div class="remeber-nd-forget text-center">
					<a href="<c:url value="guest/forgetpassword" />" class="forget">Forget
						Password ?</a>
				</div>
				<div class="social-icons-1">
					<span>Connect with : </span><br />
					<br />
					<ul>
						<li style="padding-bottom: 5px;"><a href="#"
							onclick="fb_login();"
							class="btn sm btn-block btn-social btn-facebook"
							style="padding: 0px 0px 0px 45px;"> <i class="fa fa-facebook"></i>
								Facebook
						</a></li>
						<li>
							<div id="gSignInWrapper">
								<div id="customBtn"
									class="btn sm btn-block btn-social btn-google-plus"
									style="padding: 0px 0px 0px 45px;">
									<i class="fa fa-google"></i> Google
								</div>
								<script>
									startApp();
								</script>
							</div>
						</li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</body>
</html>