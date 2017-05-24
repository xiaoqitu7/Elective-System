<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>上海大学选课系统</title>
 <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="http://v3.bootcss.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

</head>
<body>
<%
		if (session.getAttribute("student") != null&&session.getAttribute("teacher") != null)
			response.sendRedirect("main.jsp");
	%>
<div class="container">
<s:form action="login" method="post" theme="simple" cssClass="form-signin">

    <h2 class="form-signin-heading">请登陆</h2>
    <s:textfield name="username" cssClass="form-control" placeholder="账号"/>
    <s:password name="password" cssClass="form-control" placeholder="密码"/>
       <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住账号
          </label>
        </div>
    <s:submit value="登陆" cssClass="btn btn-lg btn-primary btn-block"/> 
</s:form>
</div>
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