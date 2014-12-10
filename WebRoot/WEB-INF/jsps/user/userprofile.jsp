<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-个人资料</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/css/common/css.css" rel="stylesheet"
	type="text/css" />


<script language="javascript" src="<%=basePath%>/js/common/jquery-yeqian.js"></script>
<%-- <script language="javascript" src="<%=basePath%>/js/user/region.js"></script> --%>
<script src="<%=basePath %>/js/common/validForm.js"></script>
<script src="<%=basePath %>/js/common/validForm_datatype.js"></script>
<script language="javascript" src="<%=basePath%>/js/common/area.js"></script>
</head>

<body class="white">
<%@ include file="/WEB-INF/jsps/includes/top.jsp"%>
	<div id="wapper">
		<div class="main">
			<p class="passw_wz">
				您现在位于：首页 >> 我的美试 <span>- 个人首页</span>
			</p>
			<!-- 个人中心公共头部开始 -->
			<c:import url="/user/usertop.htm"></c:import>
					
			<!-- 个人中心公共头部结束 -->
			<div class="indiv_bottom top25">
				<ul class="indiv_bl">
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.index")%>"><em></em>个人首页</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.info")%>" class="geren_bj">个人资料</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.account")%>">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.order")%>">我的订单</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.comment")%>">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.collect")%>" >我的收藏</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exchange")%>">我的兑换</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.medal")%>">体验勋章</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.remind")%>">美试提醒</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.invite")%>">邀请好友</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.space")%>">我的空间</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.safe")%>"  >安全中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.help")%>">帮助中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exit")%>">退出</a></li>
				</ul>
				<div class="indiv_br fr">
					<div id="Tab1" class="data">
						<div class="Menubox">
							<ul>
								<li class="hover"><a href="<%=basePath%>/user/profile.htm" class="hover">个人资料</a></li>
								<li ><a href="<%=basePath%>/user/uploadPhoto.htm" >修改头像</a></li>
								<li ><a href="<%=basePath%>/user/toRecAddr.htm" >收货地址</a></li>
							</ul>
						</div>
						<div class="Contentbox fixed">
							<div id="con_one_1" class="two hover">
							<form id="userProfile" method="post" action="<%=basePath %>/user/update.htm">
								<input type="hidden" name="userId" value="${user.userId}"/>
								<div class="cont_data fixed">
									<ul>
										<li><span>登录手机号：</span>${user.phone}</li>
										<li><span>真实姓名：</span>${user.name}</li>
										<li id="gendervalue"><span>性 别：</span><input
											type="hidden" name="gender" id="gender"
											value="${user.gender}" /> <span id="gendervalue"><script>
												if ($("#gender").val() == 1)
													$("#gendervalue").append(
															"男")
												else
													$("#gendervalue").append(
															"女")
											</script></span></li>
										<li><span>身份证号：</span>${user.identification}</li>
										<li><span>密保邮箱：</span>${user.email}</li>
										<li><span>昵 称：</span><input type="text" name="nickname" id="nickname"
											 class="loginFormTdIpt_a disabled" value="${user.nickname}" datatype="/^[\S|\u4e00-\u9fa5]{1,20}$/"  errormsg="请填写1到20位的字符" sucmsg="可以使用" ajaxurl="<%=basePath %>/register/validateDuplicate.htm" value="${user.nickname}"></li>
										<li><span>生 日：</span>${user.brithdayStr}</li>
										<input type="hidden" value="${user.canModifyRegion}" id="canmodifyregion" />
										<li id="showDistrict"><span>常驻地区：</span>${user.provinceName}省${user.cityName}市<em>（每月只能修改一次）</em></li>
										<li style="display:none" id="modifyDistrict"><span>常驻地区：</span>
											<input type="hidden" name="provinceName" id="provinceName" value="${user.provinceName}"/>
										  <select name="province" id="s_province" class="loginFormTdIpt_d disabled" >
							                <option>请选择</option>
							              </select>
							              <input type="hidden" name="cityName" id="cityName" value="${user.cityName}"/>
							              <select name="city" id="s_city" class="loginFormTdIpt_d disabled">
							                <option>请选择</option>
							              </select>
							              <select name="district" id="s_county" class="loginFormTdIpt_c" style="display:none">
												<option>
													请选择
												</option>
											</select>
										<em>（每月只能修改一次）</em>
										</li>
										
										
										<li><span>从事行业：</span><select
											name="select" id="select" class="loginFormTdIpt_c disabled" disabled>
												<option>官员</option>
										</select></li>
										<input type="hidden" name="education" id="education" value="${user.education}" />
										<li id="educationValue"><span>教育程度：</span> <select
											name="select" id="educationSelector" class="loginFormTdIpt_c disabled"
											disabled>
												<option value="0">小学</option>
												<option value="1">初中</option>
												<option value="2">高中</option>
												<option value="3">专科</option>
												<option value="4">本科</option>
												<option value="5">硕士</option>
												<option value="6">博士</option>
										</select></li>
										<li><span>兴趣爱好：</span>
										<input type="hidden" name="interest" id="interest" value="${user.interest}"/>
											<p>
												<input type="checkbox" name="checkbox" id="checkbox" value="网络"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">网络</label> <input type="checkbox" value="设计"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">设计</label> <input
													type="checkbox" name="checkbox" id="checkbox" value="逛街"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">逛街</label> <input type="checkbox" value="小品"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">小品</label> <br /> <input
													type="checkbox" name="checkbox" id="checkbox" value="摄影"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">摄影</label> <input type="checkbox" value="旅游"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">旅游</label> <input
													type="checkbox" name="checkbox" id="checkbox" value="购物"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">购物</label> <input type="checkbox" value="时尚"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">时尚</label> <br /> <input
													type="checkbox" name="checkbox" id="checkbox" value="追星"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">追星</label> <input type="checkbox" value="交友"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">交友</label> <input
													type="checkbox" name="checkbox" id="checkbox" value="读书"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">读书</label> <input type="checkbox" value="果粉"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">果粉</label> <br /> <input
													type="checkbox" name="checkbox" id="checkbox" value="数码"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">数码</label> <input type="checkbox" value="美食"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">美食</label> <input
													type="checkbox" name="checkbox" id="checkbox" value="英语"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">英语</label> <input type="checkbox" value="名牌"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">名牌</label> <br /> <input
													type="checkbox" name="checkbox" id="checkbox" value="音乐"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">音乐</label> <input type="checkbox" value="健身"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">健身</label> <input
													type="checkbox" name="checkbox" id="checkbox" value="看电影"
													class="data_bd01 disabled" disabled /> <label 
													class="data_bd02">看电影</label> <input type="checkbox" value="收藏"
													name="checkbox" id="checkbox" class="data_bd01 disabled" disabled />
												<label  class="data_bd02">收藏</label>
											</p></li>
										<li><span>QQ号码：</span> <input type="text" name="qq" id="qq"
											 class="loginFormTdIpt_a disabled" value="${user.qq}"
											></li>
										<li><span>微 信：</span> <input type="text" name="weixin" id="weixin"
											 class="loginFormTdIpt_a disabled" value="${user.weixin}"
											 /></li>
										<li class="padding100"><span>接收美试网最新品牌及商品优惠信息</span>
											<p>
												<input type="hidden" name="enablePhoneSubscription" id="enablePhoneSubscription" value="${user.enablePhoneSubscription}"/>
												<input type="checkbox" name="smsRecive" id="smsRecive"
													class="data_bd03 disabled"  /> <label
													 class="data_bd04">短信</label> 
													<input type="hidden" name="enableEmailSubscription" id="enableEmailSubscription" value="${user.enableEmailSubscription}"/>
													<input
													type="checkbox" name="emailRecive" id="emailRecive"
													class="data_bd03 disabled" /> <label
													 class="data_bd04">邮件</label>
											</p>
											<p class="padding100 ys">如果您选择取消，以后将不再接收任何优惠信息, 请慎重！</p></li>
										<p class="data_anniu">
											<a href="#" class="baoc" id="modify">修改</a><a href="#" class="baoc" id="save" style="display:none">保存</a>
										</p>
									</ul>
								</div>
							 </form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script>
//$.initProv("#provinceSelector","#citySelector",$("#provinceName").val(),$("#cityName").val());
//_init_area();
//$("#s_province").find("option[text="+$("#provinceName").val()+"]").attr("selected",true);
//$(".disabled").attr("disabled",true);
$(function(){var validateObj=$("#userProfile").Validform({
		tiptype:4,
		usePlugin:{
			passwordstrength:{
				minLen:6,
				maxLen:20
			}
		}

	});}) 
var educationArray = new Array("小学", "初中", "高中", "专科", "本科", "硕士", "博士");
var education = ${user.education};
if (education != null 
		&& education < educationArray.length-1) {			
	$("#educationSelector").val(education);
}
var interestStrs=$("#interest").val();
if(interestStrs!=null){
	var interestArray=interestStrs.split(",");
	$(".data_bd01").each(function(){
		var interest=$(this).val();
		for(var i=0;i<interestArray.length;i++){
			if(interest==interestArray[i]){
				$(this).attr("checked",true);
			}
		}
	});
}
if($("#enablePhoneSubscription").val()==1){
	$("#smsRecive").attr("checked",true);
}
if($("#enableEmailSubscription").val()==1){
	$("#emailRecive").attr("checked",true);
}


function getInterest(){

	var interestStr="";
	$(".data_bd01").each(function(){
		if($(this).attr("checked")){
			interestStr+=$(this).val()+",";
		}
	});
	if(interestStr.length>0){
		if(interestStr.charAt(interestStr.length-1)==","){		
			interestStr=interestStr.substr(0,interestStr.length-1);
		}
	}
	$("#interest").val(interestStr);

};

function getEducation(){
	if($("#educationSelector").val()!=null){
		
		$("#education").val($("#educationSelector").val());
		
	}
}

$("#modify").click(function(){
	$(this).hide();
	$(".disabled").attr("disabled",false);
	if($("#canmodifyregion").val()==1){
		/* $("#provinceSelector").attr("disabled",true);
		$("#citySelector").attr("disabled",true); */
		$("#modifyDistrict").show();
		$("#showDistrict").hide();
	}
	
	$("#save").show();
});



 
$("#save").click(function(){

	getInterest();
	getEducation();
	//var provinceName=$("#provinceSelector").val()!=null?$._cityInfo[$("#provinceSelector").val()].n:"";
	
	/* $("#provinceName").val(provinceName);
	var citys=$._cityInfo[$("#provinceSelector").val()].c;
	if(citys!=null)
		var cityName=$("#citySelector").val()!=null?citys[$("#citySelector").val()]:"";
	
	$("#cityName").val(cityName); */
	if($("#emailRecive").attr("checked")){
		$("#enableEmailSubscription").val(1);
	}else{
		$("#enableEmailSubscription").val(0);
	}
		//$("#enableEmailSubscription").val()==1;
	if($("#smsRecive").attr("checked")){
		$("#enablePhoneSubscription").val(1);
	}else{
		$("#enablePhoneSubscription").val(0);
	}
	if($("#s_province option:selected").text()!="省份"&&$("#s_province option:selected").text()!=null)
		$("#provinceName").val($("#s_province option:selected").text());
	if($("#s_city option:selected").text()!="地级市"&&$("#s_city option:selected").text()!=null)
		$("#cityName").val($("#s_city option:selected").text());
	$("#userProfile").submit();
});

_init_area();


$(".disabled").attr("disabled",true);
</script>
</body>
</html>
