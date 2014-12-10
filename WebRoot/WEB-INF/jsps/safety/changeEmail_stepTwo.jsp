<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-修改密保邮箱</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/js/common/jquery-1.7.min.js"></script>
</head>
<script language=javascript>  

	//”重新发送验证码邮件“超链的onclick事件
	function reSendEmail(){
		$.ajax({
			url : "<%=basePath%>/safety/reSend.json",
			type : "get",
			async : false,
			dataType : "json",
			beforeSend : function() {
			},
			success : function(data) {
				if(500==data){
					//系统内部异常
					alert("系统内部异常");
				}else if(501==data){
					//用户未登陆，请求被拦截
					alert("您还未登陆");
				}else{
					//正确返回结果
					alert("邮件已发送");
				}
			}
		});
	}

	//“确定”链接的onclick事件
	function link_commit(){
		var code_val = $("#code").val();
		$.ajax({
			url : "<%=basePath%>/safety/submitCode_changeEmail.json",
			type : "get",
			data : {code:code_val},
			async : false,
			dataType : "json",
			beforeSend : function() {
			},
			success : function(data) {
				var codeFlag = data.isCodeRight;
				if(500==data){
					//系统内部异常
					alert("系统内部异常");
				}else if(501==data){
					//用户未登陆，请求被拦截
					alert("您还未登陆");
				}else{
					//正确返回结果
					if(!codeFlag){
						alert("验证码错误");
						return false;
					}else{
						$("#submit_code").submit();
					}
				}
			}
		});
	}
	
</script>
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
          <div class="email_nav01"></div>
          <div class="verification" id="stepThree">
           <div class="verification_a" id="stepTwo">
              <div class="tionb_top tiona_top"> 您现在的密保邮箱是：${user.email }
                <dl class="tiona_top_cent">
                  <dt><span>验证码邮件已发送，请立即</span><a href="#" class="fas03">查看邮件获取验证码</a></dt>
                  <dd>验证码邮件30分钟内有效，请尽快登录您的邮箱完成验证</dd>
                </dl>
              <a href="#" class="fas02" id="reSendEmail" onclick="reSendEmail()">重新发送验证码邮件</a>
              <form action="<%=basePath%>/safety/submitCode_changeEmail.htm" id="submit_code">
                <div class="tiona_top_bottom" ><span>验证码：</span>
                  <input type="text" name="code" id="code"/>
                  <a href="#" class="fas04" onclick="link_commit()">确定</a>
               </div>
              </form>
              </div>
             <div class="tiona_bottom">为保障账户安全，更改账户重要信息时需要通过密保邮箱进行身份验证，感谢您的理解！<br/>
             	密保邮箱是修改帐号信息的唯一方法，请慎重修改
            </div>
           </div>
          </div>
         </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>