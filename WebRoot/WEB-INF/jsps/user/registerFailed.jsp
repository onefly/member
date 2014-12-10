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
oh shit。。注册失败了，即将跳转注册页面
<script>
function go(){
	 window.location.href="<%=rootPath %>/register/forward.htm";
};
	
setTimeout("go()",3000);  
</script>
</body>
</html>