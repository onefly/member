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
</head>
<script language=javascript>  

	//手机号输入框失去焦点事件（正则验证手机号是否合法）
	var phoneAlert;
	function checkPhone(){
		var phone_val = $("#newPhone").val();
		if(!(/^[1][0-9]{10}$/.test(phone_val))){
			phoneAlert = false;
			$("#infoAlert").text("手机号有误！");
		}else{
			phoneAlert = true;
			$("#infoAlert").text("");
		}
	}
	
	//点击超链，发送ajax请求来获取短信验证码
	var t, inter;
	function getCode(){
		var phone_val = $("#newPhone").val();
		if ($("#phoneCodeLink").text() == "获取验证码" && phoneAlert==true) {
			$("#phoneCodeLink").html("<font id='leaveTime'>180</font>秒后重新发送");
			//$("#phoneCodeLink").text('444');
			t = setTimeout("changeState()", 1000 * 60 * 3);
			inter = setInterval("changeText()", 1000);
			$.ajax({
				url: "${pageContext.request.contextPath}/getSMSCode.json",
				type: "get",
				data: {phone:phone_val},
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
						alert("短信已发送");
					}
				}
			});
			
		}
	}
	//点击后进入倒计时状态，60秒后可以重新获取，每秒(1000毫秒)倒计时减1
	function changeText() {
		var num = $("#leaveTime").text();
		$("#leaveTime").text(num - 1);
	}
	
	//60秒后显示可以获取验证码
	function changeState() {
		$("#phoneCodeLink").html("获取验证码");
		clearInterval(inter);
		clearTimeout(t);
	}
	
	//提交表单的codeSubmit()方法
	function codeSubmit(){
		var code_val = $("#phone_validateCode").val();
		if(!phoneAlert){
			$("#infoAlert").text("请填写正确手机号");
			return false;
		}
		if(code_val==""){
			$("#alert_code").text("请输入验证码");
			return false;
		}
		else{
			$.ajax({
				url: "${pageContext.request.contextPath}/safety/validateCodeVerify.json",
				type: "get",
				data: {validateCode:code_val},
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
						if(times > 0){//有剩余的输入机会
							if(data.checkFlag){//验证码输入错误
								$("#updatePhone_form").submit();
							}
							if(!data.checkFlag){
								$("#alert_code").text("验证码错误");
								return false;
							}
						}else{
							$("#updatePhone_form").submit();
						}
					}
				}
			});
		}
	}
	
	//验证码输入框的onFocus事件
	function cleanInput(){
		$("#phone_validateCode").val("");
		$("#alert_code").text("");
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
          <div class="mobile_nav02"></div>
          <div class="verification">
            <div class="verification_b mobile_a fixed"> <span class="bit">恭喜，您的密保邮箱已验证成功！</span>
              <ul class="fixed">
              <form action="${pageContext.request.contextPath}/safety/formSubmit.htm" id="updatePhone_form">
                <li> 
                  <span>新手机号：</span>
                  <input type="text" size=8 onblur="checkPhone()" class="loginFormTdIpt_a" id="newPhone" name="newPhone">
                  <span class="pa_a_01" id="infoAlert" style="color: red;" ></span>
                </li>
                <li> 
                  <span>验证码：</span>
                  <input type="text" size="8" class="loginFormTdIpt_a"
                  		id="phone_validateCode" name="validateCode" onFocus="cleanInput()"> 
                  <a href="#" id="phoneCodeLink" onclick="getCode()">获取验证码</a>
                  <p></p>
                  <span class="pa_a_01" id="alert_code" style="color: red;" ></span>
                </li>
             </form>
             </ul>
              <input type="button" class="verif01" onclick="codeSubmit()" value="确定">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>