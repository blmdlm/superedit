<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户中心->修改密码</title>

<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/proprieter/usercenter/password.js"></script>
<link rel="stylesheet" href="res/css/add.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="res/utilLib/bootstrap.min.css"
	type="text/css" media="screen" />

</head>
<body>
	<div class="div_from_aoto" style="width: 500px;">
		<FORM>
			<DIV class="control-group">
				<br>
				<br>
				<br>
				<br>
				<br>
				<br> <label class="laber_from">原密码:</label>
				<DIV class="controls">
					<INPUT class="input_from" type=text id="oldpassword" name="oldpassword"/>
					<div style="display: inline" id="tip1"></div>
					<P class=help-block></P>
				</DIV>
			</DIV>


			


			<DIV class="control-group">
				<LABEL class="laber_from">新密码:</LABEL>
				<DIV class="controls">
					<INPUT class="input_from" type=text id="password1" name="password1"/>
					<div style="display: inline" id="tip2"></div>
					<P class=help-block></P>
				</DIV>
			</DIV>
			<DIV class="control-group">
				<LABEL class="laber_from">确认新密码:</LABEL>
				<DIV class="controls">
					<INPUT class="input_from" type=text id="password2" name="password2" />
					<div style="display: inline" id="tip3"></div>
					<P class=help-block></P>
				</DIV>
			</DIV>
			
			<DIV class="control-group">
				<br> <LABEL class="laber_from"></LABEL>
				<DIV class="controls">
				<button type="button" class="btn btn-success" id="btn" style="width:150px;">确认</button>
				 <div id="tip4"></div>
				</DIV>
				
               
                             
			</DIV>

		</FORM>
	</div>
</body>
</html>