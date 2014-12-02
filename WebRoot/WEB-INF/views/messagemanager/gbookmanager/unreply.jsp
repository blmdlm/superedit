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

<title>留言管理->未回复留言</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="res/css/add.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="res/utilLib/bootstrap.min.css"
	type="text/css" media="screen" />

<script type="text/javascript" src="res/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="res/js/gejing/gbookmanagerunreply.js"></script>
</head>

<body>
	<div class="div_from_aoto" style="width: 80%;">
		<table class="table table-hover table-striped">

			<!-- On rows -->
			<tr>
				<td>时间</td>
				<td>作者</td>
				<td>内容</td>
				<td>操作</td>
			</tr>


			<!-- On cells (`td` or `th`) -->
			<c:forEach items="${results}" varStatus="i" var="result">
				<tr class="${styles[result[4]]}">
					<td>${result[1]}</td>
					<td>${result[2]}</td>
					<td>${result[3]}</td>
					<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" 
 onclick="change(${result[0]})" >回复</button></td>
				</tr>
			</c:forEach>

		</table>

	</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">请输入回复内容</h4>
				</div>
				<div class="modal-body">
				<textarea id="content" class="form-control" rows="3"></textarea>
				</div>
				<div class="modal-footer">
					<button id="confirm" type="button" class="btn btn-default" data-dismiss="modal" onclick="reply()" >确定</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	

</body>
</html>
