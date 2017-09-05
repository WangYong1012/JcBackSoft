<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>金池金融汇 - 上传图片</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/skin/main/css/dashboard.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
	<!-- uploadify -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/uploadify/uploadify.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/uploadify/jquery.uploadify.min.js"></script>:

	<script type="text/javascript" src="${pageContext.request.contextPath }/uploadify/jquery.uploadify.js"></script>
	<link href="${pageContext.request.contextPath }/uploadify/uploadify.css" rel="stylesheet" type="text/css"/>

	<script type="text/javascript">
		$(function(){
			$("#uploadify_files").uploadify({
				width:50,
				height:20,
				swf:"${pageContext.request.contextPath}/uploadify/uploadify.swf",
				uploader:"${pageContext.request.contextPath}/upload/UploadifyServlet",
				cancelImg:"${pageContext.request.contextPath}/uploadify/uploadify-cancel.jpg",
				buttonText:"浏  览",
				queueID:"scQuenId",
				queueSizeLimit:10,
				auto:false,
				multi:true,
				removeCompleted:true,
				fileSizeLimit:"10MB",
				fileTypeDesc:"Image Files",
				fileTypeExts:"*.gif; *.jpg; *.png; *.bmp;",
				onInit:function()
				{
					//初始化
				},
				onSelectOnce:function(event, data)
				{
					//alert(data);
				},
				onSelect:function(file)
				{

				},
				onCancel:function(file)
				{

				},
				onSelectError:function(file, errorCode, errorMsg)
				{
					$.messager.alert("提示信息", "错误内容为：" + errorMsg);
				},
				onQueueComplete:function(data)
				{
					$("#uploadImgResult").html("上传成功：" + data.uploadsSuccessful + "个, 失败：" + data.uploadsErrored + "个");
					//上传成功后的显示内容提示

				},
				onUploadSuccess:function(file, data, response)
				{
					var date = new Date();
					var dateString = date.getFullYear();
					var sufi = $("#uploadFilesInput").val();
					$("#uploadFilesInputs").append("<input type=\"text\" name=\"uploadFilesInput\" class=\"form-control\" value=\"http://inf.shandongjinchi.com/image/" + dateString + "/" + data + "\" readonly/>");
				}
			});
		})
		//开始上传文件
		function startToUploadFiles()
		{
			var fileLengthes = $("#scQuenId").find("div[id^=SWFUpload_]").length;
			if(0 == fileLengthes)
			{
				$("#dialogResultMessageShowSpan").html("请选择图片后再点击“上传图片”按钮进行上传操作！");
				$("#thirdDialogBtn").click();
			}else
			{
				$("#uploadify_files").uploadify("upload", "*");
			}
		}
	</script>
</head>
<body class="container">
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">金池金融汇 - 后台首页</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">待增功能</a></li>
				<li><a href="${pageContext.request.contextPath}/system/logout">退出后台</a></li>
			</ul>
		</div>
	</div>
</nav>
<div class="row">
	<div class="col-sm-3 col-md-2 sidebar">
		<!-- 左侧导航栏 -->
		<ul class="nav nav-sidebar">
			<li><a href="${pageContext.request.contextPath}/system/main/index.html">用户列表</a></li>
			<li><a href="${pageContext.request.contextPath}/system/main/query.html">用户查询</a></li>
			<li><a href="${pageContext.request.contextPath}/system/news/list.html">新闻列表</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/system/image/index.html">图片上传</a></li>
			<li><a href="${pageContext.request.contextPath}/system/balance/index.html">虚拟金币</a></li>
			<li><a href="${pageContext.request.contextPath}/system/authentication/index.html">添加认证</a></li>
		</ul>
	</div>
	<!-- 右侧列表栏 -->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<section>
			<h3>图片上传</h3>
		</section>
		<div>
			<span id="scQuenId"></span>
			<span id="uploadImgResult"></span>
			<input type="file" name="uploadify" id="uploadify_files"/>
			<input type="button" class="btn btn-warning btn-sm" value="开始上传" onclick="startToUploadFiles();"/>
			<p>上传结果（路径）：</p>
			<span id="uploadFilesInputs">

			</span>
		</div>


	</div>

	<!-- 上传成功提示弹出框 -->
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
					<span id="dialogResultMessageShowSpan"></span>
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