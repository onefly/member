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
  	<td>充值记录id</td>
  	<td>用户id</td>
  	<td>充值时间</td>
  	<td>充值数量</td>
  	<td>充值金额</td>
  	<td>当前余额</td>
  	<td>充值项目</td>
  	
  </tr>
   <c:forEach items="${list}" var="p">
   <tr>
  		<td>${p.recordId}</td>
  		<td>${p.userId}</td>
  		<td><fmt:formatDate type="both" value="${p.rechargeTime }"/></td>
  		<td>${p.rechargeCount}</td>
  		<td>${p.rechargeMoney}</td>
  		<td>${p.currentBalance}</td>
  		<td>${p.rechargeProject}</td>
  	
  		</tr>
  </c:forEach>
   有${fn:length(list)}个元素<br>
  	当前${currentPages}页 总共${totalPages}页
  	<a href="/member/rechargeRecord/getRecord/1/${currentPages-1}/1.htm">上一页</a>
  	<a href="/member/rechargeRecord/getRecord/1/${currentPages+1}/1.htm">下一页</a>
  </table>

 
</html>
