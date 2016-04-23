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

<title>注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="Register">

<link href="<%=path%>/css/login.css" rel="stylesheet" type="text/css">


<script type="text/javascript" charset="utf-8" src="js/register.js">
	
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
					<td class="first">验证码</td>
					<td class="second"><input id="inputIdentifyCode" type="text"
						name="inputIdentifyCode"></td>
				</tr>

				<tr>
					<td class="first"><input id="changeCodeButton" type="button"
						value="更换验证码" onclick="changeIdentifyCodeJS()"></td>
					<td class="second"><img id="identifyCodeImg"
						src="images/defaultCode.jpg"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button"
						value="返回登录" onclick="returnLogin()"> <input type="button"
						value="注册" onclick="check()"></td>
				</tr>

				<c:if test="${nameIsExist eq 'true' }">
					<tr>
						<td colspan="2" align="center">
							<h1>注册的用户已存在</h1>
						</td>
					</tr>
				</c:if>

				<c:if test="${identifyCodeError eq 'true' }">
					<tr>
						<td colspan="2" align="center">
							<h1>验证码错误</h1>
						</td>
					</tr>
				</c:if>



				<c:if test="${usernameAndPassword eq 'true' }">
					<tr>
						<td colspan="2" align="center">
							<h1>用户名和密码有误</h1>
						</td>
					</tr>
				</c:if>


			</table>
		</form>
	</div>
</body>
</html>
