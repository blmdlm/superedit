<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript" src="res/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="res/js/editor/querymanager/authordetail.js"></script>
</head>

<body>
	<!-- 内容开始 -->
	<div class="div_from_aoto" style="width: 80%;">


		<div class="panel panel-info">
			<div class="panel-body ">
				<center>${result[1]}</center>
			</div>
			<table class="table table-hover">
				<tr>
					<td>性别</td>
					<td>${result[2]}</td>
				</tr>
				<tr>
					<td>手机</td>
					<td>${result[3]}</td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td>${result[4]}</td>
				</tr>
				<tr>
					<td>地址</td>
					<td>${result[5]}</td>
				</tr>
				<tr>
					<td>注册时间</td>
					<td>${result[6]}</td>
				</tr>
				<tr>
					<td>投递总数</td>
					<td>${result[7]}</td>
				</tr>
				<tr>
					<td>录用总数</td>
					<td>${result[8]}</td>
				</tr>
				<tr>
					<td>录用比</td>
					<td>${result[9]}</td>
				</tr>

				<!-- Button trigger modal -->

				<tr>
					<td>
						<center>
							<button type="button" class="btn btn-primary btn-sm "
								data-toggle="modal" data-target="#myModal01"
								onclick="check(${result[0]})">查看所有投递到本杂志的稿件</button>
						</center>

					</td>
					<td>
						<center>
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#mymodal02"
								onclick="change(${result[0]})">约稿</button>
						</center>

					</td>
				</tr>
			</table>
		</div>



	</div>



	<!-- 内容结束 -->


	<!-- 模态框01开始 -->



	<div class="modal fade" id="myModal01" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">所有投递到本杂志的稿件</h4>
				</div>
				<div class="modal-body">
					<br>
					<div id="result01"></div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>




	<!-- 模态框01结束 -->

	<!--模态框02开始-->

	<div class="modal fade" id="mymodal02" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">进行约稿</h4>
				</div>
				<div class="modal-body">

					<div id="record_title" class="row" align="center">最近的约稿记录</div>
					<div id="record" class="row">
						<table class="table table-hover table-striped">
							<tr class="success">
								<td>时间</td>
								<td>内容</td>
							</tr>
							<tr class="info">
								<td id="time">2014-12-12</td>
								<td id="content">打瞌睡打瞌睡打瞌打瞌睡打瞌睡打瞌睡打瞌睡</td>
							</tr>
						</table>
					</div>
					<div class="row" align="center">请输入约稿信息</div>
					<div class="row">
						<textarea id="message" class="form-control" rows="3"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button id="confirm" type="button" class="btn btn-default"
						data-dismiss="modal" onclick="set()">确认</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!--模态框02结束-->






</body>
</html>
