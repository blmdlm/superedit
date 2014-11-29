<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户中心->查看账户</title>

<script type="text/javascript" src="res/js/jquery.min.js"></script>

<link rel="stylesheet" href="res/css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="res/utilLib/bootstrap.min.css" type="text/css" media="screen" />
<link rel="stylesheet" href="res/css/gejing/usermanagercheck.css" type="text/css" media="screen" />

</head>
<body>
<div class="div_from_aoto" style="width: 80%;">
    <!--基本布局开始-->
    <div class="container-fluid">
    <div class="row-fluid" id="a1">
       <p class="title">总编</p>
       <c:forEach items="${staffs01}" varStatus="i" var="staff">
       <div class="twobutton">
            <button type="button" class="btn  btn-primary" style="width:130px" disabled="disabled">${staff.name}</button>
          
        </div>
		</c:forEach>
    </div>
    
    <div class="row-fluid" id="a2">
        
        <p class="title">财务人员</p>
       <c:forEach items="${staffs02}" varStatus="i" var="staff">
       <div class="twobutton">
            <button type="button" class="btn  btn-primary" style="width:130px" disabled="disabled">${staff.name}</button>
   
        </div>
		</c:forEach>
    </div>

    <div class="row-fluid" id="a3">
        <p class="title">留言管理人员</p>
       <c:forEach items="${staffs03}" varStatus="i" var="staff">
       <div class="twobutton">
            <button type="button" class="btn  btn-primary" style="width:130px" disabled="disabled">${staff.name}</button>
    
        </div>
		</c:forEach>
    </div>
    </div>
    <!--基本布局结束-->
</div>
</body>
</html>