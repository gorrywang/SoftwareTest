<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>山东软件测试大赛-确认信息</title>
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
						<li class="active"><a>信息确认</a></li>
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
		<div class="jumbotron">
			<h2>信息确认</h2>
			<br />

			<c:choose>
				<c:when test="${data.ok == 1}">
					<form>
						<div class="form-group">
							<label for="exampleInputName1">学校名称</label> <input
								disabled="disabled" value="${data.schoolname }"
								name="schoolname" type="text" class="form-control"
								placeholder="请输入学校名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">领队</label> <input
								disabled="disabled" value="${data.lead }" name="lead"
								type="text" class="form-control" placeholder="请输入领队名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">指导老师一</label> <input
								disabled="disabled" value="${data.teacher1 }" name="tea1"
								type="text" class="form-control" placeholder="请输入指导老师一名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">指导老师一联系方式</label> <input
								disabled="disabled" value="${data.tel1 }" name="tel1"
								type="text" class="form-control" placeholder="请输入指导老师一联系方式">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">指导老师二</label> <input
								disabled="disabled" value="${data.teacher2 }" name="tea2"
								type="text" class="form-control" placeholder="请输入指导老师二名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">指导老师二联系方式</label> <input
								disabled="disabled" value="${data.tel2 }" name="tel2"
								type="text" class="form-control" placeholder="请输入指导老师二联系方式">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">学生一</label> <input
								disabled="disabled" value="${data.stu1 }" name="stu1"
								type="text" class="form-control" placeholder="请输入学生一名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">学生二</label> <input
								disabled="disabled" value="${data.stu2 }" name="stu2"
								type="text" class="form-control" placeholder="请输入学生二名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">学生三</label> <input
								disabled="disabled" value="${data.stu3 }" name="stu3"
								type="text" class="form-control" placeholder="请输入学生三名称">
						</div>

						<h6>
							<font color="#ff0000">*信息已无法修改</font>
						</h6>
					</form>
				</c:when>
				<c:otherwise>
					<form method="post"
						action="${ pageContext.request.contextPath}/postConfirm">
						<div class="form-group">
							<label for="exampleInputName1">学校名称</label> <input
								value="${data.schoolname }" name="schoolname" type="text"
								class="form-control" placeholder="请输入学校名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">领队</label> <input
								value="${data.lead }" name="lead" type="text"
								class="form-control" placeholder="请输入领队名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">指导老师一</label> <input
								value="${data.teacher1 }" name="tea1" type="text"
								class="form-control" placeholder="请输入指导老师一名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">指导老师一联系方式</label> <input
								value="${data.tel1 }" name="tel1" type="text"
								class="form-control" placeholder="请输入指导老师一联系方式">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">指导老师二</label> <input
								value="${data.teacher2 }" name="tea2" type="text"
								class="form-control" placeholder="请输入指导老师二名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">指导老师二联系方式</label> <input
								value="${data.tel2 }" name="tel2" type="text"
								class="form-control" placeholder="请输入指导老师二联系方式">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">学生一</label> <input
								value="${data.stu1 }" name="stu1" type="text"
								class="form-control" placeholder="请输入学生一名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">学生二</label> <input
								value="${data.stu2 }" name="stu2" type="text"
								class="form-control" placeholder="请输入学生二名称">
						</div>
						<div class="form-group">
							<label for="exampleInputName1">学生三</label> <input
								value="${data.stu3 }" name="stu3" type="text"
								class="form-control" placeholder="请输入学生三名称">
						</div>
						<button type="submit" class="btn btn-default">信息无误 确认提交</button>
						<h6>
							<font color="#ff0000">*信息只可以修改一次, 请谨慎修改</font>
						</h6>
					</form>
				</c:otherwise>
			</c:choose>

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