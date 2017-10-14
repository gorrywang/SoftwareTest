<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>山东软件测试大赛-说明会回执</title>
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
						<li><a href="${pageContext.request.contextPath }/webNotice">通知</a></li>
						<li><a href="${pageContext.request.contextPath }/webConfirm">信息确认</a></li>
						<li class="active"><a>说明会回执</a></li>
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
		<div class="jumbotron">
			<h2>说明会回执</h2>
			<br />
			<form method="post"
				action="${pageContext.request.contextPath }/postSmh">
				<div class="form-group">
					<label for="exampleInputName1">学校名称</label> <input
						name="schoolname" type="text" class="form-control"
						placeholder="请输入学校名称">
				</div>
				<div class="form-group">
					<label for="exampleInputName1">联系老师</label> <input name="lead"
						type="text" class="form-control" placeholder="请输入联系老师姓名">
				</div>
				<div class="form-group">
					<label for="exampleInputName1">联系电话</label> <input name="tea1"
						type="text" class="form-control" placeholder="请输入联系方式">
				</div>
				<div class="form-group">
					<label for="name">是否住宿</label> <select class="form-control"
						name="stay" onchange="show(this.value)">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</div>
				<div class="form-group">
					<label for="name">男士人数</label> <select class="form-control"
						name="mannum">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
					</select>
				</div>
				<div class="form-group">
					<label for="name">女士人数</label> <select class="form-control"
						name="woman">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
					</select>
				</div>
				<div class="form-group">
					<label for="name">需要单间数量</label> <select class="form-control"
						id="ss" name="djnum">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>
				<div class="form-group">
					<label for="name">需要标间数量</label> <select class="form-control"
						id="s" name="bjnum">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>

				<div class="form-group">
					<label for="name">抵达时间</label> <input name="cometime" type="date"
						class="form-control">
				</div>

				<div class="form-group">
					<label for="name">离会时间</label> <input name="gotime" type="date"
						class="form-control">
				</div>

				<div class="form-group">
					<label for="name">备注</label>
					<textarea class="form-control" rows="3" name="bz"></textarea>
				</div>

				<button type="submit" class="btn btn-default">信息无误 确认提交</button>

				<h6>
					<font color="#ff0000">*信息只可以提交一次, 请谨慎提交</font>
				</h6>
			</form>
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

<script>
	function show(v) {
		if (v == 0) {
			document.getElementById("ss").disabled = "false";
			document.getElementById("s").disabled = "false";
		} else if (v == 1) {
			document.getElementById("ss").disabled = "";
			document.getElementById("s").disabled = "";
		}
	};
</script>

</html>