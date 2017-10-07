<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>山东软件测试大赛-后台</title>
<link rel="icon" href="images/logo.png" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="icon" href="img/icon.png" type="image/x-icon" />
<link rel="shortcut icon" href="img/icon.png" type="image/x-icon" />
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-default ">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand">后台设置</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a>操作设置</a></li>
						<li><a
							href="${pageContext.request.contextPath }/nextnotice.jsp">发布通知</a></li>
						<li><a href="${pageContext.request.contextPath }/lookQr">查看确认信息</a></li>
						<li><a href="${pageContext.request.contextPath }/lookSmh">查看说明会回执信息</a></li>
						<li><a href="${pageContext.request.contextPath }/lookDs">查看大赛回执信息</a></li>
						<li><a href="${pageContext.request.contextPath }/index.jsp">回到首页</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h2>开关设置</h2>
			<form role="form" method="post"
				action="${pageContext.request.contextPath }/webOpen">
				<div class="form-group">
					<label for="name">确认表开关</label> <select name="qrb"
						class="form-control">
						<option value="0">关</option>
						<option value="1">开</option>
					</select> <label for="name">说明会回执开关</label> <select name="smh"
						class="form-control">
						<option value="0">关</option>
						<option value="1">开</option>
					</select> <label for="name">大赛回执开关</label> <select name="ds"
						class="form-control">
						<option value="0">关</option>
						<option value="1">开</option>
					</select> <br />
					<button type="submit" class="btn btn-default">保存设置</button>
				</div>
			</form>
		</div>
	</div>

	<div id="footer" class="container" style="margin-top: 20px;">
		<nav class="navbar navbar-default">
			<div class="navbar-inner navbar-content-center"
				style="text-align: center">
				<h5 class="text-muted credit" style="padding: 5px;">易晨网站 | 软件测试
					| 山东劳动职业技术学院 | 技术支持</h5>
				<h5 class="text-muted credit" style="padding: 5px;">鲁ICP备17040550号-1</h5>
				<h5 class="text-muted credit" style="padding: 5px;">&copy;2016-2017</h5>
			</div>
		</nav>
	</div>
</body>

</html>