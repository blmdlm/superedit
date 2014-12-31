<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
<title>用户中心->修改个人资料</title>

<script type="text/javascript" src="res/js/jquery.min.js"></script>

<link rel="stylesheet" href="res/css/add.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="res/utilLib/bootstrap.min.css"
	type="text/css" media="screen" />

</head>
<body>
	<div class="div_from_aoto" style="width: 500px;">
		<sf:form method="post" modelAttribute="staff">
			<DIV class="control-group">
				<br>
				<br>
				<br>
				<br>
				<br>
				<br> <label class="laber_from">姓名:</label>
				<DIV class="controls">
					<sf:input class="input_from" path="name" value="${i_user.name}" />
					<P class=help-block></P>
				</DIV>
			</DIV>

			<DIV class="control-group">
				<c:choose>
					<c:when test="${i_user.gender==0}">
						<DIV class="control-group">
							<LABEL class="laber_from">性别:</LABEL>
							<DIV class="controls">
								<sf:select class="form-control" style="width:41%" path="gender">
									<option value="0" >男</option> 
									<option  value="1" >女</option> 
								</sf:select>
							</DIV>
						</DIV>
					</c:when>

					<c:otherwise>
						<DIV class="control-group">
							<LABEL class="laber_from">性别:</LABEL>
							<DIV class="controls">
								<sf:select class="form-control" style="width:41%" path="gender">
									<option value="1" >女</option> 
									<option value="0" >男</option> 
								</sf:select>
							</DIV>
						</DIV>
					</c:otherwise>
				</c:choose>

			</DIV>






			<DIV class="control-group">
				<LABEL class="laber_from">手机:</LABEL>
				<DIV class="controls">
					<sf:input class="input_from" path="phone" value="${i_user.phone}" />
					<P class=help-block></P>
				</DIV>
			</DIV>
			<DIV class="control-group">
				<LABEL class="laber_from">邮箱:</LABEL>
				<DIV class="controls">
					<sf:input class="input_from" path="email" value="${i_user.email}" />
					<P class=help-block></P>
				</DIV>
			</DIV>
			<DIV class="control-group">
				<LABEL class="laber_from">出版社:</LABEL>
				<DIV class="controls">
					<sf:input class="input_from" path="publisher.name"
						value="${i_user.publisher.name}" />
					<P class=help-block></P>
				</DIV>
			</DIV>
			<DIV class="control-group">
				<br> <LABEL class="laber_from"></LABEL>
					<DIV class="controls">
						<button type="submit" class="btn btn-warning" style="width:150px;">保存</button>
					</DIV>
			</DIV>

		</sf:form>
	</div>
</body>
</html>