<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-个人资料</title>
<link href="${pageContext.request.contextPath}/style/public.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/style/Individual_center.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/css/common/css.css" rel="stylesheet"
	type="text/css" />

<script src="${pageContext.request.contextPath}/js/common/jquery-1.7.min.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/common/jquery-yeqian.js"></script>


</head>

<body class="white">
<jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>

<input id="re" type="hidden" value="${result}"></input>
	<div id="wapper">
		<div class="main">
			<p class="passw_wz">
				您现在位于：首页 >> 我的美试 <span>- 个人首页</span>
			</p>
			<c:import url="/user/usertop.htm"></c:import>
			<div class="indiv_bottom top25">
				<ul class="indiv_bl">
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.index")%>" class="geren_bj"><em></em>个人首页</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.info")%>" >个人资料</a></li>
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
								<li><a href="${pageContext.request.contextPath}/user/profile.htm">个人资料</a></li>
								<li><a class="hover" href="${pageContext.request.contextPath}/user/uploadPhoto.htm">修改头像</a></li>
								<li><a href="${pageContext.request.contextPath}/user/toRecAddr.htm">收货地址</a></li>
							</ul>
						</div>
						<div class="Contentbox fixed">
							<div id="con_one_2" class="two hover">
									<ul class="img_top">
										<li class="img_topa">
											<span>温馨提示：<br />
												上传头像仅支持HPG,GIF,PNG格式，文件小于5M。<br />
												点击你的头像可进行修改,上传完之后可任意截取你想要图片,截取完之后,按保存即可。
										</span></li>
								<%@ include file="/WEB-INF/jsps/user/uploadPhoto/uploadHead.jsp"%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
