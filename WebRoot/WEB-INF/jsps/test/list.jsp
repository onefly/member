<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    
 
  </body>
  <hr>
  <table>
  <tr>
  	<td>id</td>
  	<td>用户id</td>
  	<td>积分</td>
  	<td>体验值</td>
  	<td>体验包</td>
  	<td>大牌胸章</td>
  	<td>时间</td>
  </tr>
   <c:forEach items="${list}" var="p">
   <tr>
  		<td>${p.id}</td>
  		<td>${p.userId}</td>
  		<td>${p.score}</td>
  		<td>${p.experienceValue}</td>
  		<td>${p.ingot}</td>
  		<td>${p.medal}</td>
  		<td><fmt:formatDate  type="both" value="${p.recordTime}"/></td>
  		</tr>
  </c:forEach>

  </table>
  		 有${fn:length(list)}个元素<br>
  	当前${currentPages}页 总共${totalPages}页
  	<a href="/member/accountRecord/getRecord.htm?userId=110&page=${currentPages-1}&pageSize=10">上一页</a>
  	<a href="/member/accountRecord/getRecord.htm?userId=110&page=${currentPages+1}&pageSize=10">下一页</a>
  	
 
</html>
