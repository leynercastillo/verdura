<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Verdura</title>
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="-1" />
	<link rel="icon" type="image/png" href="resource/images/icons/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="resource/style/stylePage.css">
	<link rel="stylesheet" type="text/css" href="resource/style/bootstrap.min.css">
	<z:zkhead />
</head>
<body>
	<%
	    request.setAttribute(org.zkoss.zk.ui.sys.Attributes.NO_CACHE, Boolean.TRUE);
	%>
	<z:page>
		<z:window>
			<div class="page">
				<div class="aside">
					<jsp:include page="system/frmMenu.zul"></jsp:include>
				</div>
				<div class="section-main">
					<jsp:include page="system/index.zul" />
				</div>
			</div>
		</z:window>
	</z:page>
</body>
</html>