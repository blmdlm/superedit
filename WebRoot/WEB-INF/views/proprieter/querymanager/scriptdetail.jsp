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

<title>My JSP 'set.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="res/css/add.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="res/utilLib/bootstrap.min.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="res/css/proprieter/querymanager/scriptdetail.css"
	type="text/css" media="screen" />
<script type="text/javascript" src="res/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="res/js/proprieter/querymanager/scriptdetail.js"></script>
</head>

<body>
	<!-- 内容开始 -->
	<div class="div_from_aoto" style="width: 80%;">
	
	
<div class="panel panel-info">
  <div class="panel-body ">
    <center>${result[1]}</center>
  </div >
    	<table class="table table-hover">
  	<tr>
  	<td>作者</td>
  	<td><a href="proprieter/querymanager/authordetail?id=${result[2]}">${result[3]}</a></td>	
  	</tr>
  	 <tr>
  	<td>摘要</td>
  	<td>${result[8]}</td>	
  	</tr>
  	 <tr>
  	<td>杂志</td>
  	<td>${result[5]}</td>	
  	</tr>
  	 <tr>
  	<td>投递时间</td>
  	<td>${result[6]}</td>	
  	</tr>
  	 <tr>
  	<td>稿费</td>
  	<td>${result[9]}</td>	
  	</tr>
  	<tr>
  	<td>处理状态</td>
  	<td>${result[7]}</td>	
  	</tr>
  	
  	<tr class="detail">  	
  	<td>稿费状态</td>
  	<td id="payment"></td>
  	</tr>
  	
   	<tr class="detail">  	
  	<td>审核状态</td>
  	<td id="audit"></td>
  	</tr>
  		
  	<tr class="detail">  
  	<td>校对状态</td>
  	<td id="proofread"></td>
  	</tr>
  		
  	<tr class="detail">    	  	
  	<td>排版状态</td>
  	<td id="compose"></td>	
  	</tr>   
  	 	

  	
  	  	
	</table>
  <div class="panel-footer">	
  <!-- Button trigger modal -->
  <center>
  
	<button type="button" class="btn btn-primary btn-sm "   onclick="check(${result[0]})">
  		查看详细状态
	</button>
  </center>
</div>
</div>
	
	

</div>
	
	

	<!-- 内容结束 -->










</body>
</html>
