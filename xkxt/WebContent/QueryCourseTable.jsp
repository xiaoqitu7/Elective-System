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
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
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
            <li><a href="queryElective.action">已选课程查询</a></li>
            <li class="active"><a href="CourseTable.action">课表查询<span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
     	<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th></th>
								<th></th>
								<th>一</th>
								<th>二</th>
								<th>三</th>
								<th>四</th>
								<th>五</th>
							</tr>
						</thead>
						<tbody>
							<s:set value="#session.coursetable1" id="c1"/>
								<tr>
								    <td>1</td>
								    <td>8:00~8:45</td>
									<td class="col-md-2"><s:property value="#c1.km1" /></td>
									<td class="col-md-2"><s:property value="#c1.km2" /></td>
									<td class="col-md-2"><s:property value="#c1.km3" /></td>
									<td class="col-md-2"><s:property value="#c1.km4" /></td>
									<td class="col-md-2"><s:property value="#c1.km5" /></td>
								</tr>
							<s:set value="#session.coursetable2" id="c2"/>
								<tr>
								    <td>2</td>
								    <td>8:55~9:40</td>
									<td><s:property value="#c2.km1" /></td>
									<td><s:property value="#c2.km2" /></td>
									<td><s:property value="#c2.km3" /></td>
									<td><s:property value="#c2.km4" /></td>
									<td><s:property value="#c2.km5" /></td>
								</tr>
							<s:set value="#session.coursetable3" id="c3"/>
								<tr>
								    <td>3</td>
								    <td>10:00~10:45</td>
									<td><s:property value="#c3.km1" /></td>
									<td><s:property value="#c3.km2" /></td>
									<td><s:property value="#c3.km3" /></td>
									<td><s:property value="#c3.km4" /></td>
									<td><s:property value="#c3.km5" /></td>
								</tr>
							<s:set value="#session.coursetable4" id="c4"/>
								<tr>
								    <td>4</td>
								    <td>10:55~11:40</td>
									<td><s:property value="#c4.km1" /></td>
									<td><s:property value="#c4.km2" /></td>
									<td><s:property value="#c4.km3" /></td>
									<td><s:property value="#c4.km4" /></td>
									<td><s:property value="#c4.km5" /></td>
								</tr>
							<s:set value="#session.coursetable5" id="c5"/>
								<tr>
								    <td>5</td>
								    <td>12:10~12:55</td>
									<td><s:property value="#c5.km1" /></td>
									<td><s:property value="#c5.km2" /></td>
									<td><s:property value="#c5.km3" /></td>
									<td><s:property value="#c5.km4" /></td>
									<td><s:property value="#c5.km5" /></td>
								</tr>
							<s:set value="#session.coursetable6" id="c6"/>
								<tr>
								    <td>6</td>
								    <td>13:05~13:50</td>
									<td><s:property value="#c6.km1" /></td>
									<td><s:property value="#c6.km2" /></td>
									<td><s:property value="#c6.km3" /></td>
									<td><s:property value="#c6.km4" /></td>
									<td><s:property value="#c6.km5" /></td>
								</tr>
							<s:set value="#session.coursetable7" id="c7"/>
								<tr>
								    <td>7</td>
								    <td>14:10~14:55</td>
									<td><s:property value="#c7.km1" /></td>
									<td><s:property value="#c7.km2" /></td>
									<td><s:property value="#c7.km3" /></td>
									<td><s:property value="#c7.km4" /></td>
									<td><s:property value="#c7.km5" /></td>
								</tr>
								<s:set value="#session.coursetable8" id="c8"/>
								<tr>
								    <td>8</td>
								    <td>15:05~15:50</td>
									<td><s:property value="#c8.km1" /></td>
									<td><s:property value="#c8.km2" /></td>
									<td><s:property value="#c8.km3" /></td>
									<td><s:property value="#c8.km4" /></td>
									<td><s:property value="#c8.km5" /></td>
								</tr>
							<s:set value="#session.coursetable9" id="c9"/>
								<tr>
								    <td>9</td>
								    <td>16:00~16:45</td>
									<td><s:property value="#c9.km1" /></td>
									<td><s:property value="#c9.km2" /></td>
									<td><s:property value="#c9.km3" /></td>
									<td><s:property value="#c9.km4" /></td>
									<td><s:property value="#c9.km5" /></td>
								</tr>
							<s:set value="#session.coursetable10" id="c10"/>
								<tr>
								    <td>10</td>
								    <td>16:55~17:40</td>
									<td><s:property value="#c10.km1" /></td>
									<td><s:property value="#c10.km2" /></td>
									<td><s:property value="#c10.km3" /></td>
									<td><s:property value="#c10.km4" /></td>
									<td><s:property value="#c10.km5" /></td>
								</tr>
							<s:set value="#session.coursetable11" id="c11"/>
								<tr>
								    <td>11</td>
								    <td>18:00~18:45</td>
									<td><s:property value="#c11.km1" /></td>
									<td><s:property value="#c11.km2" /></td>
									<td><s:property value="#c11.km3" /></td>
									<td><s:property value="#c11.km4" /></td>
									<td><s:property value="#c11.km5" /></td>
								</tr>
							<s:set value="#session.coursetable12" id="c12"/>
								<tr>
								    <td>12</td>
								    <td>18:55~19:40</td>
									<td><s:property value="#c12.km1" /></td>
									<td><s:property value="#c12.km2" /></td>
									<td><s:property value="#c12.km3" /></td>
									<td><s:property value="#c12.km4" /></td>
									<td><s:property value="#c12.km5" /></td>
								</tr>
							<s:set value="#session.coursetable13" id="c13"/>
								<tr>
								    <td>13</td>
								    <td>19:50~20:35</td>
									<td><s:property value="#c13.km1" /></td>
									<td><s:property value="#c13.km2" /></td>
									<td><s:property value="#c13.km3" /></td>
									<td><s:property value="#c13.km4" /></td>
									<td><s:property value="#c13.km5" /></td>
								</tr>
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
    <script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>