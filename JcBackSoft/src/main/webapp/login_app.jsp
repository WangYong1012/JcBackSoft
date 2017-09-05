<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>金融汇下载</title>
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var Terminal = {
			// 辨别移动终端类型
			platform : function() {
				var u = navigator.userAgent, app = navigator.appVersion;
				return {
					// ios终端
					ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
					// android终端或者uc浏览器
					android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1,
					// 是否为iPhone或者QQHD浏览器
					iPhone : u.indexOf('iPhone') > -1,
					// 是否iPad
					iPad : u.indexOf('iPad') > -1
				};
			}(),
			// 辨别移动终端的语言：zh-cn、en-us、ko-kr、ja-jp...
			language : (navigator.browserLanguage || navigator.language)
					.toLowerCase()
		}

		var theUrl = 'http://www.XXX.com';;

		// 根据不同的终端，跳转到不同的地址
		if (Terminal.platform.android) {
			$.post("${pageContext.request.contextPath}/get_version", {}, function(result) {
				var jsonStr = eval('(' + result + ')');
				window.location.href = jsonStr.url;
			})

			//theUrl = 'http://27.221.81.15/dd.myapp.com/16891/480CF92AA908D0E1FE5B7191BA01076C.apk?mkey=56f160de022961d2&f=b110&fsname=com.cn.piaoju_2.1.9_19.apk&p=.apk';
		} else if (Terminal.platform.iPhone) {
			theUrl = 'https://itunes.apple.com/cn/app/jin-chi-jin-rong-hui/id1029017710?mt=8';
			location.href = theUrl;
		}
	</script>
</head>
<body class="container" style="font-family: 微软雅黑;">

</body>
</html>
