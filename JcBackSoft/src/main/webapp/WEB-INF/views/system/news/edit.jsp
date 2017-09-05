<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>金池金融汇 - 新闻编辑</title>
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
			var newsid = ${newId};
			$.post("${pageContext.request.contextPath}/system/news/loadContent",
				{
					"newId" : newsid
				}, function(result)
				{
					$("#newsId").val(result["newsEntity"].newsid);
					$("#newsTitle").val(result["newsEntity"].title);
					$("#newsAuthor").val(result["newsEntity"].author);
					$("#uploadFilesInput").val(result["newsEntity"].headimage);
					CKEDITOR.instances.newsContent.setData(result["newsEntity"].content);
				})


			$("#uploadify_files").uploadify({
				width:50,
				height:20,
				swf:"${pageContext.request.contextPath}/uploadify/uploadify.swf",
				uploader:"${pageContext.request.contextPath}/upload/UploadifyServlet",
				cancelImg:"${pageContext.request.contextPath}/uploadify/uploadify-cancel.jpg",
				buttonText:"浏  览",
				queueID:"scQuenId",
				queueSizeLimit:1,
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
				},
				onUploadSuccess:function(file, data, response)
				{
					var sufi = $("#uploadFilesInput").val();
					if(sufi == "")
					{
						$("#uploadFilesInput").val(data);
					}
					else
					{
						$("#uploadFilesInput").val(data);
					}
				}
			});

			$("#submitContentBtn").click(function(){

				$("#submitContentBtn").addClass("disabled");
				var newsid = $("#newsId").val();
				var author = $("#newsAuthor").val();
				var title = $("#newsTitle").val();
				var data = CKEDITOR.instances.newsContent.getData();
				var files = $("#uploadFilesInput").val();
				//执行保存操作
				$.post("${pageContext.request.contextPath}/system/news/update",
						{
							"newsId" : newsid,
							"author" : author,
							"title" : title,
							"content" : data,
							"files" : files
						}, function(result)
						{
							$("#dialogResultMessageShowSpan").html("发布新闻成功！");
							$("#thirdDialogBtn").click();
							//直接跳转至新闻列表界面
						})
			})
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
		<section>
			<h3>新闻发布</h3>
		</section>
		<form id="newsEditForm">
			<div class="input-group">
				<label class="input-group-addon" for="newsTitle">标题：</label>
				<input type="text" id="newsTitle" class="form-control" value="" placeholder="请输入新闻标题"/>
				<input type="hidden" id="newsId" value=""/>
			</div>
			<br/>
			<div class="input-group">
				<label class="input-group-addon" for="newsAuthor">作者：</label>
				<input type="text" id="newsAuthor" class="form-control" value="" placeholder="请输入作者姓名"/>
			</div>
			<br/>
			<div>
				<input type="text" id="uploadFilesInput" class="form-control" value="" readonly/>
				<span id="scQuenId"></span>
				<span id="uploadImgResult"></span>
				<input type="file" name="uploadify" id="uploadify_files"/>
				<input type="button" class="btn btn-warning btn-sm" value="上传图片" onclick="startToUploadFiles();"/>
			</div>
			<br/>
			<textarea rows="80" cols="60" name="contentEditor_thisWin" id="newsContent" placeholder="请输入新闻正文内容"></textarea>
			<script type="text/javascript">CKEDITOR.replace('contentEditor_thisWin');</script>
			<br/>
			<div class="row">
				<div class="col-sm-3">

				</div>
				<div class="col-sm-3">
					<input type="reset" id="resetContentBtn" class="btn btn-default btn-sm" value="重新编辑"/>
				</div>
				<div class="col-sm-3">
					<input type="button" id="submitContentBtn" class="btn btn-success btn-sm" value="确认发布"/>
				</div>
				<div class="col-sm-3">

				</div>
			</div>




		</form>
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