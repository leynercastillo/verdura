<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="-1" />
</head>
<body style="height: auto">
	<%
		request.setAttribute(org.zkoss.zk.ui.sys.Attributes.NO_CACHE,
				Boolean.TRUE);
	%>
	<jsp:include page="frmItemMaster.zul" />
</body>
</html>