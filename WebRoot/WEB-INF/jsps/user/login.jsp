<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/style/Login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/js/common/jquery-1.7.min.js"></script>

<script type="text/javascript">
	$(function() {
		//点击图片更换验证码
		$("#changeimage").click(
			function() {
				$("#safecode").val("");
				var src = '<%=basePath %>/image/validcode.htm?date='+ new Date().getTime();
				this.src = src;
			});
		$("#changeimage_link").click(
				function() {
					$("#safecode").val("");
					var src_link = '<%=basePath %>/image/validcode.htm?date='+ new Date().getTime();
					$("#changeimage").attr("src",src_link);
				});
	});

	//ajax发送请求获取后台验证码
	function checkAll() {
		$.ajax({
			url : "<%=basePath %>/image/getCode.json",
			type : "get",
			async : false,
			dataType : "json",
			beforeSend : function() {
			},
			success : function(data) {
				var input_safecode = $("#safecode").val().toLowerCase();
				var input_username = $("#phoneInput").val();
				var input_password = $("#pwdInput").val();
				if(input_username==""){
					$("#infoAlert").text("请输入手机号");
					return false;
				}
				if(input_password==""){
					$("#infoAlert").text("请输入密码");
					return false;
				}
				if (input_safecode == "") {
					$("#infoAlert").text("请输入验证码");
					return false;
				} else if (input_safecode != data.code) {
					$("#infoAlert").text("验证码错误");
					var src = '<%=basePath %>/image/validcode.htm?date='+ new Date().getTime();
					$("#changeimage").attr("src",src);
					$("#safecode").val("");
					return false;
				} else {
					$("#login_form").submit();
				}
			}
		});
	}
	
	//将cookie中的信息回写
	$(document).ready(function(){
		var val_username = $("#hide_uname").val();
   		$("#phoneInput").val(val_username);
   		if(val_username!=""){
   			$("#rem_phone").attr("checked",true);
   		}else{
   			$("#rem_phone").attr("checked",false);
   		}
   	});
	
</script>
</head>

<body>
	<div id="wapper">
	<input type="hidden" id="hide_uname" value="${uname }"/>
		<div class="box">
			<a href="#" class="login_logo"></a>
			<div class="login_main">
				<div class="login_m_l"></div>
				<div class="login_m_r">
					<h2>美试网是一个实名认证的品牌体验网站！</h2>
				<form id="login_form" name="login_form" method="post" action="<%=basePath %>/user/login.htm">
					<div class="login_m_c">
						<div class="login_input01">
							<span class="login_icon01"></span>
								<input type="text" name="phone" id="phoneInput" placeholder="手机号码" title="请输入帐号"
								class="loginFormTdIpt">
						</div>
						<p></p>
						<div class="login_input01">
							<span class="login_icon02"></span>
								<input type="password" name="password" id="pwdInput" placeholder="密码" title="请输入密码"
								tabindex="2" class="loginFormTdIpt">
						</div>
						<p></p>
						<div class="login_input02">
							<input type="text" name="validcode" id="safecode" title="请输入验证码" class="login_yzm"><span>
								<img src="<%=basePath %>/image/validcode.htm" style="cursor:pointer" id="changeimage" width="76" height="31" />
								<a href="#" id="changeimage_link">换一张</a>
								<h3 id="infoAlert" style="color: red;"></h3>
							</span>
						</div>
						<p></p>
						<div class="login_input">
								<span> 
									<input type="checkbox" name="checkbox_phone" value="1" id="rem_phone"/> 
									<label for="checkbox">记住帐号</label> 
								</span> 
								<span>
									<input type="checkbox" name="checkbox_autoLogin" value="1" id="checkbox_autoLogin"/> 
									<label for="checkbox">自动登陆</label> 
								</span>
							</form>
							<a href="<%=basePath %>/user/forgetpwd.htm">忘记密码？</a>
						</div>
						<a href="#" class="login_anniu" id="login_link" onclick="checkAll()">登 录</a>
						<p class="login_zhuc">
							还没有帐号？<a href="<%=basePath%>/register/forward.htm">免费注册</a>
						</p>
						
					</div>

					<div class="login_m_b"></div>








				</div>
			</div>







		</div>










	</div>
</body>

</html>

