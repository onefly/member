<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-修改手机号码</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/js/common/jquery-1.7.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<body class="white">
<jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>
<div id="wapper">
  <div class="main">
    <p class="passw_wz">您现在位于：首页 >> 我的美试 <span>- 个人首页</span></p>
    
    <!-- 个人中心公共头引入 -->
    <c:import url="/user/usertop.htm"></c:import>
    
    <div class="indiv_bottom top25">
      <ul class="indiv_bl">
       				<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.index")%>"><em></em>个人首页</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.info")%>">个人资料</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.account")%>">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.order")%>">我的订单</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.comment")%>">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.collect")%>" >我的收藏</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exchange")%>">我的兑换</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.medal")%>">体验勋章</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.remind")%>">美试提醒</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.invite")%>">邀请好友</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.space")%>">我的空间</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.safe")%>" class="geren_bj" >安全中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.help")%>">帮助中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exit")%>">退出</a></li>
      </ul>
      <div class="indiv_br fr">
        
        <div class="password">
          <div class="email_nav03"></div>
          <div class="verification">
            <div class="verification_b verification_c fixed"> <span class="bit">恭喜，您的密保邮箱已修改成功！</span>
              <p>您可以前往：<em><a href="#">美试网首页</a> | 
              				<a href="#">我的空间</a> | 
              				<a href="#">帮助中心</a>
              			</em>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>