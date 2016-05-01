<%@page import="cn.wxjia.pojo.WebVisitBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>访客记录页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="visit">

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/showVisit.css">


</head>

<body>
	<h1>访客记录页</h1>
	<a href="jsp/main.jsp">返回</a>
	<br>
	<table border="1px">
		<tr>
			<td>ip</td>
			<td>time</td>
			<td>address</td>
		</tr>

		<c:forEach var="visiterBean" items="${list }">
			<tr>
				<td>${visiterBean.ip }</td>
				<td>${visiterBean.visitTime }</td>
				<td>${visiterBean.address }</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
