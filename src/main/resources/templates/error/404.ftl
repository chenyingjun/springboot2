<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="后台业务系统-404">
<meta name="author" content="chenyingjun">
<title>后台业务管理系统-404</title>
<link rel="shortcut icon" href="${request.contextPath}/include/images/favicon.png"
	type="image/png">
<link href="${request.contextPath}/include/css/style.default.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body class="notfound">
	<section>
		<div class="notfoundpanel">
			<h1>404!</h1>
			<h3>您访问的页面不存在，请确认地址是否正确!</h3>
			<h4>如果您确认地址完全正确，请联系管理员！</h4>
			<a class="btn btn-success" href="javascript:history.go(-1)">原路返回？</a> <a
				class="btn btn-success"
				href="${request.contextPath}/main">返回主页重新操作？</a>
		</div>
		<!-- notfoundpanel -->
	</section>
</body>
</html>
