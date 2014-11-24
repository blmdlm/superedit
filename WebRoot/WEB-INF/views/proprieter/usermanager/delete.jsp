<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

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
  	<h1>删除账户</h1><br>
  	<h3><a href="proprieter/index">返回首页</a></h3>
  
  <hr>
  <table border="1" width="200" cellpadding="0" cellspacing="0">
  	<tr>
  		<td>职务</td>
  		<td>名称</td>
  		<td>操作</td>
  	<tr>
  	<c:forEach items="${staffs}" varStatus="i" var="staff">
  	<tr>
  		<td>
  		<c:if test="${staff.role==6}">
  			总编
  		</c:if>
  	
  		<c:if test="${staff.role==9}">
  			财务人员
  		</c:if>
  		 <c:if test="${staff.role==8}">
  			留言管理人员
  		</c:if>
  		
  		
  		</td>
  		<td>${staff.email}</td>
  		<td><a href="proprieter/usermanager/delete/${staff.id}">删除</a></td>
  	</tr>
  	</c:forEach>
  	<tr>
  		<td></td>
  		<td></td>
  		<td></td>
  	<tr>
  	
  	
  
  </table>
  
  </center>
    
  </body>
</html>
