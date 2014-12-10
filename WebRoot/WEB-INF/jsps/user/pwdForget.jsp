<%@ include file="/WEB-INF/jsps/includes/import.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/style/public.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/passwordForget.css" rel="stylesheet" type="text/css" />
</head>
<script language="javascript" src="${pageContext.request.contextPath }/js/common/jquery-yeqian.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-1.11.0.js"></script>
<script type="text/javascript">
	$(function(){
		//点击图片更换验证码
		$("#safecode").click(function(){
			var src='${pageContext.request.contextPath}/image/validcode.htm?date='+new Date().getTime();
			this.src=src;
		});
		
		//点击超链更换验证码
		$("#changecode").click(function(){
			var src_link='${pageContext.request.contextPath}/image/validcode.htm?date='+new Date().getTime();
			$("#safecode").attr("src",src_link);
		});
	});
	
	//点击"下一步"的onclick事件
	function nextStep(){
		var phone_val = $("#iptPhone").val();
		$.ajax({
			url: "${pageContext.request.contextPath}/pwdForget/verifyPhone.json",
			data: {phone:phone_val},
			type: "get",
			async: false,
			success: function(data){
				if(!data.isRegistedPhone){
					$("#info_alert").text("未注册手机号");
					return false;
				}else{
					$("#alert_info1").html("<span class='pa_a_01'>您注册时的密保邮箱是：</span>"+data.handledEmail );
					document.getElementById('iptPhone_div').style.display='none'; 
					document.getElementById('sendEmail_div').style.display='block';
				}
			}
		});
	}
	
	//发送密码重置邮件的onclick事件
	function sendEmail(){
		$("#sendEmail_form").submit();
	}
	
	//重新发送按钮的onclick事件
	function resend(){
		nextStep();
	}
	
	//手机号输入框的onfocus事件
	function modifyPhone(){
		$("#info_alert").text("");
	}
	
	//ajax发送请求获取后台验证码
/* 	function email_commit(){
		$.ajax({
			url: "${pageContext.request.contextPath}/image/getCode.json",
			type: "get",                    
			async : false,
			success:function(data){
				var input = $("#validateCode_id").val();
				var email = $("#email").val();
				if(email==""){
					$("#info_alert").text("请输入邮箱");
					return false;
				}
				if(input==""){
					$("#info_alert").text("请输入验证码");
					return false;
				}else if(input!=data.code){
					$("#info_alert").text("验证码不正确");
					var src='${pageContext.request.contextPath}/image/validcode.htm?date='+new Date().getTime();
					$("#safecode").attr("src",src);
					$("#validateCode_id").val("");
					return false;
				}else{
					$("#useEmail").submit();
				}
			}
		});
	} */
	
	//手机号输入框失去焦点的事件，发送ajax请求验证手机号是否注册
	var phoneAlert;
	$(document).ready(function(){
		$("#phoneInput").change(function(){
			var phone_val = $("#phoneInput").val();
			$.ajax({
				url: "${pageContext.request.contextPath}/pwdForget/judgePhone.json",
				type: "get",
				data:{phone:phone_val},
				async: false,
				success: function(data){
					if(500==data){
						//系统内部异常
						alert("系统内部异常");
					}else if(501==data){
						//用户未登陆，请求被拦截
						alert("您还未登陆");
					}else{
						if(!data.registFlag){
							phoneAlert = false;
							$("#infoAlert").text("未邦定的手机号");
						}else if(phone_val==""){
							phoneAlert = false;
							$("#infoAlert").text("请填写手机号");
						}else{
							phoneAlert = true;
							$("#infoAlert").text("");
						}
					}
				}
			});
		});
	});
	
	//点击超链，发送ajax请求来获取短信验证码
	var t, inter;
	function getPhoneCode(){
		var phone_val = $("#phoneInput").val();
		if ($("#phoneCodeLink").text() == "获取验证码"&&phoneAlert==true) {
			$("#phoneCodeLink").html("<span id='leaveTime'>60</span>秒后重新发送");
			t = setTimeout("changeState()", 1000 * 60);
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
	
	//提交表单的sendMS()方法
	function sendMS(){
		var code_val = $("#phoneCode").val();
		var phone_val = $("#phoneInput").val();
		if(!phoneAlert){
			$("#infoAlert").text("请填写正确手机号");
			return false;
		}
		if(code_val==""){
			$("#infoAlert_code").text("请输入验证码");
			return false;
		}
		else{
			$("#forgetEmail_form").submit();
		}
	}
</script>


<body>
<div id="wapper" class="white">
  <div class="main">
    <p class="passw_wz">您现在位于：首页 &gt;&gt; <span>忘记密码</span></p>
    <p class="passw_biaot">忘记密码</p>
    <div id="Tab1" class="passw_cent">
      <div class="Menubox">
        <ul>
          <li id="one1" onclick="setTab('one',1,3)"  class="hover">通过密保邮箱找回密码</li>
          <li id="one2" onclick="setTab('one',2,3)">忘记密保邮箱</li>
          <li id="one3" onclick="setTab('one',3,3)">其他方式找回密码</li>
        </ul>
      </div>
      <div class="Contentbox"> 
        <!--通过密保邮箱找回密码-->
	        <div id="con_one_1" class="two hover">
	          <div class="passw_a fixed" id="iptPhone_div">
	            <ul>
	              <li>
	               <form action="${pageContext.request.contextPath}/pwdForget/showInfo.htm" id="sendEmail_form" method="post">
	              	<span class="pa_a_01">请输入您注册时的手机号：</span>
	                <input name="iptPhone" type="text"  class="txt01" id="iptPhone" onfocus="modifyPhone()" />
	                <span class="pa_a_01" id="info_alert" style="color: red"></span>
	                <input type="button" name="nextStep_btn" id="nextStep_btn" onclick="nextStep()" class="passw_qda" value="下一步" />
	               </form>
	              </li>
	            </ul>
	          </div>
	          
	          <div class="passw_b passw_c fixed" id="sendEmail_div" style="display: none">
	            <ul>
	              <li id="alert_info1"></li>
	              <li>
	                <input type="button" onclick="sendEmail()" class="passw_qd" value="发送邮件重置密码" />
	              </li>
	            </ul>
          	  </div>
	          
	          <!-- <div class="passw_b passw_c fixed" id="resend_div" style="display: none">
	            <ul>
	              <li id="alert_info2"></li>
	              <li>
	                <div>
	                  <span>密码邮件已发送，请立即</span>
	                  <input type="submit" name="button" id="button" class="pa_c_01" value="查看邮件获取密码" />
	                </div>
	              </li>
	              <li>
	                <input type="button" name="resend_btn" id="resend_btn" class="passw_qd" value="重新发送" onclick="resend()" />
	              </li>
	            </ul>
	          </div> -->
          <%--
	        <div class="passw_b passw_c fixed" style="display:none;">
	          <ul>
	            <li><span class="pa_a_01">您注册时的密保邮箱是：</span>1********2@163.com</li>
	            <li>
	              <div><span>密码邮件已发送，请立即</span><a href="#" class="pa_c_01">查看邮件获取密码</a></div>
	            </li>
	            <li><a href="#" class="passw_qd">重新发送密码到密保邮箱</a></li>
	          </ul>
	        </div>
          --%>
          </div>
        
        <!--忘记密保邮箱-->
        <div id="con_one_2" class="two" style="display:none">
          <div class="passw_a fixed">
	          <form action="${pageContext.request.contextPath }/pwdForget/sendMessage.htm" id="forgetEmail_form">
	            <ul>
	              <li>
	              	<span class="pa_a_01">请输入您注册时的手机号：</span>
	                <input name="phone" type="text"  class="txt01" id="phoneInput" />
	                <span class="pa_a_01" id="infoAlert" style="color: red;" ></span>
	              </li>
	              <li><span class="pa_a_01">验证码：</span>
	                <input name="massageCode" type="text"  class="txt02" id="phoneCode"/>
	                <a href="#" class="TestGetCode" id="phoneCodeLink" onclick="getPhoneCode()">获取验证码</a>
	                <span class="pa_a_01" id="infoAlert_code" style="color: red;" ></span>
	              </li>
	              <li>
	              	<a href="#" class="passw_qd passw_qd2" id="send2Phone" onclick="sendMS()">发送密保邮箱到手机</a>
	              </li>
	            </ul>
	          </form>
          </div>
        </div>
        
        <!--其他方式找回密码-->
        <div id="con_one_3" style="display:none">
          <div class="passw_d fixed">
            <ul>
              <li>如忘记密保邮箱和注册手机号，请点击<a href="${pageContext.request.contextPath }/pwdForget/userState.htm">申诉找回身份</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
