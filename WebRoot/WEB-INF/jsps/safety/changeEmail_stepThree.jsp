<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-修改密保邮箱</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet" type="text/css" />

 <style type="text/css">
    *{margin:0;padding:0;list-style-type:none;}
    /* .demo{width:300px;margin:40px auto;} */
    /* mailBox */
    #mailBox{background:#fff;border:1px solid #ddd;padding:3px 5px 5px;position:absolute;z-index:9999;display:none;-webkit-box-shadow:0px 2px 7px rgba(0, 0, 0, 0.35);-moz-box-shadow:0px 2px 7px rgba(0, 0, 0, 0.35);}
    #mailBox p{width:100%;margin:0;padding:0;height:20px;line-height:20px;clear:both;font-size:12px;color:#ccc;cursor:default;}
    #mailBox ul{padding:0;margin:0;}
    #mailBox li{font-size:12px;height:22px;line-height:22px;color:#939393;font-family:'Tahoma';list-style:none;cursor:pointer;overflow:hidden;}
    #mailBox .cmail{color:#000;background:#e8f4fc;}
 </style>
<script type="text/javascript" src="<%=basePath %>/js/common/autoMail.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$('#newEmail').autoMail({
		emails:['qq.com','163.com','126.com','sina.com','sohu.com','yahoo.cn','gmail.com','hotmail.com','live.cn']
	});
	$('#reIptEmail').autoMail({
		emails:['qq.com','163.com','126.com','sina.com','sohu.com','yahoo.cn','gmail.com','hotmail.com','live.cn']
	});
});
</script>
<script type="text/javascript">

	

	//点击发送验证邮件后，隐藏该按键，出现”重新发送“按键
	function send(){
		var newEmail = $("#newEmail").val();
		var reNewEmail = $("#reIptEmail").val();
		if(newEmail==""||reNewEmail==""){
			alert("请将资料填写完整！");
			return false;
		}
		if(newEmail != reNewEmail){
			alert("两次输入不一致！");
			return false;
		}else{
			$.ajax({
				url: "${pageContext.request.contextPath}/safety/sendEmail_changeEmail.json",
				type: "get",
				data: {newEmail:newEmail},
				async : false,
				success:function(data){
					if(500==data){
						//系统内部异常
						alert("系统内部异常");
					}else if(501==data){
						//用户未登陆，请求被拦截
						alert("您还未登陆");
					}else{
						//正确返回结果
						document.getElementById('send_div').style.display='none';
						document.getElementById('reSend_div').style.display='block';
					}
				}
			});
		}
	}
	
</script>
</head>

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
          <div class="email_nav02"></div>
          <div class="verification email">
            <div class="verification_b mobile_a  email_a fixed"> <span class="bit">恭喜，您的身份已验证成功！</span>
             <form action="" method="post" id="changeEmail_form">
               <ul class="fixed">
                <li> <span>请填写您的新密保邮箱：</span>
                  <input type="text" class="loginFormTdIpt_a" id="newEmail">
                </li>
                <li> <span>请再次填写您的新密保邮箱：</span>
                  <input type="text" class="loginFormTdIpt_a" id="reIptEmail">
                </li>
               </ul>
              </form>
              <div id="send_div">
               <button id="send_btn" onclick="send()" class="verif01">发送激活邮件</button> 
              </div> 
              <div id="reSend_div" style="display:none;"> 
                <dl class="tiona_top_cent">
				  <dt>
				    <span>验证码邮件已发送，请立即</span>
					<a href="#" class="fas03">查看邮件激活</a>
				  </dt>
                  <dd>验证码邮件30分钟有效，请尽快登录您的邮箱完成验证</dd>
                </dl>
                <button class="verif01" onclick="reSend()">重新发送激活邮件</button>
              </div>
              <div class="tiona_bottom emaila">为保障账户安全，更改账户重要信息时需要通过密保邮箱进行身份验证，感谢您的理解！<br/>
					密保邮箱是修改帐号信息的唯一方法，请慎重修改
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