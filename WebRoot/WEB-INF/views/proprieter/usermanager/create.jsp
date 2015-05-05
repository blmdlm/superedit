<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户中心->修改个人资料</title>

<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="res/js/proprieter/usermanager/create.js"></script>

<link rel="stylesheet" href="res/css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="res/utilLib/bootstrap.min.css" type="text/css" media="screen" />

</head>
<body>
<div class="div_from_aoto" style="width: 500px;">
    
        <DIV class="control-group"><br><br><br><br><br><br>
            <label class="laber_from">邮箱:</label>
            <DIV  class="controls" ><input  type="text" class="input_from" id="email"/><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <label class="laber_from">职务:</label>
            <DIV  class="controls" >
          	<select id="role"  class="form-control" style="width:201px">
          		<option value="6" >总编</option>
				<option value="9" selected="true">财务人员</option>
				<option value="8">留言管理</option>          	
          	</select>
          	
     
            <P class=help-block></P>
            </DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from">密码:</LABEL>
            <DIV  class="controls" ><input type="text" class="input_from" id="password" /><P class=help-block></P></DIV>
        </DIV>
        
   			
        
        
        <DIV class="control-group" ><br>
            <LABEL class="laber_from" ></LABEL>
            <DIV class="controls" ><button type="button" class="btn btn-warning" style="width:150px;" onclick="create()">创建</button></DIV>
        </DIV>
  		
  	

  <div style="display:none">
  <button  id="modalbtn" type="button"    data-toggle="modal" data-target="#myModal" onclick="query()"/>
  </div>				
  		
</div>



	<!-- 模态框开始-->
<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
		<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">请为总编选择负责的一个杂志</h4>
      </div>
      <div class="modal-body">
      	
        <div id="result">
        
        </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
	
	
	
	
	<!-- 模态框结束 -->








</body>
</html>