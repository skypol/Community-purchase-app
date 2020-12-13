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
					class="crumb-step">&gt;</span><span class="crumb-name">信息</span>
					</div>
				</div>
			<div class="result-wrap">
			
		<div class="result-wrap">
			<form name="myform" id="myform" method="post">
				<div class="result-title">
					<div class="result-list">
					</div>
				</div>
				</form>
				
				<div class="result-wrap">
				<form name="myform" id="myform" method="post" class="layui-form" action="${pageContext.request.contextPath}/news/findAllDingdan">
				<tr>
								<th><i class="require-red"></i>团购商品：</th>
								<td><select name="key">
										<option value="全部">全部</option>
										<option value="秋月梨">秋月梨</option>
										<option value="披萨">披萨</option>
										<option value="豆腐干">豆腐干</option>
										<option value="泡饭">泡饭</option>
										<option value="苹果">苹果</option>
										<option value="肉夹馍">肉夹馍</option>
								</select></td>
								<input type="hidden" value="2" name="type"/>
							</tr>
							<input type="submit" value="搜索"/>    
							<a href="${pageContext.request.contextPath}/news/dctg?type=2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;导出Excel</a>
							</form>
				
				
				<div class="result-content">
					<table class="result-tab" width="100%">
						<tr>
							<th>序号</th>
							<th>用户</th>
							<th>昵称</th>
							<th>商品名称</th>
							<th>价格</th>
							<th>社区</th>
							<th>添加时间</th>
							<th>收获地址及联系方式</th>
							<th>当前状态</th>
							<th>处理</th>
						</tr>
						<c:forEach var="x" items="${list}" varStatus="status">

							<tr>
								<td>${status.index+1}</td>
								<td>${x.user}</td>
								<td>${x.nickname}</td>
								<td>${x.name}</td>
								<td>${x.price}</td>
								<td>${x.type}</td>
								<td>${x.addtime}</td>
								<td>${x.pj}</td>
								<td>${x.state}</td>
								<td><a href="${pageContext.request.contextPath}/news/upddstate?dingdan.id=${x.id}&dingdan.state=接受&type=2">接受</a>||<a href="${pageContext.request.contextPath}/news/upddstate?dingdan.id=${x.id}&dingdan.state=拒绝&type=2">拒绝</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			
			</div>
		</div>
	</div>
	<!--/main-->
</body>
</html>
