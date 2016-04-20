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

<title>丽萍 and 维熙</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="丽萍&&维熙的小网站">

<link href="<%=path%>/css/index.css" rel="stylesheet" type="text/css">

</head>

<body>

	<c:if test="${loginSuccess eq 'true' }">
		<h1>登陆成功</h1>
	</c:if>

	<c:if test="${registerSuccess eq 'true' }">
		<h1>注册成功</h1>
	</c:if>

	<a href="<%=path%>/jsp/youthRecords.jsp">时光记录</a>
	<br>
	<a href="<%=path%>/jsp/loveTree.jsp">爱情树</a>
	<br>
	<a href="ShowVisitor">查看访客记录</a>
	<br>
</body>
</html>
