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
	
	//点击“重新发送”键时的onclick事件
	function resend(){
		var email_val = $("#email").val();
		$.ajax({
			url: "${pageContext.request.contextPath}/pwdForget/resend.json",
			data: {email:email_val},
			type: "get",
			async: false,
			success: function(data){
				if(data==500){
					//系统内部异常
					alert("系统内部异常");
				}else{
					alert("邮件已发送");
				}
			}
		});
	}
</script>


<body>
<div id="wapper" class="white">
  <div class="main">
    <p class="passw_wz">您现在位于：首页 &gt;&gt; <span>忘记密码</span></p>
    <p class="passw_biaot">忘记密码</p>
    <div id="Tab1" class="passw_cent">
      
      <div class="Contentbox"> 
	          <div class="passw_b passw_c fixed" id="resend_div">
	            <ul>
	              <li id="alert_info"><span class='pa_a_01'>您注册时的密保邮箱是：${handledEmail }</span></li>
	              <li>
	                <div>
	                  <span>密码邮件已发送，请立即</span>
	                  	<input type="submit" name="button" id="button" class="pa_c_01" value="查看邮件获取密码" />
	                  	<input type="hidden" name="email" id="email" value="${email }"/>
	                </div>
	              </li>
	              <li>
	                <input type="button" name="resend_btn" id="resend_btn" class="passw_qd" value="重新发送" onclick="resend()" />
	              </li>
	            </ul>
	          </div>
          </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
