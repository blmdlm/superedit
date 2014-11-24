<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
   	<h1>个人资料</h1>
   	<h3><a href="proprieter/index">返回首页</a></h3>
   	<hr>
   	<br>
   	姓名:${h_user.name}<br>
   	邮件:${h_user.email}<br>
   	性别:${h_user.gender}<br>
   	手机:${h_user.phonenum}<br>
   	出版社:${h_user.address}<br>
   	密码:${h_user.password}<br>
	<a href="proprieter/usercenter/update">修改资料</a>   
   </center>
  </body>
</html>
