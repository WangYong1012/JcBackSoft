<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>${newsEntity.author}</title>
	<link href="${pageContext.request.contextPath}/local/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
	<script src="${pageContext.request.contextPath}/local/js/jquery.min.js"></script>
	<link href="${pageContext.request.contextPath}/local/css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="application/x-javascript">
		addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
	</script>
	<meta name="keywords" content="Tender Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndriodCompatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/local/js/move-top.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/local/js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
	</script>
	<style type="text/css">
		img { width: auto; max-width: 100%; }
	</style>
</head>
<body>
<div class="container-fluid" style="font-family: 微软雅黑;padding: 20px 10px 0px 10px;">
	<div id="callout-form-validation-state-accessibility" class="bs-callout bs-callout-warning"
		 style="color: #9e9e9e;padding: 10px 20px 0px 20px;background: #F6F6F6;">
		<p>
			新闻编号：${newsEntity.newsid}
		</p>
		<p>
			发布时间：${newsEntity.issuetime}
		</p>
		<p>
			发布人：${newsEntity.author}
		</p>
	</div>
	<br/>
	<div class="panel panel-danger">
		<div class="panel-heading">
			&nbsp;
		</div>
		<div class="panel-body" style="word-break: break-all; word-wrap:break-word;">
			<h4>${newsEntity.title}</h4>
			${newsEntity.content}
		</div>
		<div class="panel-footer" style="font-size: 13px;">
			山东左邻右舍信息咨询有限公司 版权所有
		</div>
	</div>
</div>
</body>
</html>