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

<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="Login">

<link href="<%=path%>/css/login.css" rel="stylesheet" type="text/css">


<script type="text/javascript" charset="utf-8">
	function register() {
		//window.navigate("register.jsp");
		window.location.href = "register.jsp";
	}

	function check() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if (null == username || "" == username) {
			alert("用户邮箱为空");
			return;
		}
		var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
		if (!pattern.test(username)) {
			// 如果验证不成功
			alert("邮箱格式不正确");
			return;
		}
		if (null == password || "" == password) {
			alert("密码为空");
			return;
		}
		document.getElementById("myForm").submit();
	}

	document.onkeydown = function() {
		// 如果按下回车键
		if (event.keyCode == 13) {
			check();
		}
	}
</script>

</head>

<body>

	<div>
		<form id="myForm" action="Login" method="post">
			<table border="0px" align="center">
				<tr>
					<td colspan="2" align="center">登录页</td>
				</tr>
				<tr>
					<td class="first">用户邮箱</td>
					<td class="second"><input id="username" type="text"
						name="username"></td>
				</tr>
				<tr>
					<td class="first">密码</td>
					<td class="second"><input id="password" type="password"
						name="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="登录"
						onclick="check()"> <input type="button" value="先去注册"
						onclick="register()"></td>
				</tr>
				<c:if test="${loginFaliure eq 'true' }">
					<tr>
						<td colspan="2" align="center">
							<h1>登录失败，请重试</h1>
						</td>
					</tr>
				</c:if>
			</table>
		</form>
	</div>

</body>
</html>



