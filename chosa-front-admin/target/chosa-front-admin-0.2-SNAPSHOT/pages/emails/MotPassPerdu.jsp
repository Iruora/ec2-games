<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<% 
	String currentUrl=(String) request.getAttribute("javax.servlet.forward.request_uri");
	currentUrl = currentUrl.replace("/CHOSA", "");
	String[] urlAsArray=currentUrl.split("/");
	String url="";
   	int nbr = urlAsArray.length;
// 	if (currentUrl.endsWith("/")){
// 		if (nbr < 3){
// 			url= "./";
// 		}
// 		else {
// 			url= "../";
// 		}
// 	}
   	for(int i=0; i<nbr-3;i++){
   		url= "../"+ url;
   	}
   	String parenturl="";
   	if ( (currentUrl.startsWith("/family"))||(currentUrl.startsWith("/program"))||(currentUrl.startsWith("/member"))||(currentUrl.startsWith("/activity"))||(currentUrl.startsWith("/theme"))||(currentUrl.startsWith("/admin")) || (currentUrl.startsWith("/guest"))|| (currentUrl.startsWith("/trainingCenter"))
   			|| (currentUrl.startsWith("/class"))|| (currentUrl.startsWith("/teacher")|| (currentUrl.startsWith("/user")))) {
   		parenturl = "../";
   	}
  	parenturl = parenturl + url;
%>
   <c:set value='<%=url%>'  var="url"></c:set>
   <c:set value='<%=parenturl%>'  var="parenturl"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf8" />
<style>
p {
	font-family: 'Open Sans', sans-serif;
	font-weight: 400;
	font-size: 13px;
	color: #192d4e;
	letter-spacing: 0;
	line-height: 1.4;
	text-align: center;
}

h2 {
	font-family: 'Open Sans', sans-serif;
	font-size: 24px;
	color: #192D4B;
	line-height: 1.2;
}

.btn {
	height: 50px;
	margin: 0;
	padding: 0 20px;
	text-decoration: none;
	vertical-align: middle;
	background: #00b4e6;
	border: 0;
	font-family: 'Open Sans', sans-serif;
	font-size: 14px;
	font-weight: 600;
	line-height: 45px;
	color: #FFFFFF;
	text-transform: uppercase;
}
</style>
</head>
<body>
	<div bgcolor="#F1F1F1"
		style="background-color: #f1f1f1; font-size: 14px; font-weight: 400; line-height: 160%">
		<table border="0" cellpadding="0" cellspacing="0"
			style="background-color: #f1f1f1; border: 0 none; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 14px; font-weight: 400; line-height: 160%; margin: auto; width: 100%; max-width: 600px">
			<tbody>
				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0" width="100%"
							style="width: 100%;; color: #ffffff; padding-top: 5px; padding-bottom: 5px; padding-left: 30px; padding-right: 30px; margin-top: 30px; margin-bottom: 10px; border: 0 none">
							<tbody style="width: 100%; max-width: 600%">
								<tr>
									<td><a href="https://www.CHOSA.com"
										style="vertical-align: middle; display: block; color: #ffffff; line-height: 1"
										target="_blank"
										data-saferedirecturl="https://www.google.com/url?hl=fr&amp;q=https://www.CHOSA.com&amp;source=gmail&amp;ust=1501750228627000&amp;usg=AFQjCNEmOtf5L8gk5E36ZWnw5b9E4v44JA">
											<img alt="CHOSA" height="33"
											src="${parenturl}static/theme/theme/images/logo.jpg"
											style="border: 0 none" width="99" class="CToWUd">
									</a></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>

				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0" width="100%"
							style="width: 100%;; color: #ffffff; padding-top: 5px; padding-bottom: 5px; padding-left: 30px; padding-right: 30px; margin-top: 30px; margin-bottom: 10px; border: 0 none">
							<tbody style="width: 100%; max-width: 600%">
								<tr>
									<td><center>
											<h2>#emailSubject#</h2>
										</center></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>

						<table cellpadding="0" cellspacing="0" border="0"
							bgcolor="#FFFFFF"
							style="width: 100%; background-color: #ffffff; padding: 30px 30px 0px; color: #666666; font-family: Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 160%; border: 0 none">
							<tbody>

								<tr>

									<td>
										<table class="m_-3335448033320000562simple" cellpadding="0"
											cellspacing="0" border="0"
											style="padding: 0px; border-collapse: collapse; color: #666666; font-family: Helvetica, Arial, sans-serif; font-size: 11px; width: 100%">
											<tbody>
												<tr>
													<td style="width: 800px">


														<p>
															<!-- DEBUT DU MESSAGE -->
															<center style="line-height: 170%;">
															<p> Forgot your password? No worries! </p>
															<p> It's happening to everyone. </p> <button class="btn"> <a
																	href="${link }change-password?mailUser=${email }"
																	style="text-decoration:none;color:#ffffff "> Change PASSWORD </a> </button> <p> Thank you for your confidence, </p> <br> <strong> The chosa team </strong> </center>
														<!-- FIN DU MESSAGE-->
														</p>
														
														
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>


							</tbody>
							
							
							
							
							
							
							
						</table>
						<table cellpadding="0" cellspacing="0" border="0"
							bgcolor="#FFFFFF" height="60"
							style="width: 100%; background-color: #ffffff; padding: 0px 30px 30px; color: #666666; font-family: Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 160%; border: 0 none">
							<tbody>
								<tr valign="middle">

								</tr>
							</tbody>
						</table>
					</td>
				</tr>

				<tr>
					<td>

						<table cellpadding="0" cellspacing="0" border="0"
							bgcolor="#444444"
							style="width: 100%; background-color: #4b494a; padding: 5px 30px; color: #ffffff; font-family: Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 160%; border: 0 none">
							<tbody>
								<tr>
									<td
										class="m_-3335448033320000562full-xs m_-3335448033320000562center-xs"><a
										href="https://www.CHOSA.com"
										style="display: inline-block; color: #fff; text-decoration: none; padding-top: 0px; padding-right: 5px; margin-bottom: 0px; padding-left: 5px"
										target="_blank"
										data-saferedirecturl="https://www.google.com/url?hl=fr&amp;q=https://www.CHOSA.com&amp;source=gmail&amp;ust=1501750228627000&amp;usg=AFQjCNEmOtf5L8gk5E36ZWnw5b9E4v44JA">A
											propos</a> <a href="https://www.CHOSA.com/fr/help"
										style="display: inline-block; color: #fff; text-decoration: none; padding-top: 0px; padding-right: 5px; margin-bottom: 0px; padding-left: 5px"
										target="_blank"
										data-saferedirecturl="https://www.google.com/url?hl=fr&amp;q=https://www.CHOSA.com/fr/help&amp;source=gmail&amp;ust=1501750228627000&amp;usg=AFQjCNE_dXtWsHtcNf0bMVU4rnrRPMLnDw">Aide</a>
									</td>
									<td width="50%"
										style="line-height: 14px; color: #fff; text-align: right; text-decoration: none"
										class="m_-3335448033320000562full-xs m_-3335448033320000562center-xs"><a
										href="http://twitter.com/CHOSA"
										style="color: #fff; text-decoration: none; margin-top: 0px; margin-left: 2%; margin-right: 2%; margin-bottom: 0px"
										target="_blank"
										data-saferedirecturl="https://www.google.com/url?hl=fr&amp;q=http://twitter.com/UnitagLive&amp;source=gmail&amp;ust=1501750228627000&amp;usg=AFQjCNG97-ClQ-b3chPQ4nValcK5UUir-A">
											<img
											src="https://ci3.googleusercontent.com/proxy/1hg8p4KT3mB6eO8tZIZ2iFD6RQ9L-7CT_YS4zi-T-ECH0HY2D7kHIbSYH-Ir361Hy2ctaAach7yuV5VnqhI4xXQdFy9Q9s-iApqhaEXyU9UcfcKUb3EA_NVQwskL9XeK3D7-Vq8HDIFH=s0-d-e1-ft#https://static-unitag.com/images/mail/commons/mailing-short-twitter.png?mh=adf376f0"
											style="border: 0 none" alt="Twitter" width="22" height="22"
											class="CToWUd">
									</a> <a href="http://www.facebook.com/CHOSA"
										style="color: #fff; text-decoration: none; padding-top: 0px; padding-left: 5px; padding-right: 5px; padding-bottom: 0px"
										target="_blank"
										data-saferedirecturl="https://www.google.com/url?hl=fr&amp;q=http://www.facebook.com/CHOSA&amp;source=gmail&amp;ust=1501750228627000&amp;usg=AFQjCNEAjD9hCo9b87SkpPsvyhp-PT6-lA"><img
											src="https://ci5.googleusercontent.com/proxy/fcHm-xZ8S3XV7mictR4I0MtuZvd2rnQkvkz9qBkgycOGptSsTmszBLhl7IbjUZzPptAr-iyFz_BP0gxmLO6tAxB3QdNudDZB5Oz6m6Hf30-Sak5QkBdQDHNRX9VtK5ANIOak-Mht5IeWpw=s0-d-e1-ft#https://static-unitag.com/images/mail/commons/mailing-short-facebook.png?mh=0fd5fe05"
											style="border: 0 none" alt="Facebook" width="22" height="22"
											class="CToWUd"></a> <a
										href="http://www.linkedin.com/company/CHOSA"
										style="color: #fff; text-decoration: none; padding-top: 0px; padding-bottom: 0px; padding-left: 5px; padding-right: 5px"
										target="_blank"
										data-saferedirecturl="https://www.google.com/url?hl=fr&amp;q=http://www.linkedin.com/company/CHOSA&amp;source=gmail&amp;ust=1501750228627000&amp;usg=AFQjCNFvYUi9d4pMjpcM-dRIhu_joSVd0Q">
											<img
											src="https://ci4.googleusercontent.com/proxy/zfFnz9ISpmvu2RBrxgsbbThMPd34SDN7yFmm8gSdyHvtD5pG2S4cGhSzV4yDZ04nvAPcmhpGtyB-iz8p0vHneHW-ErbVunNzJ3OLmXLBtavt43JJ9FL41SUqMhtsqkyc4ObyFDGc9QhFYw=s0-d-e1-ft#https://static-unitag.com/images/mail/commons/mailing-short-linkedin.png?mh=8a3bd56d"
											style="border: 0 none" alt="LinkedIn" width="22" height="22"
											class="CToWUd">
									</a> <a href="http://plus.google.com/+UnitagLive"
										style="color: #fff; text-decoration: none; padding-top: 0px; padding-left: 5px; padding-right: 0px; padding-bottom: 0px"
										target="_blank"
										data-saferedirecturl="https://www.google.com/url?hl=fr&amp;q=http://plus.google.com/%2BUnitagLive&amp;source=gmail&amp;ust=1501750228627000&amp;usg=AFQjCNHgsCDaoGKS5Opbxai0cBNOKJesXg"><img
											src="https://ci3.googleusercontent.com/proxy/8JWP_RgglnI2ngVa9xMgi3f_M6XvqCukwwBkN8N6-xIIbPA1D8sOOLVRPYkx9tTXTNouaXllJ1QeXe6Rdn7F3a3w8XRddFdzBvGT5uJQ642x719n5ssyM8qsv8YBQ_Wdr_X0thWHY00=s0-d-e1-ft#https://static-unitag.com/images/mail/commons/mailing-short-google.png?mh=65866086"
											style="border: 0 none" alt="Google+" width="22" height="22"
											class="CToWUd"></a></td>
								</tr>
							</tbody>
						</table>
						
						<center>
						<br>
							<img
								src="http://tomcat.preprod.portago.eu/CHOSA/static/images/header-fixe.png"><font
								size="2" color="#797e84"><br>POWERD BY CHOSA<br>Votre
								Ã©tiquette connectÃ©e</font>
						</center> <font size="1" color="#797e84">CHOSA 2017 | 90 Avenue
							d'enghien,93800 Epinay sur Seine,France | www.chosa.com |
							support@chosa.com | se connecter </font>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0"
							bgcolor="#F6F6F6"
							style="width: 100%; background-color: #f6f6f6; padding: 5px 8px; color: #666666; font-family: Arial, sans-serif; font-weight: 400; line-height: 160%; border: 0 none">
							<tbody>
								<tr>
									<td></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="yj6qo"></div>
		<div class="adL"></div>
	</div>
</body>
</html>