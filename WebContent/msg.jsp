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
<link rel="icon" href="img/icon.png" type="image/x-icon" />
<link rel="shortcut icon" href="img/icon.png" type="image/x-icon" />
<c:choose>
	<c:when test="${result == 1 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/login.jsp">
	</c:when>
	<c:when test="${result == 2 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/admin.jsp">
	</c:when>
	<c:when test="${result == 3 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/index.jsp">
	</c:when>
	<c:when test="${result == 4 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/webConfirm">
	</c:when>
	<c:when test="${result == 5 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/webSmh">
	</c:when>
	<c:when test="${result == 6 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/webDs">
	</c:when>
</c:choose>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
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
					id="bs-example-navbar-collapse-1"></div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h2>提示</h2>
			<p>${msg }</p>
			<h5>3秒后自动跳转, 请稍后……</h5>
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