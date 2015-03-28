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

<link rel="stylesheet" href="res/css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="res/utilLib/bootstrap.min.css" type="text/css" media="screen" />

</head>
<body>
<div class="div_from_aoto" style="width: 500px;">
    <sf:form  method="post" modelAttribute="staff">
        <DIV class="control-group"><br><br><br><br><br><br>
            <label class="laber_from">邮箱:</label>
            <DIV  class="controls" ><sf:input class="input_from" path="email"  /><P class=help-block></P></DIV>
        </DIV>
        <DIV class="control-group">
            <label class="laber_from">职务:</label>
            <DIV  class="controls" >
          	<sf:select path="role" class="form-control" style="width:201px">
          		<sf:option value="10" selected="true">编辑</sf:option>
				<sf:option value="3">审核人员</sf:option>
				<sf:option value="5">校对人员</sf:option>          	
				<sf:option value="4">排版人员</sf:option>          	
          	</sf:select>
          	
        
            <P class=help-block></P>
            </DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from">密码:</LABEL>
            <DIV  class="controls" ><sf:input class="input_from" path="password" /><P class=help-block></P></DIV>
        </DIV>
        
        <DIV class="control-group" ><br>
            <LABEL class="laber_from" ></LABEL>
            <DIV class="controls" ><button type="submit" class="btn btn-warning" style="width:150px;" onclick="">创建</button></DIV>
        </DIV>
    </sf:form>
</div>
</body>
</html>