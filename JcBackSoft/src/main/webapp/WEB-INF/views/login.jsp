<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>金池金融汇 - 登录</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="container"
	  style="padding: 40px 350px 0px 350px;">
	<!-- 如果发现页面样式不正常，需要对方确认自己的网络连接是否正常 -->
	<%--<div class="row">--%>
		<form method="post" class="form-signin" action="j_spring_security_check" novalidate="novalidate">
			<div class="input-group">
				<label class="input-group-addon" for="j_username">账号</label>
				<input type="text" id="j_username" name="j_username" value="15662696090" class="form-control" style="width: 35%;"
					   placeholder="请输入您的账户" required/>
			</div>
			<div class="input-group">
				<label class="input-group-addon" for="j_password">密码</label>
				<input type="password" id="j_password" name="j_password" value="4414463" class="form-control" style="width: 35%;"
					   placeholder="* * * * * * * * *" required/>
			</div>
			<input type="submit" class="btn btn-success btn-md" value="提交"/>
			<input type="reset" class="btn btn-default btn-md" value="取消"/>
		</form>
	<%--</div>--%>

</body>
</html>