<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>山东软件测试大赛-通知详细内容</title>
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
					<a class="navbar-brand" href="#">软件测试大赛</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">

					</ul>

				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h2>${notice.title }</h2>
			<p>${notice.content }</p>
			<br />
			<h5 class="pull-right">发布日期: ${notice.createtime }</h5>
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