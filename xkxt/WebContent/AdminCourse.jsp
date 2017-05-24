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
		if (session.getAttribute("admin") == null)
			response.sendRedirect("login.jsp");
	%>
	<div class="modal fade" id="course" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 400px">
			<div class="modal-content">
				<div class="modal-header" role="document">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改课程信息</h4>
				</div>
				<s:form action="editOpen" method="post" theme="simple"
					cssClass="form-inline">
					<div class="modal-body">

						<div class="form-group">
							<s:textfield name="sksj" cssClass="form-control"
								placeholder="上课时间" />
						</div>
						<div class="form-group">
							<s:textfield name="rs" cssClass="form-control" placeholder="可选人数" />
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<s:submit value="提交更改" cssClass="btn btn-primary" />
					</div>
				</s:form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<div class="modal fade" id="addcourse" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 740px">
			<div class="modal-content">
				<div class="modal-header" role="document">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加课程信息</h4>
				</div>
				<s:form action="addOpen" method="post" theme="simple"
					cssClass="form-inline">
					<div class="modal-body">
						<div class="form-group">
							<s:textfield name="open.kh" cssClass="form-control"
								placeholder="课程号" />
						</div>
						<div class="form-group">
							<s:textfield name="open.gh" cssClass="form-control"
								placeholder="教师号" />
						</div>
						<div class="form-group">
							<s:textfield name="open.sksj" cssClass="form-control"
								placeholder="上课时间" />
						</div>
						<div class="form-group">
							<s:textfield name="open.rs" cssClass="form-control"
								placeholder="可选人数" />
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<s:submit value="添加课程" cssClass="btn btn-primary" />
					</div>
				</s:form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
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
					<li class="active"><a href="queryCourse.action">开课情况查询<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#addcourse">添加课程</button>
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
										href="admin.action?kh=<s:property value="#course.kh" />&gh=<s:property value="#course.gh" />"><button
												class="btn btn-sm">
												<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											</button> </a></td>
									<td><a
										href="delOpen.action?course.kh=<s:property value="#course.kh"/>&course.gh=<s:property value="#course.gh"/>"
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
	<script type="text/javascript">
		var modal = "${request.modal}";
		if (modal == "1") {
			$('#course').modal('show')
		}
	</script>
</body>
</html>