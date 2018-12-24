<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>		
		<!-- Footer -->
		<footer class="footer style-2">

			<!-- Footer Columns -->
			<div class="footer-column">
				<div class="container">
					<div class="row">
						
						<!-- Colunm Widget -->
						<div class="col-sm-4">
							<div class="f-column-widget">
								<div class="f-column-widget">
									<h4>About Us</h4>
									<p class="address-p">About us message</p>
								</div>
							</div>
						</div>
						<!-- Colunm Widget -->

						<!-- Colunm Widget -->
						<div class="col-sm-8">
							<div class="f-column-widget">
								<h4>NewsLetter </h4>
								<div class="newslatter">
									<p>NewsLetter message</p>
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Email">
										<button type="submit" class="btn">Register</button>
									</div>
								</div>
							</div>
						</div>
						<!-- Colunm Widget -->
					</div>
				</div>
			</div>
			<!-- Footer Columns -->

			<!-- Sub Footer -->
			<div class="sub-footer">
				<div class="container">
					<p>© Copyright 2017. Chosa</p>
					<ul class="sub-footer-nav">
						<sec:authorize access="isAuthenticated()">
							<li><a href="${url}termsconditions">TERMS OF USE</a></li>
							<li><a href="${url}legalnotice">PRIVACY AND SECURITY</a></li>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							<li><a href="${parenturl}guest/termsconditions">TERMS OF USE</a></li>
							<li><a href="${parenturl}guest/legalnotice">PRIVACY AND SECURITY</a></li>
						</sec:authorize>
						<li><a href="https://docs.google.com/forms/d/e/1FAIpQLScPWCetI2miYhP66xy7c2KPsGMOx4_C4YqhS4oDnkOZbM_IeA/viewform?c=0&w=1">Contact</a></li>
					</ul>
				</div>
			</div>
			<!-- Sub Footer -->

		</footer>
		<!-- Footer -->
</div>
	<!-- Wrapper -->
	
	<script type="text/javascript" src="//platform.linkedin.com/in.js">
	    api_key: 86ue54ywcivgt1
	    authorize: true
	</script>
	<script>
	function logout() {
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signOut().then(function () {
		      console.log('User signed out.');
		    });
		FB.logout(function(response) {});
		IN.User.logout();
		document.getElementById("logoutForm").submit();
	}
	 function onLoad() {
	      gapi.load('auth2', function() {
	        gapi.auth2.init();
	      });
	    }
	</script>
	<!-- To load google user -->
	<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
	<!-- back To Button -->
	<span id="scrollup" class="scrollup circle-btn"><i class="fa fa-angle-up"></i></span>
	<!-- back To Button -->
	<!-- Java Script -->
	<script src="${parenturl}static/theme/theme/js/jquery.js"></script>        
	<script src="${parenturl}static/theme/theme/js/bootstrap.min.js"></script>
	<script src="${parenturl}static/theme/theme/js/jquery-ui.js"></script>		
	<script src="${parenturl}static/theme/theme/js/datepicker.js"></script>					
	<script src="${parenturl}static/theme/theme/js/bigslide.js"></script>					
	<script src="${parenturl}static/theme/theme/js/parallax.js"></script>			   	 
	<script src="${parenturl}static/theme/theme/js/owl-carousel.js"></script>	
	<script src="${parenturl}static/theme/theme/js/bxslider.js"></script>	
	<script src="${parenturl}static/theme/theme/js/prettyPhoto.js"></script>			
	<script src="${parenturl}static/theme/theme/js/isotope.pkgd.js"></script>			
	<script src="${parenturl}static/theme/theme/js/main.js"></script>
	
<%--     <script type="text/javascript" src="${parenturl}static/theme/canvas/script/UI5eec.js?ver=23072013"></script> --%>
<%--     <script type="text/javascript" src="${parenturl}static/theme/canvas/script/ActionsLogger5eec.js?ver=23072013"></script> --%>
<%--     <script type="text/javascript" src="${parenturl}static/theme/canvas/script/basicPaintProgramf17d.js?ver=22062013"></script> --%>
    
    
<%--     <script type="text/javascript" src="${parenturl}static/theme/canvas/script/jscolor/jscolor.js"></script> --%>
<%--     <link rel="stylesheet" type="text/css" href="${parenturl}static/theme/canvas/style/Painter53d5.css?ver=26072013" /> --%>
	<!-- Hotjar Tracking Code for http://tomcat.preprod.portago.eu/walkthetalk/ -->
	<script>
	    (function(h,o,t,j,a,r){
	        h.hj=h.hj||function(){(h.hj.q=h.hj.q||[]).push(arguments)};
	        h._hjSettings={hjid:466335,hjsv:5};
	        a=o.getElementsByTagName('head')[0];
	        r=o.createElement('script');r.async=1;
	        r.src=t+h._hjSettings.hjid+j+h._hjSettings.hjsv;
	        a.appendChild(r);
	    })(window,document,'//static.hotjar.com/c/hotjar-','.js?sv=');
	</script>
	<script>
		(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
		ga('create', 'UA-96827533-1', 'auto');
		ga('send', 'pageview');
	</script>