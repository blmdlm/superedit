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
<title>用户中心->查看个人资料</title>

<script type="text/javascript" src="res/js/jquery.min.js"></script>

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
				<br> <label class="laber_from">姓名:</label>
				<DIV class="controls">
					<INPUT class="input_from" type=text value="${k_user.name}"
						readonly="readonly" />
					<P class=help-block></P>
				</DIV>
			</DIV>


			<c:choose>

				<c:when test="${k_user.gender==0}">
					<DIV class="control-group">
						<label class="laber_from">性别:</label>
						<DIV class="controls">
							<INPUT class="input_from" type=text value="男" readonly="readonly" />
							<P class=help-block></P>
						</DIV>
					</DIV>
				</c:when>

				<c:otherwise>
					<DIV class="control-group">
						<label class="laber_from">性别:</label>
						<DIV class="controls">
							<INPUT class="input_from" type=text value="女" readonly="readonly" />
							<P class=help-block></P>
						</DIV>
					</DIV>
				</c:otherwise>

			</c:choose>


			<DIV class="control-group">
				<LABEL class="laber_from">手机:</LABEL>
				<DIV class="controls">
					<INPUT class="input_from" type=text value="${k_user.phone}"
						readonly="readonly" />
					<P class=help-block></P>
				</DIV>
			</DIV>
			<DIV class="control-group">
				<LABEL class="laber_from">邮箱:</LABEL>
				<DIV class="controls">
					<INPUT class="input_from" type=text value="${k_user.email}"
						readonly="readonly" />
					<P class=help-block></P>
				</DIV>
			</DIV>
			<DIV class="control-group">
				<LABEL class="laber_from">出版社:</LABEL>
				<DIV class="controls">
					<INPUT class="input_from" type=text
						value="${k_user.publisher.name}" readonly="readonly" />
					<P class=help-block></P>
				</DIV>
			</DIV>
			<DIV class="control-group">
				<br> <LABEL class="laber_from"></LABEL>
				<DIV class="controls">
					<a href="editor/usercenter/update"><button type="button"
							class="btn btn-success" style="width:150px;">修改</button></a>
				</DIV>
			</DIV>

		</FORM>
	</div>
</body>
</html>