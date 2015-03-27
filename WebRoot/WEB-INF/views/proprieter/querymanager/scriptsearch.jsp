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
<link rel="stylesheet" href="res/css/proprieter/querymanager/scriptsearch.css"
	type="text/css" media="screen" />
<script type="text/javascript" src="res/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="res/js/proprieter/querymanager/scriptsearch.js"></script>

</head>

<body>
	<div class="div_from_aoto" style="width: 80%;">

		<!-- 搜索框开始 -->

		<div class="row">
			<div class="col-lg-6 searchbox">
				<div class="input-group">
					<input type="text" id="input" class="form-control"
						placeholder="搜索稿件"> <span class="input-group-btn">
						<button class="btn btn-default" type="button"
							onclick="showResult()">Search</button>
					</span>
				</div>
			</div>
		</div>


		<!-- 搜索框结束 -->
		<div class="row">
			<br>
		</div>
		<!-- 结果集开始 -->
		<div class="row">
			<div id="result">



			
			
			
			
			
			
			
			</div>
		</div>
		<!-- 结果集结束 -->
	</div>




</body>
</html>
