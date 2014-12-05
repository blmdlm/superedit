<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>super edit</title>
    
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
   <center> <h1>欢迎登陆超级采编系统</h1><br>
  
 		<p>社长请登陆</p>
    	<a href="login?id=h6"><input type="submit" value="登陆"></a>
    	<p>留言管理员请登陆</p>
    	<a href="login?id=i8"><input type="submit" value="登陆"></a>
    	 <p>财务人员请登陆</p>
    	<a href="login?id=j9"><input type="submit" value="登陆"></a>
    	 <p>编辑请登陆</p>
    	<a href="login?id=k10"><input type="submit" value="登陆"></a>
  </body>
</html>
