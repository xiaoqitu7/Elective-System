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
					<li class="active"><a href="queryCourse.action">课程查询<span
							class="sr-only">(current)</span></a></li>
					<li><a href="queryElective.action">已选课程查询</a></li>
					<li><a href="CourseTable.action">课表查询</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<s:form action="searchCourse" method="post" theme="simple"
					cssClass="form-inline">
					<div class="form-group">
						<s:textfield name="kh" cssClass="form-control" placeholder="课号" />
					</div>
					<div class="form-group">
						<s:textfield name="km" cssClass="form-control" placeholder="课程名" />
					</div>
					<div class="form-group">
						<s:textfield name="xf" cssClass="form-control" placeholder="学分" />
					</div>
					<div class="form-group">
						<s:textfield name="xm" cssClass="form-control" placeholder="教师名" />
					</div>
					<div class="checkbox">
						<label> <s:checkbox name="rswm" /> 选课人数未满
						</label>
					</div>
					<div class="pull-right">
						<s:submit value="搜索" cssClass="btn btn-default" />
					</div>
				</s:form>
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
								<th>可选人数</th>
								<th>已选人数</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.querycourses" id="course">
								<tr>
									<td><s:property value="#course.kh" /></td>
									<td><s:property value="#course.km" /></td>
									<td><s:property value="#course.xf" /></td>
									<td><s:property value="#course.xm" /></td>
									<td><s:property value="#course.sksj" /></td>
									<td><s:property value="#course.rs" /></td>
									<td><s:property value="#course.dqrs" /></td>
									<td><a
										href="addElective.action?course.kh=<s:property value="#course.kh"/>&course.gh=<s:property value="#course.gh"/>&course.sksj=<s:property value="#course.sksj"/>"
										OnClick="if(!confirm('确定选择这门课程吗?'))return false;else return true;">
											<button class="btn btn-sm">
												<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
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
	<script type="text/javascript">
		var msg = "${request.tipMessage}";
		if (msg != "") {
			alert(msg);
		}
	</script>
</body>
</html>