<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>欢迎使用后台</title>
<!-- <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script> -->
<!-- <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css" /> -->
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="container" style="font-family: 微软雅黑;">
	<div style="height: 50px;">

	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			山东左邻右舍信息咨询有限公司 - 后台
		</div>
		<div class="panel-body">
			<div class="col-xs-12 col-sm-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						公司简介
					</div>
					<div class="panel-body">
						山东左邻右舍信息咨询有限公司成立于2011年，长期致力于软件开发、网站建设运营、金融信息服务等领域。
						作为济南高新区重合同、守信誉企业，在风云变化的互联网行业，山东左邻右舍始终走在思维前沿、技术前沿、
						创新前沿，为客户提供最优质的服务，为员工搭建施展才能的舞台。公司已于2015年4月3日在上海股权托管交
						易中心挂牌，股权代码：204829。
					</div>
					<dl class="dl-horizontal">
						<dt>联系人</dt>
						<dd>徐经理</dd>
						<dt>电&nbsp;话</dt>
						<dd>0531-88810902</dd>
						<dt>手&nbsp;机</dt>
						<dd>15588892250</dd>
					</dl>
				</div>
			</div>
			<div class="col-xm-12 col-sm-6">
				<div class="panel panel-success">
					<div class="panel-heading">
						用户登录
					</div>
					<div class="panel-body">
						<br/>
						<form method="post" class="form-signin" action="j_spring_security_check" novalidate="novalidate">
							<div class="input-group">
								<label class="input-group-addon" for="j_username">账号（UserName）</label>
								<input type="text" id="j_username" name="j_username" value="" class="form-control" style="width: 70%;"
									   placeholder="请输入您的账户" required/>
							</div>
							<br/>
							<div class="input-group">
								<label class="input-group-addon" for="j_password">密码（PassWord）</label>
								<input type="password" id="j_password" name="j_password" value="" class="form-control" style="width: 70%;"
									   placeholder="* * * * * * * * *" required/>
							</div>
							<br/><br/>
							<div class="row">
								<div class="col-sm-2 col-xs-12">
								</div>
								<div class="col-sm-4 col-xs-12">
									<input type="reset" class="btn btn-default btn-md" value="取消（Reset）"/>
								</div>
								<div class="col-sm-4 col-xs-12">
									<input type="submit" class="btn btn-success btn-md" value="提交（Submit）"/>
								</div>
								<div class="col-sm-2 col-xs-12">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<marquee onmouseover=this.stop() onmouseout=this.start()>
				金池金融汇 - 新版APP已经上线  下载地址<a class="" href="http://www.shandongjinchi.com" target="_blank">点击这里</a>
			</marquee>
		</div>
	</div>
</body>
</html>
