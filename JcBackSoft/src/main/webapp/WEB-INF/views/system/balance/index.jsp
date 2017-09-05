<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>金池金融汇 - 虚拟货币</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/skin/main/css/dashboard.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var mobileName = $("#queryMobileName").val();
			$.post("${pageContext.request.contextPath}/system/balance/loadContent",
					{
						"pages" : 1,
						"mobileName" : mobileName
					}, function(result)
					{
						var html = "";
						for(var len = 0; len < result["lists"].length; len ++)
						{
							html += "<tr>"
							html += "<td>" + result["lists"][len].id + "</td>";
							html += "<td>" + result["lists"][len].username + "</td>";
							html += "<td>" + result["lists"][len].balance + "</td>";
							html += "<td>" + result["lists"][len].remark + "</td>";
							html += "<td><a href=\"javascript:addBalance(" + result["lists"][len].username + ", " + result["lists"][len].balance + ");\">"
									+ "后台充值" + "</a></td>";
							html += "</tr>";
						}
						$("#balanceListBodyDiv").html(html);
						$("#pagenationDiv").html(result["pagenation"]);
					})
			//userListFootDiv
			$("#updateUserBalance").click(function(){
				var mobileName = $("#dialog_userName").val();
				var balance = $("#dialog_balance").val();
				$.post("${pageContext.request.contextPath}/system/balance/update",
						{
							"balance" : balance,
							"mobileName" : mobileName
						}, function(result)
						{
							//
						})

			})
		})
		//上一页
		function goPage(pageNum)
		{
			var mobileName = $("#queryMobileName").val();
			$.post("${pageContext.request.contextPath}/system/balance/loadContent",
					{
						"pages" : pageNum,
						"mobileName" : mobileName
					}, function(result)
					{
						var html = "";
						for(var len = 0; len < result["lists"].length; len ++)
						{
							html += "<tr>"
							html += "<td>" + result["lists"][len].id + "</td>";
							html += "<td>" + result["lists"][len].username + "</td>";
							html += "<td>" + result["lists"][len].balance + "</td>";
							html += "<td>" + result["lists"][len].remark + "</td>";
							html += "<td><a href=\"javascript:addBalance(" + result["lists"][len].username + ", " + result["lists"][len].balance + ");\">"
									+ "后台充值" + "</a></td>";
							html += "</tr>";
						}
						$("#balanceListBodyDiv").html(html);
						$("#pagenationDiv").html(result["pagenation"]);
					})
		}
		function addBalance(username)
		{
			$("#dialog_userName").val(username);

			$.post("${pageContext.request.contextPath}/getUserBalance", {"username" : username}, function(result){
				$("#dialog_currentBalance").val(result["balance"]);
			});
			$("#thirdDialogBtn").click();
		}
	</script>

</head>
<body class="container">

<!-- 包含了导航的内容 -->
<%@include file="../../head.jsp"%>

<div class="row">
	<div class="col-sm-3 col-md-2 sidebar">
		<!-- 左侧导航栏 -->
		<ul class="nav nav-sidebar">
			<li><a href="${pageContext.request.contextPath}/system/main/index.html">用户列表</a></li>
			<li><a href="${pageContext.request.contextPath}/system/main/query.html">报表查询</a></li>
			<li><a href="${pageContext.request.contextPath}/system/news/list.html">新闻列表</a></li>
			<li><a href="${pageContext.request.contextPath}/system/image/index.html">图片上传</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/system/balance/index.html">虚拟金币</a></li>
			<li><a href="${pageContext.request.contextPath}/system/authentication/index.html">添加认证</a></li>
		</ul>
	</div>
	<!-- 右侧列表栏 -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<%--<h3 class="sub-header">用户列表</h3>--%>
			<input type="text" class="form-control" id="queryMobileName" value="" placeholder="请输入手机号"
				   style="width: 20%;display: inline"/>
			<input type="button" id="queryUserNameBtn" class="btn btn-primary btn-md" value="执行查询" onclick="goPage('1');"/>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
				<tr>
					<th>ID</th>
					<th>电话号码</th>
					<th>余额</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody id="balanceListBodyDiv">

				</tbody>
				<tfoot id="balanceListFootDiv">

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
					<h4 class="modal-title" id="myModalLabel">后台充值</h4>
				</div>
				<div class="modal-body" id="dialogResultMessage">
					手机号码：<input type="text" class="form-control" id="dialog_userName"
								style="width: 60%;display: inline" readonly/><br/>
					当前余额：<input type="text" class="form-control" id="dialog_currentBalance"
								style="width: 60%;display: inline" readonly/><br/>
					充值金额：<input type="text" class="form-control" id="dialog_balance" placeholder="请输入充值金额"
								style="width: 60%;display: inline"/><br/>
					<font color="blue">请注意 : 充值金额指的是在原有余额的基础上增加的金额.</font>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" data-dismiss="modal" id="updateUserBalance">确认修改</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>