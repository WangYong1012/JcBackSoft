<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>404错误界面</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="container">

	没有找到您请求的界面，请确认URL后重试！&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/system/main/index">返回主页</a>
</body>
</html>
