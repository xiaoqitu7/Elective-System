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

<!--  <link href="css/bootstrap-editable.css" rel="stylesheet" />

<link href="css/bootstrap-table.min.css" rel="stylesheet" />

-->
</head>

<body>
	<%
		if (session.getAttribute("teacher") == null)
			response.sendRedirect("login.jsp");
	%>
	<div class="modal fade" id="grade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:400px">
			<div class="modal-content">
				<div class="modal-header" role="document">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改/提交成绩</h4>
				</div>
				<s:form action="editGrade" method="post" theme="simple"
					cssClass="form-inline">
					<div class="modal-body">

						<div class="form-group">
							<s:textfield name="pscj" cssClass="form-control" placeholder="平时成绩" />
						</div>
						<div class="form-group">
							<s:textfield name="kscj" cssClass="form-control" placeholder="考试成绩" />
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
					<li><a href="mainTeacher.jsp">公告</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="queryOpen.action">当前课程查询<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						调整分数占比<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="computezpcj.action?bili=2">2：8</a></li>
						<li><a href="computezpcj.action?bili=3">3：7</a></li>
						<li><a href="computezpcj.action?bili=4">4：6</a></li>
						<li><a href="computezpcj.action?bili=5">5：5</a></li>
					</ul>
				</div>
				<div class="clearfix" style="margin-bottom: 20px;"></div>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>平时成绩</th>
								<th>考试成绩</th>
								<th>总评成绩</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.querystudent" id="student">
								<tr>
									<td><s:property value="#student.xh" /></td>
									<td><s:property value="#student.xm" /></td>
									<td><s:property value="#student.pscj" /></td>
									<td><s:property value="#student.kscj" /></td>
									<td><s:property value="#student.zpcj" /></td>
									<td><a 
									href="modal.action?xh=<s:property value="#student.xh" />" 
											><button class="btn btn-sm">
												<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
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
		if (modal != "") {
			$('#grade').modal('show')
		}
	</script>
</body>
</html>