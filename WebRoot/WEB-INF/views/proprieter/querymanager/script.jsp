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
<link rel="stylesheet" href="res/css/proprieter/querymanager/script.css"
	type="text/css" media="screen" />
<script type="text/javascript" src="res/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="res/js/proprieter/querymanager/script.js"></script>

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
			<div id="result"></div>
		</div>
		<!-- 结果集结束 -->
	</div>


	<!--模态框开始-->
	<div class="modal fade" id="mymodal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<!-- 模态框body开始 -->
				<div class="modal-body">
					<table class="table table-hover">
						<tr>
							<td class="active">作者</td>
							<td id="author" class="info"></td>
						</tr>
						<tr>
							<td class="active">摘要</td>
							<td id="summary" class="info"></td>
						</tr>
						<tr>
							<td class="active">审核流程</td>
							<td id="audit" class="info"></td>
						</tr>
						<tr>
							<td class="active">校对流程</td>
							<td id="proofread" class="info"></td>
						</tr>
						<tr>
							<td class="active">排版流程</td>
							<td id="compose" class="info"></td>
						</tr>
						<tr>
							<td class="active">稿费状态</td>
							<td id="payment" class="info"></td>
						</tr>
				
					</table>

				</div>
				<!-- 模态框body结束 -->
<!-- 				<div class="modal-footer"> -->
<!-- 					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button> -->
<!-- 				</div> -->
			</div>
		</div>
	</div>

	<!--模态框结束-->













</body>
</html>
