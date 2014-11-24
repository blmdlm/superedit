<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'create.jsp' starting page</title>
    
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
  	<h1>创建账户</h1><br>
  	<h3><a href="proprieter/index">返回首页</a></h3>
  
  <hr>
  <form action="proprieter/usermanager/create" method="POST">

  	<p>邮箱: <input type="text" name="email" /></p>

  	<p>职务: <select name="role">
  <option value ="6" selected="true">总编</option>
  <option value ="9">财务人员</option>
  <option value="8">留言管理人员</option>
 
</select></p>
  	
  	<p>密码: <input type="text" name="password" /></p>

  	<input type="submit" value="创建" />

	</form>
  
  
  </center>
    
  </body>
</html>
