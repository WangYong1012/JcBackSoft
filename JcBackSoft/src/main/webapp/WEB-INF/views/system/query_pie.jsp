<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>金池金融汇 - 首页</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/skin/main/css/dashboard.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/chart/js/fusioncharts.js"></script>
	<script src="${pageContext.request.contextPath}/chart/js/themes/fusioncharts.theme.fint.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		FusionCharts.ready(function(){
			renderCharts();
		})

		function renderCharts()
		{
			var beginDate = $("#beginDate").val();
			var endDate = $("#endDate").val();
			var property = $("#selectProperty").val();
			//加载用户总数量
			$.post("${pageContext.request.contextPath}/system/user/userinfopie",
				{
					"beginDate" : beginDate,
					"endDate" : endDate,
					"property" : property
				},
			function(result)
			{
				var myChart = new FusionCharts({
					type: 'doughnut2d',
					renderAt: 'chart-userinfo-allcounts',
					width: '550',
					height: '550',
					dataFormat: 'json',
					dataSource: eval('(' + result + ')')
				});
				myChart.render();
			})
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
			<li><a href="${pageContext.request.contextPath}/system/main/index">用户列表</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/system/main/query">报表查询</a></li>
			<li><a href="${pageContext.request.contextPath}/system/news/list.html">新闻列表</a></li>
			<li><a href="${pageContext.request.contextPath}/system/image/index.html">图片上传</a></li>
			<li><a href="${pageContext.request.contextPath}/system/balance/index.html">虚拟金币</a></li>
			<li><a href="${pageContext.request.contextPath}/system/authentication/index.html">添加认证</a></li>
		</ul>
	</div>
	<!-- 右侧列表栏 -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<%--<h3 class="sub-header">用户列表</h3>--%>
		从&nbsp;<input id="beginDate" class="Wdate" type="text" onfocus="WdatePicker();">
		&nbsp;至&nbsp;<input id="endDate" class="Wdate" type="text" onfocus="WdatePicker();">
			<select id="selectProperty">
				<option value="plat">客户端类型</option>
				<option value="useridentity">用户身份</option>
				<option value="area">地区</option>
				<option value="sex">性别</option>
				<option value="state">用户角色</option>
			</select>
		<input type="button" class="btn btn-success btn-sm" value="执行查询" onclick="renderCharts();"/>
		<br/>
		<section>
			<div class="table-responsive">
				<table class="table table-striped">
					<div id="chart-userinfo-allcounts">

					</div>
				</table>
			</div>
		</section>
	</div>
</div>
</body>
</html>