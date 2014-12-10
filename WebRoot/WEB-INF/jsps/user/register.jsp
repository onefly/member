<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link href="<%=basePath %>/style/public.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/style/Login.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/css/common/css.css" rel="stylesheet" type="text/css" />

<link href="<%=basePath %>/css/common/validForm.css" rel="stylesheet">
<script src="<%=basePath %>/js/common/jquery-1.7.min.js"></script>
<script src="<%=basePath %>/js/common/validForm.js"></script>
<script src="<%=basePath %>/js/common/validForm_datatype.js"></script>
<script src="<%=basePath %>/js/common/dateselector.js"></script>
<script src="<%=basePath %>/js/user/region.js"></script>
<script language="javascript" src="<%=basePath%>/js/common/area.js"></script>
</head>

<body>
<div id="wapper">
  <div class="box"> <a href="#" class="login_logo"></a>
    <div class="login_main">
      <div class="regis_left">
        <div class="regis_img"></div>
        <div class="regis_bottom"></div>
      </div>
      <div class="regis_right">
        <h2>美试网是一个实名认证的品牌体验网站！</h2>
        <div class="regis_cent">
        <form id="register_form" method="post" action="<%=basePath %>/register/post.htm">
        <em style="color:#ea000b">${message}</em></br/>
        <input type="hidden" name="inviteUserId" id="inviteUserId" value="${inviteUserId}"/>
          <ul>
            <li><span class="fize14">手 机 号：</span>
              <input type="text" name="phone" id="phone_number" placeholder="手机号码" class="loginFormTdIpt_a" datatype="m" errormsg="请填写正确的手机号码" sucmsg="可以使用" ajaxurl="<%=basePath %>/register/validateDuplicate.htm" value="${user.phone}">
              <span class="regis_ys02 Validform_checktip"></span></li>
            <li><span class="fize14">验 证 码：</span>
              <input type="text" name="checkNumber" id="checkNumber" class="loginFormTdIpt_b">
              <button  class="regis_yzm" id="send">发送验证码</button></li>
            <li><span class="fize14">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</span>
              <input type="text" name="nickname" id="nick_name" placeholder="请输入6-20位字符的组合" class="loginFormTdIpt_a" datatype="/^[\S|\u4e00-\u9fa5]{1,20}$/"  errormsg="请填写1到20位的字符" sucmsg="可以使用" ajaxurl="<%=basePath %>/register/validateDuplicate.htm" value="${user.nickname}">
              <span class="regis_ys02 Validform_checktip"></span></li>
            <li><span class="fize14">密保邮箱：</span>
              <input type="text" name="email" id="email" placeholder="用于忘记密码找回" class="loginFormTdIpt_a" datatype="e" errormsg="请填写正确的邮箱" sucmsg="可以使用" ajaxurl="<%=basePath %>/register/validateDuplicate.htm" value="${user.email}">
              <span class="regis_ys02 Validform_checktip"></span></li>
          </ul>
          <ul class="regis_cent02">
            <li><span class="fize14">真实姓名：</span>
              <input type="text" name="name" id="name"  placeholder="实名认证，用于找回密码" class="loginFormTdIpt_a" value="${user.name}">
            </li>
            <li><span class="fize14">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span> <span class="nanv">
              <input type="radio" name="gender" id="radio1" value="1" class="nanv01" />
              <label for="radio">男</label>
              </span> <span class="nanv">
              <input type="radio" name="gender" id="radio2" value="0" class="nanv01" datatype="*"/>
              <label for="radio">女</label>
              </span> </li>
            <li><span class="fize14">出生日期：</span><input type="hidden" name="brithday" id="brithday" />
              <select name="brithdayyear" id="year" class="loginFormTdIpt_c">

              </select>
              <select name="brithdaymonth" id="month" class="loginFormTdIpt_c">
          
              </select>
              <select name="brithdayday" id="day" class="loginFormTdIpt_c">
           
              </select>
              <span style="margin-left:-6px;" class="regis_ys01">请真实填写不能修改</span> </li>
            <li><span class="fize14">身份证号：</span>
              <input type="text" name="identification" id="identification" placeholder="每个身份证号只能注册一个账户" class="loginFormTdIpt_a" datatype="idcard" errormsg="号码不正确" sucmsg="可以使用" ajaxurl="<%=basePath %>/register/validateDuplicate.htm" value="${user.identification}">
              <span class="regis_ys02 Validform_checktip"></span></li>
          </ul>
          <ul>
            <li><span class="fize14">常驻地区：</span>
            	<!-- <input type="hidden" name="provinceName" id="provinceName" />
              <select name="province" id="selectProv" class="loginFormTdIpt_d" >
                <option>请选择</option>
              </select>
              <input type="hidden" name="cityName" id="cityName" datatype="*"/>
              <select name="city" id="selectCity" class="loginFormTdIpt_d">
                <option>请选择</option>
              </select> -->
              <input type="hidden" name="provinceName" id="provinceName" />
			<input type="hidden" name="cityName" id="cityName" />

			<select name="province" id="s_province" class="loginFormTdIpt_c">
				<option>
					请选择
				</option>
			</select>
			<select name="city" id="s_city" class="loginFormTdIpt_c">
				<option>
					请选择
				</option>
			</select>
			<select name="district" id="s_county" class="loginFormTdIpt_c" style="display:none">
												<option>
													请选择
												</option>
											</select>
            </li>
            <li><span class="fize14">登录密码：</span>
              <input type="password" name="password" id="password" placeholder="请输入6-20位字母和数字的组合,区分大小写" class="loginFormTdIpt_a" datatype="/^[A-Za-z0-9]{6,20}$/"  errormsg="请填写有字母数字组成的6到20位密码" sucmsg="可以使用">
              <span class="regis_ys02 Validform_checktip"></span></li>
            </li>
            <li><span class="fize14">确认密码：</span>
              <input type="password" name="check_passwd" id="checkPasswd" placeholder="" class="loginFormTdIpt_a" recheck="password" datatype="/^[A-Za-z0-9]{6,20}$/"  errormsg="密码不一致" sucmsg="可以使用">
              <span class="regis_ys02 Validform_checktip"></span></li>
            </li>
           <%--  <li><span class="fize14">验 证 码：</span>
              <input type="text" name="checkNumber" id="checkNumber" placeholder="" class="login_yzm">
              <span><img src="<%=basePath %>/register/validcode.htm" width="76" height="31"id="validCode" /><a id="refreshImg" href="#">换一张</a></span></li> --%>
            <li><span class="regis_gx">
              <input name="agree" type="checkbox" value="" id="agree" />
              <label for="checkbox"><a href="#">同意《美试网用户协议》</a></label>
              </span> </li>
            <li class="clear"><a href="#" class="width130" id="submit">立即注册</a>
              <p>我有帐号，<a href="<%=basePath %>/user/toLogin.htm">直接登录</a></p>
            </li>
          </ul>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="<%=basePath %>/js/user/register.js"></script>
<script>
	function send(){
		var timer=setInterval(clock, 1000);
		$("#send").unbind();  
		var count=30;
		function clock(){
	        if(count>0){
	        	count--;
	        	$("#send").text("发送验证码"+count);
	        }else{
	        	clearInterval(timer);
	        	$("#send").text("发送验证码");
	        	$("#send").bind("click",send());
	        }
		        
		}
	}
	$("#send").click(function(){
		var timer=setInterval(clock, 1000);
		$("#send").attr("disabled",true); 
		var count=30;
		function clock(){
	        if(count>0){
	        	count--;
	        	
	        	$("#send").text("发送验证码"+count);
	        }else{
	        	clearInterval(timer);
	        	$("#send").text("发送验证码");
	        	$("#send").attr("disabled",false); 
	        }
		        
		}
	});
</script>
</body>
</html>