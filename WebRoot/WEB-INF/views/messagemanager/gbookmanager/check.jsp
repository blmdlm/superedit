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
<title>留言管理->查看留言</title>

<script type="text/javascript" src="res/js/jquery.min.js"></script>

<link rel="stylesheet" href="res/css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="res/utilLib/bootstrap.min.css" type="text/css" media="screen" />
<link rel="stylesheet" href="res/css/messagemanager/gbookmanager/check.css" type="text/css" media="screen" />

</head>
<body>
<!--主界面开始-->    
<div class="div_from_aoto" style="width: 80%;">
    <!--留言板开始-->
    <div class="messagebord">
    <!--留言板头部开始-->
    <div class="bord_up">

       
    </div>    
    <!--留言板头部结束-->

    <!--问答部分开始-->
    <div class="bord_down">
        <!--列表开始-->
        <c:forEach items="${results}" varStatus="i" var="result">
           <span>
              <!--头像部分开始-->  
              <img class="photo" src="res/img/girl03.jpg" > 
              <!--头像部分结束-->
              <!--内容部分开始-->
              <div class="content">
                <div class="user-name">
                 	${result[0]}
                </div>
                <div class="message">
                 	${result[2]}
                       
                </div> 
                <div class="time">
                 	${result[1]}
                  
                </div>    
              </div>
              <!--内容部分结束-->


           </span>   
           <c:if test="${result[3]==1}">

           
           <span class="message-right">
              <!--头像部分开始-->  
         
                <img class="photo" src="res/img/girl03.jpg">
           
              <!--头像部分结束-->
             
              <!--内容部分开始-->
              <div class="content">
                <div class="user-name">
                  ${replys[result[4]][0]}
                </div>
                <div class="message">
                 ${replys[result[4]][2]}                                              
                </div> 
                <div class="time">
                  ${replys[result[4]][1]}
                </div>    
              </div>
              <!--内容部分结束-->


           </span> 
           </c:if>     
         </c:forEach>
        <!--列表结束-->
    </div>
    <!--问答部分结束-->
    </div>        
    <!--留言板结束-->
</div>
<!--主界面结束-->
</body>
</html>