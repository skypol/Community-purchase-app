<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
<script type="text/javascript">
	function addCity() {
		window
				.open(
						"zhuanye_add.jsp",
						"newwindow",
						"height=600, width=800, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");

	}
		function check(){
	
	document.getElementById("realpath").value = document.getElementById("path").value;
	alert(document.getElementById("realpath").value);
	return true;
}

function get(id){
	var ip = document.getElementById(id).files[0].getAsDataURL();
	alert("5555");
	if(ip.files){
		try{
			document.getElementById("realpath").value = ip.files[0].getAsDataURL();
			alert(ip.value);
		}catch(err){
		}
	}
}
</script>
</head>

<body>
	<!--/sidebar-->
	<div class="main-wraps">
		<div class="crumb-wrap">
			<div class="crumb-list">
				<i class="icon-font"></i><a href="index.html">首页</a><span
					class="crumb-step">&gt;</span><span class="crumb-name">用户信息</span>
					</div>
				</div>
			<div class="result-wrap">
			<form action="${pageContext.request.contextPath}/wenti/dao" method="post">
				<div class="result-title">
					<div class="result-list">
					
					</div>

				</div>
			</form>
		<div class="result-wrap">
			<form name="myform" id="myform" method="post">
				<div class="result-title">
					<div class="result-list">
					</div>
				</div>
				<div class="result-content">
					<table class="result-tab" width="100%">
						<tr>
							<th>序号</th>
							<th>昵称</th>
							<th>帐号</th>
							<th>密码</th>
							<th>操作</th>
						</tr>
						<c:forEach var="x" items="${u}" varStatus="status">

							<tr>
								<td>${status.index+1}</td>
								<td>${x.nickname}</td>s
								<td>${x.username}</td>
								<td>${x.pass}</td>
								<td>  <a class="link-del"
									href="${pageContext.request.contextPath}/user/del/${x.id}">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</form>
		</div>
	</div>
	<!--/main-->
</body>
</html>
