<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-安全中心</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="<%=basePath%>/js/common/jquery-1.7.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var strength = ${user.passwdStrength};
		if(strength==0){
			$("#strength").text("弱");
		}else if(strength==1){
			$("#strength").text("中");
		}else{
			$("#strength").text("强");
		}
	});
</script>

<body class="white">
 <jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>
 <div id="wapper">
  <div class="main">
  
    <!-- 个人中心公共头引入 -->
    <c:import url="/user/usertop.htm"></c:import>
    
    <p class="passw_wz">您现在位于：首页 >> 我的美试 <span>- 个人首页</span></p>
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
        <div class="safety fixed">
          <h2>您的基础信息</h2>
          <div class="safety_top">
            <p>登录手机： ${user.phone}</p>
            <p>密保邮箱： ${user.email}</p>
            <p>上次登录时间： ${user.lastLoginTimeStr}（不是您登录的？请<a href="<%=basePath%>/safety/changePassword.htm">点击这里</a>修改登录密码）</p>
          </div>
          <h2>您的安全服务</h2>
          <ul class="safety_cent">
			<li> <span class="fuw05">未完成</span>
				 <span class="fuw02">身份认证</span>
				 <span class="fuw03">每个身份证号仅能注册一个美试帐号，不能修改；如果帐号被盗无法找回，请及时联系网站客服，核实身份后，可以修改密码及其它信息</span>
				 <a href="#" class="bj_l">认证</a> 
			</li>
			<li> <span class="fize14">强度：<em id="strength"></em></span>
				 <span class="fuw02 right01">登录密码</span> 
				 <span class="fuw03">安全性高的密码可以使帐号更安全。建议您定期更换密码，且设置一个包含数字和字母，并长度为6－20位的密码，区分大小写</span> 
				 <a href="<%=basePath%>/safety/changePassword.htm">修改</a> 
			</li>
            <li> <span class="fuw01">已完成</span>
            	 <span class="fuw02">手机验证</span> 
            	 <span class="fuw03">你注册的手机号将成为您登录本站的唯一用户名，建议您使用常用的手机号注册，方便验证密码及接收订阅信息，请谨慎修改</span> 
            	 <a href="<%=basePath%>/safety/changePhone.htm">修改</a> 
            </li>
            <li style="border-bottom:none"> 
            	<span class="fuw01">已完成</span> 
            	<span class="fuw02">密保邮箱</span> 
            	<span class="fuw03">是您日常找回登录密码，修改手机号码等信息的唯一方法，请牢记并谨慎修改，建议使用QQ邮箱</span> 
            	<a href="<%=basePath%>/safety/changeEmail.htm">修改</a> 
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>