<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>金池金融汇 - 首页</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/skin/main/css/dashboard.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var loginName = $("#queryLoginName").val();
			var userName = $("#queryUserName").val();
			$.post("${pageContext.request.contextPath}/system/user/getUserList",
					{
						"pages" : 1,
						"loginName" : loginName,
						"userName" : userName
					}, function(result)
			{
				for(var len = 0; len < result["lists"].length; len ++)
				{
					var html = "<tr>"
					html += "<td>" + result["lists"][len].id + "</td>";
					html += "<td>" + result["lists"][len].username + "</td>";
					html += "<td><a href=\"javascript:showUserInfoMore('"
							+ result["lists"][len].trueusername + "','"
							+ result["lists"][len].sex + "','"
							+ result["lists"][len].phone + "','"
							+ result["lists"][len].companyname + "','"
							+ result["lists"][len].companyaddress + "','"
							+ result["lists"][len].score + ""
							+ "')\">" + result["lists"][len].trueusername + "</a></td>";
					html += "<td>" + result["lists"][len].sex + "</td>";
					html += "<td>" + result["lists"][len].phone + "</td>";
					html += "<td>" + result["lists"][len].state + "</td>";
					html += "<td>" + result["lists"][len].plat + "</td>";
					html += "</tr>";
					$("#userListBodyDiv").append(html);
				}
				$("#pagenationDiv").append(result["pagenation"]);
			})
			//userListFootDiv
		})
		//上一页
		function goPage(pageNum)
		{
			var loginName = $("#queryLoginName").val();
			var userName = $("#queryUserName").val();
			$.post("${pageContext.request.contextPath}/system/user/getUserList",
					{
						"pages" : pageNum,
						"loginName" : loginName,
						"userName" : userName
					}, function(result)
			{
				var html = "";
				for(var len = 0; len < result["lists"].length; len ++)
				{
					html += "<tr>";
					html += "<td>" + result["lists"][len].id + "</td>";
					html += "<td>" + result["lists"][len].username + "</td>";
					html += "<td><a href=\"javascript:showUserInfoMore('"
							+ result["lists"][len].trueusername + "','"
							+ result["lists"][len].sex + "','"
							+ result["lists"][len].phone + "','"
							+ result["lists"][len].companyname + "','"
							+ result["lists"][len].companyaddress + "','"
							+ result["lists"][len].score + ""
							+ "')\">" + result["lists"][len].trueusername + "</a></td>";
					html += "<td>" + result["lists"][len].sex + "</td>";
					html += "<td>" + result["lists"][len].phone + "</td>";
					html += "<td>" + result["lists"][len].state + "</td>";
					html += "<td>" + result["lists"][len].plat + "</td>";
					html += "</tr>";
				}
				$("#userListBodyDiv").html(html);
				$("#pagenationDiv").html(result["pagenation"]);
			})
		}

		function showUserInfoMore(v1, v2, v3, v4, v5, v6)
		{
			$("#dialog_userName").html(v1);
			$("#dialog_phone").html(v2);
			$("#dialog_sex").html(v3);
			$("#dialog_Companyname").html(v4);
			$("#dialog_Companyaddress").html(v5);
			$("#dialog_score").html(v6);
			$("#thirdDialogBtn").click();
		}
	</script>

</head>
<body class="container">

<!-- 包含了导航的内容 -->
<%@include file="../head.jsp"%>

<div class="row">
	<div class="col-sm-3 col-md-2 sidebar">
		<!-- 左侧导航栏 -->
		<ul class="nav nav-sidebar">
			<li class="active"><a href="${pageContext.request.contextPath}/system/main/index.html">用户列表</a></li>
			<li><a href="${pageContext.request.contextPath}/system/main/query.html">报表查询</a></li>
			<li><a href="${pageContext.request.contextPath}/system/news/list.html">新闻列表</a></li>
			<li><a href="${pageContext.request.contextPath}/system/image/index.html">图片上传</a></li>
			<li><a href="${pageContext.request.contextPath}/system/balance/index.html">虚拟金币</a></li>
			<li><a href="${pageContext.request.contextPath}/system/authentication/index.html">添加认证</a></li>
		</ul>
	</div>
	<!-- 右侧列表栏 -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<%--<h3 class="sub-header">用户列表</h3>--%>
			<input type="text" class="form-control" id="queryLoginName" value="" placeholder="请输入账户名"
				   style="width: 20%;display: inline"/>
			<input type="text" class="form-control" id="queryUserName" value="" placeholder="请输入用户名"
				   style="width: 20%;display: inline;"/>
			<input type="button" id="queryUserNameBtn" class="btn btn-primary btn-md" value="执行查询" onclick="goPage('1');"/>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
				<tr>
					<th>ID</th>
					<th>帐号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>联系方式</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody id="userListBodyDiv">

				</tbody>
				<tfoot id="userListFootDiv">

				</tfoot>
			</table>
		</div>
		<div id="pagenationDiv">

		</div>
	</div>

	<input type="button" id="thirdDialogBtn" data-toggle="modal" data-target="#parameterModal" style="display: none;"/>
	<!-- 当出现异常情况时，直接弹出提示框 -->
	<div class="modal fade" id="parameterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">个人信息详情</h4>
				</div>
				<div class="modal-body" id="dialogResultMessage">
					用户名：<span id="dialog_userName"></span><br/>
					性  别：<span id="dialog_sex"></span><br/>
					手机号：<span id="dialog_phone"></span><br/>
					公司名称：<span id="dialog_Companyname"></span><br/>
					公司地址：<span id="dialog_Companyaddress"></span><br/>
					当前积分：<span id="dialog_score"></span><br/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" data-dismiss="modal">关闭窗口</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>