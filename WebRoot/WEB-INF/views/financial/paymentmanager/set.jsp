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
	<link rel="stylesheet" href="res/css/add.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="res/utilLib/bootstrap.min.css" type="text/css" media="screen" />
	<script type="text/javascript" src="res/js/jquery-1.11.1.min.js"></script>
  	<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="res/js/financial/paymentmanager/set.js"></script>
  </head>
  
  <body>
    <div class="div_from_aoto" style="width: 80%;">
    <table class="table table-hover table-striped">
    

			<tr>
				<td>录用杂志</td>
				<td>稿件标题</td>
				<td>作者</td>
				<td>时间</td>
				<td>操作</td>

			</tr>

			<c:forEach items="${results}" varStatus="i" var="result">
				<tr class="${styles[result[5]]}">
					<td>${result[1]}</td>
					<td>${result[2]}</td>
					<td>${result[3]}</td>
					<td>${result[4]}</td>
					<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#mymodal" 
 onclick="change(${result[6]})" >设置稿费</button></td>
				</tr>
			</c:forEach>

            
		</table>

       </div>
       
       
       <!--模态框开始-->

<div class="modal fade" id="mymodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">请输入稿费</h4>
      </div>
      <div class="modal-body">
       	<div class="input-group">
  			<span class="input-group-addon">RMB</span>
  			<input id="content" type="text" class="form-control">
  			<span class="input-group-addon">.00</span>
		</div>
      </div>
      <div class="modal-footer">
        <button id="confirm" type="button" class="btn btn-default" data-dismiss="modal" onclick="set()">确认</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>
       
       <!--模态框结束-->
       
       
       
       
       
       
       
       
       
       
       
       
       
  </body>
</html>
