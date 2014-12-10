<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申诉找回</title>
<link href="${pageContext.request.contextPath }/style/public.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/style/passwordForget.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-1.11.0.js"></script>
<script type="text/javascript">
	
</script>

<body class="white">
<div id="wapper">
  <div class="main">
    <p class="passw_wz">您现在位于：首页 >> <span>申诉找回身份</span></p>
    <p class="passw_biaot">申诉找回身份</p>
    <div class="state">
      <div class="fixed">
         <div class="xuanz fixed">
          <span>申诉目的</span>
            <input type="radio" name="radio_update" id="radio_update" value="update" />
            <label for="radio">修改现有账户信息</label>
            <input type="radio" name="radio_create" id="radio_create" value="create" />
            <label for="radio">创建新账户</label>
         </div>
        <ul class="state_a fixed">
          <li><span class="pa_a_01">您的真实姓名：</span>
            <input name="name" type="text"  class="state01" id="realName"/>
          </li>
          <li><span class="pa_a_01">您的身份证号码：</span>
            <input name="identification" type="text"  class="state02" id="id_card"/>
          </li>
          <li><span class="pa_a_01">联系电话：</span>
            <input name="connectPhone" type="text"  class="state02" id="connectPhone"/>
            <p>(必要时，我们会电话联系您确认信息）</p>
          </li>
          <li><span class="pa_a_01">您申请的登录手机号码：</span>
            <input name="phone" type="text"  class="state02" id="login_phone"/>
              <input type="button" name="btn_getSMSCode" id="btn_getSMSCode"
              	class="state03" value="获取手机验证码" onclick="sendSMSCode()"/>
          </li>
          <li><span class="pa_a_01">填写手机验证码：</span>
            <input name="SMSCode_userIpt" type="text" id="SMSCode_userIpt" class="state01"/>
          </li>
          <li><span class="pa_a_01">您申请的密保邮箱：</span>
            <input name="email" type="text" id="newEmail" class="state02"/>
              <input type="button" name="btn_getEmailCode" id="btn_getEmailCode"
                class="state03" value="获取邮箱验证码" onclick="sendEmailCode()"/>
              <p id="emailCode_alert">验证码邮件已发送，邮件内容24小时有效，<br />请尽快登录您的邮箱完成验证</p>
          </li>
          <li><span class="pa_a_01">填写邮箱验证码：</span>
            <input name="emailCode_userIpt" type="text" id="emailCode_userIpt" class="state01"/>
          </li>
          <li><input type="submit" name="button" id="button" class="statea" value="确定" /></li>
        </ul>
      </div>
      <div class="state_c fixed">
        <div class="state_ctop fixed">
         <span class="statec01"><p>您的真实姓名是：</p><em>张三</em></span>
         <span class="statec02"><p>您的身份证号是：</p><em>43098119870909001a</em></span>
         <span class="statec03"><p>联系电话：</p><em>138****2650</em></span>
         <span class="statec04"><p>您申请的登录手机号码是：</p><em>123****8900</em></span>
         <span class="statec05"><p>您申请的密保邮箱是：</p><em>1*********0@qq.com</em></span>
        </div>
        <div class="state_ccent fixed">
        <p class="top30"><em>0/140</em>填写申诉理由</p>
        <textarea name="" cols="" rows="" class="width675"></textarea>
        
        <p class="top30">上传身份证照片</p>
        <p>*仅支持JPG，PNG图片格式，图片小于2M</p>
        <p>*照片中的以下信息必须真实有效且清晰可见：1.手持证件人的五官　2.身份证上的所有信息</p>
        <p>*图片示例<img src="images/state01.png" width="206" height="63" /></p>
        
        <p class="uploading"><input type="submit" name="button" id="button" class="uploading01" value="选择上传1" /><input name="" type="text" class="uploading02" /><input type="submit" name="button" id="button" class="uploading01" value="上传" /><input type="submit" name="button" id="button" class="uploading01" value="取消" /></p>
        <p class="uploading"><input type="submit" name="button" id="button" class="uploading01" value="选择上传2" /><input name="" type="text" class="uploading02" /><input type="submit" name="button" id="button" class="uploading01" value="上传" /><input type="submit" name="button" id="button" class="uploading01" value="取消" /></p>
        <p><img src="images/state02.jpg" width="563" height="175" /></p>
        <p class="submit"><input type="submit" name="button" id="button" class="uploading01" value="提交申诉" /></p>
       </div>
      
      
      
      
      
      
    </div>
    <div class="state_d">
     <ul>
      <li>您的申诉已经提交</li>
      <li><span class="yellow">美试客服会在三个工作日之内与您联系完成身份验证</span></li>
      <li><span class="fize14">3秒后页面自动跳转至首页</span></li>
     </ul>
    
    </div>
  </div>
</div>
</body>
</html>
