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
			var titleName = $("#queryTitleName").val();
			var authorName = $("#queryAuthorName").val();
			$.post("${pageContext.request.contextPath}/system/news/getNewsList",
					{
						"pages" : 1,
						"titleName" : titleName,
						"authorName" : authorName
					}, function(result)
			{
				var html = "";
				for(var len = 0; len < result["lists"].length; len ++)
				{
					html += "<tr>";
					html += "<td>" + result["lists"][len].newsid + "</td>";
					html += "<td><a href=\"${pageContext.request.contextPath}/system/news/index.html?newId='"
							+ result["lists"][len].newsid + "'\">" + result["lists"][len].title + "</a></td>";
					html += "<td>" + result["lists"][len].author + "</td>";
					html += "<td>" + result["lists"][len].issuetime + "</td>";
					html += "<td><a href=\"javascript:deleteNewsFunc(" + result["lists"][len].newsid + ")\">删除</a>&nbsp;&nbsp;" +
							"|&nbsp;&nbsp;<a href=\"${pageContext.request.contextPath}/system/news/edit.html?newId='" + result["lists"][len].newsid + "'\">编辑</a></td>";
					html += "</tr>";
				}
				$("#newsListBodyDiv").html(html);
				$("#pagenationDiv").html(result["pagenation"]);
			})
			//userListFootDiv
		})
		//上一页
		function goPage(pageNum)
		{
			var titleName = $("#queryTitleName").val();
			var authorName = $("#queryAuthorName").val();
			$.post("${pageContext.request.contextPath}/system/news/getNewsList",
					{
						"pages" : pageNum,
						"titleName" : titleName,
						"authorName" : authorName
					}, function(result)
			{
				var html = "";
				for(var len = 0; len < result["lists"].length; len ++)
				{
					html += "<tr>";
					html += "<td>" + result["lists"][len].newsid + "</td>";
					html += "<td><a href=\"${pageContext.request.contextPath}/system/news/index.html?newId='"
							+ result["lists"][len].newsid + "'\">" + result["lists"][len].title + "</a></td>";
					html += "<td>" + result["lists"][len].author + "</td>";
					html += "<td>" + result["lists"][len].issuetime + "</td>";
					html += "<td><a href=\"javascript:deleteNewsFunc(" + result["lists"][len].newsid + ")\">删除</a>&nbsp;&nbsp;" +
							"|&nbsp;&nbsp;<a href=\"${pageContext.request.contextPath}/system/news/edit.html?newId='" + result["lists"][len].newsid + "'\">编辑</a></td>";
					html += "</tr>";
				}
				$("#newsListBodyDiv").html(html);
				$("#pagenationDiv").html(result["pagenation"]);
			})
		}
		function deleteNewsFunc(newsid)
		{
			//需要加上弹出提示
			if(window.confirm('您确定删除该条新闻？')){
				//alert("确定");
				$.post("${pageContext.request.contextPath}/system/news/deleteNews", {"newsId" : newsid }, function(result)
				{
					goPage(1);
				})
				return true;
			}else{
				//alert("取消");
				return false;
			}
		}
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
			<input type="text" class="form-control" id="queryTitleName" value="" placeholder="请输入标题"
				   style="width: 20%;display: inline"/>
			<input type="text" class="form-control" id="queryAuthorName" value="" placeholder="请输入发布人"
				   style="width: 20%;display: inline;"/>
			<input type="button" id="queryUserNameBtn" class="btn btn-primary btn-md" value="执行查询" onclick="goPage('1');"/>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
				<tr>
					<th>ID</th>
					<th>新闻标题</th>
					<th>新闻作者</th>
					<th>发布时间</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody id="newsListBodyDiv">

				</tbody>
				<tfoot id="newsListFootDiv">

				</tfoot>
			</table>
		</div>
		<div id="pagenationDiv">

		</div>
	</div>
</div>
</body>
</html>