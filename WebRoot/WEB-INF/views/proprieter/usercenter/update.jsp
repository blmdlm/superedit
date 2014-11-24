<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <center>
   	<h1>修改个人资料</h1>
   	<h3><a href="proprieter/index">返回首页</a></h3>
   	<hr>
   	<br>
   	<sf:form method="post" modelAttribute="staff">
   	   	姓名:<sf:input path="name" value="${h_user.name}" /><br>
   	邮件:<sf:input path="email" value="${h_user.email}"/><br>
   	性别:<sf:input path="gender" value="${h_user.gender}"/><br>
   	手机:<sf:input path="phone" value="${h_user.phone}"/><br>
  
   	密码:<sf:input path="password" value="${h_user.password}"/><br>
   	<input type="submit" value="修改"/>
   	</sf:form>

   
   </center>
  </body>
</html>
