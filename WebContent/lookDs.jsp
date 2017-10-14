<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>山东软件测试大赛-查看已提交数据</title>
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
						<li><a href="${pageContext.request.contextPath }/admin.jsp">操作设置</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath }/nextnotice.jsp">发布通知</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/lookQr">查看确认信息</a></li>
						<li><a href="${pageContext.request.contextPath }/lookSmh">查看说明会回执信息</a></li>
						<li class="active"><a>查看大赛回执信息</a></li>
						<li><a href="${pageContext.request.contextPath }/index.jsp" target="_blank">回到首页</a>
						</li>

					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<h2>已提交的大赛回执</h2>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>学校</th>
					<th>姓名</th>
					<th>职务</th>
					<th>电话</th>
					<th>地址</th>
					<th>住宿</th>
					<th>男士</th>
					<th>女士</th>
					<th>单间</th>
					<th>标间</th>
					<th>抵达时间</th>
					<th>离会时间</th>
					<th>抵达车次</th>
					<th>接站</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="t" varStatus="num">
					<tr>
						<td>${num.count }</td>
						<td>${t.schoolname }</td>
						<td>${t.name }</td>
						<td>${t.post }</td>
						<td>${t.tel }</td>
						<td>${t.addr }</td>
						<td>${t.stay==1?"是":"否" }</td>
						<td>${t.malenum }</td>
						<td>${t.femalenum }</td>
						<td>${t.stay==0?"不住宿":t.djnum }</td>
						<td>${t.stay==0?"不住宿":t.bjnum }</td>
						<td>${t.cometime }</td>
						<td>${t.gotime }</td>
						<td>${t.car }</td>
						<td>${t.meet==1?"是":"否" }</td>
						<td>${t.timp }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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