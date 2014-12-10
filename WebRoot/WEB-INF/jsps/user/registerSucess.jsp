<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
  String rootPath =  application.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
注册成功，5秒后跳转登录页面
<script>
function go(){
	 window.location.href="<%=rootPath %>/user/toLogin.htm";
};
	
setTimeout("go()",5000);  
</script>
</body>
</html>