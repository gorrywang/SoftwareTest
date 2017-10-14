<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>山东软件测试大赛-通知</title>
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
						<li><a href="${pageContext.request.contextPath }/index.jsp">主页<span
								class="sr-only">(current)</span></a></li>
						<li class="active"><a href="">通知</a></li>
						<li><a href="${pageContext.request.contextPath }/webConfirm">信息确认</a></li>
						<li><a href="${pageContext.request.contextPath }/webSmh">说明会回执</a></li>
						<li><a href="${pageContext.request.contextPath }/webDs	">大赛回执</a></li>
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
		<div class="jumbotron">
			<h2>最新通知</h2>

			<ul class="list-group">
				<c:forEach items="${list }" var="t">
					<li class="list-group-item"><span class="badge">${t.createtime }</span>
						<a
						href="${pageContext.request.contextPath }/showNotice?id=${t.id}"
						target="_blank">${t.title }</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div id="footer" class="container" style="margin-top: 20px;">
		<nav class="navbar navbar-default">
			<div class="navbar-inner navbar-content-center"
				style="text-align: center">
				<h5 class="text-muted credit" style="padding: 5px;">易晨网站 | 软件测试
					| 山东劳动职业技术学院 | 技术支持</h5>
				<h5 class="text-muted credit" style="padding: 5px;">www.eachwang.com
					| 鲁ICP备17040550号-1</h5>
				<h5 class="text-muted credit" style="padding: 5px;">&copy;2016-2017</h5>
			</div>
		</nav>
	</div>
</body>

</html>
