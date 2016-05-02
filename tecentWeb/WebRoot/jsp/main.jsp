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

<title>Jia_Vc的主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="<%=path%>/css/main.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="/tecentWeb/js/main.js">
	
</script>

</head>

<body>
	<c:if test="${loginSuccess eq 'true' }">
		<h1>登陆成功</h1>
	</c:if>

	<c:if test="${registerSuccess eq 'true' }">
		<h1>注册成功</h1>
	</c:if>

	<c:if test="${commentSuccess eq 'true' }">
		<h1>评论成功</h1>
	</c:if>

	<c:if test="${commentSuccess eq 'false' }">
		<h1>评论失败</h1>
	</c:if>

	<h1>${username }~~Jia_Vc的主页欢迎你</h1>
	<a href="ShowVisitor">查看访客记录</a>

	<h1>有啥好建议，给我留言。</h1>

	<form id="myForm" action="LeaveWord" method="post">
		<textarea id="userComment" name="userComment" rows="10" cols="100"></textarea>
		<br> <input type="button" value="提交留言" onclick="comment()">
	</form>

</body>
</html>
