<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>金池金融汇 - 新闻列表页</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/skin/main/css/dashboard.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var newId = ${newId};
			$.post("${pageContext.request.contextPath}/system/news/loadContent",
				{
					"newId" : newId
				}, function(result)
				{
					console.info(result);
					$("#content-head").html(result["newsEntity"].title);
					$("#content-body").html(result["newsEntity"].content);
					$("#content-foot").html("作者：" + result["newsEntity"].author + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
							"发布时间：" + result["newsEntity"].issuetime);
				})
		})
	</script>
</head>
<body class="container">

<!-- 包含了导航的内容 -->
<%@include file="../../head_news.jsp"%>

<div class="row">
	<div class="col-sm-3 col-md-2 sidebar">
		<!-- 左侧导航栏 -->
		<ul class="nav nav-sidebar">
			<li><a href="${pageContext.request.contextPath}/system/main/index.html">用户列表</a></li>
			<li><a href="${pageContext.request.contextPath}/system/main/query.html">报表查询</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/system/news/list.html">新闻列表</a></li>
			<li><a href="${pageContext.request.contextPath}/system/image/index.html">图片上传</a></li>
			<li><a href="${pageContext.request.contextPath}/system/balance/index.html">虚拟金币</a></li>
			<li><a href="${pageContext.request.contextPath}/system/authentication/index.html">添加认证</a></li>
		</ul>
	</div>
	<!-- 右侧列表栏 -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<%--<h3 class="sub-header">用户列表</h3>--%>
			<div class="panel panel-success">
				<div class="panel-heading">
					<span id="content-head"></span>
				</div>
				<div class="panel-body">
					<span id="content-body"></span>
				</div>
				<div class="panel-footer">
					<span id="content-foot"></span>
				</div>
			</div>
	</div>
</div>
</body>
</html>