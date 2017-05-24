<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

<title>上海大学选课系统</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/dashboard.css" rel="stylesheet">

</head>

<body>
	<%
		if (session.getAttribute("student") == null)
			response.sendRedirect("login.jsp");
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">上海大学选课系统</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="cancle.jsp">注销</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="main.jsp">公告</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="queryCourse.action">课程查询</a></li>
					<li class="active"><a href="queryElective.action">已选课程查询<span
							class="sr-only">(current)</span></a></li>
					<li><a href="CourseTable.action">课表查询</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="table-responsive">
					<table class="table table-bordered">
						<s:set value="#session.student" id="student" />
						<s:set value="#session.department" id="department" />
						<tr>
							<th>个人信息</th>
							<th>学号：        <s:property value="#student.xh" /></th>
							<th>姓名：        <s:property value="#student.xm" /></th>
							<th>院系：        <s:property value="#department.mc" /></th>
							<th>已选学分：        <s:property value="#session.xuefen" /></th>
						</tr>

					</table>
				</div>
				<div class="clearfix" style="margin-bottom: 20px;"></div>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>课程号</th>
								<th>课名</th>
								<th>学分</th>
								<th>教师名</th>
								<th>上课时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.queryelective" id="elective">
								<tr>
									<td><s:property value="#elective.kh" /></td>
									<td><s:property value="#elective.km" /></td>
									<td><s:property value="#elective.xf" /></td>
									<td><s:property value="#elective.xm" /></td>
									<td><s:property value="#elective.sksj" /></td>
									<td><a
										href="delElective.action?elective.kh=<s:property value="#elective.kh"/>&elective.gh=<s:property value="#elective.gh"/>"
										OnClick="if(!confirm('确定删除这门课程吗?'))return false;else return true;">
											<button class="btn btn-sm">
												<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
											</button>
									</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document.write('<script src="js/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>