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
    
    <title>留言管理->审核留言</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="res/css/add.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="res/utilLib/bootstrap.min.css" type="text/css" media="screen" />
  <link rel="stylesheet" href="res/css/gejing/gbookmanagerpostaduit.css" type="text/css" media="screen" />
  <script type="text/javascript" src="res/js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <div class="div_from_aoto" style="width: 80%;">
 		   <div class="heading"></div>
       <div class="list ">
			<c:forEach items="${messes}" varStatus="i" var="mess">	
            <div class="row bg-success">
              <div class="time col-md-1">${mess.sendTime}</div> 
              <div class="message col-md-9">${mess.content}</div>
              <div class="buttons col-md-1">
                <button type="button" class="btns  btn btn-primary" data-toggle="modal" data-target="#myModal01">通过</button>
              </div>
              <div class="buttons col-md-1">
                <button type="button" class="btns  btn btn-primary" data-toggle="modal" data-target="#myModal02">不通过</button>
              </div>
            </div>    
			</c:forEach>

            


       </div>
    </div>


<!--模态框开始-->

<div class="modal fade" id="myModal01" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">注意</h4>
      </div>
      <div class="modal-body">
        确认通过该条留言吗？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="myModal02" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">注意</h4>
      </div>
      <div class="modal-body">
        确认不通过该条留言吗？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>
    <!--模态框结束-->

















  </body>
</html>
