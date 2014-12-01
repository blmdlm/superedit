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
<link rel="stylesheet" href="res/css/gejing/gbookmanagercheck.css" type="text/css" media="screen" />

</head>
<body>
<!--主界面开始-->    
<div class="div_from_aoto" style="width: 80%;">
    <!--留言板开始-->
    <div class="messagebord">
    <!--留言板头部开始-->
    <div class="bord_up">

       <i class=""></i> 
    </div>    
    <!--留言板头部结束-->

    <!--问答部分开始-->
    <div class="bord_down">
        <!--列表开始-->
           <span>
              <!--头像部分开始-->  
               
              <img class="photo" src="res/img/girl03.jpg" >
               
              <!--头像部分结束-->
             
              <!--内容部分开始-->
              <div class="content">
                <div class="user-name">
                  小冰
                </div>
                <div class="message">
                       你曾经深爱过的某人，无非也就是芸芸众生中的一个，只是爱由心生，自以为他/她会是今生最爱，当你感觉你爱她，你用心去爱就觉的他/她最珍贵，当万物归原，生命仍然继续，他/她无非也就是你生命中的一个过客。                         
                </div> 
                <div class="time">
                  今天 3:53pm
                </div>    
              </div>
              <!--内容部分结束-->


           </span>   
           
           
           <span class="message-right">
              <!--头像部分开始-->  
         
                <img class="photo" src="res/img/girl03.jpg">
           
              <!--头像部分结束-->
             
              <!--内容部分开始-->
              <div class="content">
                <div class="user-name">
                  小火
                </div>
                <div class="message">
                  我们根本无法确定哪一个才是今生最爱，如果不懂得去珍惜，你身边这个爱你的/你爱的人，在某一天，也会成为你身边的过客。                                              
                </div> 
                <div class="time">
                  今天 3:53pm
                </div>    
              </div>
              <!--内容部分结束-->


           </span>      
         
        <!--列表结束-->
    </div>
    <!--问答部分结束-->
    </div>        
    <!--留言板结束-->
</div>
<!--主界面结束-->
</body>
</html>