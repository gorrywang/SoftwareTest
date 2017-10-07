<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>山东软件测试大赛</title>
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
					<a class="navbar-brand">软件测试大赛</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a>主页<span class="sr-only">(current)</span></a>
						</li>
						<li><a href="${pageContext.request.contextPath }/webNotice">通知</a></li>
						<li><a href="${pageContext.request.contextPath }/webConfirm">信息确认</a></li>
						<li><a href="${pageContext.request.contextPath }/webSmh">说明会回执</a></li>
						<li><a href="${pageContext.request.contextPath }/webDs">大赛回执</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">

						<c:if test="${cookie.username == null}">
							<li><a href="${pageContext.request.contextPath }/login.jsp"><span
									class="glyphicon glyphicon-log-in"></span> 登录</a></li>
						</c:if>
						<c:if test="${cookie.username != null}">
							<li><a> 登录成功</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="img/b1.jpg" alt="First slide" width="100%">
				</div>
				<div class="item">
					<img src="img/b2.jpg" alt="Second slide" width="100%">
				</div>
				<div class="item">
					<img src="img/b3.jpg" alt="Third slide" width="100%">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;
			</a> <a class="carousel-control right" href="#myCarousel"
				data-slide="next">&rsaquo; </a>
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