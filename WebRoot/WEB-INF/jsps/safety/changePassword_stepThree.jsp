<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-修改登录密码</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/js/common/jquery-1.7.min.js"></script>
</head>
<script language=javascript>  
	//判断输入密码的类型  
	function AuthPasswd(string) {
    if(string.length >= 6) {
        if(/[a-zA-Z]+/.test(string) && /[0-9]+/.test(string) && /\W+\D+/.test(string)) {
        	//密码安全性为强
        	pwStrength(2);
            
        }else if(/[a-zA-Z]+/.test(string) || /[0-9]+/.test(string) || /\W+\D+/.test(string)) {
        	//密码安全性为中
            if(/[a-zA-Z]+/.test(string) && /[0-9]+/.test(string)) {
            	pwStrength(1);
                
            }else if(/\[a-zA-Z]+/.test(string) && /\W+\D+/.test(string)) {
            	//密码安全性为中
            	pwStrength(1);
                
            }else if(/[0-9]+/.test(string) && /\W+\D+/.test(string)) {
            	//密码安全性为中
            	pwStrength(1);
                
            }else{
            	//密码安全性为弱
            	pwStrength(0);
            }
        }
    }else{
    	//密码位数少于6
    	pwStrength(null);
    }
}


	//显示颜色  
	function pwStrength(num) {
		$("#passwordStrength").val(num);
		O_color = "#eeeeee";//密码长度小于6时
		L_color = "#ffcc00";//强度为弱
		M_color = "#FF9900";//强度为中
		H_color = "#ff6600";//强度为强
		if (num == 0) {
			$("#infoAlert").text("");
			Lcolor = L_color;
			Mcolor = H_color = O_color;
			
		} else if(num == 1){
			$("#infoAlert").text("");
			Mcolor = M_color;
			Lcolor = Hcolor = O_color;
			
		} else if(num == 2){
			$("#infoAlert").text("");
			Hcolor = H_color;
			Lcolor = Mcolor = O_color;
		}else{
			Lcolor = Mcolor = Hcolor = O_color;
			$("#infoAlert").text("密码少于6位");
		}
		document.getElementById("strength_L").style.background = Lcolor;
		document.getElementById("strength_M").style.background = Mcolor;
		document.getElementById("strength_H").style.background = Hcolor;
		return;
	}
	
	//确定用来判断是否提交表单
	function updatePwd(){
		var flag = $("#passwordStrength").val();
		var newPasswd = $("#newPasswd").val();
		var newPasswdAgain = $("#newPwdAgain").val();
		if(newPasswd != newPasswdAgain){
			$("#info_alert").text("两次密码输入不一致");
			return false;
		}else{
			if(flag == null||flag == ""){
				$("#info_alert").text("密码长度小于6位");
				return false;
			}else{
				$("#updatePwd_form").submit();
			}
		}
	}
	
	//再次输入密码的输入框获得焦点事件 onFocus
	function inputNewPwd(){
		$("#newPwdAgain").val("");
		$("#info_alert").text("");
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
        <div class="password" id="stepFour">
          <div class="password_nav02"></div>
          <div class="verification">
            <div class="verification_b fixed"> <span class="bit">恭喜，您的密保邮箱已验证成功！</span>
            <form action="<%=basePath %>/safety/update.htm" id="updatePwd_form">
              <ul class="fixed">
                <li> <span>新密码：</span>
                  <input type="password" size=8 onKeyUp="AuthPasswd(this.value)" maxlength="20"
                  	class="loginFormTdIpt_a" id="newPasswd"  name="newPasswd">
                  <input type="hidden" id="passwordStrength" name="passwordStrength">
                  <span id="infoAlert" style="color: red;"></span>
                  <dl>
                    <dt id="strength_L">弱</dt>
                    <dt id="strength_M">中</dt>
                    <dt id="strength_H">强</dt>
                    <dd>为了提升您的密码安全性，建议使用6-20位字母加数字的混合密码</dd>
                  </dl>
                </li>
                <li> <span>确认新密码：</span>
                  <input type="password" size=8 class="loginFormTdIpt_a" id="newPwdAgain" onfocus="inputNewPwd()">
                  <span id="info_alert" style="color: red;"></span>
                </li>
              </ul>
    		</form>
           	<a href="#" class="verif01" onclick="updatePwd()">确定</a> 
           </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>