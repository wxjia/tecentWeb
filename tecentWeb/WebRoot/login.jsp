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

<script type="text/javascript" charset="utf-8" src="js/login.js">
	
</script>

</head>

<body>

	<h4>vcyoung.cn 于2016年4月16日 上线</h4>
	<h4>vcyoung.cn 2016年4月21日 第一次遭到攻击</h4>
	<h4>vcyoung.cn 2016年4月23日 完成注册验证码</h4>
	<h4>vc 打算每周写几页，毕业时就应该有好多页了</h4>

	<div>
		<form id="myForm" action="Login" method="post">
			<table align="center">
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
					<td class="first"><input type="button" value="登录"
						onclick="check()"></td>
					<td class="second"><input type="button" value="先去注册"
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
