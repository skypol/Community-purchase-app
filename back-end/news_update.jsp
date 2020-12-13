<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
<script type="text/javascript">
	function addCity() {
		window
				.open(
						"zhuanye_add.jsp",
						"newwindow",
						"height=600, width=800, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");

	}
</script>
</head>

<body>

	<!--/sidebar-->
	<div class="main-wraps">

		<div class="crumb-wrap">
			<div class="crumb-list">
				<i class="icon-font"></i>首页<span class="crumb-step">&gt;</span>商品信息<span
					class="crumb-step">&gt;</span><span>新增</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="result-wrap">
			<div class="result-content">


				<table class="insert-tab" width="100%" style="margin-top: 100dx;">
					<tbody>
						<form action="${pageContext.request.contextPath}/news/update"
							method="post">
							<tr>
								<th><i class="require-red"></i>商品名称：</th>
								<td><input class="common-text required" id="mesage.title"
									name="mesage.title" size="50" value="${mesage.title }" type="text">
									<input class="common-text required" id="mesage.id"
									name="mesage.id" size="50" value="${mesage.id }" type="hidden"></td>
							</tr>
							<tr>
								<th><i class="require-red"></i>商品价格：</th>
								<td><input class="common-text required" id="mesage.price"
									name="mesage.price" size="50" value="${mesage.price }" type="text">元</td>
							</tr>
							<tr>
								<th><i class="require-red"></i>社区：</th>
								<td><select name="mesage.type">
								<option value="${mesage.type }">${mesage.type }</option>
										<option value="金陵湾">金陵湾</option>
										<option value="新和园">新和园</option>
										<option value="芳草园">芳草园</option>
										<option value="汇贤居">汇贤居</option>
								</select></td>
							</tr>
							<tr>
								<th>描述：</th>
								<td><textarea name="mesage.msg" class="common-textarea"
										id="mesage.msg" cols="30" style="width: 98%;" rows="10">${mesage.msg}</textarea></td>
							</tr>
<tr>
								<th><i class="require-red"></i>数量：</th>
								<td><input class="common-text required" id="mesage.shuliang"
									name="mesage.shuliang" size="50" value="${mesage.shuliang }" type="text"></td>
							</tr>
							<tr>
								<th></th>
								<td><input class="btn btn-primary btn6 mr10" value="提交"
									type="submit"> <input class="btn btn6"
									onClick="history.go(-1)" value="返回" type="button"></td>
							</tr>
						</form>
					</tbody>
				</table>

			</div>

		</div>
	</div>

</body>
</html>
