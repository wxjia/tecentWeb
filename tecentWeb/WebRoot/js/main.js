/**
 * 
 */

function comment() {
	var userComment = document.getElementById("userComment").value;
	if (null == userComment || userComment == "") {
		alert("请输入留言内容");
		return;
	}

	if (userComment.length > 128) {
		alert("输入的留言过长");
		return;
	}

	document.getElementById("myForm").submit();
}