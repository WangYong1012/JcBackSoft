<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>金池金融汇 - 添加认证</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/skin/main/css/dashboard.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function(){

		})
		//验证用户是否存在
		function checkExistUser()
		{
			var username = $("#userName").val();
			$.post("${pageContext.request.contextPath}/system/user/existUser",
					{ username : username },
					function(result)
					{
						var json = eval('(' + result + ')');
						if("SUCCESS" == json["resultCode"])
						{
							$("#existUserInfoSpan").html("<p style='width: 20%;' class='bg-success text-success'>" + json["resultMsg"] + "</p>");
						}else
						{
							$("#existUserInfoSpan").html("<p style='width: 20%;' class='bg-danger text-danger'>" + json["resultMsg"] + "</p>");
						}

					}
			)
		}
		function saveAuthentication()
		{
			var beginDate = $("#beginDate").val();
			var endDate = $("#endDate").val();
			var username = $("#userName").val();
			var region = $("#region").val();
			var type = $("#type").val();
			var payType = $("#payType").val();
			if(beginDate == "" || endDate == "" || username == "")
			{
				$("#thirdDialogBtn").click();
				return ;
			}
			$.post("${pageContext.request.contextPath}/system/authentication/save",
					{
						"beginDate" :beginDate,
						"endDate" :endDate,
						"username" : username,
						"region" : region,
						"type" : type,
						"payType" :payType
					},
					function(result)
			{
				alert("保存成功!");
			})

		}

		function changeEndDate()
		{
			var beginDate = $("#beginDate").val();
			var kssj = beginDate.replace(/-/g,"/");
			var date = new Date(kssj);
			var endDate = date.setMonth(date.getMonth() + 1);
			$("#endDate").val(new Date(endDate).toLocaleDateString());
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
			<li><a href="${pageContext.request.contextPath}/system/balance/index.html">虚拟金币</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/system/authentication/index.html">添加认证</a></li>
		</ul>
	</div>
	<!-- 右侧列表栏 -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<%--<h3 class="sub-header">用户列表</h3>--%>
		<p><h4>新增认证</h4></p><span id="existUserInfoSpan"></span>
		<div class="input-group">
			<label class="input-group-addon" for="userName">用户名</label>
			<input type="text" id="userName" name="userName" value="" class="form-control" style="width: 40%;"
				   placeholder="输入用户名" required onblur="checkExistUser();"/>
		</div>
			<br/>
		<div class="input-group">
			开始时间：<input id="beginDate" class="Wdate" type="text" dateFmt="yyyy/MM/dd" onfocus="WdatePicker();" onchange="changeEndDate();"/>
		</div>
			<br/>
		<div class="input-group">
			结束时间：<input id="endDate" class="Wdate" type="text" dateFmt="yyyy-MM-dd" onfocus="WdatePicker();"/>
		</div>
			<br/>
		<div class="input-group">
			<label class="input-group-addon" for="region">所在地区</label>
			<input type="text" id="region" name="region" value="" class="form-control" style="width: 40%;" required/>
		</div>
			<br/>
		<div class="input-group">
			<label class="input-group-addon" for="type">所属类型</label>
			<input type="text" id="type" name="type" value="" class="form-control" style="width: 40%;" required/>
		</div>
			<br/>
		<div class="input-group">
			<label class="input-group-addon" for="payType">是否支付</label>
			<select id="payType" name="payType" style="width: 40%;">
				<option value="未支付">未支付</option>
				<option value="已支付">已支付</option>
			</select>
		</div>
		<br/>
		<div class="input-group">
			<input type="button" class="btn btn-success btn-sm" value="提交认证" onclick="saveAuthentication();"/>
		</div>
	</div>

	<input type="button" id="thirdDialogBtn" data-toggle="modal" data-target="#parameterModal" style="display: none;"/>
	<!-- 当出现异常情况时，直接弹出提示框 -->
	<div class="modal fade" id="parameterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">提示信息</h4>
				</div>
				<div class="modal-body" id="dialogResultMessage">
					您还有未填写的项目, 请在填写完成后点击提交按钮!
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" data-dismiss="modal" id="updateUserBalance">关闭</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>