<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<h1 align='center'>密码错误，请重新输入！</h1>
<table align="center">
	<form action="login" method ="post">
		<tr>
			<td>账号：<input type="text" name="name" /></td>
			<td>密码：<input type="password" name="password" /></td>	
		</tr>
		<tr>
			<td align='right'><input type="submit" value="登录" /></td>
		</tr>
	</form>
</table>
</body>
</html>