<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="Register">

<link href="<%=path%>/css/login.css" rel="stylesheet" type="text/css">


<script type="text/javascript" charset="utf-8">
	function check() {
		var username = document.getElementById("username").value;
		var realname = document.getElementById("realname").value;
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;

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
		if (null == realname || "" == realname) {
			alert("真实姓名为空");
			return;
		}
		if (null == password || "" == password) {
			alert("密码为空");
			return;
		}

		if (password.length < 6) {
			alert("密码长度小于6");
			return;
		}

		if (null == repassword || "" == repassword) {
			alert("确认密码为空");
			return;
		}

		if (password != repassword) {
			alert("两次密码输入不同");
			return;
		}

		if ("123456" == password || "666666" == password) {
			alert("密码太简单");
			return;
		}

		document.getElementById("myForm").submit();
	}

	function returnLogin() {
		window.location.href = "login.jsp";
		//window.navigate("login.jsp");
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
		<form id="myForm" action="Register" method="post">
			<table border="0px" align="center">
				<tr>
					<td colspan="2" align="center">注册页</td>
				</tr>
				<tr>
					<td class="first">邮箱</td>
					<td class="second"><input id="username" type="text"
						name="username"></td>
				</tr>
				<tr>
					<td class="first">姓名</td>
					<td class="second"><input id="realname" type="text"
						name="realname"></td>
				</tr>
				<tr>
					<td class="first">密码</td>
					<td class="second"><input id="password" type="password"
						name="password"></td>
				</tr>
				<tr>
					<td class="first">确认密码</td>
					<td class="second"><input id="repassword" type="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button"
						value="返回登录" onclick="returnLogin()"> <input type="button"
						value="注册" onclick="check()"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
