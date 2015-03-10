<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Fresco y natural - Login</title>
	<link rel="icon" type="image/png"
	href="resource/images/icons/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="resource/style/stylePage.css">
	<link rel="stylesheet" type="text/css" href="resource/style/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span6 offset3">
				<div class="modal">
					<div class="modal-header">
						<h3>Iniciar Sesion</h3>
					</div>
					<div class="modal-body">
						<jsp:include page="system/login/login.zul" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="span10 offset1" style="text-align: right;"></div>
			</div>
		</div>
	</div>
</body>
</html>