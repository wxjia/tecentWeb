/**
 * 
 */

var xmlHttpRequest;
var identifyCode = "";

function changeIdentifyCodeJS() {
	createXmlHttpRequest();
	if (xmlHttpRequest != null) {// 确定XMLHttpRequest是否创建成功
		var url = "IdentifyingCode";
		xmlHttpRequest.open("POST", url, true);
		xmlHttpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;");
		xmlHttpRequest.onreadystatechange = processRequest; // 注册回调函数
		xmlHttpRequest.send("random=random");
	} else {
		alert("不能创建XMLHttpRequest对象实例");
	}
}

function createXmlHttpRequest() {
	try {
		// 针对IE5、IE5.5、IE6
		xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			// 针对IE5、IE5.5、IE6
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			try {
				// 针对FireFox、Mozillar、Opera、Safari、IE7、IE8
				xmlHttpRequest = new XMLHttpRequest();// 创建XMLHttpRequest对象

				if (xmlHttpRequest.overrideMimeType) {// 修正某些浏览器的BUG
					xmlHttpRequest.overrideMimeType("text/xml");
				}
			} catch (e) {
				alert("无法使用ajax");
			}
		}
	}
}

function processRequest() {
	if (xmlHttpRequest.readyState == 4) {// 判断是否建立连接
		if (xmlHttpRequest.status == 200) {
			identifyCode = xmlHttpRequest.responseText;
			identifyCode = identifyCode.toUpperCase();
			var verify = document.getElementById("identifyCodeImg");
			verify.setAttribute("src", "images/identifyCode.jpg?random="
					+ Math.random());
			document.getElementById("changeCode").value = "更换验证码";
		} else {
			alert("请求处理返回的数据有错误");
			alert(xmlHttpRequest.status);

		}
	}
}

function check() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if (null == username || "" == username) {
		alert("用户邮箱为空");
		return;
	}
	if (username.length > 40) {
		alert("用户邮箱过长");
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
	if (password.length > 40) {
		alert("密码过长");
		return;
	}

	var inputIdentifyCode = document.getElementById("inputIdentifyCode").value;
	if (null == inputIdentifyCode || "" == inputIdentifyCode) {
		alert("验证码为空");
		return;
	}
	inputIdentifyCode = inputIdentifyCode.toUpperCase();
	if (inputIdentifyCode != identifyCode) {
		alert("验证码错误");
		return;
	}
	document.getElementById("myForm").submit();
}

function register() {
	// window.navigate("register.jsp");
	window.location.href = "register.jsp";
}

document.onkeydown = function() {
	// 如果按下回车键
	if (event.keyCode == 13) {
		check();
	}
};